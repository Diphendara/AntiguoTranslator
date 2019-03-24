package diphendara.antiguo.translator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Text2Antiguo
import kotlinx.android.synthetic.main.number_fragment_tab1.*




class NumberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.number_fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listNumbers = Array(5) { KnowCase("0", "0") }
        val numbers = "01234"

        numbers.toCharArray().forEachIndexed { index, element ->
            listNumbers[index] = KnowCase(element.toString(), element.toString())
        }

        numbersGridView.adapter = CustomGridAdapter(
            context!!,
            listNumbers,
            antiguoNumberTextView,
            textNumberTextView,
            "number")

        setTextToAntiguoListener()

    }

    private fun setTextToAntiguoListener() {
        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    try {
                        antiguoNumberTextView.text = Text2Antiguo.parseNumber(s.toString())
                        textNumberTextView.text = s.toString()
                    } catch (exception: NumberFormatException) {
                        Toast.makeText(context, getString(R.string.number_to_long), Toast.LENGTH_LONG).show()
                    }
                } else {
                    antiguoNumberTextView.text = ""
                    textNumberTextView.text = ""

                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}