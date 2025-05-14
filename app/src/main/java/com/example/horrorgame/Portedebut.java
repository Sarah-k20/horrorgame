package com.example.horrorgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Portedebut extends AppCompatActivity {

    private TextView dialogueText;
    private View zonePorte;
    private int currentLineIndex = 0;

    private String[] introLines = {
            "Devant vous, à travers le brouillard, le manoir se dresse, massif et immobile. " +
                    "Un portail rouillé garde l’entrée, comme s’il hésitait à laisser passer quiconque.",
            "Vous coupez le moteur, sortez du véhicule. L’air est glacial, saturé d’humidité et d’odeur de feuilles mortes.",
            "Pas un bruit. Juste le crissement de vos pas sur le gravier, et le grincement du portail que vous poussez lentement.",
            "Vous êtes devant la porte principale. La poignée est froide. Vous inspirez... et entrez."
    };

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portedebut);

        dialogueText = findViewById(R.id.dialogueText);
        zonePorte = findViewById(R.id.zonePorte);
        ImageView backgroundImage = findViewById(R.id.backgroundImage);
        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(800);

        zonePorte.setVisibility(View.INVISIBLE);


        afficherDialogueAutomatique(fadeIn);


        zonePorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MediaPlayer mediaPlayer = MediaPlayer.create(Portedebut.this, R.raw.doorcreaking);
                mediaPlayer.setVolume(1f, 1f);
                mediaPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backgroundImage.setImageResource(R.drawable.dooropen);

                        startActivity(new Intent(Portedebut.this, Debutexplication.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                    }
                }, 1000);

            }
        });
    }

    private void afficherDialogueAutomatique(Animation fadeIn) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentLineIndex < introLines.length) {
                    dialogueText.setText(introLines[currentLineIndex]);
                    dialogueText.startAnimation(fadeIn);
                    currentLineIndex++;
                    handler.postDelayed(this, 4000);
                } else {

                    dialogueText.setText("Appuyez sur la porte pour entrer.");
                    zonePorte.setVisibility(View.VISIBLE);
                }
            }
        }, 100);
    }
}
