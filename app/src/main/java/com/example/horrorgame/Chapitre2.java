package com.example.horrorgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import android.widget.ImageView;


public class Chapitre2 extends Activity {

    private String enteredCode = "";
    private LinearLayout keyboardLayout;
    private TextView dialogueText;
    private boolean codeTrouve = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapitre2);
        View flashView = findViewById(R.id.flashView);


        keyboardLayout = findViewById(R.id.clavier);
        dialogueText = findViewById(R.id.dialogueText);

        keyboardLayout.setVisibility(View.GONE);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.jumpscare);



        findViewById(R.id.zoneportrait1).setOnClickListener(v -> {
            afficherTexte("Le tic-tac s’est arrêté… Il est toujours 03:10. Toujours.");
        });

        findViewById(R.id.zoneportrait2).setOnClickListener(v -> {
            afficherTexte("Regarde bien… Le chiffre des heures et celui des minutes ne s’aiment pas. L’un est plus petit que l’autre.");
        });
        findViewById(R.id.zoneportrait3).setOnClickListener(v -> {
            afficherTexte("Quand la cloche sonnera, il sera trop tard… Combien de secondes avant la délivrance ?");
            mediaPlayer.start();
            mediaPlayer.setVolume(1f, 1f);

            flashView.setVisibility(View.VISIBLE);


            new Handler().postDelayed(() -> {
                AlphaAnimation flash = new AlphaAnimation(1.0f, 0.0f);
                flash.setDuration(200);
                flash.setFillAfter(true);
                flashView.startAnimation(flash);
            }, 50);


            new Handler().postDelayed(() -> {
                flashView.setVisibility(View.GONE);
            }, 800);
        });




        findViewById(R.id.zoneporte).setOnClickListener(v -> {
            if (!codeTrouve) {
                keyboardLayout.setVisibility(View.VISIBLE);
                afficherTexte("Entrez le code à 5 chiffres.");
            }
        });

        initKeyboard();
    }

    private void afficherTexte(String texte) {
        dialogueText.setText(texte);
    }

    private void initKeyboard() {
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn0 = findViewById(R.id.btn0);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnEnter = findViewById(R.id.btnEnter);

        View.OnClickListener digitClickListener = v -> {
            if (enteredCode.length() < 5) {
                enteredCode += ((Button) v).getText().toString();
            }
        };

        btn1.setOnClickListener(digitClickListener);
        btn2.setOnClickListener(digitClickListener);
        btn3.setOnClickListener(digitClickListener);
        btn4.setOnClickListener(digitClickListener);
        btn5.setOnClickListener(digitClickListener);
        btn6.setOnClickListener(digitClickListener);
        btn7.setOnClickListener(digitClickListener);
        btn8.setOnClickListener(digitClickListener);
        btn9.setOnClickListener(digitClickListener);
        btn0.setOnClickListener(digitClickListener);

        btnClear.setOnClickListener(v -> {
            enteredCode = "";
            afficherTexte("Code effacé.");
        });

        btnEnter.setOnClickListener(v -> {
            if ("71050".equals(enteredCode)) {
                codeTrouve = true;
                keyboardLayout.setVisibility(View.GONE);
                afficherTexte("La porte s’ouvre lentement… Vous pouvez avancer.");
                Intent intent = new Intent(this, Chapitre3.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            } else {
                enteredCode = "";
                afficherTexte("Code incorrect. Essayez encore.");
            }
        });
    }
}
