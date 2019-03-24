package diphendara.antiguo.translator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import diphendara.antiguo.translator.R
import kotlinx.android.synthetic.main.number_fragment_tab1.*



class NumberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.number_fragment_tab1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        inputNumber.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    try {
                        antiguoNumberTextView.text = parseText(s.toString())
                    } catch (exception: NumberFormatException) {
                        Toast.makeText(context, getString(R.string.number_to_long), Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    fun parseText(inputText: String): String {
        val number: Long = inputText.toLong()
        val quotient = number / 5
        val remainder = number % 5

        return if (quotient.compareTo(0) == 0){
            remainder.toString()
        } else {
            parseText(quotient.toString()) + remainder.toString()
        }
    }

}