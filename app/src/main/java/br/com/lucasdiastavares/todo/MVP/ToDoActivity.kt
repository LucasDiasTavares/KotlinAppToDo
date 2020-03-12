package br.com.lucasdiastavares.todo.MVP

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import br.com.lucasdiastavares.todo.R
import br.com.lucasdiastavares.todo.Utils.HackListener
import kotlinx.android.synthetic.main.activity_to_do.*
import kotlinx.android.synthetic.main.row_task.*
import kotlinx.android.synthetic.main.toolbar.*

class ToDoActivity : AppCompatActivity(), InterfaceToDo.ViewImpl, HackListener {

    private var adapterToDo : ToDoAdapter?=null
    private var presenterToDo: ToDoPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        presenterToDo = ToDoPresenter(this, this)
        initcomponents()
        presenterToDo?.showTaskList()
    }

    fun initcomponents(){
        toolbar.title = "Tavares Tarefas"
        btn_main_salvar.setOnClickListener {
            val edtTitle = main_edt.text.toString()
            presenterToDo?.save(edtTitle)
            main_edt.text?.clear()
        }

        recyclerView.layoutManager = LinearLayoutManager(
                this, LinearLayout.VERTICAL, false)

        adapterToDo = ToDoAdapter(this, presenterToDo?.showTaskList()?:ArrayList(), presenter = presenterToDo!! ,hackListener = this)
        recyclerView.adapter = adapterToDo
    }

    override fun notifyAddTask(position: Int) {
        adapterToDo?.notifyItemInserted(position)
    }

    override fun notifyRemoveTask(position: Int) {
        adapterToDo?.notifyItemRemoved(position)
    }

    override fun onClickHack(viewClicked: View, position: Int) {
        when(viewClicked.id){
            R.id.btn_delete -> {
                presenterToDo?.removeTask(position)
                Toast.makeText(this, "Deletado", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_edit -> {
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
