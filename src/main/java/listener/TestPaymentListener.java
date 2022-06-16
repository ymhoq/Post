package listener;

public class TestPaymentListener {

	public static void test() {

		PaymentStatus paymentStatus = new PaymentStatus();

		// Register a listener ()
		paymentStatus.registerListener(new PaymentStatusListener() {
			@Override
			public void paid(Event event) {
				PaymentStatus paymentStatus1 = event.getResource();
				System.out.println(paymentStatus1 + "Succsessful paid!");
			}

			@Override
			public void unpaid(Event event) {
				PaymentStatus paymentStatus1 = event.getResource();
				System.out.println(paymentStatus1 + "Unpaid");
			}
			
		});

		// When the eat method is called, the event is fired, the event object is passed
		// to the listener, and finally the listener gets the event source and works
		// with the event source
		paymentStatus.Paid();
	}

}
