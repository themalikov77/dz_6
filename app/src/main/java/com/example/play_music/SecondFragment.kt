package com.example.play_music

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.example.play_music.databinding.ActivityMain2Binding
import com.example.play_music.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter:MusicAdapter
    var list = arrayListOf<Music>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       loadData()
        adapter=MusicAdapter(list, this::onClick)
        binding.recycler.adapter=adapter



        }
    fun onClick(music: Music) {
        val intent= Intent(requireActivity(),MainActivity2::class.java)
        intent.putExtra("key",music.music)
        startActivity(intent)

    }


    private fun loadData() {
        list.add(Music("1","PRINCE","На Пятом","3:21"))
        list.add(Music("2","Coolio","Gangsta Paradise","3:00"))
        list.add(Music("3","Жах-Халиб","Медина","3:01"))
        list.add(Music("4","Jax","Себелеп","2:57"))
        list.add(Music("5","Улукманапо","Летали","3:32"))
        list.add(Music("6","Градусы","Режисер","2:43"))
        list.add(Music("7","Мирбек Атабеков","Мурас","2:55"))


    }

}