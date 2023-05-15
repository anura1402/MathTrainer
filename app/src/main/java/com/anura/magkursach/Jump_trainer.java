package com.anura.magkursach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class Jump_trainer extends AppCompatActivity {
    private Bundle extras;
    private Class parentClass;
    private Button button;
    Intent intent;
    String activityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_trainer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null){
            toolbar.setTitle("Выбор сложности");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        extras = getIntent().getExtras();
        parentClass = (Class<Activity>)extras.getSerializable("EXTRA_NEXT_ACTIVITY_CLASS");
        activityName = getIntent().getStringExtra("activity_name");
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        button = findViewById(R.id.button2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                radioButton.getText().toString();
                if (radioButton.getText().toString().equals("Легкая")){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intent = new Intent(Jump_trainer.this, TrainActivity.class);
                            intent.putExtra("EXTRA_NEXT_ACTIVITY_CLASS", parentClass);
                            intent.putExtra("activity_name", activityName);
                            startActivity(intent);
                        }
                    });
                }
                //TextView tv = findViewById(R.id.textView13);
                //tv.setText(radioButton.getText().toString());
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(Jump_trainer.this, parentClass);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}