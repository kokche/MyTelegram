package com.example.mytelegram.ui.`object`

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mytelegram.R
import com.example.mytelegram.ui.fragments.SettingsFragment
import com.example.mytelegram.utils.replaceFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(var mainActivity: AppCompatActivity, var toolbar: Toolbar) {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create() {
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withAccountHeader(mHeader)
            .withActivity(mainActivity)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withToolbar(toolbar)
            .addDrawerItems(
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(100)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_create_group))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(101)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_create_secret_chat))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(102)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_create_channel))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(103)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_contacts))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_contacts),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(104)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_phone))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_phone),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(105)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_favorites))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(106)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_settings))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),
                DividerDrawerItem(),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(107)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_invate_friends))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem()
                    .withIconTintingEnabled(true)
                    .withIdentifier(108)
                    .withName(mainActivity.getString(R.string.app_drawer_items_name_help))
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                        7 -> mainActivity.replaceFragment(SettingsFragment())
                    }
                    return false
                }
            })
            .build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName(mainActivity.getString(R.string.app_drawer_header_def_name))
                    .withEmail(mainActivity.getString(R.string.app_drawer_header_def_number))
            ).build()
    }

}