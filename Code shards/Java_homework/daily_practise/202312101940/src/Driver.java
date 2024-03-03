import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class Driver {
	public static void main(String[] args) {
		List<Employee> list = new LinkedList<>();
		list.add(new Permanent("lawyer","cool"));
		list.add(new Permanent("Fuck","Dick"));
		list.add(new PartTime("Hash","Virgin"));
		list.add(new PartTime("Old","fff"));
		System.out.println("");
		ListIterator<Employee> itr = list.listIterator();
		while(itr.hasNext()) {
			Employee employee = itr.next();
			System.out.println(employee.toString());
		}
		System.out.println("");
		for(int i = 0; i< list.size();i++) {
			System.out.println("Price is" + list.get(i).calculatePay(35));
		}
		
		FileReadWrite file = new FileReadWrite();
		
		System.out.println("");
		file.writeToFile(list);
		file.readFromFile();
		
		EmployeeComparator compare = new EmployeeComparator();
		
		Employee min = list.get(0);
		for(int i = 0;i < list.size()-1;i++) {
			if(compare.compare(list.get(i), list.get(i+1))<0) {
					min = list.get(i);
			}
		}
		System.out.println(min.toString());
				
	}
}
