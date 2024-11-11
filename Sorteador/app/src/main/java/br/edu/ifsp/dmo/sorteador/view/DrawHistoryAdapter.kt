package br.edu.ifsp.dmo.sorteador.view


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.ifsp.dmo.sorteador.R
import br.edu.ifsp.dmo.sorteador.model.Draw


class DrawHistoryAdapter(
    context: Context,
    private val data: List<Int>
) : ArrayAdapter<Int>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.results, parent, false)

        val sequenceTextView: TextView = view.findViewById(R.id.textviewSequence)
        val numberTextView: TextView = view.findViewById(R.id.textviewNumber)

        // Get the number from the data list
        val number = data[position]
        // Format the sequence number and the drawn number
        sequenceTextView.text = "${position + 1} sorteio  |"
        numberTextView.text = String.format("%03d", number)

        return view
    }
}