package br.com.lucasdiastavares.todo.MVP

import android.content.Context
import br.com.lucasdiastavares.todo.data.ToDoObject
import br.com.lucasdiastavares.todo.repositors.Repo_ToDo

class ToDoModel(private val context: Context): InterfaceToDo.ModelImpl {

    override fun getTaskList(): ArrayList<ToDoObject> {
        return Repo_ToDo(context).getAllTasks()
    }

    override fun createTask(task: ToDoObject) {
        Repo_ToDo(context).createTask(task)
    }

    override fun deleteTask(id: Int) {
        Repo_ToDo(context).deleteImcT(id)
    }

    override fun getLastTask(): ToDoObject {
        return Repo_ToDo(context).getLastTask()
    }

    override fun updateCompleted(id: Int, completed: Boolean) {
        Repo_ToDo(context).updateCompleted(id, completed)
    }

}
