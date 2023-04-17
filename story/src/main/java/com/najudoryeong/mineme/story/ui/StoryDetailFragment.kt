package com.najudoryeong.mineme.story.ui


import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.najudoryeong.mineme.common_ui.BaseFragment
import com.najudoryeong.mineme.story.ImageAdapter
import com.najudoryeong.mineme.story.data.dto.StoryDetailData
import com.najudoryeong.mineme.story.data.dto.UseStoryDetailData
import com.najudoryeong.mineme.story.databinding.FragmentStoryDetailBinding
import com.najudoryeong.mineme.story.util.DetailStoryFoundationInfo
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StoryDetailFragment : BaseFragment<FragmentStoryDetailBinding>(
    DetailStoryFoundationInfo
) {

    private val storyViewModel: StoryViewModel by viewModels()
    private val args: StoryDetailFragmentArgs by navArgs()

    override fun initView() {

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            adapter = ImageAdapter()
            val uriList = listOf(
                    "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800",
                    "https://upload3.inven.co.kr/upload/2022/03/15/bbs/i16343629296.jpg?MW=800"
            ).map { it.toUri() }
            testDummy = UseStoryDetailData(
                "경남 창원시",
                "n",
                null,
                "2022 Oct 1",
                uriList,
                512,
                "날씨가 좋았다\n그래서 기분이 좋았다",
                "김도우"
            )
        }

    }


}