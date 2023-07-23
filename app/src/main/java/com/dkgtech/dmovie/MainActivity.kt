package com.dkgtech.dmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dkgtech.dmovie.databinding.ActivityMainBinding
import com.dkgtech.dmovie.ui.Explore.ExploreFragment
import com.dkgtech.dmovie.ui.Home.HomeFragment
import com.dkgtech.dmovie.ui.User.UserFragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            addFrag(HomeFragment())
            bottomNavigation.show(0)
            bottomNavigation.setBackgroundResource(R.color.cyan)
            bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_home))
            bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_explore))
            bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_profile))

            bottomNavigation.setOnClickMenuListener {
                when (it.id) {
                    0 -> {
                        replaceFrag(HomeFragment())
                        bottomNavigation.setBackgroundResource(R.color.cyan)
                    }

                    1 -> {
                        replaceFrag(ExploreFragment())
                        bottomNavigation.setBackgroundResource(R.color.red)
                    }

                    else -> {
                        replaceFrag(UserFragment())
                        bottomNavigation.setBackgroundResource(R.color.yellow)
                    }
                }
            }

        }

    }

    private fun replaceFrag(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFrag(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
            .addToBackStack(Fragment::class.java.simpleName).commit()
    }
}