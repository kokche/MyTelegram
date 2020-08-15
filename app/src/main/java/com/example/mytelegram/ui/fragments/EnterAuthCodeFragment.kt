package com.example.mytelegram.ui.fragments

import androidx.fragment.app.Fragment
import com.example.mytelegram.R
import com.example.mytelegram.activity.MainActivity
import com.example.mytelegram.activity.RegisterActivity
import com.example.mytelegram.utils.*
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_auth_code.*

class EnterAuthCodeFragment(val phoneNumber: String, val id: String) :
    Fragment(R.layout.fragment_enter_auth_code) {
    override fun onStart() {
        (activity as RegisterActivity).title = phoneNumber
        super.onStart()
        register_input_auth_code.addTextChangedListener(AppTextWatcher {
            if (register_input_auth_code.text.toString().length == 6) {
                verifyCode()
            }
        })
    }

    private fun verifyCode() {
        val code = register_input_auth_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val uid = AUTH.currentUser?.uid.toString()
                val dateMap = mutableMapOf<String, Any>()
                dateMap[CHILD_ID] = uid
                dateMap[CHILD_PHONE] = phoneNumber
                dateMap[CHILD_USERNAME] = uid
                REF_DATABASE_ROOT.child(NODE_USERS).child(uid).updateChildren(dateMap)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("Добро пожаловать")
                            (activity as RegisterActivity).replaceActivity(MainActivity())
                        } else showToast(it.exception?.message.toString())
                    }
            } else {
                showToast(task.exception?.message.toString())
            }
        }

    }
}