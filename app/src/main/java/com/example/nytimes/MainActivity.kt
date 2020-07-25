package com.example.nytimes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nytimes.databinding.ActivityMainBinding
import com.example.nytimes.ui.`object`.AppDrawer
import com.example.nytimes.ui.fragments.ChatFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunck()
    }

    private fun initFunck() {
        setSupportActionBar(mToolbar);
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.dataContainer,
                ChatFragment()
            ).commit()

    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

    }
}