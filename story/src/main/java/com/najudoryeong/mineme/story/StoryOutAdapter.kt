package com.najudoryeong.mineme.story

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.najudoryeong.mineme.story.databinding.ItemStoryOutBinding
import com.najudoryeong.mineme.story.domain.entity.StoryListWithDate
import com.najudoryeong.mineme.story.ui.dummy


class StoryOutAdapter(val fragment : Fragment): ListAdapter<StoryListWithDate, RecyclerView.ViewHolder>(StoryOutDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("testStory","홀더 만듬")

        return StoryOutViewHolder(
            ItemStoryOutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoryOutViewHolder){
            val storyListWithDate = getItem(position)
            holder.bind(storyListWithDate)
        }
    }

    override fun getItemCount(): Int {
        Log.d("testStory", super.getItemCount().toString())
        return super.getItemCount()
    }

    inner class StoryOutViewHolder(private val binding: ItemStoryOutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(storyListWithDate : StoryListWithDate){
            // 외부 이제 나눈다 날짜별로
            with(binding) {
                outRecyclerView.adapter = StoryInAdapter(fragment).apply { submitList(storyListWithDate.posts) }
                yearMonth = getYearMonth(storyListWithDate.year,storyListWithDate.month)
                executePendingBindings()
            }
        }

        private fun getYearMonth(year : String, month : String) : String {
            return "$year $month"
        }
    }

}

private class StoryOutDiffCallback : DiffUtil.ItemCallback<StoryListWithDate>() {
    override fun areItemsTheSame(oldItem: StoryListWithDate, newItem: StoryListWithDate): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: StoryListWithDate, newItem: StoryListWithDate): Boolean {
        return oldItem == newItem
    }
}