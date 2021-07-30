

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */
public interface ITaskData {

	public int generateTaskId();

	/**
	 * 
	 * @param newTask
	 */
	public void addTask(Task newTask);

	/**
	 * 
	 * @param taskId
	 */
	public Task getTask(int taskId);

	public ArrayList<Task> getTaskList();

}