package com.esq.ecxcoronaapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.esq.ecxcoronaapp.ui.bottom_nav.HomeFragment
import com.esq.ecxcoronaapp.ui.bottom_nav.NewsFragment
import com.esq.ecxcoronaapp.ui.bottom_nav.StatsFragment
import com.esq.ecxcoronaapp.ui.navigation_drawer.about_us.AboutUsActivity
import com.esq.ecxcoronaapp.utils.shortToast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val TAG = this::class.simpleName
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var homeFragment: HomeFragment
    lateinit var newsFragment: NewsFragment
    lateinit var statFragment: StatsFragment
    private lateinit var activeFrag: Fragment
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationMenuView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        homeFragment = HomeFragment.newInstance()
        newsFragment = NewsFragment.newInstance()
        statFragment = StatsFragment.newInstance()
        activeFrag = homeFragment
        supportFragmentManager.beginTransaction().add(R.id.container, homeFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, newsFragment)
            .hide(newsFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, statFragment)
            .hide(statFragment).commit()
        setUpBottomNavBar()
        setUpNavView()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onBackPressed() {
        val drawer = drawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else if (bottomNavigationMenuView.id == R.id.home)
            super.onBackPressed()
        else
            bottomNavigationMenuView.id = R.id.home
    }

/*
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
 */

    private fun setUpNavView() {
        drawerLayout = drawer_layout
        val navView: NavigationView = nav_view
        navView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,  R.string.navigation_drawer_open,   R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        /*
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        */
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_us -> {
                startActivity(Intent(this@MainActivity, AboutUsActivity::class.java))
                shortToast("Home clicked")
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
       return true
    }

    private fun setUpBottomNavBar() {
        bottomNavigationMenuView = bottom_nav
        bottomNavigationMenuView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    shortToast("Home Clicked")
                    setFragment(homeFragment)
                    true
                }
                R.id.news -> {
                    shortToast("News clicked")
                    setFragment(newsFragment)
                    true
                }
                R.id.stats -> {
                    shortToast("Stats clicked")
                    setFragment(statFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().hide(activeFrag)
        transaction.show(fragment)
        activeFrag = fragment
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

}
