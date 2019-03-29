package diphendara.antiguo.translator

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Antiguo2Text
import diphendara.antiguo.translator.parsers.ParseNumber

class AntiguoGridAdapter(
    private val context: Context,
    private val gridValues: Array<KnowCase>,
    private val type: String?,
    private val eraseButton: ImageButton,
    private val antiguoTextView: TextView,
    private val textTextView: TextView
    ) : BaseAdapter() {

    override fun getCount(): Int {
        return gridValues.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val gridView: View

        if (convertView == null) {

            gridView = inflater.inflate(R.layout.antiguo_button, null)

            val button = gridView.findViewById(R.id.customButtonLayout) as LinearLayout

            val buttonAntiguoTextView = gridView.findViewById(R.id.buttonAntiguoTextView) as TextView
            buttonAntiguoTextView.text = gridValues[position].antiguoValue

            val buttonTextTextView = gridView.findViewById(R.id.buttonTextTextView) as TextView
            buttonTextTextView.text = gridValues[position].value

            button.setOnClickListener{
                setTextInViews(antiguoTextView.text.toString()+gridValues[position].value)
            }

            eraseButton.setOnClickListener{
                if(antiguoTextView.text.isNotEmpty()) {
                    setTextInViews(antiguoTextView.text.substring(0, antiguoTextView.text.length-1))
                }
            }

        } else {
            gridView = convertView
        }

        return gridView
    }

    private fun setTextInViews(antiguoValue: String)
    {
        antiguoTextView.text = antiguoValue
        val numeric = antiguoValue.matches("[0-9]+".toRegex())

        if("string" == type) {
            textTextView.text = Antiguo2Text.parseText(antiguoValue)
        } else if(numeric){
            textTextView.text = ParseNumber.parseNumber(antiguoValue, 10)
        } else {
            textTextView.text = ""
        }
    }
}