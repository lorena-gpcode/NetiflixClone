package com.lorena.netiflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.lorena.netiflixclone.databinding.ActivityDetalhesFilmeBinding
import com.lorena.netiflixclone.databinding.ActivityVideoBinding

class Video : AppCompatActivity() {
    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val videourl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflixcolne-b689b.appspot.com/o/THE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=bbe119ac-3a16-49d5-8735-3dbdc2f825af")
        val video = binding.video
        // adiciona os controles do video, exemplo : pausar, avançar
        video.setMediaController(MediaController(this))
        // setando o video do servidor
        video.setVideoURI(videourl)
        video.requestFocus()
        video.start()

    }
}