package diphendara.antiguo.translator

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import diphendara.antiguo.translator.fragments.antiguoToNormal.Quinary2DecimalFragment
import diphendara.antiguo.translator.fragments.antiguoToNormal.AntiguoToStringFragment
import diphendara.antiguo.translator.fragments.normalToAntiguo.ToAntiguoFragment
import android.os.Bundle

class MyPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return AntiguoToStringFragment()
            }
            1 -> {
                //String to Antiguo
                val arguments = Bundle()
                val fragment = ToAntiguoFragment()

                arguments.putInt("fragmentLayout", R.layout.string_to_antiguo_fragment)
                arguments.putInt("fragmentInputText", R.id.inputText)
                arguments.putInt("antiguoTextView", R.id.antiguoTextView4)
                arguments.putInt("textTextView", R.id.textTextView4)
                arguments.putString("ToParse", "string")

                fragment.arguments = arguments

                return fragment
            }
            2 -> {
                return Quinary2DecimalFragment()
            }
            3 -> {
                //Number to Antiguo
                val arguments = Bundle()
                val fragment = ToAntiguoFragment()

                arguments.putInt("fragmentLayout", R.layout.decimal_to_quinary_fragment)
                arguments.putInt("fragmentInputText", R.id.dec2AntInput)
                arguments.putInt("antiguoTextView", R.id.antiguoTextView2)
                arguments.putInt("textTextView", R.id.textTextView2)
                arguments.putString("ToParse", "number")

                fragment.arguments = arguments

                return fragment
            }
            else -> return AntiguoToStringFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.resources.getString(R.string.antiguo_text_tab)
            1 -> context.resources.getString(R.string.string_text_tab)
            2 -> context.resources.getString(R.string.antiguo_number_tab)
            3 -> context.resources.getString(R.string.number_text_tab)
            else -> {
                return ""
            }
        }
    }
}