package br.com.lucasdiastavares.todo.MVP

import br.com.lucasdiastavares.todo.data.ToDoObject

interface InterfaceToDo {

    interface ModelImpl {
        fun createTask(task: ToDoObject)
        fun deleteTask(id: Int)
        fun getTaskList(): ArrayList<ToDoObject>
        fun getLastTask(): ToDoObject
    }

    interface ViewImpl{
        fun notifyAddTask(position : Int)
        fun notifyRemoveTask(position : Int)
    }

    interface PresenterImpl {
        fun save(title: String)
        fun showTaskList(): ArrayList<ToDoObject>
        fun showLastTaskAdded() :ToDoObject
        fun delete(id: Int)
        fun removeTask(posicaoAdapter: Int)
    }

}
