package com.najudoryeong.mineme.story.ui

import android.widget.Toast
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoryFragment : BaseFragment<FragmentStoryBinding>(Story_Foundation_Info) {

    private val storyViewModel: StoryViewModel by viewModels()
    private val storyOutAdapter: StoryOutAdapter by lazy {
        StoryOutAdapter()
    }



    override fun initView() {



        binding.apply {
            //todo callback
            this.lifecycleOwner = viewLifecycleOwner
            this.adapter = storyOutAdapter
            this.viewModel = storyViewModel
            this.swiperefreshlayout.setOnRefreshListener {
                storyViewModel.raedStory{
                    swiperefreshlayout.isRefreshing = false
                }
            }
        }

        storyViewModel.raedStory()
        toastObserve()

    }

    private fun toastObserve() {
        lifecycleScope.launch{
            storyViewModel.toastMessage.collectLatest {
                if (it.isNotEmpty()){
                    Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}