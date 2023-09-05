package com.anura.magkursach.trigonometry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.anura.magkursach.MainActivity;
import com.anura.magkursach.R;
import com.anura.magkursach.training.Jump_trainer;

import java.util.Objects;

public class Rad_table extends AppCompatActivity {

    private Intent intent;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rad_table);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null){
            toolbar.setTitle("Табличные значения (радианы)");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Rad_table.this, Jump_trainer.class);
                intent.putExtra("EXTRA_NEXT_ACTIVITY_CLASS", Rad_table.class);
                intent.putExtra("activity_name", "Rad_table");
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(Rad_table.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}