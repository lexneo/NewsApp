package com.lexneoapps.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lexneoapps.newsapp.databinding.ItemArticlePreviewBinding
import com.lexneoapps.newsapp.models.Article

class NewsAdapter() :
    ListAdapter<Article, NewsAdapter.TeamViewHolder>(RecordDiffCallback()) {


    class TeamViewHolder(val binding: ItemArticlePreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {
                Glide.with(this.root).load(article.urlToImage).into(ivArticleImage)
                tvSource.text = article.source.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt


            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TeamViewHolder(binding)


    }


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentArticle = getItem(position)

        holder.bind(currentArticle)
        holder.binding.root.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentArticle)
            }
        }
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnClickListener(onItemClick: (Article) -> Unit) {
        this.onItemClickListener = onItemClick
    }
}

private class RecordDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}
