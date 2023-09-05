package com.anura.magkursach.ui.keyboard;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.anura.magkursach.MainActivity;
import com.anura.magkursach.R;
import com.anura.magkursach.algebra.Abb_multipl_formulas;
import com.anura.magkursach.training.Jump_trainer;
import com.anura.magkursach.training.Questions;
import com.anura.magkursach.training.ResultActivity;
import com.anura.magkursach.training.TrainActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import io.github.kexanie.library.MathView;

public class sampleActivity extends AppCompatActivity {
    public Keyboard keyboard;
    private TextView questionTextView;
    private MathView questionFormula;
    private Button submitButton;

    List<Questions> questionsItems;
    int currentQuestions = 0;
    int correct = 0, wrong = 0;
    String activityName = "";
    int size_of_questions = 0;
    ArrayList<String> leftQ = new ArrayList<>();
    ArrayList<String> rightQ = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null) {
            toolbar.setTitle("Тренировка");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        questionFormula = findViewById(R.id.mv_formula);
        questionTextView = findViewById(R.id.textQuestion);
        keyboard = findViewById(R.id.kb);
        Button check = keyboard.findViewById(R.id.bt_check);

        activityName = getIntent().getStringExtra("activity_name");

        // Initialize questions list

        loadAllQuestions();
        Log.d("TAG1", "Quest: " + questionsItems.toString());

        // Set first question
        setQuestionScreen(currentQuestions);
        size_of_questions = questionsItems.size();
        //setQuestionView(questionFormula);
        setQuestionView(questionsItems.get(0).getFormula());

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = "a...b";
                String user_part = keyboard.get_latex_text().replace("\\lceil", "");
                //String total = questionFormula.getText().replace("...", user_part);
                String total2 = "$$"+user_part.replace(" ", "")+"$$";
                Log.d("TAG1", "total " + total2 + " user_part " + user_part);
                showPopup(total2);
                //questionFormula.setText("");

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(sampleActivity.this, MainActivity.class);
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
        String jsonquiz = loadJsonFromAsset("formulasMiddle.json");
        //Log.d("TAG1", jsonquiz);
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONObject structure = jsonObject.getJSONObject("formulas");
            //Log.d("TAG1", "activityName: " + activityName);
            JSONArray questions = structure.getJSONArray(activityName);
            //Log.d("TAG1", "structure: " + structure + "\nquestions: " + String.valueOf(questions));

            for (int i = 0; i < questions.length(); i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionsString = question.getString("question");
                String formulaString = question.getString("formula");
                String correctString = question.getString("correct");
                String correct2String = question.getString("correct2");

                this.questionsItems.add(new Questions(questionsString, formulaString, correctString,correct2String));
                //Log.d("TAG1", questionsItems.toString());
            }
            Collections.shuffle(questionsItems);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TAG1", "error: " + e);
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
    }

    private void setQuestionView(String formula) {
        //String formula = questionFormula.getText();
        //keyboard.reset_text();
        leftQ.clear();
        rightQ.clear();
        Log.d("TAG1","formula "+formula);
        String formulaLeft = formula.split("\\.\\.\\.")[0];
        String formulaRight = formula.split("\\.\\.\\.")[1];

        //cоставление ArrayString из левой части формулы для передачи в функцию
        for (int i = 0; i < formulaLeft.length(); i++) {
            char c = formulaLeft.charAt(i);
            String character = String.valueOf(c);
            leftQ.add(character);

        }
        //cоставление ArrayString из правой части формулы для передачи в функцию
        for (int i = 0; i < formulaRight.length(); i++) {
            char c = formulaRight.charAt(i);
            String character = String.valueOf(c);
            rightQ.add(character);
        }
        Log.d("TAG1","questionF "+questionFormula+" leftQ "+leftQ+" rightQ "+rightQ);
        //передача формулы для отображения, а так же начальные данные для левой и правой части от курсора
        keyboard.set_view(questionFormula, leftQ, rightQ);
    }

    private void showPopup(String formula) {
        if (formula.equals(questionsItems.get(currentQuestions).getAnswer()) || formula.equals(questionsItems.get(currentQuestions).getAnswer2())) {
            correct++;
            final BottomSheetDialog dialogCorrect = new BottomSheetDialog(this);
            dialogCorrect.setContentView(R.layout.popup_window_correct);
            //io.github.kexanie.library.MathView mv = dialog.findViewById(R.id.window_mathView);
            //mv.setText(formula);

            dialogCorrect.show();
            Button btnNext = dialogCorrect.findViewById(R.id.btn_next);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Действие при нажатии на кнопку "Далее"
                    dialogCorrect.dismiss();
                    if (currentQuestions < questionsItems.size() - 1) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                currentQuestions++;
                                setQuestionScreen(currentQuestions);
                                //keyboard.reset_text();
                                setQuestionView(questionsItems.get(currentQuestions).getFormula());
                            }
                        }, 500);
                    } else {
                        Intent intent = new Intent(sampleActivity.this, ResultActivity.class);
                        intent.putExtra("correct", correct);
                        intent.putExtra("wrong", wrong);
                        intent.putExtra("questions", size_of_questions);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        } else {
            wrong++;
            final BottomSheetDialog dialogWrong = new BottomSheetDialog(this);
            dialogWrong.setContentView(R.layout.popup_window_wrong);
            //io.github.kexanie.library.MathView mv = dialog.findViewById(R.id.window_mathView);
            //mv.setText(formula);
            dialogWrong.show();
            Button btnNext = dialogWrong.findViewById(R.id.btn_next);
            MathView mv_correct = dialogWrong.findViewById(R.id.formula_correct);
            mv_correct.setText(questionsItems.get(currentQuestions).getAnswer());
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Действие при нажатии на кнопку "Далее"
                    dialogWrong.dismiss();
                    if (currentQuestions < questionsItems.size() - 1) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                currentQuestions++;
                                setQuestionScreen(currentQuestions);
                                //keyboard.reset_text();
                                setQuestionView(questionsItems.get(currentQuestions).getFormula());
                            }
                        }, 500);
                    } else {
                        Intent intent = new Intent(sampleActivity.this, ResultActivity.class);
                        intent.putExtra("correct", correct);
                        intent.putExtra("wrong", wrong);
                        intent.putExtra("questions", size_of_questions);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        }
    }
}