package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnVoice1, btnVoice2, btnVoice3, btnVoice4;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVoice1 = findViewById(R.id.Voice1);
        btnVoice2 = findViewById(R.id.Voice2);
        btnVoice3 = findViewById(R.id.Voice3);
        btnVoice4 = findViewById(R.id.Voice4);

        btnVoice1.setOnClickListener(v -> playAudio(R.raw.test));
    }

    private void playAudio(int audioResId) {
        if (player == null) {
            player = MediaPlayer.create(MainActivity.this, audioResId);
        }
        player.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
