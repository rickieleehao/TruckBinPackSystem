import java.util.Scanner;

public class TruckBinPackSystem {
	public void main(String [] args){

		Scanner scanner = new Scanner (System.in);
		TaskList taskList = new TaskList("TaskList.txt");
		TaskController control = new TaskController(taskList);
		MainSystemUI mainUI = new MainSystemUI(control, scanner);
		mainUI.start();
		System.out.println("\n--------------------------------------------------");
		System.out.println("Thanks for using TruckBinPackSystem!");
		System.out.println("--------------------------------------------------");	
		scanner.close();
	}
}