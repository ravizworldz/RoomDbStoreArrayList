package com.android.roomdbstoreobject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.roomdbstoreobject.db.UserEntity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter (): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items  = ArrayList<UserEntity>()

    fun setListData(data: ArrayList<UserEntity>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {

        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val tvPhone = view.tvPhone
            val tvHobies= view.tvHobies

        fun bind(data: UserEntity) {
            tvName.text = data.name
            tvEmail.text = data.email
            tvPhone.text = data.phone
            tvHobies.text = data.hobbies.toString()
        }
    }
}
