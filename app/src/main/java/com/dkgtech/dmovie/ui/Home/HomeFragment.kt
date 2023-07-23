package com.dkgtech.dmovie.ui.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dkgtech.dmovie.MainActivity
import com.dkgtech.dmovie.R
import com.dkgtech.dmovie.adapter.RecyclerWhatsStreamIndiaAdapter
import com.dkgtech.dmovie.api.ApiHelper
import com.dkgtech.dmovie.databinding.FragmentHomeBinding
import com.dkgtech.dmovie.model.DataModel
import com.dkgtech.dmovie.repo.MovieRepository

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val apiHelper = ApiHelper.create()

        val repo = MovieRepository(apiHelper)

        homeFragmentViewModel = ViewModelProvider(
            this,
            HomeFragmentViewModelFactory(repo)
        )[HomeFragmentViewModel::class.java]


        binding.rcViewWhatsStreamIndia.layoutManager = GridLayoutManager(requireContext(), 2)

        homeFragmentViewModel.getWhatsStreamIndia(
            "ac07a503edmshbf4fc6fc1e76a8dp1a9d8fjsnbfca73785334",
            "imdb188.p.rapidapi.com",
            "india"
        )

        homeFragmentViewModel.listData.observe(viewLifecycleOwner) { data ->
            binding.rcViewWhatsStreamIndia.adapter =
                RecyclerWhatsStreamIndiaAdapter(requireContext(),)

        }

        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}