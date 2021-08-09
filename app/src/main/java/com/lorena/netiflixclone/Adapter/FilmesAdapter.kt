package com.lorena.netiflixclone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lorena.netiflixclone.Model.Filmes
import com.lorena.netiflixclone.databinding.ListaFilmesBinding

class FilmesAdapter (val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  FilmesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {

        with(holder){
            with(filmes[position]){
                binding.capaFilme.setImageResource(capaFilme)
            }
        }

    }

   // o getItemCount(): passa a quantidade de itens que iremos receber na nossa lista
    override fun getItemCount() = filmes.size

    // inner é uma classe interna
    inner class FilmesViewHolder(val binding: ListaFilmesBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}