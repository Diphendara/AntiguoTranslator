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
        return when (position) {
            0 -> {
                AntiguoToStringFragment()
            }
            1 -> {
                toAntiguoFragment("string")
            }
            2 -> {
                Quinary2DecimalFragment()
            }
            3 -> {
                toAntiguoFragment("number")
            }
            else -> AntiguoToStringFragment()
        }
    }

    private fun toAntiguoFragment(type: String): Fragment
    {
        val antFragment = ToAntiguoFragment()

        if (type == "string") {
            antFragment.arguments =  stringToAntiguoArguments()
        } else {
            antFragment.arguments = numberToAntiguoFragment()
        }

        return antFragment
    }

    private fun stringToAntiguoArguments(arguments: Bundle = Bundle()): Bundle
    {
        //String to Antiguo
        arguments.putInt("fragmentLayout", R.layout.string_to_antiguo_fragment)
        arguments.putInt("fragmentInputText", R.id.inputText)
        arguments.putInt("antiguoTextView", R.id.antiguoTextView4)
        arguments.putInt("textTextView", R.id.textTextView4)
        arguments.putString("ToParse", "string")

        return arguments
    }

    private fun numberToAntiguoFragment(arguments: Bundle = Bundle()): Bundle
    {
        //Number to Antiguo
        arguments.putInt("fragmentLayout", R.layout.decimal_to_quinary_fragment)
        arguments.putInt("fragmentInputText", R.id.dec2AntInput)
        arguments.putInt("antiguoTextView", R.id.antiguoTextView2)
        arguments.putInt("textTextView", R.id.textTextView2)
        arguments.putString("ToParse", "number")

        return arguments
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