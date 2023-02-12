package com.najudoryeong.mineme.story

import androidx.fragment.app.viewModels
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.story.databinding.FragmentStoryBinding
import com.example.common.data.entity.Story
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>(Story) {

    private val viewModel: StoryViewModel by viewModels()

    private val myListAdapter: StoryAdapter by lazy {
        StoryAdapter()
    }

    private val dataSet = arrayListOf<StoryModel>().apply {
        add(StoryModel("2022-01-03",1, "마산","https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"))
        add(StoryModel("2022-01-04",1, "마산1","https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"))
        add(StoryModel("2022-01-05",1, "마산2","https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"))
        add(StoryModel("2022-01-06",1, "마산3","https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"))
        add(StoryModel("2022-01-07",1, "마산4","https://images.unsplash.com/photo-1511739001486-6bfe10ce785f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"))

    }

    override fun initView() {
        binding.apply {
            //todo callback
            this.lifecycleOwner = viewLifecycleOwner
            this.adapter = myListAdapter
            this.viewModel = viewModel
        }
        viewModel.raedStory()
    }

}