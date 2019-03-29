package diphendara.antiguo.translator.fragments.antiguoToNormal

import android.media.Image
import android.view.View
import android.widget.GridView
import android.widget.ImageButton
import diphendara.antiguo.translator.AntiguoGridAdapter
import diphendara.antiguo.translator.R
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.fragments.CustomFragment

class ToStringFragment : CustomFragment()
{
    private var resourceGridView =  R.id.simbolsGridView
    private var resourceEraseButton = R.id.eraseButton

    override fun setInputComponentIdentificator()
    {
        resourceGridView = arguments!!.getInt("fragmentGridView")
        resourceEraseButton = arguments!!.getInt("eraseButton")
    }

    override fun setCustomBehavoir(view: View)
    {
        val gridView = view.findViewById<GridView>(resourceGridView)
        val eraseButton = view.findViewById<ImageButton>(resourceEraseButton)
        var knowCaseArray = KnowCase.getKnowLetters()

        val type = arguments!!.getString("ToParse")

        if(type == "number") {
            knowCaseArray = KnowCase.getKnowNumbers()
        }

        gridView.adapter = AntiguoGridAdapter(
            context!!,
            knowCaseArray,
            type,
            eraseButton,
            antiguoTextView!!,
            textTextView!!)
    }
}