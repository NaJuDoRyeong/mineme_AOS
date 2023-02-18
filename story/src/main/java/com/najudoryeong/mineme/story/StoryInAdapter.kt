package com.najudoryeong.mineme.story

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.najudoryeong.mineme.common.domain.entity.Story
import com.najudoryeong.mineme.story.databinding.ItemStoryInBinding


class StoryInAdapter : ListAdapter<Story, RecyclerView.ViewHolder>(StoryInDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryInViewHolder(
            ItemStoryInBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryInViewHolder){
            val story = getItem(position)
            holder.bind(story)
        }
    }

    inner class StoryInViewHolder(private val binding: ItemStoryInBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storyModel: Story) {
            with(binding) {
                story = storyModel
                itemView.setOnClickListener {
                    // story 상세보기
                    Log.d("testStory","상세보기 클릭")
                }
                executePendingBindings()
            }
        }
    }

}

private class StoryInDiffCallback : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem == newItem
    }
}