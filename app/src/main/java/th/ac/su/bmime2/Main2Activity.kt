package th.ac.su.bmime2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val height = intent.getDoubleExtra("height", -1.0)
        val weight = intent.getDoubleExtra("weight", -1.0)

        var bminum = findViewById<TextView>(R.id.bminum)
        var btnclose = findViewById<TextView>(R.id.btnclose)
        var bmiis = findViewById<TextView>(R.id.bmiis)
        var heiwei = findViewById<TextView>(R.id.heiwei)


        var heightforbmi: Double = 0.0
        var result: Double = 0.0

        heightforbmi = height / 100
        result = weight / (heightforbmi * heightforbmi)

        bminum.setText(result.toString())

        if (result < 18.50) {
            bmiis.setText("(Underweight)")

        } else if (result >= 18.50 && result <= 25.00) {
            bmiis.setText("(Healthy)")

        } else if (result > 25.00 && result <= 30.00) {
            bmiis.setText("(Overweight)")

        } else if (result > 30) {
            bmiis.setText("(Obese)")

        }

        heiwei.setText("height :" + height.toString() + "weight :" + weight.toString())

        var btnShare = findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener {

            val value = ("height :" + height.toString() + "weight :" + weight.toString())

            var intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, value)
            intent.type = "text/plan"

            startActivity(Intent.createChooser(intent, "share info"))
        }
        btnclose.setOnClickListener {

            var intent = Intent()
            intent.putExtra("rate", bminum.text.toString().toDouble())

            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
