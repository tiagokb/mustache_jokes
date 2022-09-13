package br.com.tiagokontarski.mustachejokes.activities

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.com.tiagokontarski.mustachejokes.R
import br.com.tiagokontarski.mustachejokes.adapters.ViewPagerAdapter
import br.com.tiagokontarski.mustachejokes.databinding.ActivityMainBinding
import br.com.tiagokontarski.mustachejokes.viewmodels.MainActivityViewModel
import com.google.android.material.tabs.TabLayoutMediator

val tabTitles = arrayOf(
    "New",
    "Jokes",
    "Writed"
)

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.mainPager
        val tabLayout = binding.mainTabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        tabLayout.selectTab(tabLayout.getTabAt(1))
    }
}