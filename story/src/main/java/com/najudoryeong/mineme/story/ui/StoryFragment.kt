package com.najudoryeong.mineme.story.ui

import androidx.fragment.app.viewModels
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.story.databinding.FragmentStoryBinding
import com.najudoryeong.mineme.story.StoryOutAdapter
import com.najudoryeong.mineme.story.util.Story_Foundation_Info
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>(Story_Foundation_Info) {

    private val viewModel: StoryViewModel by viewModels()
    private val storyOutAdapter : StoryOutAdapter by lazy {
        StoryOutAdapter()
    }


    override fun initView() {
        /// 이거는 바깥 그거에 넣어줄 데이터
        viewModel.raedStory()

        binding.apply {
            //todo callback
            this.adapter = storyOutAdapter
            this.list = dummy
            this.lifecycleOwner = viewLifecycleOwner
        }

    }

}