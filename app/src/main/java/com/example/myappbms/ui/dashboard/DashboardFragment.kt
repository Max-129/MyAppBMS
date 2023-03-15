package com.example.myappbms.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myappbms.R
import com.example.myappbms.databinding.FragmentDashboardBinding
import com.example.myappbms.model.Quotes
import com.example.myappbms.utils.toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var db: FirebaseFirestore

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = FirebaseFirestore.getInstance()
        binding.btnSave.setOnClickListener {
            if (binding.etAuthor.text.toString().isNotEmpty() && binding.etQuote.text.toString().isNotEmpty()) {
                save()
            } else if (binding.etAuthor.text.toString().isEmpty()) {
                binding.etAuthor.error = getString(R.string.filling_val)
            } else if (binding.etQuote.text.toString().isEmpty()) {
                binding.etQuote.error = getString(R.string.filling_val)
            } else {
                binding.etQuote.error = getString(R.string.filling_val)
                binding.etAuthor.error = getString(R.string.filling_val)
            }
        }
    }

    private fun save() {
        val quote = Quotes(
            text = binding.etQuote.text.toString(),
            author = binding.etAuthor.text.toString()
        )
        db.collection(FirebaseAuth.getInstance().currentUser?.uid.toString()).add(quote)
            .addOnSuccessListener {
                activity?.toast("Success!")
                binding.etAuthor.setText("")
                binding.etQuote.setText("")
            }.addOnFailureListener {
                Log.e("Quotes", "save: " + it.message)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}