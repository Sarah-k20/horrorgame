package com.example.horrorgame;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class parametres extends AppCompatActivity {

    SeekBar seekBarVolume;
    AudioManager audioManager;
    Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        seekBarVolume = findViewById(R.id.seekBarVolume);
        btnRetour = findViewById(R.id.btnRetour);

        // 🎧 Initialisation AudioManager pour gérer le volume système
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax(maxVolume);
        seekBarVolume.setProgress(currentVolume);

        // 📉 Quand on change la position de la SeekBar
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // 🔙 Action du bouton Retour
        btnRetour.setOnClickListener(v -> {
            finish(); // Ferme l'activité et revient au menu
        });
    }
}
