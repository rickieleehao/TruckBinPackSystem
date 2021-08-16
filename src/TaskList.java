import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:08 AM
 */
public class TaskList implements ITaskData {

	private ArrayList<Task> taskList;
	private String fileName;
	public Task m_Task;

	public TaskList() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param fileName
	 */
	public TaskList(String fileName) {
		// TODO: How to cast when reading string?

		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));

			String lineText;
			while ((lineText = in.readLine()) != null) {
				String[] line = lineText.split(",");
				Task aTask = new Task(line[0], line[1], line[2], line[3]);
				taskList.add(aTask);
			}
			in.close();
			System.out.println("Read in task list successful.");
		} catch (IOException e) {
			System.out.println("File read task list error.");
			System.exit(0);
		}
	}

	public int generateTaskId() {

		int taskIDCounter = 0;

		taskIDCounter++;
		return taskIDCounter - 1;
	}

	/**
	 * 
	 * @param newTask
	 */
	public void addTask(Task newTask) {
		taskList.add(newTask);
	}

	/**
	 * 
	 * @param id
	 */

	/*
	 * public Task searchTask(int id) { boolean found = false; int i = 0; int count
	 * = taskList.size();
	 * 
	 * Task theTask = null;
	 * 
	 * while (i < count && !found) { theTask = taskList.get(i); if
	 * (theTask.getId().equals(id)) found = true; else i++; } if (!found) theTask =
	 * null;
	 * 
	 * return theTask; }
	 */

	public Task getTask(int id) {

		// TODO: Not sure. Can try for loop.

		Iterator iterator = taskList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(id)) {
				return (Task) iterator.next();
			}
		}
		return null;
	}

	public ArrayList<Task> getTaskList() {
		return taskList;
	}

	public void writeToFile() {
		// TODO: write here?
	}
}// end TaskList