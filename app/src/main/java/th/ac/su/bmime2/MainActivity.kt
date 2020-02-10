package th.ac.su.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var height = findViewById<EditText>(R.id.height)
        var weight = findViewById<EditText>(R.id.weight)
        var btncalculate = findViewById<Button>(R.id.btncalculate)



        btncalculate.setOnClickListener {


            var intent = Intent(this@MainActivity,Main2Activity::class.java)
            intent.putExtra("height",height.text.toString().toDouble())
            intent.putExtra("weight",weight.text.toString().toDouble())



            startActivity(intent)
            /// TODO
        }
    }
}
