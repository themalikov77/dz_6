package com.example.play_music

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.play_music.databinding.ItemMusicBinding

class MusicAdapter(var musicList: List<Music>, var onClick:(Music) -> Unit): RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
      return MusicViewHolder(ItemMusicBinding.inflate(LayoutInflater.from(parent.context),parent,false ))
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position])
        holder.itemView.setOnClickListener {
            onClick(musicList[position])
        }

    }

    override fun getItemCount(): Int {
       return musicList.size
    }

    inner class MusicViewHolder(var binding:ItemMusicBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(music:Music){
            binding.music.text=music.singer
            binding.tvSigner.text=music.music
            binding.tvTime.text=music.time
            itemView.setOnClickListener {
                onClick.invoke(music)
            }
        }


    }
}