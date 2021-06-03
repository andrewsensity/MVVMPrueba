package com.santy.mvvmprueba.ViewModel.RecyclerView

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.santy.mvvmprueba.Model.MailModel
import com.santy.mvvmprueba.R
import com.santy.mvvmprueba.View.DetailActivity
import com.santy.mvvmprueba.View.Fragments.MailFragment
import com.santy.mvvmprueba.View.MainActivity
import java.security.AccessController.getContext

class RecyclerViewAdapter(val images: List<MailModel>, val clickListener: MailFragment):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imgCircleButton:    ImageView = view.findViewById(R.id.imgCircleBlue)
        var imgFlags:           ImageView = view.findViewById(R.id.imgFlags)
        var imgstar:            ImageView = view.findViewById(R.id.imgStar)
        var tvTitle:            TextView = view.findViewById(R.id.tvTitle)
        var tvMessage:          TextView = view.findViewById(R.id.tvMessage)
        var llMessage:          LinearLayoutCompat = view.findViewById(R.id.llMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.cardview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCircleButton.setImageResource(images.get(position).circle)
        holder.imgFlags.setImageResource(images.get(position).flags)
        holder.imgstar.setImageResource(images.get(position).star)
        holder.tvTitle.text = images.get(position).title
        holder.tvMessage.text = images.get(position).message
        holder.llMessage.setOnClickListener(){
            Toast.makeText(it.context, "This is Messages", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    interface ClickListener{
        fun onItemClickListener(mailModel: MailModel)
    }
}