package ac.obl.paywent.example;

import ac.obl.paywent.client.AccountsApi;
import ac.obl.paywent.client.PaymentsApi;
import ac.obl.paywent.client.ProfilesApi;
import ac.obl.paywent.client.invoker.ApiException;
import ac.obl.paywent.client.model.AccountResponse;
import ac.obl.paywent.client.model.AccountType;
import ac.obl.paywent.client.model.NewAccountRequest;
import ac.obl.paywent.client.model.NewPaymentRequest;
import ac.obl.paywent.client.model.NewProfileRequest;
import ac.obl.paywent.client.model.ProfileResponse;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RunClient {
    public static void main(final String[] args) throws ApiException, InterruptedException {
        System.out.println("Client example");
        new RunClient().run();
    }

    final AccountsApi accountsApi = new AccountsApi();
    final ProfilesApi profilesApi = new ProfilesApi();
    final PaymentsApi paymentsApi = new PaymentsApi();

    public void run() throws ApiException, InterruptedException {
        final var profiles = createTwoProfiles();
        final var accounts = createTwoAccountsForProfiles(profiles);
        profiles.forEach(System.out::println);
        accounts.forEach(System.out::println);

        final AtomicInteger totalSum = new AtomicInteger(0);
        final ExecutorService executor = Executors.newFixedThreadPool(50);
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        IntStream
            .range(0, 100)
            .forEach(i -> executor.submit(() -> {
                sendRandomPayment(profiles, accounts, totalSum, countDownLatch);
            }));

        System.out.println("Waiting for all threads to finish");
        countDownLatch.await();
        System.out.println("Done, total sum posted: " + totalSum.get());
        executor.shutdown();
    }

    private List<ProfileResponse> createTwoProfiles() throws ApiException {
        final var profiles = profilesApi.getProfiles();
        if (profiles.isEmpty()) {
            profilesApi.postProfiles(new NewProfileRequest().name("Pam"));
            profilesApi.postProfiles(new NewProfileRequest().name("Jim"));
        }
        return profilesApi.getProfiles();
    }

    private List<AccountResponse> createTwoAccountsForProfiles(final List<ProfileResponse> profiles) throws ApiException {
        final var accounts = accountsApi.getAccounts();
        if (accounts.isEmpty()) {
            accountsApi.postAccounts(
                new NewAccountRequest()
                    .name("Account A")
                    .number("111-222")
                    .type(AccountType.SAVINGS)
                    .profileId(profiles.get(0).getId())
            );
            accountsApi.postAccounts(
                new NewAccountRequest()
                    .name("Account X")
                    .number("999-888")
                    .type(AccountType.CREDIT)
                    .profileId(profiles.get(1).getId())
            );
        }
        return accountsApi.getAccounts();
    }

    private final Random random = new Random();

    private void sendRandomPayment(final List<ProfileResponse> profiles, final List<AccountResponse> accounts, final AtomicInteger totalSum, final CountDownLatch countDownLatch) {
        final var profileFrom = profiles.get(0);
        final var accountFrom = accounts.get(0);
        final var profileTo = profiles.get(1);
        final var accountsTo = accounts.get(1);

        final var amount = 10 + random.nextInt(990);
        try {
            paymentsApi.postPayments(new NewPaymentRequest()
                .amount(String.valueOf(amount))
                .currency("USD")
                .originator(profileFrom.getId())
                .beneficiary(profileTo.getId())
                .sender(accountFrom.getId())
                .receiver(accountsTo.getId())
            );
        } catch (final ApiException e) {
            e.printStackTrace();
        }

        totalSum.addAndGet(amount);
        countDownLatch.countDown();
    }

}
