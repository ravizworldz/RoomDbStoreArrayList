package com.android.roomdbstoreobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.android.roomdbstoreobject.db.Hobbies
import com.android.roomdbstoreobject.db.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getAllUsersObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })

        saveButton.setOnClickListener {

            val hobbies = ArrayList<Hobbies>()
            hobbies.add(Hobbies("chess"))
            hobbies.add(Hobbies("watching tv"))
            hobbies.add(Hobbies("swimming"))
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val phone = phoneInput.text.toString()
            val user = UserEntity(0, name, email, phone, hobbies)
            viewModel.insertUserInfo(user)
            nameInput.setText("")
            emailInput.setText("")
            phoneInput.setText("")
        }
    }

}