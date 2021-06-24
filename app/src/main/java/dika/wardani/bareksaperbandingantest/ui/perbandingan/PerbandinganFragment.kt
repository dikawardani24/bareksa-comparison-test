package dika.wardani.bareksaperbandingantest.ui.perbandingan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dika.wardani.bareksaperbandingantest.R
import dika.wardani.bareksaperbandingantest.databinding.FragmentPerbandinganBinding

class PerbandinganFragment : Fragment() {
    private lateinit var binding: FragmentPerbandinganBinding

    private fun goBack() {
        requireActivity().finish()
    }

    private fun initView() {
        binding.run {
            componentAppBar.run {
                titleTv.text = getString(R.string.fg_perbandingan_title)
                backBtn.setOnClickListener { goBack() }
            }

            perbandinganVpager.adapter = PerbandinganViewPagerAdapter(requireActivity())
            TabLayoutMediator(tabLayout, perbandinganVpager) {tab, pos ->
                when(pos) {
                    0 -> tab.setText(R.string.imbal_hasil)
                    1 -> tab.setText(R.string.dana_kelolaan)
                }
            }.attach()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_perbandingan, container, false)
        return binding.root
    }

}