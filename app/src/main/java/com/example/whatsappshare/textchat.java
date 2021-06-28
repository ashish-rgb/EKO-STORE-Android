package com.example.whatsappshare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;


public class textchat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textchat);


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    public void btShareText(View view){
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType(getString(R.string.text_type));
        intentShare.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.subject));
        intentShare.putExtra(Intent.EXTRA_TEXT,getString(R.string.message));

        startActivity(Intent.createChooser(intentShare, getString(R.string.success_msg)));
    }

}