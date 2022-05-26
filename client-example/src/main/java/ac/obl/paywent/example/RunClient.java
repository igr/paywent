package ac.obl.paywent.example;

import ac.obl.paywent.client.AccountsApi;
import ac.obl.paywent.client.invoker.ApiClient;
import ac.obl.paywent.client.invoker.ApiException;

public class RunClient {
    public static void main(final String[] args) throws ApiException {
        System.out.println("Client example");
        final var apiClient = new ApiClient();
        

        final var accountsApi = new AccountsApi(apiClient);
        accountsApi.getAccounts().forEach(accountResponse -> {
            System.out.println(accountResponse.getName());
        });
    }
}
