package com.example.mediaplayerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playMedia = findViewById(R.id.playButton);
        Button pauseMedia = findViewById(R.id.pauseButton);


        String url = "https://server-24.stream-server.nl:18334/;stream.mp3"; // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.prepareAsync();



        playMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseMedia.setVisibility(View.VISIBLE);
                playMedia.setVisibility(View.GONE);
                mediaPlayer.start();
            }
        });

        pauseMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseMedia.setVisibility(View.GONE);
                playMedia.setVisibility(View.VISIBLE);
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }

            }
        });

    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }


}