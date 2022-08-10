package library.client

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import library.client.fragment.home.HomeFragment
import library.client.fragment.other.NoConnectionFragment
import library.client.helper.FragmentHelper
import library.client.response.NetworkResponse


class LauncherActivity : AppCompatActivity(), NetworkResponse {

    var isNetworkEnabled = false
    private var bottomNavigationView: BottomNavigationView? = null
//    private val tag = "LauncherActivity"
    private var backWasPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launcher)
        setViews()
        setListeners()
        showMainPage()
    }

    override fun onBackPressed() {
        if (backWasPressed) {
            super.onBackPressed()
            moveTaskToBack(true)
            backWasPressed = false
            finish()
        } else {
            Toast.makeText(
                this,
                getString(R.string.close_on_back_alert),
                Toast.LENGTH_SHORT
            ).show()
            backWasPressed = true
        }
    }

    private fun showMainPage() {
        val menu: Menu = bottomNavigationView!!.menu
        val menuItem: MenuItem = menu.getItem(0)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            CustomFragment.newInstance(menuItem)
        ).commit()
    }

    private fun setViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    @Suppress("DEPRECATION")
    private fun setListeners() {
        bottomNavigationView?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    @Suppress("DEPRECATION")
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                CustomFragment.newInstance(item)
            ).commit()
            return@OnNavigationItemSelectedListener true
        }

    fun getBottomNavigationView(): BottomNavigationView? {
        return this.bottomNavigationView
    }

    override fun NetworkCheckFinish(status: Boolean?) {
        if (status!!) {
            if (!isNetworkEnabled) {
                isNetworkEnabled = true
                FragmentHelper(this, true, true)
                    .execute(HomeFragment())
                setBottomNavigationViewVisible()
            }
        } else {
            isNetworkEnabled = false
            setBottomNavigationViewInvisible()
            FragmentHelper(this, true, false)
                .execute(NoConnectionFragment())
        }
    }

    private fun setBottomNavigationViewInvisible() {
        TODO("Not yet implemented")
    }

    private fun setBottomNavigationViewVisible() {
        TODO("Not yet implemented")
    }
}