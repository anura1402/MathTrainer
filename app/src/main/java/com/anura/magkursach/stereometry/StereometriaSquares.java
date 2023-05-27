package com.anura.magkursach.stereometry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.anura.magkursach.R;
import com.anura.magkursach.training.Jump_trainer;
import com.anura.magkursach.ui.geometry.GeometryFragment;

import java.util.Objects;

public class StereometriaSquares extends AppCompatActivity {
    private Intent intent;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stereometria_squares);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        if (toolbar != null){
            toolbar.setTitle("Площади пространственных фигур");
            setSupportActionBar(toolbar);
        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(StereometriaSquares.this, Jump_trainer.class);
                intent.putExtra("EXTRA_NEXT_ACTIVITY_CLASS", StereometriaSquares.class);
                intent.putExtra("activity_name", "StereometriaSquares");
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Действие при нажатии кнопки назад на toolbar
                Intent intent = new Intent(this, GeometryFragment.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}