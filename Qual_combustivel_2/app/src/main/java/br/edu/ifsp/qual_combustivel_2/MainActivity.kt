package br.edu.ifsp.qual_combustivel_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.qual_combustivel_2.R
import java.lang.NumberFormatException
class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var gasolineEditText: EditText
    private lateinit var ethanolEditText: EditText
    private lateinit var mButton: Button
    private lateinit var mTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findById()
        setClick()
    }
    override fun onClick(v: View) {
        if (v == mButton) {
            calculate()
        }
    }
    /**
     * Faz o calculo de qual dos combustíveis é mais vantajoso
     * para o abastecimento. O método valida os dados de entrada
     * e apresenta as mensagens diretamente em objetos do leiaute.
     */
    private fun calculate() {
        if (gasolineEditText.text.toString().isEmpty() ||
            ethanolEditText.text.toString().isEmpty()) {
            Toast.makeText(
                this,
                getString(R.string.gasoline_qtd),
                Toast.LENGTH_SHORT
            ).show();
            mTextView.text = ""
        } else {
            val gas = retriveValue(gasolineEditText)
            val etha = retriveValue(ethanolEditText)
            val result = etha / gas
            if (result < 0.7) {
                mTextView.text = getString(R.string.answer_ethanol)
                mTextView.setTextColor(resources.getColor(R.color.ethanol,
                    this.theme))
            } else {
                mTextView.text = getString(R.string.answer_gas)
                mTextView.setTextColor(resources.getColor(R.color.gasoline,
                    this.theme))
            }
        }
    }
    /**
     * Recupera o valor Double que está no Edittext que
     * é passado como argumento para o método. Em caso de
     * erro (exceção) o valor zero é retornado.
     */
    private fun retriveValue(input: EditText): Double {
        return try {
            input.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, getString(R.string.wrong_value), Toast.LENGTH_SHORT).show()
            0.0
        }
    }
    private fun findById() {
        gasolineEditText = findViewById(R.id.edittext_gasoline)
        ethanolEditText = findViewById(R.id.edittext_ethanol)
        mButton = findViewById(R.id.button_calculate)
        mTextView = findViewById(R.id.textview_response)
    }
    private fun setClick() {
        mButton.setOnClickListener(this)
    }
}