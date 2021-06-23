package com.example.whatsappshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.StrictMode;

import org.w3c.dom.Text;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {

    Button bttext ,btimages, btdocuments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //defining all the buttons
        bttext = findViewById(R.id.bt_text);
        btimages = findViewById(R.id.bt_images);
        btdocuments = findViewById(R.id.bt_documents);

        ActivityCompat.requestPermissions(this,new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

        //It will go to the send text page
        public void sendtext(View view){
            Intent gotoText = new Intent();
            gotoText.setClass(this,textchat.class);
            startActivity(gotoText);
        }

    //It will go to the send images page
    public void sendimages(View view){
        Intent gotoImages = new Intent();
        gotoImages.setClass(this,imageschat.class);
        startActivity(gotoImages);
    }

    //It will go to the send document page
    public void sendDocuments(View view){
        Intent gotoDocuments = new Intent();
        gotoDocuments.setClass(this,documentchat.class);
        startActivity(gotoDocuments);
    }


}