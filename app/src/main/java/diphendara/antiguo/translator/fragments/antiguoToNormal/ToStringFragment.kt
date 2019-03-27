package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Antiguo2Text
import diphendara.antiguo.translator.parsers.ParseNumber
import diphendara.antiguo.translator.parsers.Text2Antiguo
import kotlinx.android.synthetic.main.antiguo_button.*
import kotlinx.android.synthetic.main.antiguo_to_string_fragment.*
import kotlinx.android.synthetic.main.quinary_to_decimal_fragment.*

class ToStringFragment : Fragment() {

    private var resourceGridView =  R.id.simbolsGridView
    private var layout = R.layout.antiguo_to_string_fragment
    private var resourceAntiguoTextView = R.id.antiguoTextView4
    private var resourceTextTextView = R.id.textTextView4
    private var antiguoTextView: TextView? = null
    private var textTextView: TextView? = null

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
        antiguoTextView = view.findViewById(resourceAntiguoTextView)
        textTextView = view.findViewById(resourceTextTextView)

        var knowCaseArray = KnowCase.getKnowLetters()

        if(arguments!!.getString("ToParse") == "number") {
            knowCaseArray = KnowCase.getKnowNumbers()
        }

        gridView.adapter = CustomGridAdapter(
            context!!,
            knowCaseArray,
            ::setText)

    }

    private fun setComponentsIdentificators()
    {
        if(arguments == null){
            return
        }

        resourceGridView = arguments!!.getInt("fragmentGridView")
        resourceAntiguoTextView = arguments!!.getInt("antiguoTextView")
        resourceTextTextView = arguments!!.getInt("textTextView")
    }

    private fun setText(knowCase: KnowCase)
    {
        antiguoTextView!!.append(knowCase.value)
        if(arguments!!.getString("ToParse") == "string") {
            textTextView!!.text = Antiguo2Text.parseText(antiguoTextView!!.text.toString())
        } else {
            textTextView!!.text = ParseNumber.parseNumber(antiguoTextView!!.text.toString(), 10)
        }
    }

}