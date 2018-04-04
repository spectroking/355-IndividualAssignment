package com.example.kinglm.a355app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        EditText ogWord = (EditText)findViewById(R.id.field);
        final String str = ogWord.getText().toString();



        Button enterValuesButton = findViewById(R.id.enterValues);
        enterValuesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toEnterValueScreen = new Intent(getApplicationContext(), EnterValues.class);
                startActivity(toEnterValueScreen);
            }
        });

        Button pairButton = findViewById(R.id.getAntonym);
        pairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toResultsScreen = new Intent(getApplicationContext(), Results.class);
                toResultsScreen.putExtra("Input", str);
                startActivity(toResultsScreen);
            }
        });
    }
}