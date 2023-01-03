package com.example.textencryptor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class MainActivity2 extends AppCompatActivity {
    TextView receiver_msg;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        receiver_msg = findViewById(R.id.receive_value);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String val = extras.getString("input");
            String encryptedText = encrypt(val, 3);
            receiver_msg.setText(encryptedText);
        }


    }

    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ((c + shift - 'A') % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c + shift - 'a') % 26 + 'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }




}