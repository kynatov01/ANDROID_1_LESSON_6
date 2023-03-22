package com.example.android_1_lesson_6.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_1_lesson_6.R
import com.example.android_1_lesson_6.data.CatModel
import com.example.android_1_lesson_6.interfaces.CatClick

class CatAdapter(
    private val listmodel: MutableList<CatModel>,
    private val listener: CatClick
) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var image: ImageView? = null
        private var name: TextView? = null
        private var detail: TextView? = null

        init {
            image = view.findViewById(R.id.image_cat)
            name = view.findViewById(R.id.txt_status_code)
            detail = view.findViewById(R.id.txt_detail)
        }

        fun onBind(catmodel: CatModel) {
            image?.let { Glide.with(it).load(catmodel.image).into(image!!) }
            name?.text = catmodel.name
            detail?.text = catmodel.detailText
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        ).apply {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(listmodel[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = listmodel.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(listmodel[position])
    }

}