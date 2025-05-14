package com.example.horrorgame;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Enigme1 extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private boolean[][] states = new boolean[3][3];
    private ImageView coffreImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enigme1);

        coffreImage = findViewById(R.id.coffreff);

        String[] ids = {
                "btn00", "btn01", "btn02",
                "btn10", "btn11", "btn12",
                "btn20", "btn21", "btn22"
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int resId = getResources().getIdentifier(ids[i * 3 + j], "id", getPackageName());
                buttons[i][j] = findViewById(resId);

                int finalI = i;
                int finalJ = j;
                buttons[i][j].setOnClickListener(v -> {
                    toggle(finalI, finalJ);
                    updateUI();
                    checkWin();
                });
            }
        }


        Button resetBtn = findViewById(R.id.Reset_btn);
        resetBtn.setOnClickListener(v -> reset());
        Button btnRetour = findViewById(R.id.btn_retour);
        btnRetour.setOnClickListener(v -> finish());

        updateUI();
    }

    private void toggle(int i, int j) {
        toggleCell(i, j);
        toggleCell(i - 1, j); // haut
        toggleCell(i + 1, j); // bas
        toggleCell(i, j - 1); // gauche
        toggleCell(i, j + 1); // droite
    }

    private void toggleCell(int i, int j) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3) {
            states[i][j] = !states[i][j];
        }
    }

    private void updateUI() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                int color = states[i][j] ? Color.BLACK : Color.WHITE;
                buttons[i][j].setBackgroundTintList(ColorStateList.valueOf(color));
            }
        }
    }

    private void checkWin() {
        for (boolean[] row : states)
            for (boolean cell : row)
                if (!cell) return;

        for (Button[] row : buttons)
            for (Button btn : row)
                btn.setEnabled(false);

        coffreImage.setImageResource(R.drawable.coffreoo);
    }

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                states[i][j] = false;
                buttons[i][j].setEnabled(true);
            }
        }
        coffreImage.setImageResource(R.drawable.coffreff);
        updateUI();
    }
}
