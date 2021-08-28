import java.util.ArrayList;

public class TaskController {

	private ITask task; // creating task
	private ITaskData taskList;

	public TaskController(Task task) {
		this.task = task;
	}

	public TaskController(TaskList taskList) {
		this.taskList = taskList;
	}

	public void createTask() {
		int newTaskId = this.taskList.generateTaskId();
		this.task = new Task(newTaskId);
	}

	public void addParcel(Parcel parcel) {
		this.task.addParcel(parcel);
	}

	public void updateTaskToList() {
		this.taskList.addTask((Task) this.task);
	}

	public void generateAlgorithmResults() {
		this.task.setFFDResult(new FFDAlgorithm(this.task.getParcelList()));
		this.task.setBFDResult(new BFDAlgorithm(this.task.getParcelList()));
	}

	public void updateFile() {
		this.taskList.updateFile();
	}

	public void setTask(Task theTask) {
		this.task = theTask;
	}

	public Task getTask() {
		return (Task) this.task;
	}

	public Task getTask(int taskId) {
		return taskList.getTask(taskId);
	}

	public ArrayList<Task> getTaskList() {
		return taskList.getTaskList();
	}
}