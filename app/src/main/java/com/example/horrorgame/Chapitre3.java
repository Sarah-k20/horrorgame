package com.example.horrorgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Chapitre3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chapitre3);


        Button btnCoffre = findViewById(R.id.btn_coffre);
        btnCoffre.setOnClickListener(v -> {
            Intent intent = new Intent(Chapitre3.this, Enigme1.class);
            startActivity(intent);
            finish();
        });
        Button btnRetourCouloir = findViewById(R.id.btn_retour_couloir);
        btnRetourCouloir.setOnClickListener(v -> {
            Intent intent = new Intent(Chapitre3.this, Chapitre2.class);
            startActivity(intent);
            finish();
        });

    }
}