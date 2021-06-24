package dika.wardani.bareksaperbandingantest.ui.perbandingan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dika.wardani.bareksaperbandingantest.ui.perbandingan.danaKelolaan.DanaKelolaanFragment
import dika.wardani.bareksaperbandingantest.ui.perbandingan.imbalHasil.ImbalHasilFragment

class PerbandinganViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val totalTab = 2

    override fun getItemCount(): Int {
        return totalTab
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ImbalHasilFragment()
            else -> DanaKelolaanFragment()
        }
    }

}