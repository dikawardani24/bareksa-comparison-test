package dika.wardani.bareksaperbandingantest.ui.perbandingan.imbalHasil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dika.wardani.bareksaperbandingantest.R
import org.koin.android.ext.android.inject

class ImbalHasilFragment : Fragment() {

    private val viewModel: ImbalHasilViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_imbal_hasil, container, false)
    }

}