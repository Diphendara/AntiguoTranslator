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
import diphendara.antiguo.translator.parsers.ParseNumber
import diphendara.antiguo.translator.parsers.Text2Antiguo

class ToAntiguoFragment: Fragment() {

    private var resourceEditText =  R.id.inputText
    private var resourceAntiguoTextView = R.id.antiguoTextView4
    private var resourceTextTextView = R.id.textTextView4

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        var layout = arguments?.getInt("fragmentLayout")

        if (layout == null) {
            layout = R.layout.string_to_antiguo_fragment
        }

        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        setComponentsIdentificators()

        val inputText = view.findViewById<EditText>(resourceEditText)
        val antiguoTextView = view.findViewById<TextView>(resourceAntiguoTextView)
        val textTextView = view.findViewById<TextView>(resourceTextTextView)

        setChangedListener(inputText, antiguoTextView, textTextView);
    }

    private fun setComponentsIdentificators()
    {
        if(arguments == null){
           return
        }

        resourceEditText = arguments!!.getInt("fragmentInputText")
        resourceAntiguoTextView = arguments!!.getInt("antiguoTextView")
        resourceTextTextView = arguments!!.getInt("textTextView")
    }

    private fun setChangedListener(inputText: EditText, antiguoTextView: TextView, textTextView: TextView)
    {
        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    if(arguments!!.getString("ToParse") == "string") {
                        antiguoTextView.text = Text2Antiguo.parseText(s.toString())
                    } else {
                        antiguoTextView.text = ParseNumber.parseNumber(s.toString(), 5)
                    }

                    textTextView.text = s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}