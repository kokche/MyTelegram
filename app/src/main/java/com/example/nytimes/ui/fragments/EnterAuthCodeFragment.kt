package com.example.nytimes.ui.fragments

import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.nytimes.R
import kotlinx.android.synthetic.main.fragment_enter_auth_code.*

class EnterAuthCodeFragment : Fragment(R.layout.fragment_enter_auth_code) {
    override fun onStart() {
        super.onStart()
        register_input_auth_code.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if (register_input_auth_code.text.toString().length == 6)
                {
                    VerifyCode()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    private fun VerifyCode() {
        Toast.makeText(activity,"ok",Toast.LENGTH_LONG).show()
    }
}