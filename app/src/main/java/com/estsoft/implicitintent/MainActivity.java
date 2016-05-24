package com.estsoft.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String ACTION_SHARED_ACTIVITY = "com.estsoft.android.action.SHARE_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button callButton = (Button)findViewById(R.id.callButton);
        callButton.setOnClickListener(this);

        Button addressbookButton = (Button)findViewById(R.id.addressbookButton);
        addressbookButton.setOnClickListener(this);

        Button webButton = (Button)findViewById(R.id.webButton);
        webButton.setOnClickListener(this);

        Button sharedActivityButton = (Button)findViewById(R.id.sharedActivityButton);
        sharedActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.callButton){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-5442-4488"));
            startActivity(intent);
        } else if(v.getId() == R.id.addressbookButton) {
            Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/data/phones"));
            startActivity(intent);
        } else if(v.getId() == R.id.webButton){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.estsoft.com"));
            startActivity(intent);
        } else if(v.getId() == R.id.sharedActivityButton){
            Intent intent = new Intent(ACTION_SHARED_ACTIVITY);
            startActivity(intent);
        }
    }
}
