package com.codingurkan.ag_store.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.codingurkan.ag_store.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private var binding : FragmentLoginBinding? = null
    private lateinit var auth : FirebaseAuth
    //private var loginViewModel : LoginFragmentViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
       // val currentUser = auth.currentUser
        /*
        if (currentUser != null){
            val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
            findNavController().navigate(action)
        }
         */
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickTextView()
        login()

    }

    private fun onClickTextView(){
        val tvClickMe = binding?.tvRegister

        tvClickMe?.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            findNavController().navigate(action)
        }
    }

    private fun login(){
            binding?.loginButton?.setOnClickListener {
                val email = binding?.etEmail?.text.toString()
                val password = binding?.etPassword?.text.toString()
                if (email.isNotEmpty() && password.isNotEmpty()){
                    auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                        val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
                        findNavController().navigate(action)
                }.addOnFailureListener {
                        Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "You entered incomplete information", Toast.LENGTH_SHORT).show()
                }
            }
        }
}
