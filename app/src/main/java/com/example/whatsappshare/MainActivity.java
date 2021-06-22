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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button text ,images,documents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //defining all the buttons
        text = findViewById(R.id.bt_text);
        images = findViewById(R.id.bt_images);
        documents = findViewById(R.id.bt_documents);

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