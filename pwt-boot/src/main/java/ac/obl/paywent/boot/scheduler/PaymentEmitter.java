package ac.obl.paywent.boot.scheduler;

import ac.obl.paywent.payment.SendAvailablePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEmitter {

	private final SendAvailablePayment sendAvailablePayment;

	@Scheduled(fixedDelay = 1000)
	public void scheduleFixedDelayTask() {
		sendAvailablePayment.invoke();
	}
}
