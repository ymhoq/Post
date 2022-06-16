package abstractfactory;

import com.solvd.post.dao.models.Order;
import com.solvd.post.dao.models.PackageBox;
import com.solvd.post.dao.models.Payment;

public class BigPackage implements PackageFactory {

	@Override
	public Order createOrder() {

		return new Order();
	}

	@Override
	public PackageBox createPackageBox() {

		return new PackageBox();
	}

	@Override
	public Payment createPayment() {

		return new Payment();
	}

}
