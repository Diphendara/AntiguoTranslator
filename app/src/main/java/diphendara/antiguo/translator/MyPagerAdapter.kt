package diphendara.antiguo.translator

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import diphendara.antiguo.translator.fragments.normalToAntiguo.ToAntiguoFragment
import android.os.Bundle
import diphendara.antiguo.translator.fragments.antiguoToNormal.ToStringFragment

class MyPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //toStringFragment("string")
                toStringFragment("number")
            }
            1 -> {
                toAntiguoFragment("string")
            }
            2 -> {
                toStringFragment("number")
            }
            3 -> {
                toAntiguoFragment("number")
            }
            else -> toStringFragment("string")
        }
    }

    private fun toStringFragment(type: String): Fragment
    {
        val antFragment = ToStringFragment()

        if (type == "string") {
            antFragment.arguments =  antiguoToStringArguments()
        } else {
            antFragment.arguments = antiguoToNumberFragment()
        }

        return antFragment
    }

    private fun antiguoToStringArguments(arguments: Bundle = Bundle()): Bundle
    {
        //Antiruo to String
        arguments.putInt("fragmentLayout", R.layout.antiguo_to_string_fragment)
        arguments.putInt("fragmentGridView", R.id.simbolsGridView)
        arguments.putInt("antiguoTextView", R.id.antiguoTextView)
        arguments.putInt("textTextView", R.id.textTextView)
        arguments.putString("ToParse", "string")

        return arguments
    }

    private fun antiguoToNumberFragment(arguments: Bundle = Bundle()): Bundle
    {
        //Antiguo to Number
        arguments.putInt("fragmentLayout", R.layout.quinary_to_decimal_fragment)
        arguments.putInt("fragmentGridView", R.id.quinaryGridView)
        arguments.putInt("antiguoTextView", R.id.antiguoTextView3)
        arguments.putInt("textTextView", R.id.textTextView3)
        arguments.putString("ToParse", "number")

        return arguments
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