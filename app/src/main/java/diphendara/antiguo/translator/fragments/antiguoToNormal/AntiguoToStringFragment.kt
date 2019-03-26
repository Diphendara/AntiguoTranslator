package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Antiguo2Text
import kotlinx.android.synthetic.main.antiguo_to_string_fragment.*

class AntiguoToStringFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.antiguo_to_string_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        simbolsGridView.adapter = CustomGridAdapter(
            context!!,
            generateKnowCaseArray(),
            ::setText)
    }

    private fun setText(knowCase: KnowCase)
    {
        antiguoTextView.append(knowCase.antiguoValue)
        textTextView.text = Antiguo2Text.parseText(antiguoTextView.text.toString())
    }

    private fun generateKnowCaseArray(): Array<KnowCase>
    {
        val listTexts = Array(45) { KnowCase("a", "H") }
        val normalChars = "bcdefghijklmnopqrstuvwxyz"
        val capitalChars = "BCDFGHJKLMPRSTVWXYZ"

        val vowelAArray = Array(1) { KnowCase("a", "H") }

        var generalIndex = 0

        normalChars.toCharArray().forEachIndexed { index, element ->
            listTexts[index] = KnowCase(element.toString(), element.toString())
        }

        generalIndex += normalChars.length

        capitalChars.toCharArray().forEachIndexed { index, element ->
            listTexts[generalIndex+index] = KnowCase(element.toString().toLowerCase()+'a', element.toString())
        }

        return vowelAArray+listTexts
    }

}