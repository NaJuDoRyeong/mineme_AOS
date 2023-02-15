package com.najudoryeong.mineme.story.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.story.databinding.FragmentStoryBinding
import com.najudoryeong.mineme.story.StoryOutAdapter
import com.najudoryeong.mineme.story.util.Story_Foundation_Info
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>(Story_Foundation_Info) {

    private val viewModel: StoryViewModel by viewModels()
    private val storyOutAdapter: StoryOutAdapter by lazy {
        StoryOutAdapter()
    }


    override fun initView() {

        viewModel.raedStory()

        /// 이거는 바깥 그거에 넣어줄 데이터
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.storyList.collect()
                }
            }
        }


        binding.apply {
            //todo callback
            this.lifecycleOwner = viewLifecycleOwner
            this.adapter = storyOutAdapter
            this.viewModel = viewModel
        }

    }

}