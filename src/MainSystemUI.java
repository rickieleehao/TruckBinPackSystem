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
					choice = this.scanner.nextInt();
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

	private void createTask() {
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

		this.control.generateBFDResult(); // this.control.generateAlgorithmResult
		this.control.generateFFDResult();
		printResult(this.control.getTask());
	}

	private void searchTask() {
		Task retrievedTask = null;
		boolean isFound = false, exit = false;
		System.out.println("-----------------------");
		System.out.println("   Searching a Task");
		System.out.println("-----------------------");
		while (!isFound || exit) {
			try {
				System.out.print("Kindly enter the Task ID -> ");
				retrievedTask = this.control.getTask(this.scanner.nextInt());
				isFound = true;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Please enter a valid Task ID.\n");
				System.out.println("e.g. 001");
			} // option to cancel the searching progress
		}

		printResult(retrievedTask);
	}

	private void displayAllTasks() {
		System.out.println("-----------------------");
		System.out.println("Displaying all Tasks result ");
		System.out.println("-----------------------");

		for (Task task : this.control.getTaskList())
			printResult(task); // fetch data from file
	}

	private void printResult(Task task) {
		Algorithm algo;

		for (int algoType = 1; algoType <= 2; algoType++) {
			if (algoType == 1) {
				algo = task.getBFDResult();
				System.out.println("Best Fit Decreasing:-");
			} else { // algoType == 2
				algo = task.getFFDResult();
				System.out.println("First Fit Decreasing:-");
			}

			System.out.println("Number of truck allocated -> " + algo.getAllocatedTrucks().size());
			for (int i = 0; i < algo.getAllocatedTrucks().size(); i++) {
				System.out.println("Truck " + i + 1);
				System.out.println(algo.getAllocatedTrucks().get(i));
			}
			System.out.println("Time Allocated -> " + algo.getTimeAllocated());
			System.out.println("Remaining Capacity -> " + algo.getRemainingCapacity());
		}
		System.out.println("");
	}
}
