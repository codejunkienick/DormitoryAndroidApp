package co.anot.espresso.dormitoryapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.jetbrains.anko.*
class AddTaskActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
          val taskRoommate = editText {
            hint = "Roommate Name"
          }.lparams {
              setMargins(16, 16, 16, 0)
              width = matchParent
          }
          val taskNameInput = editText {
            id = R.id.taskName
            hint = "Task name"
          }.lparams {
              setMargins(16, 16, 16, 0)
              width = matchParent
          }
          button("Add") {
            onClick {
              val output = Intent()
              output.putExtra("taskName", taskNameInput.text.toString())
              output.putExtra("roommateName", taskRoommate.text.toString())
              setResult(Activity.RESULT_OK, output)
              finish()
            }
          }.lparams {
              gravity = right
              setMargins(8, 16, 8, 0)
          }
        }
    }
}
