package com.example.android.booklisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button searchButton = (Button) findViewById(R.id.seach_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = (EditText)findViewById(R.id.input);
                String input = et.getText().toString().trim();
                if(input.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Type something and try again.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                    intent.putExtra("TextBox",input);
                    startActivity(intent);
                }
            }
        });
    }
}
