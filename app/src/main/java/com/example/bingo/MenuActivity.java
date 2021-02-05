package com.example.bingo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

public class MenuActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button btnPlay=(Button) findViewById(R.id.id_btnPlay);
        Button btnQuit=(Button) findViewById(R.id.id_btnQuit);
        Button btnRules=(Button) findViewById(R.id.id_btnRules);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, NumbersActivity.class);
                startActivity(i);
                finish();
            }
        });


        btnQuit.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to quit?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alert = builder.create();
                alert.show();
            }
        });

        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MenuActivity.this, RulesActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
