package com.example.g5.ui.features.two

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.g5.R
import com.example.g5.databinding.ItemG1Binding
import com.example.g5.domain.entities.responses.ClientGithub

private const val TAG = "G5-G1Adapter : "

class G1Adapter(
    private val onClickPosition: ((clickedPos: Int) -> Unit)
) :
    RecyclerView.Adapter<G1Adapter.G1ViewHolder>() {

    private val clientGithubList = mutableListOf<ClientGithub>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): G1ViewHolder {
        val binding = ItemG1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return G1ViewHolder(binding)
    }

    override fun getItemCount(): Int = clientGithubList.size

    override fun onBindViewHolder(holder: G1ViewHolder, position: Int) {
        val item = clientGithubList[position]
        holder.bind(item)
    }

    // original
    fun loadEmptyData() {
        Log.d(TAG, "loadEmptyData: ")
        clientGithubList.clear()
        clientGithubList.addAll(emptyList())
        notifyDataSetChanged()
    }

    // new!!
    fun setNewData(newList: List<ClientGithub>) {
        Log.d(TAG, "setNewData: ")
        clientGithubList.clear()
        clientGithubList.addAll(newList)
        notifyDataSetChanged()
    }

    fun getTodoList(): List<ClientGithub> = clientGithubList

    inner class G1ViewHolder(private val binding: ItemG1Binding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onClickPosition.invoke(adapterPosition)
        }

        fun bind(clientGithub: ClientGithub) {
            binding.apply {
                tvAuthorName.text = clientGithub.name
                tvRepoName.text = clientGithub.repo.name
                imvAuthor.load(clientGithub.avatar) {
                    crossfade(true)
                    placeholder(R.drawable.shape_default)
                    transformations(CircleCropTransformation())
                }
                imvAuthor.setOnClickListener {
                    Log.i(TAG, "bind: IMAGE at pos = $adapterPosition")
                }
            }
        }
    }
}