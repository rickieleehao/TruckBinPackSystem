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

	}

	public void addParcel(Parcel parcel) {
		this.task.addParcel(parcel);
	}

	public void generateFFDResult() {
		this.task.setBFDResult(new FFDAlgorithm(this.task.getParcelList()));
	}

	public void generateBFDResult() {
		this.task.setBFDResult(new BFDAlgorithm(this.task.getParcelList()));
	}

	public Task getTask() {
		return (Task) this.task;
	}

	public Task getTask(int taskId) {
		return taskList.getTask(taskId);
	}

	public ArrayList<Task> getTaskList() {
		return null;
	}
}