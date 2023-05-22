package com.example.delivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.delivery.databinding.FragmentSignInBinding
import com.example.delivery.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private lateinit var firebaseAuth: FirebaseAuth

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAuth = FirebaseAuth.getInstance()

        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignin.setOnClickListener {
            val email = binding.textInputEmail.text.toString()
            val password = binding.textInputPassword.text.toString()
            signInFirebase(email, password)
        }

        binding.textViewSignUp.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            this.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun signInFirebase(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    if (email == "admin@email.com" && password == "admin1"){
                        val action = SignInFragmentDirections.actionSignInFragmentToOrderManagerFragment()
                        this.findNavController().navigate(action)
                    } else {
                        val action = SignInFragmentDirections.actionSignInFragmentToOrderFragment()
                        this.findNavController().navigate(action)
                    }

                } else {
                    Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(requireContext(), "Fields are empty", Toast.LENGTH_SHORT).show()
        }
    }
}