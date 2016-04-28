package co.anot.espresso.dormitoryapplication
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.drawerLayout


class MainActivity : AppCompatActivity() {
    private var taskList: MutableList<Task> = prepareData()
    val code = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val taskAdapter = TaskAdapter(taskList)
        taskListView.layoutManager = LinearLayoutManager(applicationContext)
        taskListView.itemAnimator = DefaultItemAnimator()
        taskListView.adapter = taskAdapter

        addTaskButton.onClick {
            startActivityForResult(intentFor<AddTaskActivity>(), code)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == code) {
            if (resultCode == RESULT_OK) {
                val taskName = data?.extras?.getString("taskName")
                val roommate = data?.extras?.getString("roommateName")
                taskList.add(Task(taskName!!, Roommate(roommate!!)))
                taskListView.adapter.notifyDataSetChanged()
            }
        }

    }

    override fun onBackPressed() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    private fun prepareData(): MutableList<Task> {
        return mutableListOf(
                Task("Выкинул мусор", Roommate("Вадим")),
                Task("Выкинул мусор еще раз", Roommate("Вадим"))
        )
    }
}