package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.R
import com.example.mytelegram.utils.replaceFragment
import com.example.mytelegram.utils.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone.*


class EnterPhoneFragment : Fragment(R.layout.fragment_enter_phone) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()) {
            showToast(getString(R.string.register_toast_enter_on))
        } else {
            replaceFragment(EnterAuthCodeFragment())
        }
    }
}