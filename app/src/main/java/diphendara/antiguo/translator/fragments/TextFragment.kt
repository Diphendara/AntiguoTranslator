package diphendara.antiguo.translator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Text2Antiguo
import kotlinx.android.synthetic.main.number_fragment_tab1.*
import kotlinx.android.synthetic.main.text_fragment_tab0.*

class TextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.text_fragment_tab0, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listTexts = Array(45) { KnowCase("a", "H") }
        val normalChars = "bcdfghjklmpqrstvwxyz"
        val capitalChars = "BCDFGHJKLMPRSTVWXYZ"
        val vowels = "eiou"

        var generalIndex = 0

        normalChars.toCharArray().forEachIndexed { index, element ->
            listTexts[index] = KnowCase(element.toString(), element.toString())
        }

        generalIndex = normalChars.length-1

        capitalChars.toCharArray().forEachIndexed { index, element ->
            listTexts[generalIndex+index] = KnowCase(element.toString(), element.toString())
        }

        generalIndex = capitalChars.length-1 + normalChars.length-1

        vowels.toCharArray().forEachIndexed { index, element ->
            listTexts[generalIndex+index] = KnowCase(element.toString(), element.toString())
        }

        listTexts[listTexts.size-1] = KnowCase("a", "H")

        simbolsGridView.adapter = CustomGridAdapter(
            context!!,
            listTexts,
            textTextView,
            antiguoTextTextView,
            "text")

        inputText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                antiguoTextTextView.text = Text2Antiguo.parseText(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}