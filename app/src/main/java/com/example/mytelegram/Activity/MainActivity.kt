package com.example.mytelegram.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.databinding.ActivityMainBinding
import com.example.mytelegram.ui.`object`.AppDrawer
import com.example.mytelegram.ui.fragments.ChatFragment
import com.example.mytelegram.utils.replaceActivity
import com.example.mytelegram.utils.replaceFragment

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
        initFunc()
    }

    private fun initFunc() {
        if (true) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatFragment())
        } else {
            replaceActivity(RegisterActivity())
        }

    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)

    }
}