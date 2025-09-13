/*
Descripción: Reproductor sencillo con reproducir, pausar y detener
Autor: Esther Mariana Chunga Pacheco
Fecha creación: 12/09/2025
Fecha última modificación: 12/09/2025
*/

package com.example.practica3

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MusicPlayerActivity : AppCompatActivity() {

    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        player = MediaPlayer.create(this, R.raw.mi_musica)

        val play = findViewById<Button>(R.id.btnPlay)
        val pause = findViewById<Button>(R.id.btnPause)
        val stop = findViewById<Button>(R.id.btnStop)

        play.setOnClickListener { player.start() }
        pause.setOnClickListener { if (player.isPlaying) player.pause() }
        stop.setOnClickListener { 
            if (player.isPlaying) {
                player.stop()
                player = MediaPlayer.create(this, R.raw.mi_musica)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}
