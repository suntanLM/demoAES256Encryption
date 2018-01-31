package com.example.tanlm.aes_encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn_en);
        mButton.setOnClickListener(this);

    }

    public void encrypt() {
        try {
            CryptLib cryptLib = new CryptLib();
            String output = "";
            String plainText = "This is the text to be encrypted";
            String key = CryptLib.SHA256("duali@123", 32); //32 bytes = 256 bit
            String iv = CryptLib.SHA256("duali@123", 16); //16 bytes = 128 bit
            output = cryptLib.encrypt(plainText, key, iv); //encrypt
            Toast.makeText(this, "Encrypt = " + output, Toast.LENGTH_SHORT).show();
            Log.d("Encrypt", output);
            output = cryptLib.decrypt(output, key,iv); //decrypt
            Toast.makeText(this, "Decrypt = " + output, Toast.LENGTH_SHORT).show();
            Log.d("Decrypt", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        encrypt();
    }
}
