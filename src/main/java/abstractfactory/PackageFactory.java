package abstractfactory;

import com.solvd.post.dao.models.Order;
import com.solvd.post.dao.models.PackageBox;
import com.solvd.post.dao.models.Payment;

public interface PackageFactory {
	Order createOrder();
	PackageBox createPackageBox();
   	Payment createPayment();
	
}
