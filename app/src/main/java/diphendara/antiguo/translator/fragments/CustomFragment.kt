package diphendara.antiguo.translator.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import diphendara.antiguo.translator.R

abstract class CustomFragment: Fragment()
{
    private var layout = R.layout.string_to_antiguo_fragment
    private var resourceAntiguoTextView = R.id.antiguoTextView
    private var resourceTextTextView = R.id.textTextView
    var antiguoTextView: TextView? = null
    var textTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        if(arguments != null){
            layout = arguments!!.getInt("fragmentLayout")
        }
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        if(arguments == null){
            return
        }
        setInputComponentIdentificator()
        setTextViewsIdentificators(view)
        setCustomBehavoir(view)
    }

    abstract fun setInputComponentIdentificator()

    fun setTextViewsIdentificators(view: View)
    {
        resourceAntiguoTextView = arguments!!.getInt("antiguoTextView")
        resourceTextTextView = arguments!!.getInt("textTextView")

        antiguoTextView = view.findViewById(resourceAntiguoTextView)
        textTextView = view.findViewById(resourceTextTextView)
    }

    abstract fun setCustomBehavoir(view: View)

}