package com.dkgtech.dmovie.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.dmovie.repo.MovieRepository
import com.dkgtech.dmovie.ui.Explore.ExploreFragmentViewModel

class HomeFragmentViewModelFactory(val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(movieRepository) as T
    }
}