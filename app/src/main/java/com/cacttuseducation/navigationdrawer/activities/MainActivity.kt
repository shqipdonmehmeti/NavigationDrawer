package com.cacttuseducation.navigationdrawer.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.cacttuseducation.navigationdrawer.R
import com.cacttuseducation.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)












    }
}