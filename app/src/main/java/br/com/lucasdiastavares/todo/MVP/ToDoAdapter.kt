package br.com.lucasdiastavares.todo.MVP

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasdiastavares.todo.R
import br.com.lucasdiastavares.todo.Utils.HackListener
import br.com.lucasdiastavares.todo.data.ToDoObject
import kotlinx.android.synthetic.main.row_task.view.*

class ToDoAdapter(
        private var context: Context,
        private var list: ArrayList<ToDoObject>,
        var presenter: InterfaceToDo.PresenterImpl,
        private var hackListener : HackListener): RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(root: ViewGroup, p1: Int): MyViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.row_task, root, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.itemView.txt_task.text = list[position].title
    }

    inner class MyViewHolder(itemViewHolder: View) : RecyclerView.ViewHolder(itemViewHolder), View.OnClickListener {
        init {
            itemViewHolder.btn_edit.setOnClickListener(this)
            itemViewHolder.btn_delete.setOnClickListener(this)
        }
        override fun onClick(view: View) {
            hackListener.onClickHack(view, adapterPosition)
        }
    }

}
