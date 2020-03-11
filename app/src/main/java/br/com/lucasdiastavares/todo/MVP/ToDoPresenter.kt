package br.com.lucasdiastavares.todo.MVP

import android.content.Context
import br.com.lucasdiastavares.todo.data.ToDoObject

class ToDoPresenter(private val context: Context,
                    private val _view: InterfaceToDo.ViewImpl): InterfaceToDo.PresenterImpl {

    private var model: InterfaceToDo.ModelImpl = ToDoModel(context)

    override fun save(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTaskList(): ArrayList<ToDoObject> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLastTaskAdded(): ToDoObject {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeTask(posicaoAdapter: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
