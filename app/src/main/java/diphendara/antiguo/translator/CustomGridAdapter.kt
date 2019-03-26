package diphendara.antiguo.translator

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import diphendara.antiguo.translator.dataObjects.KnowCase

class CustomGridAdapter(
    private val context: Context,
    private val gridValues: Array<KnowCase>,
    private val onClick: (KnowCase) -> Unit
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
                onClick(gridValues[position])
            }

        } else {
            gridView = convertView
        }

        return gridView
    }
}