package listener;

public interface PaymentStatusListener {
	void paid(Event event);
    void unpaid(Event event);
}
