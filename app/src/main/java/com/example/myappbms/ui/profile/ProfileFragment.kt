package com.example.myappbms.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myappbms.R
import com.example.myappbms.data.local.Pref
import com.example.myappbms.databinding.FragmentProfileBinding
import com.example.myappbms.utils.loadImage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref
    private var auth= FirebaseAuth.getInstance()

    private val launcher =
        registerForActivityResult<Intent, ActivityResult>(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val photoURI = result.data?.data
                pref.saveImage(photoURI.toString())
                binding.imgProfile.loadImage(photoURI.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        saveName()
        binding.imgProfile.loadImage(pref.getImage())
        binding.imgProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
        binding.btnDisFirebase.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().navigate(R.id.onBoardFragment)
            auth.currentUser == null
            findNavController().navigate(R.id.authFragment)
        }
    }

    private fun saveName() {
        binding.edName.setText(pref.getName())
        binding.edName.addTextChangedListener { pref.saveName(binding.edName.text.toString()) }
    }


}