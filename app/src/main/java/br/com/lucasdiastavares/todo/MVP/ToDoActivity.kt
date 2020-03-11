package br.com.lucasdiastavares.todo.MVP

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.lucasdiastavares.todo.R
import kotlinx.android.synthetic.main.toolbar.*

class ToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        toolbar.title = "To Do"
    }
}
