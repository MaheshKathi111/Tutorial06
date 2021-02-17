package com.edureka.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
     TextView tvUser;
     SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvUser = findViewById(R.id.tvUser);

        preferences = getSharedPreferences("college",MODE_PRIVATE);
        String userPreference = preferences.getString("username","");

        if(userPreference.equals(""))
        {
            Intent intent = new Intent(Welcome.this,Login.class);
            startActivity(intent);
            finish();
        }
    }



    public void logout(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        //editor.putString("username","");
        editor.remove("username");
        editor.commit();

        Intent intent = new Intent(Welcome.this,Login.class);
        startActivity(intent);
        finish();
        }
}