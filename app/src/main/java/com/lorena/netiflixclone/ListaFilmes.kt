package com.lorena.netiflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.lorena.netiflixclone.Adapter.FilmesAdapter
import com.lorena.netiflixclone.Model.addFilmes
import com.lorena.netiflixclone.Onclick.OnItemClickListener
import com.lorena.netiflixclone.Onclick.addOnItemClickListener
import com.lorena.netiflixclone.databinding.ActivityListaFilmesBinding
import java.text.FieldPosition

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_filmes = binding.recycleview
        recycler_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_filmes.layoutManager = GridLayoutManager(applicationContext, 3)

        recycler_filmes.addOnItemClickListener(object: OnItemClickListener {

            override fun onItemClicked(position: Int, view: View) {

                when {
                    position == 0 -> DetalhesFilme()
                }
            }
       })

    }

    private fun DetalhesFilme(){

        val intent = Intent(this, DetalhesFilme::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                VoltarTelaLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }
    private fun VoltarTelaLogin(){
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
    }

}