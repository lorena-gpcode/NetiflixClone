package com.lorena.netiflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.lorena.netiflixclone.Adapter.FilmesAdapter
import com.lorena.netiflixclone.Model.addFilmes
import com.lorena.netiflixclone.databinding.ActivityDetalhesFilmeBinding
import com.squareup.picasso.Picasso

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

       val recycler_outrosfilmes = binding.recycleOutrosfilmes
       recycler_outrosfilmes.adapter = FilmesAdapter(addFilmes())
       recycler_outrosfilmes.layoutManager = GridLayoutManager(applicationContext, 3)

        // pegando o video do servidor
        val capathewitcher = "https://firebasestorage.googleapis.com/v0/b/netflixcolne-b689b.appspot.com/o/video.jpg?alt=media&token=e0558405-29f0-4525-a629-06cf650ff6e7"
        Picasso.get().load(capathewitcher).fit().into(binding.capa)

        //criando o botão de play do video
        binding.playVideo.setOnClickListener{
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }

    }

    private fun Toolbar(){
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_24))
        toolbar_detalhes.setNavigationOnClickListener{
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
            finish()

        }

    }
}