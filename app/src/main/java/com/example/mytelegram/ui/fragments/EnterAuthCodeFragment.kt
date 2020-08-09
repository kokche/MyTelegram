package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.R
import com.example.mytelegram.utils.AppTextWatcher
import com.example.mytelegram.utils.showToast
import kotlinx.android.synthetic.main.fragment_enter_auth_code.*

class EnterAuthCodeFragment : Fragment(R.layout.fragment_enter_auth_code) {
    override fun onStart() {
        super.onStart()
        register_input_auth_code.addTextChangedListener(AppTextWatcher {
            if (register_input_auth_code.text.toString().length == 6) {
                verifyCode()
            }
        })
    }

    fun verifyCode() {
        showToast("Ок")
    }
}