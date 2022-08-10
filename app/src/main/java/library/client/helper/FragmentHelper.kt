package library.client.helper

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import library.client.LauncherActivity
import library.client.R
import library.client.fragment.home.HomeFragment
import library.client.fragment.other.TopFragment

class FragmentHelper() : AsyncTask<Fragment, Void, Void>() {

    private var selectedFragment: Fragment = HomeFragment()
    private var selectedTopFragment: Fragment = TopFragment()
    @SuppressLint("StaticFieldLeak")
    private var mainBottomNavigationView: BottomNavigationView? = null
    @SuppressLint("StaticFieldLeak")
    private var launcherActivity: LauncherActivity? = null
    private val TAG = "FragmentHelper"

    constructor(launcherActivity: LauncherActivity,
                checkBoxBottomNavigation:Boolean,
                topFragment: Boolean) : this() {
                    this.launcherActivity = launcherActivity
        this.mainBottomNavigationView = launcherActivity.getBottomNavigationView()
        setCheckBoxNavigation(checkBoxBottomNavigation)
        setTopFragment(topFragment)
    }

    override fun doInBackground(vararg fragments: Fragment): Void? {
        setSelectedFragment(fragments[0])
        return null
    }

    override fun onPostExecute(unused: Void?) {
        super.onPostExecute(unused)
        setSelectedFragmentToContainer()
    }

    private fun setSelectedFragmentToContainer() {
        launcherActivity!!.supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                selectedFragment)
            .commit()
    }

    private fun setTopFragment(topFragment: Boolean) {
        if(topFragment){
            setSelectedTopFragmentToContainer()
            return
        }
        launcherActivity!!.findViewById<FrameLayout>(R.id.top_header_container)
            .visibility = View.GONE
    }

    private fun setCheckBoxNavigation(checkBoxBottomNavigation: Boolean) {
        val bottomMenu:Menu = mainBottomNavigationView!!.menu
        if(checkBoxBottomNavigation){
            setBottomMenuChecked(bottomMenu)
            return
        }
        setBottomMenuUnChecked(bottomMenu)
    }

    private fun setBottomMenuChecked(bottomMenu:Menu) {
        bottomMenu.setGroupCheckable(0,true,true)
    }

    private fun setBottomMenuUnChecked(bottomMenu: Menu) {
        bottomMenu.setGroupCheckable(0,false,true)
    }

    private fun setSelectedTopFragmentToContainer(){
        launcherActivity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.top_header_container,
            selectedTopFragment).commit()
        launcherActivity!!.findViewById<FrameLayout>(R.id.top_header_container).visibility = View.VISIBLE
    }

    fun setSelectedFragment(fragment: Fragment) {
        this.selectedFragment = fragment
    }

    fun getSelectedFragment():Fragment{
        return this.selectedFragment
    }

    fun getSelectedTopFragment():Fragment{
        return this.selectedTopFragment
    }
}