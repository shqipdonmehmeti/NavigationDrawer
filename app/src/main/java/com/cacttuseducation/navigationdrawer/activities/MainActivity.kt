package com.cacttuseducation.navigationdrawer.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.cacttuseducation.navigationdrawer.R
import com.cacttuseducation.navigationdrawer.databinding.ActivityMainBinding
import com.cacttuseducation.navigationdrawer.fragments.AboutUsFragment
import com.cacttuseducation.navigationdrawer.fragments.ContactUsFragment
import com.cacttuseducation.navigationdrawer.fragments.LocationFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var aboutUsFragment : AboutUsFragment
    private lateinit var contactUsFragment: ContactUsFragment
    private lateinit var locationFragment: LocationFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToggleAndAddDrawerLayout()
        showMenuButton()
        createFragments()
        handleNavigationClick()
    }

    private fun createFragments() {
        aboutUsFragment = AboutUsFragment()
        contactUsFragment = ContactUsFragment()
        locationFragment = LocationFragment()
    }

    private fun handleNavigationClick() {
        binding.navigationView.setNavigationItemSelectedListener {
            closeDrawerIfOpened()
            when(it.itemId) {
                R.id.menuAboutUs -> setCurrentFragment(aboutUsFragment)
                R.id.menuContactUs -> setCurrentFragment(contactUsFragment)
                R.id.menuLocation -> setCurrentFragment(locationFragment)
            }
            true

        }
    }

    private fun setCurrentFragment(currentFragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer,currentFragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun closeDrawerIfOpened() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawers()
        }
    }

    private fun showMenuButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initToggleAndAddDrawerLayout() {
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}