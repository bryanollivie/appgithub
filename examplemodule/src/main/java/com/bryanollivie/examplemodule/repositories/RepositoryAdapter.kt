package com.bryanollivie.examplemodule.repositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bryanollivie.examplemodule.R
import com.bryanollivie.sdk.data.remote.model.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class RepositoryAdapter(
    private val repository: List<Repository>,
    val onItemClickListener: ((repository: Repository) -> Unit)
) : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): RepositoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return RepositoryViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = repository.count()

    override fun onBindViewHolder(viewHolder: RepositoryViewHolder, position: Int) {
        viewHolder.bindView(repository[position])
    }

    class RepositoryViewHolder(
            itemView: View,
            private val onItemClickListener: ((repository: Repository) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val repositoryTitle = itemView.repoName
        private val repositoryStars = itemView.repoStarts
        private val repositoryForks = itemView.repoForks
        private val repositoryAuthor = itemView.repoAuthor
        private val repositoryPhoto = itemView.repoAuthorPhoto

        fun bindView(repository: Repository) {
            repositoryTitle.text = repository.name
            repositoryAuthor.text = repository.owner.login
            repositoryStars.text = repository.stargazers_count.toString()
            repositoryForks.text = repository.forks.toString()
            Picasso.get().load(repository.owner.avatar_url).into(repositoryPhoto )

            itemView.setOnClickListener {
                onItemClickListener.invoke(repository)
            }
        }
    }
}