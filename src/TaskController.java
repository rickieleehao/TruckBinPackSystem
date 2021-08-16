import java.util.ArrayList;

public class TaskController implements Controller {

	private ITask task; //creating task
	private ITaskData taskList;

	public TaskController() {

	}

	public TaskController(Task task) {

	}

	public TaskController(TaskList taskList) {
		this.taskList = taskList;
	}

	public void createTask() {
		this.task = new Task();
	}

	public void addParcel(Parcel parcel) {
		this.task.addParcel(parcel);
	}

	public void generateBFDResult() {

	}

	public void generateFFDResult() {

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