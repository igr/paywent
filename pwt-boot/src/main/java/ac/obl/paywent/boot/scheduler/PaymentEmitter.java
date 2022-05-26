package ac.obl.paywent.boot.scheduler;

import ac.obl.paywent.payment.SendAvailablePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "pwt.queue.enabled", matchIfMissing = true, havingValue = "true")
@RequiredArgsConstructor
public class PaymentEmitter {

	private final SendAvailablePayment sendAvailablePayment;

	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	public void scheduleFixedDelayTask() {
		sendAvailablePayment.invoke();
	}
}
