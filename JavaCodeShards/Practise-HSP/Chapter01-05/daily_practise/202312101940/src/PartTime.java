
public class PartTime extends Employee{
	public static double PART_TIME_PAY = 10.59;
	public int id;
	
	public PartTime(String name,String dept) {
		super(name,dept);
	}
	public int getID() {
		return id;
	}
	public double calculatePay(double hours) {
		return hours * PART_TIME_PAY ;
	}

}
