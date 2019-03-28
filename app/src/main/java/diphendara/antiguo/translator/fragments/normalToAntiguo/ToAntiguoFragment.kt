package diphendara.antiguo.translator.fragments.normalToAntiguo

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.fragments.CustomFragment
import diphendara.antiguo.translator.parsers.ParseNumber
import diphendara.antiguo.translator.parsers.Text2Antiguo

class ToAntiguoFragment: CustomFragment()
{
    private var resourceEditText =  R.id.inputText

    override fun setInputComponentIdentificator()
    {
        resourceEditText = arguments!!.getInt("fragmentInputText")
    }

    override fun setCustomBehavoir(view: View) {
        val inputText = view.findViewById<EditText>(resourceEditText)

        setChangedListener(inputText)
    }

    private fun setChangedListener(inputText: EditText)
    {
        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    if(arguments!!.getString("ToParse") == "string") {
                        antiguoTextView!!.text = Text2Antiguo.parseText(s.toString())
                    } else {
                        antiguoTextView!!.text = ParseNumber.parseNumber(s.toString(), 5)
                    }

                    textTextView!!.text = s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}