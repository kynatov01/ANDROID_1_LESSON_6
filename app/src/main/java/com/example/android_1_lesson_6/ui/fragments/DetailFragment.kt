package com.example.android_1_lesson_6.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.android_1_lesson_6.R


class DetailFragment : Fragment() {
    private var detail:TextView? =null
    private var imageView: ImageView? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detail = view.findViewById(R.id.txt_detail)
        imageView = view.findViewById(R.id.image_cat_detail)
        arguments?.let { bundle ->
            val description = bundle.getString("detail")
            val image = bundle.getString("image")
            detail?.text = description
            Glide.with(this).load(image).into(imageView!!)
        }
    }


}