package com.example.whatsappshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.File;
import java.io.FileOutputStream;

public class imageschat extends AppCompatActivity {

    private ImageView fullImage;
    private Button btShare;

    private int reqcode = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageschat);

        fullImage = findViewById(R.id.fullImage);
        btShare = findViewById(R.id.btShare);

        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable=fullImage.getDrawable();
                Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), File.separator +"donut.png");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG, reqcode, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID +".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/png");

                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



//    public void btShare (View view){
//        Uri imgUri = Uri.parse(pictureFile.getAbsolutePath());
//        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//        whatsappIntent.setType("text/plain");
//        whatsappIntent.setPackage("com.whatsapp");
//        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
//        whatsappIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
//        whatsappIntent.setType("image/jpeg");
//        whatsappIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//        try {
//            activity.startActivity(whatsappIntent);
//        } catch (android.content.ActivityNotFoundException ex) {
//            ToastHelper.MakeShortText("Whatsapp have not been installed.");
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.share_option,menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case  R.id.share:
//
//                BitmapDrawable drawable = (BitmapDrawable) fullImage.getDrawable();
//                Bitmap bitmap = drawable.getBitmap();
//
//                String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"title",null);
//
//                Uri uri = Uri.parse(bitmapPath);
//
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("img/png");
//                intent.putExtra(Intent.EXTRA_STREAM,uri);
//                intent.putExtra(Intent.EXTRA_TEXT,"Play Store Link :https://play.google.com/store/apps/details?id=" + getPackageName());
//                startActivity(Intent.createChooser(intent,"Share"));
//
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


}