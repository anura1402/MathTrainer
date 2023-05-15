package com.anura.magkursach;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {


    TextView correctt, wrongt, resultinfo;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null) {
            toolbar.setTitle("Результат");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        correctt = findViewById(R.id.correctScore);
        wrongt = findViewById(R.id.wrongScore);
        resultinfo = findViewById(R.id.resultInfo);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int questions = getIntent().getIntExtra("questions", 0);
        //int score = correct * 5;

        correctt.setText("" + correct);
        wrongt.setText("" + wrong);
        //resultscore.setText("" + score);
        Log.d("TAG1", "questions: " + questions + " correct: "+ correct);
        if (correct >= 0 && correct <= questions * 0.2) {
            resultinfo.setText("Нужно пройти тест заново");
            resultImage.setImageResource(R.drawable.ic_sad);
        } else if (correct > questions * 0.2 && correct <= questions * 0.5) {
            resultinfo.setText("Нужно попробовать немного лучше");
            resultImage.setImageResource(R.drawable.ic_neutral);
        } else if (correct > questions * 0.5 && correct <= questions * 0.8) {
            resultinfo.setText("Достаточно хорошо");
            resultImage.setImageResource(R.drawable.happy);
        } else if (correct > questions * 0.8 && correct <= questions) {
            resultinfo.setText("Отличные знания!");
            resultImage.setImageResource(R.drawable.happy);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}