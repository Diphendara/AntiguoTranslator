package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.view.View
import android.widget.GridView
import diphendara.antiguo.translator.CustomGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.fragments.CustomFragment
import diphendara.antiguo.translator.parsers.Antiguo2Text
import diphendara.antiguo.translator.parsers.ParseNumber
import kotlinx.android.synthetic.main.antiguo_to_string_fragment.view.*

class ToStringFragment : CustomFragment()
{
    private var resourceGridView =  R.id.simbolsGridView

    override fun setInputComponentIdentificator()
    {
        resourceGridView = arguments!!.getInt("fragmentGridView")
    }

    override fun setCustomBehavoir(view: View)
    {
        val gridView = view.findViewById<GridView>(resourceGridView)
        var knowCaseArray = KnowCase.getKnowLetters()

        if(arguments!!.getString("ToParse") == "number") {
            knowCaseArray = KnowCase.getKnowNumbers()
        }

        gridView.adapter = CustomGridAdapter(
            context!!,
            knowCaseArray,
            ::setText)
    }


    private fun setText(knowCase: KnowCase, view: View)
    {
        System.out.println(knowCase)
        System.out.println(view)
        antiguoTextView!!.append(knowCase.value)
        if(arguments!!.getString("ToParse") == "string") {
            textTextView!!.text = Antiguo2Text.parseText(view.antiguoTextView!!.text.toString())
        } else {
            textTextView!!.text = ParseNumber.parseNumber(view.antiguoTextView!!.text.toString(), 10)
        }
    }

}