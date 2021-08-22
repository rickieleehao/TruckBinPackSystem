import java.io.File;
import java.util.*;

public class TaskList implements ITaskData {

	private ArrayList<Task> taskList;

	public TaskList(String fileName) throws Exception {
		this.taskList = new ArrayList<Task>();

		// Task ID starts from 1, 2, 3, 4, ...
		int taskId = 1;
		ArrayList<Parcel> arrFromFile = new ArrayList<Parcel>();
		String dataFromFile;

		Scanner scan = new Scanner(new File(fileName));
		scan.useDelimiter("(,|\r\n|\r|\n)");

		while (scan.hasNext()) {
			dataFromFile = scan.next();
			if (dataFromFile.equals("next")) {
				this.taskList.add(new Task(taskId, arrFromFile));
				arrFromFile = new ArrayList<Parcel>();
				taskId++;
				continue;
			}
			arrFromFile.add(new Parcel(Integer.parseInt(dataFromFile)));
		}

		scan.close();
	}

	@Override
	public int generateTaskId() {
		// Task ID starts from 1, 2, 3, 4...
		// new task ID will be the task list's size + 1

		if (this.taskList == null)
			return 1;
		else
			return this.taskList.size() + 1;
	}

	@Override
	public void addTask(Task newTask) {
		taskList.add(newTask);
	}

	@Override
	public Task getTask(int id) {
		Task theTask = null;
		for (Task task : this.taskList)
			if (task.getId() == id) {
				theTask = task;
				break;
			}
		if (theTask == null)
			throw new NullPointerException(); // Throw exception when no result found.
		return theTask;
	}

	@Override
	public ArrayList<Task> getTaskList() {
		return this.taskList;
	}

	public void writeToFile() {
		// TODO: write here?
	}
}