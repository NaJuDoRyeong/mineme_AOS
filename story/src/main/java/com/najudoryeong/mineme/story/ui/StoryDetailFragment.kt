package com.najudoryeong.mineme.story.ui


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.story.databinding.FragmentStoryDetailBinding
import com.najudoryeong.mineme.story.util.DetailStoryFoundationInfo
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StoryDetailFragment : BaseFragment<FragmentStoryDetailBinding>(DetailStoryFoundationInfo) {

    private val storyViewModel: StoryViewModel by viewModels()
    private val args: StoryDetailFragmentArgs by navArgs()

    override fun initView() {
        binding.apply {
            postIDTextView.text = args.postID.toString()
        }
    }


}