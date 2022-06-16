package listener;

public class PaymentStatus {

	// Define the listener object in the member variable
	private PaymentStatusListener paymentStatusListener;

//Define two methods in the event source
	public void Paid() {
		// When the event source calls the Paid method, it must call the listener
		// method, call the listener method, and pass the event object to
		paymentStatusListener.paid(new Event(this));
	}

	public void Unpaid() {
		// When the event source calls the Unpaid method, it must call the listener
		// method, call the listener method, and pass the event object in
		paymentStatusListener.unpaid(new Event(this));
	}

//Register a listener. There is no listener object in this class, so pass one.
	public void registerListener(PaymentStatusListener paymentStatusListener) {
		this.paymentStatusListener = paymentStatusListener;
	}
}