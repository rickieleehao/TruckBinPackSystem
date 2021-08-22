import java.util.Scanner;

public class TruckBinPackSystem {
	public void main(String[] args) {

		String dataFile = "TaskList.txt";
		Scanner scanner = new Scanner(System.in);
		try {
			TaskList taskList = new TaskList(dataFile);
			TaskController control = new TaskController(taskList);
			MainSystemUI mainUI = new MainSystemUI(control, scanner);
			mainUI.start();
			System.out.println("\n--------------------------------------------------");
			System.out.println("Thanks for using TruckBinPackSystem!");
			System.out.println("--------------------------------------------------");
			scanner.close();
		} catch (Exception e) {
			System.out.println(dataFile + " has error!");
		}
	}
}