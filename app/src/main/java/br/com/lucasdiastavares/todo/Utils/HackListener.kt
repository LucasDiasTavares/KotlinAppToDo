package br.com.lucasdiastavares.todo.Utils

import android.view.View

interface HackListener {
    fun onClickHack(viewRoot : View, viewClicked : View, position : Int)
}