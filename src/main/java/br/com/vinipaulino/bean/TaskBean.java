package br.com.vinipaulino.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vinipaulino.modelo.Task;
import br.com.vinipaulino.rn.TaskRn;

@ManagedBean
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private TaskRn taskRn;
	private Task task = new Task();

	public TaskBean() {
		this.taskRn = new TaskRn();
	}

	public void gravar() {
		taskRn.gravarTask(this.task);
		this.task = new Task();
	}
	
	public void carregar(Task task) {
		this.task = task;
	}
	
	public void remover(Task task) {
		taskRn.remove(task);
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public List<Task> getTasks(){
		return taskRn.getTasks();
	}

}
