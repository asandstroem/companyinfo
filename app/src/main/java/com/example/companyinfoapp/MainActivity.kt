package com.example.companyinfoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        var navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        drawer = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            val descFrag = DescriptionFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, descFrag).commit()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val descFrag = DescriptionFragment()
        val webFrag = WebFragment()
        val mapFrag = MapFragment()
        when (item.itemId) {
            R.id.nav_description -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    descFrag).commit()
            }
            R.id.nav_web -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    webFrag).commit()
            }
            R.id.nav_map -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    mapFrag).commit()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
