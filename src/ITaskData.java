import java.util.ArrayList;

public interface ITaskData {

	public int generateTaskId();

	public void addTask(Task newTask);

	public Task getTask(int taskId);

	public ArrayList<Task> getTaskList();

}