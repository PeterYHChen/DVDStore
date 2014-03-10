import java.util.*;

public class RentalItem {
	int custId;
	int id;
	java.util.Date rentDate;
	double fee;
	
	public RentalItem(int customerId, int DVDId) {
		custId = customerId;
		id = DVDId;
		rentDate = getCurrentDate();
		fee = 0;
	}
	
	public double getFee() {
		//fee = getCurrentDate() - rentDate;
		return fee;
	}
	
	private Date getCurrentDate() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
}
