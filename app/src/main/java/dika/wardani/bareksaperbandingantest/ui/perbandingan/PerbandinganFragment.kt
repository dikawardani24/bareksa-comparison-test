package dika.wardani.bareksaperbandingantest.ui.perbandingan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dika.wardani.bareksaperbandingantest.R
import dika.wardani.bareksaperbandingantest.databinding.FragmentPerbandinganBinding
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject

class PerbandinganFragment : Fragment() {
    private lateinit var binding: FragmentPerbandinganBinding

    private fun goBack() {
        findNavController().popBackStack()
    }

    private fun initView() {
        binding.run {
            componentAppBar.run {
                titleTv.text = getString(R.string.fg_perbandingan_title)
                backBtn.setOnClickListener { goBack() }
            }
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