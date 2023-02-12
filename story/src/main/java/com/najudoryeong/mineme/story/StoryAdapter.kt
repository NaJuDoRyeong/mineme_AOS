package com.najudoryeong.mineme.story

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.common.data.entity.Story
import com.najudoryeong.mineme.common_ui.databinding.ItemStoryBinding
import com.najudoryeong.mineme.story.databinding.TestStoryBinding


class StoryAdapter : ListAdapter<StoryModel, RecyclerView.ViewHolder>(StoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryViewHolder(
            TestStoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryViewHolder){
            val story = getItem(position)
            holder.bind(story)
        }
    }

    class StoryViewHolder(private val binding: TestStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storyModel: StoryModel) {
            with(binding) {
                story = storyModel
                executePendingBindings()
                itemView.setOnClickListener {
                    // story 상세보기
                    Log.d("testStory","상세보기 클릭")
                }
            }
        }
    }


}


private class StoryDiffCallback : DiffUtil.ItemCallback<StoryModel>() {
    override fun areItemsTheSame(oldItem: StoryModel, newItem: StoryModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: StoryModel, newItem: StoryModel): Boolean {
        return oldItem == newItem
    }
}