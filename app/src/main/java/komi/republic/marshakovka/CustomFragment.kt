package komi.republic.marshakovka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

open class CustomFragment():Fragment(){

    private var menuItem:MenuItem? = null
    private val TAG = "CustomFragment"

    constructor(item:MenuItem):this(){
        this.menuItem = item
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = requireView().findViewById(R.id.text_view) as TextView
        textView.text = menuItem.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(item: MenuItem):CustomFragment {
            return CustomFragment(item)
        }
    }
}