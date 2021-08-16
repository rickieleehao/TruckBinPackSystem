import java.util.ArrayList;

public class TaskController implements Controller {

	private ITask task;
	private ITaskData taskList;

	public TaskController() {

	}

	public TaskController(Task task) {

	}

	public TaskController(TaskList taskList) {
		this.taskList = taskList;
	}

	public void createTask() {

	}

	public void addParcel(Parcel parcel) {

	}

	public void generateBFDResult() {

	}

	public void generateFFDResult() {

	}

	public Task getTask() {
		return (Task) this.task;
	}
	
	public Task getTask(int taskId) {
		return null;
	}

	public ArrayList<Task> getTaskList() {
		return null;
	}
}