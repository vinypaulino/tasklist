package br.com.vinipaulino.rn;

import java.util.List;

import br.com.vinipaulino.dao.DAO;
import br.com.vinipaulino.modelo.Task;

public class TaskRn {

	public TaskRn() {	
	}
	
	public void gravarTask(Task task) {
		if (task.getId() == null) {
			new DAO<Task>(Task.class).adiciona(task);
		} else {
			new DAO<Task>(Task.class).atualiza(task);
		}
	}

	public List<Task> getTasks() {
		return new DAO<Task>(Task.class).listaTodos();
	}

	public void remove(Task task) {
		new DAO<Task>(Task.class).remove(task);
		
	}
}