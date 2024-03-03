import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;

public class FileReadWrite implements FileHandler<Employee>{
	
	public FileReadWrite() {
		
	}
	public void writeToFile(List<Employee> list) {
		try {
			FileWriter fileWrite = new FileWriter("file.txt");
			BufferedWriter bf = new BufferedWriter(fileWrite);
			bf.write("This is title \n");
			
			for(Employee a : list) {
				bf.write(a.toString() + "\n");
			}
			bf.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void readFromFile() {
		try {
			File employee = new File("file.txt");
			FileReader fileReader =new FileReader(employee);
			BufferedReader bs = new BufferedReader(fileReader);
			
			String line = null;
			while((line = bs.readLine())!= null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
