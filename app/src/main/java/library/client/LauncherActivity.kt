package library.client

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class LauncherActivity : AppCompatActivity() {

    private var bottomNavigationView: BottomNavigationView? = null
    private val TAG = "LauncherActivity"
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

    private fun showMainPage(){
        val menu: Menu = bottomNavigationView!!.menu
        val menuItem:MenuItem = menu.getItem(0)
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            CustomFragment.newInstance(menuItem)
        ).commit()
    }

    private fun setViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
    }

    private fun setListeners() {
        bottomNavigationView?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                CustomFragment.newInstance(item)
            ).commit()
            return@OnNavigationItemSelectedListener true
        }
}