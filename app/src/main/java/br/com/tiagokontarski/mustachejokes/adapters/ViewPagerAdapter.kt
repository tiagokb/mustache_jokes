package br.com.tiagokontarski.mustachejokes.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.tiagokontarski.mustachejokes.fragments.WritedFragment
import br.com.tiagokontarski.mustachejokes.fragments.JokesFragment
import br.com.tiagokontarski.mustachejokes.fragments.NewFragment

private const val NUM_TABS = 3

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return NewFragment()
            1 -> return JokesFragment()
            2 -> return WritedFragment()
        }

        return JokesFragment()
    }
}