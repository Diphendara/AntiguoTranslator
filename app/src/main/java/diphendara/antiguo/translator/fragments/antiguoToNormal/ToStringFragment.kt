package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.view.View
import android.widget.GridView
import diphendara.antiguo.translator.AntiguoGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.fragments.CustomFragment

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

        val type = arguments!!.getString("ToParse")

        if(type == "number") {
            knowCaseArray = KnowCase.getKnowNumbers()
        }

        gridView.adapter = AntiguoGridAdapter(
            context!!,
            knowCaseArray,
            type,
            antiguoTextView!!,
            textTextView!!)
    }
}