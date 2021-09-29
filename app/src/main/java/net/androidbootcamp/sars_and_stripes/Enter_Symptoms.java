package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Enter_Symptoms extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    Button Check_Results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_symptoms);

        cb1 = findViewById(R.id.checkbox_two);
        cb2 = findViewById(R.id.checkbox_three);
        cb3 = findViewById(R.id.checkbox_four);
        cb4 = findViewById(R.id.checkbox_five);
        cb5 = findViewById(R.id.checkbox_six);
        cb6 = findViewById(R.id.checkbox_eight);
        cb7 = findViewById(R.id.checkbox_nine);
        Check_Results = findViewById(R.id.check_Results);

    }
}