package com.anura.magkursach.ui.algebra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import com.anura.magkursach.Abb_multipl_formulas;
import com.anura.magkursach.R;
import com.anura.magkursach.Rad_to_Degrees;
import com.anura.magkursach.databinding.FragmentAlgebraBinding;


public class Algebra extends AppCompatActivity implements View.OnClickListener {


    private CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;

    //cоздание активити
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.anura.magkursach.databinding.FragmentAlgebraBinding binding = FragmentAlgebraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toast toast = Toast.makeText(getApplicationContext(),
                "Пора покормить кота!", Toast.LENGTH_SHORT);
        toast.show();

        //работа с CardView

        card1 = findViewById(R.id.cardView);
        card2 = findViewById(R.id.cardView2);
        card3 = findViewById(R.id.cardView3);
        card4 = findViewById(R.id.cardView4);
        card5 = findViewById(R.id.cardView5);
        card6 = findViewById(R.id.cardView6);
        card7 = findViewById(R.id.cardView7);
        card8 = findViewById(R.id.cardView8);
        card9 = findViewById(R.id.cardView9);
        card10 = findViewById(R.id.cardView10);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.cardView) {
            intent = new Intent(this, Abb_multipl_formulas.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.cardView6) {
            intent = new Intent(this, Rad_to_Degrees.class);
            startActivity(intent);
        }

    }
}

