package com.anura.magkursach.algebra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anura.magkursach.training.Questions;
import com.bumptech.glide.Glide;

import android.media.MediaPlayer;
import android.os.Build;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.anura.magkursach.training.Jump_trainer;
import com.anura.magkursach.MainActivity;
import com.anura.magkursach.R;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import katex.hourglass.in.mathlib.MathView;

//import id.zelory.compressor.Compressor;
//import io.github.kexanie.library.MathView;

public class Abb_multipl_formulas extends AppCompatActivity {
    private Intent intent;
    private Button button;
    private ImageView image_help1, image_help2, image_help3, image_help4, image_help5, image_help6, image_help7,
            image_mistake1, image_mistake2, image_mistake3, image_mistake4, image_mistake5, image_mistake6, image_mistake7;
    private Dialog dialog;
    io.github.kexanie.library.MathView formulaMV;
    private String formula;
    private String fileName;
    private List<Examples> examplesItems;
    private String activityName = "Abb_multipl_formulas";


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
        Log.d("TAG1", "Успешно1");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //нахождение кнопок помощи
        image_help1 = findViewById(R.id.image_help1);
        image_help2 = findViewById(R.id.image_help2);
        image_help3 = findViewById(R.id.image_help3);
        image_help4 = findViewById(R.id.image_help4);
        image_help5 = findViewById(R.id.image_help5);
        image_help6 = findViewById(R.id.image_help6);
        image_help7 = findViewById(R.id.image_help7);
        //нахождение кнопок прогнозируемых ошибок
        image_mistake1 = findViewById(R.id.image_mistake1);
        image_mistake2 = findViewById(R.id.image_mistake2);
        image_mistake3 = findViewById(R.id.image_mistake3);
        image_mistake4 = findViewById(R.id.image_mistake4);
        image_mistake5 = findViewById(R.id.image_mistake5);
        image_mistake6 = findViewById(R.id.image_mistake6);
        image_mistake7 = findViewById(R.id.image_mistake7);
//чекбокс "показать помощь"
        CheckBox checkBox = findViewById(R.id.my_checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Обработка изменения состояния CheckBox
                    image_help1.setVisibility(View.VISIBLE);
                    image_help2.setVisibility(View.VISIBLE);
                    image_help3.setVisibility(View.VISIBLE);
                    image_help4.setVisibility(View.VISIBLE);
                    image_help5.setVisibility(View.VISIBLE);
                    image_help6.setVisibility(View.VISIBLE);
                    image_help7.setVisibility(View.VISIBLE);

                    image_mistake1.setVisibility(View.VISIBLE);
                    image_mistake2.setVisibility(View.VISIBLE);
                    image_mistake3.setVisibility(View.VISIBLE);
                    image_mistake4.setVisibility(View.VISIBLE);
                    image_mistake5.setVisibility(View.VISIBLE);
                    image_mistake6.setVisibility(View.VISIBLE);
                    image_mistake7.setVisibility(View.VISIBLE);
                } else {
                    image_help1.setVisibility(View.INVISIBLE);
                    image_help2.setVisibility(View.INVISIBLE);
                    image_help3.setVisibility(View.INVISIBLE);
                    image_help4.setVisibility(View.INVISIBLE);
                    image_help5.setVisibility(View.INVISIBLE);
                    image_help6.setVisibility(View.INVISIBLE);
                    image_help7.setVisibility(View.INVISIBLE);

                    image_mistake1.setVisibility(View.INVISIBLE);
                    image_mistake2.setVisibility(View.INVISIBLE);
                    image_mistake3.setVisibility(View.INVISIBLE);
                    image_mistake4.setVisibility(View.INVISIBLE);
                    image_mistake5.setVisibility(View.INVISIBLE);
                    image_mistake6.setVisibility(View.INVISIBLE);
                    image_mistake7.setVisibility(View.INVISIBLE);
                }
            }
        });

        //мини-окна помощи
        dialog = new Dialog(Abb_multipl_formulas.this);

        image_help1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_abb);
                formula = formulaMV.getText();
                showPopupHelp(formula, 1);
                Log.d("TAG1", formula + " Успешно1");
            }
        });
        image_help2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_sub);
                formula = formulaMV.getText();
                showPopupHelp(formula, 2);
            }
        });
        image_help3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_squares);
                formula = formulaMV.getText();
                showPopupHelp(formula, 3);
            }
        });
        image_help4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_abb);
                formula = formulaMV.getText();
                showPopupHelp(formula, 4);
            }
        });
        image_help5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_sub);
                formula = formulaMV.getText();
                showPopupHelp(formula, 5);
            }
        });
        image_help6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_abb_of_cub);
                formula = formulaMV.getText();
                showPopupHelp(formula, 6);
            }
        });
        image_help7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_cub);
                formula = formulaMV.getText();
                showPopupHelp(formula, 7);
            }
        });

        //мини-окна прогнозируемых ошибок
        dialog = new Dialog(Abb_multipl_formulas.this);

        image_mistake1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_abb);
                formula = formulaMV.getText();
                showPopupMistakes(formula,1);
            }
        });
        image_mistake2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_square_of_sub);
                formula = formulaMV.getText();
                showPopupMistakes(formula,2);
            }
        });
        image_mistake3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_squares);
                formula = formulaMV.getText();
                showPopupMistakes(formula,3);
            }
        });
        image_mistake4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_abb);
                formula = formulaMV.getText();
                showPopupMistakes(formula,4);
            }
        });
        image_mistake5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_cub_of_sub);
                formula = formulaMV.getText();
                showPopupMistakes(formula,5);
            }
        });
        image_mistake6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_abb_of_cub);
                formula = formulaMV.getText();
                showPopupMistakes(formula,6);
            }
        });
        image_mistake7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formulaMV = findViewById(R.id.formula_sub_of_cub);
                formula = formulaMV.getText();
                showPopupMistakes(formula,7);
            }
        });
        //кнопка "начать тренировку"
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


    private void showPopupHelp(String formula, int number) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_window_help);
        io.github.kexanie.library.MathView mv = dialog.findViewById(R.id.window_mathView);
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
                fileName = "file:///android_asset/ruleAbb" + number + ".html";
                view.loadUrl(fileName);
                Log.d("TAG1", "fileName " + fileName);
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
                int audioId = getResources().getIdentifier("abb_" + number, "raw", getPackageName());
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), audioId);
                mediaPlayer.start();
                //speakMathView(mv);


                //dialog.dismiss();
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
                int resourceId = getResources().getIdentifier("abb_" + number, "drawable", getPackageName());
                //gif.setImageResource(R.drawable.abb_1);
                Glide.with(Abb_multipl_formulas.this)
                        .asGif()
                        .load(resourceId)
                        .listener(new RequestListener<GifDrawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                                resource.setLoopCount(1); // Устанавливаем однократное проигрывание
                                return false;
                            }
                        }).into(gif);

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
        //выход из мини-окна
        Button btnExit = dialog.findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


        //Log.d("TAG1", "Успешно1");
    }

    private void showPopupMistakes(String formula,int number) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_window_mistake);
        io.github.kexanie.library.MathView mv = dialog.findViewById(R.id.window_mathView);
        mv.setText(formula);

        Button btnExample = dialog.findViewById(R.id.btn_example);
        btnExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "Посмотреть примеры"
                dialog.hide();
                final Dialog dialogHelp = new Dialog(Abb_multipl_formulas.this);
                dialogHelp.setContentView(R.layout.examples);

                // получение размер окна телефона
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(dialogHelp.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                //layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialogHelp.getWindow().setAttributes(layoutParams);
                //установка размера диалогового окна
                //Window window = dialogWatch.getWindow();
                //window.setLayout(1000, 1000);

                katex.hourglass.in.mathlib.MathView formula1 = dialogHelp.findViewById(R.id.formula1);
                katex.hourglass.in.mathlib.MathView formula2 = dialogHelp.findViewById(R.id.formula2);
                katex.hourglass.in.mathlib.MathView formula3 = dialogHelp.findViewById(R.id.formula3);
                katex.hourglass.in.mathlib.MathView formula4 = dialogHelp.findViewById(R.id.formula4);
                loadAllExamples();
                formula1.setDisplayText(examplesItems.get(number-1).getFormula1());
                //formula1.canScrollHorizontally(100);
                formula2.setDisplayText(examplesItems.get(number-1).getFormula2());
                formula3.setDisplayText(examplesItems.get(number-1).getFormula3());
                formula4.setDisplayText(examplesItems.get(number-1).getFormula4());

                Button btn_exit = dialogHelp.findViewById(R.id.btn_exit_back);
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogHelp.dismiss();
                        dialog.show();
                    }
                });
                dialogHelp.show();
                dialogHelp.getWindow().setAttributes(layoutParams);

            }
        });

        Button btnMistake = dialog.findViewById(R.id.btn_mistake);
        btnMistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии на кнопку "Посмотреть ошибки"
                dialog.hide();
                final Dialog dialogMistakes = new Dialog(Abb_multipl_formulas.this);
                dialogMistakes.setContentView(R.layout.mistakes);

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int screenWidth = displayMetrics.widthPixels;
                int screenHeight = displayMetrics.heightPixels;
                // получение размер окна телефона
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(dialogMistakes.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                //layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialogMistakes.getWindow().setAttributes(layoutParams);
                //установка размера диалогового окна
                //Window window = dialogWatch.getWindow();
                //window.setLayout(1000, 1000);

                WebView view = dialogMistakes.findViewById(R.id.html_context);
                fileName = "file:///android_asset/mAbb" + number + ".html";
                view.loadUrl(fileName);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        screenWidth * 9 / 10, // Здесь мы установили ширину равной 50% ширины экрана
                        screenHeight * 5 / 10 // Здесь мы установили высоту равной 70% высоты экрана
                );
                view.setLayoutParams(params);
                view.requestLayout();
                view.getSettings().setBuiltInZoomControls(true);
                view.getSettings().setSupportZoom(true);
                view.setInitialScale(180);

                /*katex.hourglass.in.mathlib.MathView formula1 = dialogWatch.findViewById(R.id.formula1);
                katex.hourglass.in.mathlib.MathView formula2 = dialogWatch.findViewById(R.id.formula2);
                katex.hourglass.in.mathlib.MathView formula3 = dialogWatch.findViewById(R.id.formula3);
                katex.hourglass.in.mathlib.MathView formula4 = dialogWatch.findViewById(R.id.formula4);


                formula1.setDisplayText("\\((m+5)^2=m^2+5^2 =m^2+25\\)");
                formula2.setDisplayText("\\((3x+2y)^2=3x^2+2 \\cdot 3x\\cdot2y+2y^2=3x^2+12xy+2y^2\\)");
                formula3.setDisplayText("\\(9+24m+16m^2=3^2+3\\cdot 4m+(4m)^2=?\\)");
                formula4.setDisplayText("$$(52^2=(50+2)^2=50^2+50\\cdot2+2^2=2500+100+4=2604$$");

                 */

                Button btn_exit = dialogMistakes.findViewById(R.id.btn_exit_back);
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogMistakes.dismiss();
                        dialog.show();
                    }
                });
                dialogMistakes.show();
                dialogMistakes.getWindow().setAttributes(layoutParams);
            }
        });
        //выход из мини-окна
        Button btnExit = dialog.findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


        Log.d("TAG1", "Успешно2");
    }

    //чтение примеров из json
    private void loadAllExamples() {
        examplesItems = new ArrayList<>();
        String jsonExamples = loadJsonFromAsset("examples.json");
        //Log.d("TAG1", jsonquiz);
        try {
            JSONObject jsonObject = new JSONObject(jsonExamples);
            JSONObject structure = jsonObject.getJSONObject("examples");
            JSONArray examples = structure.getJSONArray(activityName);
            //Log.d("TAG1", "structure: " + structure + "\nquestions: " + String.valueOf(questions));

            for (int i = 0; i < examples.length(); i++) {
                JSONObject example = examples.getJSONObject(i);

                Integer exampleNumber = example.getInt("number");
                String formula1String = example.getString("formula1");
                String formula2String = example.getString("formula2");
                String formula3String = example.getString("formula3");
                String formula4String = example.getString("formula4");

                this.examplesItems.add(new Examples(exampleNumber, formula1String, formula2String, formula3String, formula4String));
                Log.d("TAG1", examplesItems.toString());
            }
            //Collections.shuffle(examplesItems);
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
    //стрелочка "назад"
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