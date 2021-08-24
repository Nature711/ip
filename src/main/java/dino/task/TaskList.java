package dino.task;

import java.util.List;
import dino.exception.*;

public class TaskList {

    private final List<Task> taskList;

    public TaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
        int size = this.taskList.size();
        System.out.println("Got it. I've added this task: \n"
                + "  " + taskList.get(size - 1));
        System.out.println("Now you have " + size +
                (size > 1 ? " tasks" : " task") + " in the list.");
    }

    public void printTaskList() throws EmptyListException{
        if (taskList.isEmpty()) throw new EmptyListException();
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }

    public void markTaskDone(int index) throws InvalidIndexException, TaskAlreadyDoneException {
        if (index > taskList.size()) {
            throw new InvalidIndexException();
        } else {
            Task t = taskList.get(index - 1);
            if (t.getStatus()) throw new TaskAlreadyDoneException();
            t.setDone();
            System.out.println("Nice! I've marked this task as done: \n" + t);
        }
    }

    public void deleteTask(int index) throws InvalidIndexException {
        if (index > taskList.size()) {
            throw new InvalidIndexException();
        } else {
            Task t = taskList.remove(index - 1);
            System.out.println("Noted. I've removed this task: \n" + t);
            int size = taskList.size();
            System.out.println("Now you have " + size +
                    (size > 1 ? " tasks" : " task") + " in the list.");
        }
    }


}
