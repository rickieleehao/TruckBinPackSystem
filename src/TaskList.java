import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class TaskList implements ITaskData {

	private ArrayList<Task> taskList;
	private String fileName;

	public TaskList(String fileName) throws Exception {
		this.fileName = fileName;
		this.taskList = new ArrayList<Task>();

		// Task ID starts from 1, 2, 3, 4, ...
		int taskId = 1;
		ArrayList<Parcel> arrFromFile = new ArrayList<Parcel>();
		String dataFromFile;

		Scanner scan = new Scanner(new File(fileName));
		scan.useDelimiter("([|]|,|\r\n|\r|\n)");

		while (scan.hasNext()) {
			dataFromFile = scan.next().replace(" ", "").replace("[", "").replace("]", "");
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

	@Override
	public void updateFile() {
		try {
			FileWriter file = new FileWriter(this.fileName);
			file.write(""); // empty the file
			file.close();
			FileWriter write = new FileWriter(this.fileName, true);
			for (Task task : this.taskList) {
				write.write(task.getParcelList().toString() + ",next\r\n");
			}
			write.close();
		} catch (Exception e) {

		}
	}
}