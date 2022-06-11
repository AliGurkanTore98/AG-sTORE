package com.codingurkan.ag_store.ui.fragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.codingurkan.ag_store.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {

    private var binding : FragmentRegisterBinding? = null
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register()
    }

    private fun register(){
        binding?.registerButton?.setOnClickListener {
            val userName = binding?.etName?.text.toString()
            val email = binding?.etEmail?.text.toString()
            val password = binding?.etPassword?.text.toString()
            val passwordAgain = binding?.etAgainPassword?.text.toString()

            if (userName.isNotEmpty() && password.isNotEmpty() && passwordAgain.isNotEmpty() && email.isNotEmpty()){
                if (password == passwordAgain){
                    auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener{
                            val action = RegisterFragmentDirections.actionRegisterFragmentToDashboardFragment()
                            findNavController().navigate(action)
                    }.addOnFailureListener {
                        Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "Password are not the same", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(requireContext(), "You entered incomplete information", Toast.LENGTH_LONG).show()
            }
        }
    }
}



