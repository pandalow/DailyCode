
public class Permanent extends Employee{
	private static double PERMANENT_PAY = 12.50;
	private int id;
	
	public Permanent(String name,String dept) {
		super(name,dept);
	}
	public int getID() {
		return id;
	}

	public double calculatePay(double hours) {
		return hours * PERMANENT_PAY;
	}
}
