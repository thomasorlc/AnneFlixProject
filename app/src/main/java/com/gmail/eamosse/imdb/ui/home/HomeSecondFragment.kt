package com.gmail.eamosse.imdb.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.FragmentHomeBinding
import com.gmail.eamosse.imdb.databinding.FragmentHomeSecondBinding

class HomeSecondFragment : Fragment() {

    private lateinit var binding: FragmentHomeSecondBinding
    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(homeViewModel){
            token.observe(viewLifecycleOwner, {
                //getMovies()
            })

            movies.observe(viewLifecycleOwner, {
                //binding.movieList.adapter = MovieAdapter(it)
            })

            error.observe(viewLifecycleOwner, {
                //afficher l'erreur
            })
        }
    }
}
