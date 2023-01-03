package com.example.textencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView receiver_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        receiver_msg = findViewById(R.id.receive_value);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String val = extras.getString("input");
            String decryptedText = decrypt(val, 3);
            receiver_msg.setText(decryptedText);
        }
    }
    public static String decrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ((c - shift - 'A' + 26) % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c - shift - 'a' + 26) % 26 + 'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

