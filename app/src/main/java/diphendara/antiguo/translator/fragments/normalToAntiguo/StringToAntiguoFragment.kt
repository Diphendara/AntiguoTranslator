package diphendara.antiguo.translator.fragments.normalToAntiguo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.parsers.Text2Antiguo
import kotlinx.android.synthetic.main.string_to_antiguo_fragment.*

class StringToAntiguoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.string_to_antiguo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()) {
                    antiguoTextView4.text = Text2Antiguo.parseText(s.toString())
                    textTextView4.text = s.toString()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

}