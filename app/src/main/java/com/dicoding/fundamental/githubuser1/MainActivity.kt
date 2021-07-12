package com.dicoding.fundamental.githubuser1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.fundamental.githubuser1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.actbar_main)

        users.addAll(getData())
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = UserRecyclerAdapter(users)
        binding.rvUsers.setHasFixedSize(true)
    }

    @SuppressLint("Recycle")
    private fun getData() : ArrayList<User> {
        val username = resources.getStringArray(R.array.username)
        val name = resources.getStringArray(R.array.name)
        val avatar = resources.obtainTypedArray(R.array.avatar)
        val location = resources.getStringArray(R.array.location)
        val repository = resources.getStringArray(R.array.repository)
        val company = resources.getStringArray(R.array.company)
        val followers = resources.getStringArray(R.array.followers)
        val following = resources.getStringArray(R.array.following)

        val users = ArrayList<User>()
        for (index in name.indices) {
            val user = User(
                username = username[index],
                name = name[index],
                avatar = avatar.getResourceId(index, 0),
                location = location[index],
                repository = repository[index],
                company = company[index],
                followers = followers[index],
                following = following[index]
            )
            users.add(user)
        }
        return users
    }
}