package com.gmail.eamosse.imdb.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.gmail.eamosse.imdb.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.token.observe(
            viewLifecycleOwner,
            Observer {
                binding.textHome.text = "${it.requestToken} - ${it.expiresAt}"
            }
        )

        homeViewModel.error.observe(
            viewLifecycleOwner,
            Observer {
                binding.textHome.text = "Erreur $it"
            }
        )

        binding.buttonHome.setOnClickListener {
            val action = HomeFragmentDirections
                .actionHomeFragmentToHomeSecondFragment("From HomeFragment")
            NavHostFragment.findNavController(this@HomeFragment)
                .navigate(action)
        }

        with(homeViewModel) {
            token.observe(viewLifecycleOwner, Observer {
                //récupérer les catégories
                getCategories()
            })

            categories.observe(viewLifecycleOwner, Observer {
                binding.categoryList.adapter = CategoryAdapter(it)
            })

            error.observe(viewLifecycleOwner, Observer {
                //afficher l'erreur
            })
        }
    }
}
