package com.example.textencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   EditText message;
   Button encrypt, decrypt, rencrypt, rdecrypt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        encrypt = findViewById(R.id.ceaserEncrypt);
        decrypt = findViewById(R.id.ceaserDecrypt);
        rencrypt = findViewById(R.id.rotEncrypt);
        rdecrypt = findViewById(R.id.rotDecrypt);
        message = findViewById(R.id.Enter_Text);

        encrypt.setOnClickListener(this);
        decrypt.setOnClickListener(this);
        rdecrypt.setOnClickListener(this);
        rencrypt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        String str = message.getText().toString();

        if (R.id.ceaserEncrypt == btnId) {
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("input", str);
            startActivity(i);
        } else if (R.id.ceaserDecrypt == btnId) {
            Intent i = new Intent(this, MainActivity3.class);
            i.putExtra("input", str);
            startActivity(i);
        } else if (R.id.rotEncrypt == btnId) {
            Intent i = new Intent(this, MainActivity4.class);
            i.putExtra("input", str);
            startActivity(i);
        } else if (R.id.rotDecrypt == btnId) {
            Intent i = new Intent(this, MainActivity5.class);
            i.putExtra("input", str);
            startActivity(i);

        }


    }


}
