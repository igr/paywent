package ac.obl.paywent.event;

@FunctionalInterface
public interface OnPaymentTopic {
	void invoke(final String message);
}
