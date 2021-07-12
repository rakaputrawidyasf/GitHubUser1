package com.dicoding.fundamental.githubuser1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.fundamental.githubuser1.databinding.ActivityDetailBinding
import java.lang.StringBuilder

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.actbar_detail)

        setData()
    }

    private fun setData() {
        val user = intent.getParcelableExtra<User>(USER) as User

        binding.civDetailAvatar.setImageResource(user.avatar)
        binding.tvDetailName.text = user.name
        binding.tvDetailUsername.text = StringBuilder("@").append(user.username)

        binding.tvLocation.text = user.location
        binding.tvCompany.text = user.company

        binding.tvFollowerCount.text = user.followers
        binding.tvFollowingCount.text = user.following

        binding.tvRepositoryCount.text = user.repository
    }
}