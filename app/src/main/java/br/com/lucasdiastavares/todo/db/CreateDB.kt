package br.com.lucasdiastavares.todo.db


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class CreateDB(private val context: Context) : SQLiteOpenHelper(context, DB_Name,null, VERSAO) {
    companion object {
        private val DB_Name = "todo.db"
        private val VERSAO = 1

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val imcT = StringBuilder()

        imcT.append(" CREATE TABLE tasks (    	 ")
        imcT.append("       id                  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL	,")
        imcT.append("       title               STRING                                      ,")
        imcT.append("       completed 		    INTEGER DEFAULT 0                          );")

        db?.execSQL(imcT.toString())
        Log.d("TAG_CREATE_DB", imcT.toString())

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        try {
            db?.execSQL("DROP TABLE IF EXISTS tasks")

        } catch (ex: Exception) {
            Log.d("TAG_UPDATE_DB", " error ao deletar: " + ex.message)
        }

        onCreate(db)
    }

    fun getConexaoDatabase(): SQLiteDatabase {
        return this.writableDatabase
    }

}