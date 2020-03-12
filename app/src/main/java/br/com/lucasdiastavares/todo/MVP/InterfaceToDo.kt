package br.com.lucasdiastavares.todo.MVP

import br.com.lucasdiastavares.todo.data.ToDoObject

interface InterfaceToDo {

    interface ModelImpl {
        fun createTask(task: ToDoObject)
        fun deleteTask(id: Int)
        fun getTaskList(): ArrayList<ToDoObject>
        fun getLastTask(): ToDoObject
        fun updateCompleted(id: Int, completed: Boolean)
    }

    interface ViewImpl{
        fun notifyTaskAdded(position : Int)
        fun notifyTaskRemoved(position : Int)
        fun notifyTaskChanged(position: Int)
    }

    interface PresenterImpl {
        fun save(givenTitle: String)
        fun showTaskList(): ArrayList<ToDoObject>
        fun showLastTaskAdded() :ToDoObject
        fun delete(id: Int)
        fun removeTask(posicaoAdapter: Int)
        fun strikeUnstrike(posicaoAdapter: Int)
    }

}
