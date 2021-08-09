package com.lorena.netiflixclone.Model

import com.lorena.netiflixclone.R

data class Filmes (

    var capaFilme: Int
        )

class FilmesBuilder{

    var capaFilme: Int = 0

    fun build():Filmes = Filmes(capaFilme)
}

fun filmes(block: FilmesBuilder.() -> Unit): Filmes = FilmesBuilder().apply(block).build()

fun addFilmes():MutableList<Filmes> = mutableListOf(

    filmes{
        capaFilme = R.drawable.filme1
    },

    filmes {
        capaFilme = R.drawable.filme2
    },

    filmes {
        capaFilme = R.drawable.filme3
    },

    filmes {
        capaFilme = R.drawable.filme4
    },

    filmes {
        capaFilme = R.drawable.filme5
    },

    filmes {
        capaFilme = R.drawable.filme6
    },

    filmes {
        capaFilme = R.drawable.filme7
    },

    filmes {
        capaFilme = R.drawable.filme8
    },

    filmes {
        capaFilme = R.drawable.filme9
    },

    filmes {
        capaFilme = R.drawable.filme10
    },

    filmes {
        capaFilme = R.drawable.filme11
    },

    filmes {
        capaFilme = R.drawable.filme12
    },


)