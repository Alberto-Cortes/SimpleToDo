package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT);

        editText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // Button save method
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new intent
                Intent i = new Intent();

                // Set intent values captured from this activity
                i.putExtra(MainActivity.KEY_ITEM_TEXT, editText.getText().toString());
                i.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // Set an OK result to the intent
                setResult(RESULT_OK, i);

                // Finish and close activity
                finish();

            }
        });
    }
}