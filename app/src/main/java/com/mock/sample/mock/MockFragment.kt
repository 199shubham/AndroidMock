package com.mock.sample.mock



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mock.sample.R
import com.mock.sample.base.AppNavigator
import com.mock.sample.base.BaseFragment
import com.mock.sample.databinding.UiFragmentMockBinding
import com.mock.sample.mock.adapter.MockAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MockFragment : BaseFragment<MockFragmentViewModel>(){

    override var layoutId: Int = R.layout.ui_fragment_mock
    val viewModel: MockFragmentViewModel by viewModels()

    val mockBinding : UiFragmentMockBinding by lazy {
        binding as UiFragmentMockBinding
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        mockBinding.vm = viewModel
        viewModel.getSampleData()
        mockBinding.recSample.adapter = MockAdapter()
        return mockBinding?.root
    }
}