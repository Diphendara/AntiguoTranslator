package diphendara.antiguo.translator

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Text2Antiguo

class CustomGridAdapter(
    private val context: Context,
    private val gridValues: Array<KnowCase>,
    private val antiguoTextView: TextView,
    private val textTextView: TextView,
    private val typeOfConversion: String
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

            val buttonAntiguoTextView = gridView.findViewById(R.id.antiguoTextView) as TextView
            buttonAntiguoTextView.text = gridValues[position].antiguoValue

            button.setOnClickListener {
                antiguoTextView.append(gridValues[position].antiguoValue)

                if("number" == typeOfConversion ) {
                    val totalText = antiguoTextView.text.toString() + gridValues[position].antiguoValue
                    textTextView.text = Text2Antiguo.parseNumber(totalText)
                } else {
                    textTextView.append(Text2Antiguo.parseText(gridValues[position].value))
                }
            }

        } else {
            gridView = convertView
        }

        return gridView
    }
}