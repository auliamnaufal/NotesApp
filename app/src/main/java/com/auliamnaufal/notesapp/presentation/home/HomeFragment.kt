package com.auliamnaufal.notesapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.auliamnaufal.notesapp.MainActivity
import com.auliamnaufal.notesapp.R
import com.auliamnaufal.notesapp.data.local.room.NotesDB
import com.auliamnaufal.notesapp.databinding.FragmentHomeBinding
import com.auliamnaufal.notesapp.utils.ExtensionFunctions.setActionBar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private var db: NotesDB? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        db = NotesDB.instance
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        db?.notesDao()?.getAlarm()?.observe(this) {
            Log.i("GetAlarm", "onResume: Database data $it")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.toolbarHome.setActionBar(requireActivity())

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }

        binding.btnDetail.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}