package diphendara.antiguo.translator

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import diphendara.antiguo.translator.fragments.normalToAntiguo.Decimal2QuinaryFragment
import diphendara.antiguo.translator.fragments.antiguoToNormal.Quinary2DecimalFragment
import diphendara.antiguo.translator.fragments.antiguoToNormal.AntiguoToStringFragment
import diphendara.antiguo.translator.fragments.normalToAntiguo.StringToAntiguoFragment

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
                StringToAntiguoFragment()
            }
            2 -> {
                Quinary2DecimalFragment()
            }
            3 -> {
                Decimal2QuinaryFragment()
            }
            else -> AntiguoToStringFragment()
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