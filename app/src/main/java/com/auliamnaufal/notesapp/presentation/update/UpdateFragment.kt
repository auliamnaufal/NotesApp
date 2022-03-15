package com.auliamnaufal.notesapp.presentation.update

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.auliamnaufal.notesapp.MainActivity
import com.auliamnaufal.notesapp.R
import com.auliamnaufal.notesapp.databinding.FragmentUpdateBinding
import com.auliamnaufal.notesapp.utils.ExtensionFunctions.setActionBar
import com.auliamnaufal.notesapp.utils.HelperFunctions.setPriorityIndicator
import com.google.android.material.appbar.MaterialToolbar

class UpdateFragment : Fragment() {
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding as FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.apply {
            toolbarUpdate.setActionBar(requireActivity())
            spinnerPrioritiesUpdate.onItemSelectedListener =
                context?.let { setPriorityIndicator(it, priorityIndicator) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_save, menu)
        val item = menu.findItem(R.id.menu_save)
        item.actionView.findViewById<AppCompatImageButton>(R.id.btn_save).setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_detailFragment)
            Toast.makeText(context, "Note has been update", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


