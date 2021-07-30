

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:08 AM
 */
public class TaskList implements ITaskData {

	private ArrayList<Task> taskList;
	private String fileName;
	public Task m_Task;

	public TaskList(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param fileName
	 */
	public TaskList(String fileName){

	}

	public int generateTaskId(){
		return 0;
	}

	/**
	 * 
	 * @param newTask
	 */
	public void addTask(Task newTask){

	}

	/**
	 * 
	 * @param id
	 */
	public Task getTask(int id){
		return null;
	}

	public ArrayList<Task> getTaskList(){
		return null;
	}

	public void writeToFile(){

	}
}//end TaskList