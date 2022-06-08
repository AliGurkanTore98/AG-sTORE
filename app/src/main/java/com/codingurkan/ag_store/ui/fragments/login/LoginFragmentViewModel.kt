package com.codingurkan.ag_store.ui.fragments.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragmentViewModel : ViewModel(){
    var updatedUser = MutableLiveData<String?>().also {
        it.value =null
    }
    var failureMessage = MutableLiveData<String?>().also {
        it.value = null
    }
    private lateinit var auth : FirebaseAuth

    fun loginFirebase(email : String , password : String){
        auth =FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                updatedUser.value = auth.currentUser?.email.toString()
            }
        }.addOnFailureListener { exception ->
            failureMessage.value =exception.localizedMessage
        }
    }
}