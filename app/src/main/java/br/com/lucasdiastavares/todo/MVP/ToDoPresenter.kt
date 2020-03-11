package br.com.lucasdiastavares.todo.MVP

import android.content.Context
import br.com.lucasdiastavares.todo.data.ToDoObject

class ToDoPresenter(private val context: Context,
                    private val _view: InterfaceToDo.ViewImpl): InterfaceToDo.PresenterImpl {

    private var model: InterfaceToDo.ModelImpl = ToDoModel(context)
    private var taskList : ArrayList<ToDoObject> = ArrayList()

    override fun save(givenTitle: String) {
        val obj = ToDoObject(title = givenTitle, completed = 0)
        model.createTask(obj)
        taskList.add(showLastTaskAdded())
        _view.notifyAddTask(taskList.lastIndex)
    }

    override fun showTaskList(): ArrayList<ToDoObject> {
        taskList.addAll(model.getTaskList())
        return taskList
    }

    override fun showLastTaskAdded(): ToDoObject {
        return model.getLastTask()
    }

    override fun delete(id: Int) {
        return model.deleteTask(id)
    }

    override fun removeTask(posicaoAdapter: Int) {
        val id = taskList[posicaoAdapter].id
        model.deleteTask(id!!)
        taskList.removeAt(posicaoAdapter)
        _view.notifyRemoveTask(posicaoAdapter)
    }

}
