package diphendara.antiguo.translator.fragments.normalToAntiguo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.parsers.Text2Antiguo

class ToAntiguoFragment(): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var layout = arguments?.getInt("fragmentLayout")

        if (layout == null) {
            layout = R.layout.string_to_antiguo_fragment
        }

        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var resourceEditText = arguments?.getInt("fragmentInputText")
        var resourceAntiguoTextView = arguments?.getInt("antiguoTextView")
        var resourceTextTextView = arguments?.getInt("textTextView")

        if (resourceEditText == null || resourceAntiguoTextView == null || resourceTextTextView == null  ) {
            resourceEditText = R.id.inputText
            resourceAntiguoTextView = R.id.antiguoTextView4
            resourceTextTextView = R.id.textTextView4
        }

        val inputText = view.findViewById<EditText>(resourceEditText)
        val antiguoTextView = view.findViewById<TextView>(resourceAntiguoTextView)
        val textTextView = view.findViewById<TextView>(resourceTextTextView)

        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    if(arguments!!.getString("ToParse") == "string") {
                        antiguoTextView.text = Text2Antiguo.parseText(s.toString())
                    } else {
                        antiguoTextView.text = Text2Antiguo.parseNumber(s.toString())
                    }

                    textTextView.text = s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

}