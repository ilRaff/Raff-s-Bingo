package com.example.bingo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {

    public void InsericiNum(int[] n, Button bt1,Button bt2,Button bt3,Button bt4,Button bt5,Button bt6)
    {
        bt1.setText(n[0]+"");
        bt2.setText(n[1]+"");
        bt3.setText(n[2]+"");
        bt4.setText(n[3]+"");
        bt5.setText(n[4]+"");
        bt6.setText(n[5]+"");
    }

    public int Estrazione(ArrayList<Integer> nu)
    {
        boolean esci=false;
        Estrai e=new Estrai();
        int n;
        n=e.NumEstratto();
        do{
            if(nu.contains(n))
            {
                n=e.NumEstratto();
            }
            else{
                nu.add(n);
                usati++;
                esci=true;
            }
        }while(!esci);
        return n;
    }

    //------------------------------------------------------------------------------------------

    int tentativi=3,indovinati=0,usati=0;
    ArrayList<Integer> numUsati = new ArrayList<Integer>(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers_activity);

        Button btnNum1=(Button) findViewById(R.id.id_btnNum1);
        Button btnNum2=(Button) findViewById(R.id.id_btnNum2);
        Button btnNum3=(Button) findViewById(R.id.id_btnNum3);
        Button btnNum4=(Button) findViewById(R.id.id_btnNum4);
        Button btnNum5=(Button) findViewById(R.id.id_btnNum5);
        Button btnNum6=(Button) findViewById(R.id.id_btnNum6);



        TextView numeroEstratto=(TextView) findViewById(R.id.id_txtNumExt);
        TextView txtTentativi=(TextView) findViewById(R.id.id_txtTentativi);
        TextView txtTime=(TextView) findViewById(R.id.id_txtTime);

        Button btnSkip=(Button) findViewById(R.id.id_btnSkip2);

        //------------------------------------------------------------------------------------------

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("You have finished your attempts \n")
                .setNeutralButton("Try again...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(NumbersActivity.this,MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setCancelable(false);


        AlertDialog.Builder builder2=new AlertDialog.Builder(this);
        builder2.setMessage("All numbers are been extracted \n")
                .setNeutralButton("Try again...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(NumbersActivity.this,MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setCancelable(false);

        AlertDialog.Builder builder3=new AlertDialog.Builder(this);
        builder3.setMessage("Victory!!! \n")
                .setNeutralButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(NumbersActivity.this,MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setCancelable(false);

        AlertDialog.Builder builder4=new AlertDialog.Builder(this);
        builder4.setMessage("Time is over! \n")
                .setNeutralButton("Try again...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=new Intent(NumbersActivity.this,MenuActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setCancelable(false);

        //------------------------------------------------------------------------------------------

        CountDownTimer timer=new CountDownTimer(5000,1000) {
            AlertDialog alert;
            @Override
            public void onTick(long millisUntilFinished) {
                txtTime.setText(millisUntilFinished/1000+"");
            }
            @Override
            public void onFinish() {
                alert=builder4.create();
                alert.show();
            }
        }.start();


        for(int i=0;i<30;i++)
            numUsati.add(0);
        Estrai e=new Estrai();
        int[] numeri=e.SceltaNum();
        int n;

        InsericiNum(numeri,btnNum1,btnNum2,btnNum3,btnNum4,btnNum5,btnNum6);
        txtTentativi.setText(3+"");

        n=Estrazione(numUsati);
        numeroEstratto.setText(n+"");


        //------------------------------------------------------------------------------------------

        btnNum1.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum1.getText()))
                {
                    timer.cancel();
                    btnNum1.setBackgroundResource(R.drawable.check);
                    btnNum1.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30)
                    {
                        alert=builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnNum2.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum2.getText()))
                {
                    timer.cancel();
                    btnNum2.setBackgroundResource(R.drawable.check);
                    btnNum2.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30)
                    {
                        alert=builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnNum3.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum3.getText()))
                {
                    timer.cancel();
                    btnNum3.setBackgroundResource(R.drawable.check);
                    btnNum3.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30) {
                        alert = builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnNum4.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum4.getText()))
                {
                    timer.cancel();
                    btnNum4.setBackgroundResource(R.drawable.check);
                    btnNum4.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30)
                    {
                        alert=builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnNum5.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum5.getText()))
                {
                    timer.cancel();
                    btnNum5.setBackgroundResource(R.drawable.check);
                    btnNum5.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30)
                    {
                        alert=builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnNum6.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                if(numeroEstratto.getText().equals(btnNum6.getText()))
                {
                    timer.cancel();
                    btnNum6.setBackgroundResource(R.drawable.check);
                    btnNum6.setTextColor(Color.parseColor("#000000"));
                    indovinati++;
                    if(indovinati==6)
                    {
                        timer.cancel();
                        alert=builder3.create();
                        alert.show();
                    }
                    int n=Estrazione(numUsati);
                    if(usati==30)
                    {
                        alert=builder2.create();
                        alert.show();
                    }
                    else{
                    timer.start();
                    numeroEstratto.setText(n + "");}
                }
                else{
                    tentativi--;
                    txtTentativi.setText(tentativi+"");
                    if(tentativi==0)
                    {
                        timer.cancel();
                        alert=builder.create();
                        alert.show();
                    }
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            AlertDialog alert;
            @Override
            public void onClick(View v) {
                timer.cancel();
                int n=Estrazione(numUsati);
                if(usati==30 && indovinati!=6)
                {
                    alert=builder2.create();
                    alert.show();
                }
                else{
                timer.start();
                numeroEstratto.setText(n + "");}
            }
        });
    }
}
