package listener;

public class Event {
	private PaymentStatus paymentStatus;

	public Event() {
	}

	public Event(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentStatus getResource() {
		return paymentStatus;

	}
}
