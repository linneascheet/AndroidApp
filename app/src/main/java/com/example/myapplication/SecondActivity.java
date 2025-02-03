package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button btnVoice1, btnVoice2, btnVoice3, btnVoice4;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize buttons
        btnVoice1 = findViewById(R.id.Voice1);
        btnVoice2 = findViewById(R.id.Voice2);
        btnVoice3 = findViewById(R.id.Voice3);
        btnVoice4 = findViewById(R.id.Voice4);

        // Set up onClickListeners for each button
        btnVoice1.setOnClickListener(v -> playAudio(R.raw.sound1));
        btnVoice2.setOnClickListener(v -> playAudio(R.raw.sound2));
        btnVoice3.setOnClickListener(v -> playAudio(R.raw.sound1));
        btnVoice4.setOnClickListener(v -> playAudio(R.raw.sound1));
    }

    private void playAudio(int audioResId) {
        if (player == null) {
            player = MediaPlayer.create(SecondActivity.this, audioResId);
        }
        player.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
        }
    }
}
