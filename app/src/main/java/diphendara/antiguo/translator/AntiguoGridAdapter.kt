package diphendara.antiguo.translator

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import diphendara.antiguo.translator.dataObjects.KnowCase
import diphendara.antiguo.translator.parsers.Antiguo2Text
import diphendara.antiguo.translator.parsers.ParseNumber

class AntiguoGridAdapter(
    private val context: Context,
    private val gridValues: Array<KnowCase>,
    private val type: String?,
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
                antiguoTextView.append(gridValues[position].value)
                if("string" == type) {
                    textTextView.text = Antiguo2Text.parseText(antiguoTextView.text.toString())
                } else {
                    textTextView.text = ParseNumber.parseNumber(antiguoTextView.text.toString(), 10)
                }
            }

        } else {
            gridView = convertView
        }

        return gridView
    }
}