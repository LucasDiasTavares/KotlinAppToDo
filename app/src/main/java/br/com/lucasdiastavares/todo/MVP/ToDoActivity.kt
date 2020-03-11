package br.com.lucasdiastavares.todo.MVP

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.lucasdiastavares.todo.R
import br.com.lucasdiastavares.todo.Utils.HackListener
import kotlinx.android.synthetic.main.activity_to_do.*
import kotlinx.android.synthetic.main.row_task.*
import kotlinx.android.synthetic.main.toolbar.*

class ToDoActivity : AppCompatActivity(),InterfaceToDo.ViewImpl ,HackListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initcomponents()
    }


    fun initcomponents(){
        toolbar.title = "To Do"
        btn_main_salvar.setOnClickListener {

        }
    }

    override fun notifyAddTask(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyRemoveTask(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClickHack(viewClicked: View, position: Int) {
        when(viewClicked.id){
            R.id.btn_delete -> {
                //presenter.removeTask(position)
                Toast.makeText(this, "Deletado", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
