package com.dicoding.fundamental.githubuser1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.fundamental.githubuser1.databinding.ItemUserBinding

class UserRecyclerAdapter(private val users : ArrayList<User>) :
    RecyclerView.Adapter<UserRecyclerAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemUserBinding.bind(view)

        fun bind(user: User) {
            Glide.with(itemView.context)
                .load(user.avatar)
                .into(binding.civItemAvatar)

            binding.tvItemUsername.text = StringBuilder("@").append(user.username)
            binding.tvItemName.text = user.name
            binding.cvItemUser.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}