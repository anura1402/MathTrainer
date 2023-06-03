package com.anura.magkursach.algebra;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.widget.ImageView;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.anura.magkursach.training.Jump_trainer;
import com.anura.magkursach.MainActivity;
import com.anura.magkursach.R;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

//import id.zelory.compressor.Compressor;
import io.github.kexanie.library.MathView;

public class Abb_multipl_formulas extends AppCompatActivity {
    private Intent intent;
    private Button button;
    private ImageView image_help1, image_help2, image_help3, image_help4, image_help5, image_help6, image_help7;
    private Dialog dialog;
    MathView formulaMV;
    String formula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abb_multipl_formulas);
        //getSupportActionBar().hide();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null) {
            toolbar.setTitle("Формулы сокращенного умножения");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dialog = new Dialog(Abb_multipl_formulas.this);
        image_help1 = findViewById(R.id.image_help1);
        image_help1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_abb);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help2 = findViewById(R.id.image_help2);
        image_help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_sub);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help3 = findViewById(R.id.image_help3);
        image_help3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_squares);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help4 = findViewById(R.id.image_help4);
        image_help4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_abb);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help5 = findViewById(R.id.image_help5);
        image_help5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_sub);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help6 = findViewById(R.id.image_help6);
        image_help6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_abb_of_cub);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        image_help7 = findViewById(R.id.image_help7);
        image_help7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_cub);
                formula = formulaMV.getText();
                showPopup(formula);
            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Abb_multipl_formulas.this, Jump_trainer.class);
                intent.putExtra("EXTRA_NEXT_ACTIVITY_CLASS", Abb_multipl_formulas.class);
                intent.putExtra("activity_name", "Abb_multipl_formulas");
                startActivity(intent);
            }
        });
    }

    private void showPopup(String formula) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_window);
        MathView mv = dialog.findViewById(R.id.window_mathView);
        mv.setText(formula);

        Button btnRead = dialog.findViewById(R.id.btn_read);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "Прочитать правило"
                dialog.hide();

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int screenWidth = displayMetrics.widthPixels;
                int screenHeight = displayMetrics.heightPixels;

                final Dialog dialogRead = new Dialog(Abb_multipl_formulas.this);
                dialogRead.setContentView(R.layout.rule);

                WebView view = dialogRead.findViewById(R.id.html_context);
                view.loadUrl("file:///android_asset/abb_1_.html");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        screenWidth * 9 / 10, // Здесь мы установили ширину равной 50% ширины экрана
                        screenHeight * 7 / 10 // Здесь мы установили высоту равной 70% высоты экрана
                );
                view.setLayoutParams(params);
                view.requestLayout();
                view.getSettings().setBuiltInZoomControls(true);
                view.getSettings().setSupportZoom(true);
                //view.getSettings().setJavaScriptEnabled(true);

                Button btn_exit = dialogRead.findViewById(R.id.btn_exit_back);
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogRead.dismiss();
                        dialog.show();
                    }
                });
                dialogRead.show();
            }
        });

        Button btnListen = dialog.findViewById(R.id.btn_listen);
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "Прослушать формулу"
                dialog.dismiss();
            }
        });
        Button btnWatch = dialog.findViewById(R.id.btn_watch);
        btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "Посмотреть анимацию"
                dialog.hide();
                final Dialog dialogWatch = new Dialog(Abb_multipl_formulas.this);
                dialogWatch.setContentView(R.layout.animation);

                ImageView gif = dialogWatch.findViewById(R.id.my_gif);
                //gif.setImageResource(R.drawable.abb_1);
                Glide.with(Abb_multipl_formulas.this)
                        .asGif()
                        .load(R.drawable.abb_1)
                        .into(gif);

                Button btn_exit = dialogWatch.findViewById(R.id.btn_exit_back);
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogWatch.dismiss();
                        dialog.show();
                    }
                });
                dialogWatch.show();
            }
        });
        Button btnExit = dialog.findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


        Log.d("TAG1", "Успешно");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(Abb_multipl_formulas.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}