package br.com.furlaneto.murilo.conversortemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val textViewFahrenheit = findViewById<TextView>(R.id.textViewFahrenheit)
        val editTextCelsius = findViewById<EditText>(R.id.editTextCelsius)
        val textResult = findViewById<TextView>(R.id.textViewResult)


        btnCalcular.setOnClickListener {
            val celsius = editTextCelsius.text.toString().toFloatOrNull() ?: 0.0f
            val fahrenheit =  (celsius * 9f/5f) + 32f
            textViewFahrenheit.text = "$fahrenheit ºF"
            textResult.text = "Resultado calculado"
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}