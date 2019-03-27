package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.GridView
import android.widget.TextView
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.ParseNumber
import kotlinx.android.synthetic.main.antiguo_button.*
import kotlinx.android.synthetic.main.quinary_to_decimal_fragment.*

class ToStringFragment : Fragment() {

    private var resourceGridView =  R.id.simbolsGridView
    private var layout = R.layout.antiguo_to_string_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        if(arguments != null){
            layout = arguments!!.getInt("fragmentLayout")
        }

        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        setComponentsIdentificators()

        val gridView = view.findViewById<GridView>(resourceGridView)

        gridView.adapter = CustomGridAdapter(
            context!!,
            generateKnowCaseArray(),
            ::setText)
    }

    private fun setComponentsIdentificators()
    {
        if(arguments == null){
            return
        }

        resourceGridView = arguments!!.getInt("fragmentGridView")
    }

    private fun setText(knowCase: KnowCase)
    {
        textTextView3.append(knowCase.value)
        buttonAntiguoTextView.text = ParseNumber.parseNumber(textTextView3.text.toString(), 10)
    }

    private fun generateKnowCaseArray(): Array<KnowCase>
    {
        val listNumbers = Array(5) { KnowCase("0", "0") }
        val numbers = "01234"

        numbers.toCharArray().forEachIndexed { index, element ->
            listNumbers[index] = KnowCase(element.toString(), element.toString())
        }

        return listNumbers
    }



}