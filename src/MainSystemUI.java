import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSystemUI {

	private TaskController control;
	private Scanner scanner;

	public MainSystemUI(TaskController control, Scanner scanner) {
		this.control = control;
		this.scanner = scanner;
	}

	public void start() {
		boolean exit = false;
		while (!exit) {
			int choice = 0;
			boolean error = false;
			while (error) {
				try {
					System.out.println("-----------------------");
					System.out.println("   TruckBinPackSystem");
					System.out.println("-----------------------");
					System.out.println("1. Create new Task");
					System.out.println("2. Search task");
					System.out.println("3. Display all tasks");
					System.out.println("4. Exit");
					System.out.print("Pick option (1-4) ----> ");
					choice = scanner.nextInt();
					scanner.nextLine();
					error = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Please enter a valid number.\n");
				} catch (IndexOutOfBoundsException e) {
					scanner.nextLine();
					System.out.println("Option cannot be negative!\n");
				}
			}

			switch (choice) {
			case 1:
				createTask();
				break;
			case 2:
				searchTask();
				break;
			case 3:
				displayAllTasks();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Invalid option.\n");
			}
		}
	}

	public void createTask() {
		this.control.createTask();
		boolean repeat = true, error = true;
		System.out.println("-----------------------");
		System.out.println("   Adding new Task");
		System.out.println("-----------------------");
		System.out.println("Kindly enter the parcel's weight accordingly: ");
		while (repeat) {
			while (error) {
				try {
					System.out.print("Parcel weight -> ");
					this.control.addParcel(new Parcel(this.scanner.nextInt()));
					error = false;
				} catch (InputMismatchException e) {
					scanner.nextLine();
					System.out.println("Please enter a valid weight.\n");
					error = true;
					break;
				}
			}

			error = true;
			while (error) {
				System.out.println("Add another parcel? Y/N");
				if (this.scanner.next() == "Y" || this.scanner.next() == "y") {
					error = false;
					repeat = true;
				} else if (this.scanner.next() == "N" || this.scanner.next() == "n") {
					error = false;
					repeat = false;
				} else {
					error = true;
				}
			}
		}

		this.control.generateBFDResult();
		this.control.generateFFDResult();
		printResult(this.control.getTask());
	}

	public void searchTask() {
		Task retrievedTask = null;
		boolean isFound = false;
		System.out.println("-----------------------");
		System.out.println("   Searching a Task");
		System.out.println("-----------------------");
		while (!isFound) {
			try {
				System.out.print("Kindly enter the Task ID -> ");
				retrievedTask = this.control.getTask(this.scanner.nextInt());
				isFound = true;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Please enter a valid Task ID.\n");
				System.out.println("e.g. 001");
			}
		}

		printResult(retrievedTask);
	}

	public void displayAllTasks() {
		System.out.println("-----------------------");
		System.out.println("Displaying all Tasks result ");
		System.out.println("-----------------------");

		for (Task task : this.control.getTaskList())
			printResult(task);
	}

	private void printResult(Task task) {
		Algorithm algoBFD, algoFFD;
		algoBFD = task.getBFDResult();
		algoFFD = task.getFFDResult();

		for (int algoType = 1; algoType <= 2; algoType++) {
			if (algoType == 1)
				System.out.println("Best Fit Decreasing:-");
			else // algoType == 2
				System.out.println("First Fit Decreasing:-");

			System.out.println("Number of truck allocated -> " + algoBFD.getAllocatedTrucks().size());
			for (int i = 0; i < algoBFD.getAllocatedTrucks().size(); i++) {
				System.out.println("Truck " + i + 1);
				System.out.println(algoBFD.getAllocatedTrucks().get(i));
			}
			System.out.println("Time Allocated -> " + algoBFD.getTimeAllocated());
			System.out.println("Remaining Capacity -> " + algoBFD.getRemainingCapacity());
		}
		System.out.println("");
	}
}
