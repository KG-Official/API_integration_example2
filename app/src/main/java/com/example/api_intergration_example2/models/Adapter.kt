package com.example.api_intergration_example2.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_intergration_example2.R

class Adapter(var context: Context, var list: List<Post1>):androidx.recyclerview.widget.RecyclerView.Adapter<Adapter.viewHolder>() {
    var link = "https://islam360.app/islam360/posts/image/urdu/"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.images_list,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        Glide.with(context).load(link+list[position].img_path ).into(holder.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.imageView)

    }


}

