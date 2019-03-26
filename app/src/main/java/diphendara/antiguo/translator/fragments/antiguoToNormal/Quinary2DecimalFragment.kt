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
import diphendara.antiguo.translator.parsers.Text2Antiguo
import kotlinx.android.synthetic.main.antiguo_button.*
import kotlinx.android.synthetic.main.quinary_to_decimal_fragment.*

class Quinary2DecimalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.quinary_to_decimal_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listNumbers = Array(5) { KnowCase("0", "0") }
        val numbers = "01234"

        numbers.toCharArray().forEachIndexed { index, element ->
            listNumbers[index] = KnowCase(element.toString(), element.toString())
        }

        quinaryGridView.adapter = CustomGridAdapter(
            context!!,
            listNumbers,
            ::setText)

    }

    private fun setText(knowCase: KnowCase)
    {
        textTextView3.append(knowCase.value)
        buttonAntiguoTextView.text = Antiguo2Text.parseNumber(textTextView3.text.toString())
    }

}