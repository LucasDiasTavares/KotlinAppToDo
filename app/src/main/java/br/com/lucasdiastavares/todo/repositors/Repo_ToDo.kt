package br.com.lucasdiastavares.todo.repositors

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import br.com.lucasdiastavares.todo.data.ToDoObject
import br.com.lucasdiastavares.todo.db.CreateDB
import java.util.ArrayList


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

    fun getAllTasks(): ArrayList<ToDoObject> {
        val cursor = db_conection?.getConexaoDatabase()?.rawQuery("SELECT * FROM tasks ORDER BY id ASC", null)
        cursor?.moveToFirst()
        val list = ArrayList<ToDoObject>()

        if (cursor?.count != 0) {
            db_conection?.getConexaoDatabase()?.close()
            list.add(gerarObjTask(cursor!!))
            try {
                if (true) {
                    while (cursor.moveToNext()) {
                        list.add(gerarObjTask(cursor))
                    }
                }
            } catch (ex: Exception) {
                Log.e("TAG_GET", ex.message)
            } finally {
                cursor.close()
            }
        } else {
            db_conection?.getConexaoDatabase()?.close()
        }

        return list
    }

    private fun gerarObjTask(cursor: Cursor): ToDoObject {
        val at = ToDoObject()
        at.id = cursor.getInt(cursor.getColumnIndex("id"))
        at.title = cursor.getString(cursor.getColumnIndex("title"))
        at.completed = cursor.getInt(cursor.getColumnIndex("completed"))
        return at
    }

    fun deleteImcT(id: Int) {
        db_conection?.getConexaoDatabase()?.delete("tasks", "id=$id", null)
        db_conection?.getConexaoDatabase()?.close()
    }

    fun getLastTask() : ToDoObject{
        return getAllTasks().last()
    }



}