import java.util.List;

public interface FileHandler<E> {
	public void writeToFile(List<E> list) ;
	public void readFromFile();
	
}
