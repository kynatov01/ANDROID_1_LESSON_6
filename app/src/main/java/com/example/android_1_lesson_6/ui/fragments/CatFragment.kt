package com.example.android_1_lesson_6.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_1_lesson_6.R
import com.example.android_1_lesson_6.Repositoryes.CatRepository
import com.example.android_1_lesson_6.data.CatModel
import com.example.android_1_lesson_6.interfaces.CatClick
import com.example.android_1_lesson_6.ui.Adapters.CatAdapter


class CatFragment : Fragment(),CatClick {

    private var recycler : RecyclerView?= null
    private var repository =CatRepository()
    private var catAdapter = CatAdapter(repository.getListofCat(),this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler=view.findViewById(R.id.recycler_view)
        recycler?.layoutManager = GridLayoutManager(context,2)
        recycler?.adapter = catAdapter


    }

    override fun onItemClick(catmodel: CatModel) {
        val detailFragment = DetailFragment()
        val bundle = Bundle().apply {
            putString("detail", catmodel.detailText)
            putString("image", catmodel.image)
        }
        detailFragment.arguments = bundle
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, detailFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}