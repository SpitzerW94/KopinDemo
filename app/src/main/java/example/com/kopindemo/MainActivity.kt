package example.com.kopindemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.toast_btn)
        val dialogButton = findViewById<Button>(R.id.dialog_btn)
        val colourButton = findViewById<Button>(R.id.mode_btn)

        toastButton.setOnClickListener{showToast()}
        dialogButton.setOnClickListener{showDialog()}
        colourButton.setOnClickListener{changeMode()}
    }

    fun showDialog() {
        val builder = AlertDialog.Builder(this@MainActivity, android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
        builder.setTitle(getString(R.string.dialog_title))
                .setMessage(getString(R.string.dialog_msg))
                .setPositiveButton(getString(R.string.dialog_button1)){ _, _ ->
                    // do something
                }
                .setNegativeButton(getString(R.string.dialog_button2)){ _, _ ->
                    // do something else
                }
        builder.create().show()
    }

    fun showToast() {
        Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_SHORT).show()
    }

    fun changeMode() {
        val colour = Color.argb(255, (0..256).random(), (0..256).random(), (0..256).random())
        val background = findViewById<ConstraintLayout>(R.id.app_background)
        background.setBackgroundColor(colour)
    }

    fun IntRange.random() = Random().nextInt((endInclusive + 1) - start) + start
}
