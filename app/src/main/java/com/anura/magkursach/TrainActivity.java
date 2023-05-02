package com.anura.magkursach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.FrameMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.kexanie.library.MathView;

public class TrainActivity extends AppCompatActivity {
    private TextView questionTextView;
    private FrameLayout option1CardView, option2CardView, option3CardView, option4CardView;
    MathView questionFormula, answer1, answer2, answer3, answer4;
    private Button submitButton;
    List<CardView> cardViews = new ArrayList<>();
    List<Questions> questionsItems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;

    //private List<Questions> questionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null) {
            toolbar.setTitle("Тренировка");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initialize views
        questionTextView = findViewById(R.id.textQuestion);
        questionFormula = findViewById(R.id.formula1);
        option1CardView = findViewById(R.id.cardViewAnswer1);
        option2CardView = findViewById(R.id.cardViewAnswer2);
        option3CardView = findViewById(R.id.cardViewAnswer3);
        option4CardView = findViewById(R.id.cardViewAnswer4);
        answer1 = findViewById(R.id.formulaAnswer1);
        answer2 = findViewById(R.id.formulaAnswer2);
        answer3 = findViewById(R.id.formulaAnswer3);
        answer4 = findViewById(R.id.formulaAnswer4);
        submitButton = findViewById(R.id.buttonCheck);

        // Initialize questions list
        //questionsList = new ArrayList<>();
        //questionsList.add(new Questions("What is the capital of France?", "Paris","Paris", "London", "Berlin", "Moscow","Paris"));
        //questionsList.add(new Questions("What is the tallest mountain in the world?", "Paris","Mount Everest", "K2", "Makalu",  "Moscow","Mount Everest"));
        //questionsList.add(new Questions("What is the largest country in the world?", "Paris","Russia", "Canada", "China",  "Moscow","Russia"));
        //questionsList.add(new Questions("What is the largest country in the world?", "Paris","Russia", "Canada", "China",  "Moscow","Russia"));

        loadAllQuestions();
        //Log.d("TAG1", questionsItems.toString());

        // Set first question
        setQuestionScreen(currentQuestions);
        option1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getOption1().equals(questionsItems.get(currentQuestions).getAnswer())) {
                    correct++;
                    option1CardView.setBackgroundResource(R.color.green);
                    //answer1.setTextColor(getResources().getColor(R.color.white));
                } else {
                    wrong++;
                    option1CardView.setBackgroundResource(R.color.red);
                    //answer1.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            option1CardView.setBackgroundResource(R.drawable.border);
                            //option1CardView.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(TrainActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        option2CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getOption2().equals(questionsItems.get(currentQuestions).getAnswer())) {
                    correct++;
                    option2CardView.setBackgroundResource(R.color.green);
                    //option2CardView.setTextColor(getResources().getColor(R.color.white));
                } else {
                    wrong++;
                    option2CardView.setBackgroundResource(R.color.red);
                    //option2CardView.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            option2CardView.setBackgroundResource(R.drawable.border);
                            // option2CardView.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(TrainActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        option3CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getOption3().equals(questionsItems.get(currentQuestions).getAnswer())) {
                    correct++;
                    option3CardView.setBackgroundResource(R.color.green);
                    //option3CardView.setTextColor(getResources().getColor(R.color.white));
                } else {
                    wrong++;
                    option3CardView.setBackgroundResource(R.color.red);
                    //option3CardView.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            option3CardView.setBackgroundResource(R.drawable.border);
                            //option3CardView.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(TrainActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        option4CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionsItems.get(currentQuestions).getOption4().equals(questionsItems.get(currentQuestions).getAnswer())) {
                    correct++;
                    option4CardView.setBackgroundResource(R.color.green);
                    // option4CardView.setTextColor(getResources().getColor(R.color.white));
                } else {
                    wrong++;
                    option4CardView.setBackgroundResource(R.color.red);
                    //option4CardView.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size() - 1) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            option4CardView.setBackgroundResource(R.drawable.border);
                            // option4CardView.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, 500);
                } else {
                    Intent intent = new Intent(TrainActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(TrainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadAllQuestions() {
        questionsItems = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset("formulas.json");
        //Log.d("TAG1", jsonquiz);
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONObject structure = jsonObject.getJSONObject("formulas");
            JSONArray questions = structure.getJSONArray("Abb_multipl_formulas");
            Log.d("TAG1","structure: "+structure+"\nquestions: " +  String.valueOf(questions));
            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String formulaString = question.getString("formula");
                String answer1String = question.getString("answer1");
                String answer2String = question.getString("answer2");
                String answer3String = question.getString("answer3");
                String answer4String = question.getString("answer4");
                String correctString = question.getString("correct");

                this.questionsItems.add(new Questions(questionsString, formulaString, answer1String, answer2String, answer3String, answer4String, correctString));
                //Log.d("TAG2", questionsItems.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TAG1","error: "+e);
        }
    }

    private String loadJsonFromAsset(String s) {
        String json = "";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    private void setQuestionScreen(int currentQuestionIndex) {
        questionTextView.setText(questionsItems.get(currentQuestionIndex).getQuestion());
        questionFormula.setText(questionsItems.get(currentQuestionIndex).getFormula());
        answer1.setText(questionsItems.get(currentQuestionIndex).getOption1());
        answer2.setText(questionsItems.get(currentQuestionIndex).getOption2());
        answer3.setText(questionsItems.get(currentQuestionIndex).getOption3());
        answer4.setText(questionsItems.get(currentQuestionIndex).getOption4());
    }

}