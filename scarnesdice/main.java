package com.example.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;

import java.util.Random;
//import java.util.logging.Handler;

public class main extends AppCompatActivity {
    public static int userOverallScore = 0;
    public static int userTurnScore= 0;
    public static int computerOverallScore = 0;
    public static int computerTurnScore = 0;
    Handler timerHandler = new android.os.Handler();
    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            TextView text = (TextView) findViewById(R.id.textView2);  //textView2 : computer score
            if(computerTurn() == true) {
                if(computerTurnScore < 20) {
                     timerHandler.postDelayed(this,500);
                }
                else {
                    computerOverallScore += computerTurnScore;
                    enableButtons(true);
                    computerTurnScore = 0;
                }
            }
            else {
                computerTurnScore = 0;
                enableButtons(true);
            }
            text.setText("" + computerOverallScore);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rollDie(View view) {
        int diceValue = randomNum();
        setDiceFace(diceValue);
        if(diceValue != 1)
            userTurnScore += diceValue;
        else {
            enableButtons(false);
            userTurnScore = 0;
            timerHandler.postDelayed(timerRunnable, 1000);
        }
    }//ROLLDIE

    public void enableButtons(boolean value) {
        Button roll = (Button)findViewById(R.id.button3);
        Button hold = (Button)findViewById(R.id.button2);
        Button reset = (Button)findViewById(R.id.button);
        roll.setEnabled(value);
        hold.setEnabled(value);
        reset.setEnabled(value);

    }//ENABLEBUTTONS

    public int randomNum() {
        Random rand = new Random();
        int value;
        value = rand.nextInt(6) + 1;
        return value;
    }//RANDOMNUM

    public boolean computerTurn(){
        int diceValue = randomNum();
        setDiceFace(diceValue);
        if(diceValue != 1) {
            computerTurnScore += diceValue;
            return true;
        }
        else {
            computerTurnScore = 0;
            return false;
        }
    }//COMPUTERTURN

    public void setDiceFace(int diceValue) {
        ImageView v = (ImageView)findViewById(R.id.imageView);
        switch (diceValue) {
            case 1: v.setImageResource(R.drawable.dice1);
                break;
            case 2: v.setImageResource(R.drawable.dice2);
                break;
            case 3: v.setImageResource(R.drawable.dice3);
                break;
            case 4: v.setImageResource(R.drawable.dice4);
                break;
            case 5: v.setImageResource(R.drawable.dice5);
                break;
            case 6: v.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void holdDie(View view) {
        enableButtons(false);
        TextView text = (TextView)findViewById(R.id.textView);  //textView : your score
        userOverallScore += userTurnScore;
        userTurnScore = 0;
        text.setText("" +userOverallScore);
        timerHandler.postDelayed(timerRunnable, 0);
    }//HOLDDIE

    public void resetDie(View view) {
        TextView userText = (TextView)findViewById(R.id.textView);
        TextView computerText = (TextView)findViewById(R.id.textView2);
        userOverallScore = 0;
        userTurnScore = 0;
        computerOverallScore = 0;
        computerTurnScore = 0;
        userText.setText("" + userOverallScore);
        computerText.setText("" + computerOverallScore);
    }
}

