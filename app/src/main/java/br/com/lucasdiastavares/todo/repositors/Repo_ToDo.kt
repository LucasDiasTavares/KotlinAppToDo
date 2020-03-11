package br.com.lucasdiastavares.todo.repositors

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import br.com.lucasdiastavares.todo.data.ToDoObject
import br.com.lucasdiastavares.todo.db.CreateDB


class Repo_ToDo(private val context: Context) {

    private var db_conection: CreateDB? = null

    init {
        db_conection = CreateDB(context)
    }

    fun createTask(task: ToDoObject): Int? {
        val values = ContentValues()

        values.put("title", task.title)
        val retorno_insert = db_conection?.getConexaoDatabase()?.insert(
                "tasks", null, values)

        db_conection?.close()
        return retorno_insert?.toInt()
    }

}