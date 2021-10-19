package com.example.sharedpreferences_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button applyTextButton;
    private Button saveButton;
    private Switch switch1;

    private String save_load_text;
    private boolean switchOnOff;

    //SHARED PREFERENCES
    public static final String SHARED_PREFS = "sharedPrefs"; // SHARED PREFERENCES er naam dilam nijer ichha moto
    public static final String TEXT = "text"; // SHARED PREFERENCES jei MAP ache taar "KEY" hobe eita
    public static final String SWITCH1 = "switch1"; // SHARED PREFERENCES jei MAP ache taar "KEY" hobe eita


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewId);
        editText = findViewById(R.id.editTextId);
        applyTextButton = findViewById(R.id.applyTextButtonId);
        saveButton = findViewById(R.id.saveDataButtonId);
        switch1 = findViewById(R.id.switchId);

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateViews();

    }

    public void saveData(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE); //MODE Private dewa mane onno kono APPLICATION amader ei "SHARED_PREFS" name er Shared_Preferences er value arr change korte parbe nah
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //MAP er moto KEY-VALUE pair ee SAVE kori amra
        editor.putString(TEXT, textView.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply(); //eita nah dile DATA gula SAVE hobe nah

        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show();

    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE); //MODE Private dewa mane onno kono APPLICATION amader ei "SHARED_PREFS" name er Shared_Preferences er value arr change korte parbe nah

        save_load_text = sharedPreferences.getString(TEXT, "");  // 2nd Parameter ta huilo "DEFAULT" value
        switchOnOff = sharedPreferences.getBoolean(SWITCH1, false);
    }

    public void updateViews(){
        textView.setText(save_load_text);
        switch1.setChecked(switchOnOff);
    }


}