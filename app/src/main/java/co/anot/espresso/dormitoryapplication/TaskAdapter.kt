package co.anot.espresso.dormitoryapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.task_row.view.*

class TaskAdapter(val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val taskNameView = view.taskName
        //val roomMateView = view.roommate
    }
    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val task = taskList.get(position)
        holder?.taskNameView?.text = task.taskName
       // holder?.roomMateView?.text = task.roommate.name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.task_row, parent, false)
        return ViewHolder(view)
    }

}