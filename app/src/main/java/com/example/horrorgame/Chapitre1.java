package com.example.horrorgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chapitre1 extends Activity {

    private TextView dialogueText, inventaireText, presenceText;
    private View zoneCommode;
    private boolean aLaCle = false;
    private LinearLayout itemCle; // Référence pour l'élément de l'inventaire
    private LinearLayout inventaireLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapitre1);

        dialogueText = findViewById(R.id.dialogueText);
        inventaireText = findViewById(R.id.inventaireText);
        presenceText = findViewById(R.id.presenceText);
        zoneCommode = findViewById(R.id.zoneCommode);
        inventaireLayout = findViewById(R.id.inventaireLayout);
        itemCle = findViewById(R.id.itemCle); // Récupère l'élément de la clé

        dialogueText.setText("La pièce est silencieuse...");

        zoneCommode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!aLaCle) {
                    dialogueText.setText("Vous trouvez une clé ancienne dans un tiroir grinçant.");


                    itemCle.setVisibility(View.VISIBLE);
                    inventaireText.setText("Inventaire : Clé rouillée");
                    aLaCle = true;

                } else {
                    dialogueText.setText("Il n’y a plus rien dans la commode.");
                }
            }
        });
    }
}
