package com.example.horrorgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chapitre1 extends Activity {

    private TextView dialogueText, inventaireText, presenceText;
    private View zoneCommode;
    private View zonePorte;
    private boolean aLaCle = false;
    private LinearLayout itemCle;
    private LinearLayout inventaireLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapitre1);

        dialogueText = findViewById(R.id.dialogueText);
        inventaireText = findViewById(R.id.inventaireText);
        presenceText = findViewById(R.id.presenceText);
        zoneCommode = findViewById(R.id.zoneCommode);
        zonePorte = findViewById(R.id.zonePorte);
        inventaireLayout = findViewById(R.id.inventaireLayout);
        itemCle = findViewById(R.id.itemCle);

        dialogueText.setText("La pièce est silencieuse...");

        zoneCommode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!aLaCle) {
                    dialogueText.setText("Vous trouvez une clé ancienne dans un tiroir grinçant.");


                    itemCle.setVisibility(View.VISIBLE);


                    aLaCle = true;

                } else {
                    dialogueText.setText("Il n’y a plus rien dans la commode.");
                }
            }
        });

        zonePorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aLaCle) {
                    dialogueText.setText("La porte est ouverte.");
                    Intent intent = new Intent(Chapitre1.this, Chapitre2.class);
                    SharedPreferences prefs = getSharedPreferences("GamePrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("dernierChapitre", 2);
                    editor.apply();

                    startActivity(intent);


                } else {
                    dialogueText.setText("Vous ne pouvez pas ouvrir cette porte.");
                }
            }
        });
    }
}
