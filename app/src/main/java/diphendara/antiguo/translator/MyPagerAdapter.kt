package diphendara.antiguo.translator

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TextFragment()
            }
            1 -> {
                NumberFragment()
            }
            else -> TextFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.resources.getString(R.string.text_tab)
            1 -> context.resources.getString(R.string.number_tab)
            else -> {
                return ""
            }
        }
    }
}