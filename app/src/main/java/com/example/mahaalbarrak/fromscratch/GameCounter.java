package com.example.mahaalbarrak.fromscratch;

import android.content.Intent;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.ProcessingInstruction;

public class GameCounter extends AppCompatActivity {

    int aPlayer = 0;
    int mScoreT1P1 = 0;
    int mScoreT1P2 = 0;
   int mScoreT2P1 = 0;
   int mScoreT2P2 = 0;
  public static int mScoreT1;
   int mScoreT2 = 0;

    // Variable for keeping track of ball type: 1: adds points 2: "subtracts" (foul balls)
    int mBallType = 0;
    private TextView displayteam1player1;
    private TextView displayteam1player2;
    private TextView displayteam2player1;
    private TextView displayteam2player2;
    private ImageView activeT1P1;
    private ImageView activeT1P2;
    private ImageView activeT2P1;
    private ImageView activeT2P2;
    private TextView textViewT1P1Score;
    private TextView textViewT1P2Score;
    private TextView textViewT2P1Score;
    private TextView textViewT2P2Score;
    private TextView textViewT1Score;
    private TextView textViewT2Score;
    private Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);

        activeT1P1 = (ImageView) findViewById(R.id.activet1p1);
        activeT2P1 = (ImageView) findViewById(R.id.activet2p1);

        activeT1P2 = (ImageView) findViewById(R.id.activet1p2);
        activeT2P2 = (ImageView) findViewById(R.id.activet2p2);

        textViewT1P1Score = (TextView) findViewById(R.id.t1p1score);
        textViewT2P1Score = (TextView) findViewById(R.id.t2p1score);

        textViewT1P2Score = (TextView) findViewById(R.id.t1p2score);
        textViewT2P2Score = (TextView) findViewById(R.id.t2p2score);

        textViewT1Score = (TextView) findViewById(R.id.team1score);
        textViewT2Score = (TextView) findViewById(R.id.team2score);







        displayteam1player1 = findViewById(R.id.t1player1name);
        displayteam1player2 = findViewById(R.id.t1player2name);
        displayteam2player1 = findViewById(R.id.t2player1name);
        displayteam2player2 = findViewById(R.id.t2player2name);
        Intent intent2 = getIntent();
        Bundle b = intent2.getExtras();
        if (b != null)
        {
            String p1 = (String) b.get("team1player1");
            String p2 = (String) b.get("team1player2");
            String p3 = (String) b.get("team2player1");
            String p4 = (String) b.get("team2player2");

            displayteam1player1.setText(p1);
            displayteam1player2.setText(p2);
            displayteam2player1.setText(p3);
            displayteam2player2.setText(p4);

        }

        intent2.putExtra("displayteam1player1", displayteam1player1.getText().toString());
        intent2.putExtra("displayteam1player2", displayteam1player2.getText().toString());
        intent2.putExtra("displayteam2player1", displayteam2player1.getText().toString());
        intent2.putExtra("displayteam2player2", displayteam2player2.getText().toString());


    }


    public void nextPlayer(View view) {
        if (aPlayer == 1) {
            activeT1P1.setVisibility(View.INVISIBLE);
            activeT2P1.setVisibility(View.VISIBLE);
            activeT1P2.setVisibility(View.INVISIBLE);
            activeT2P2.setVisibility(View.INVISIBLE);
            aPlayer = 2;
           // showToast(displayteam1player1 + ("'s turn"));
        } else
            if (aPlayer == 2){


                activeT2P1.setVisibility(View.INVISIBLE);
                activeT1P1.setVisibility(View.INVISIBLE);
                activeT1P2.setVisibility(View.VISIBLE);
                activeT2P2.setVisibility(View.INVISIBLE);
            aPlayer = 3;
          //  showToast (displayteam2player1 + ("'s turn"))

        } else
            if (aPlayer == 3){

                activeT2P1.setVisibility(View.INVISIBLE);
                activeT1P1.setVisibility(View.INVISIBLE);
                activeT1P2.setVisibility(View.INVISIBLE);
                activeT2P2.setVisibility(View.VISIBLE);
                aPlayer = 4;
            }
    else
        {

            activeT2P1.setVisibility(View.INVISIBLE);
            activeT1P1.setVisibility(View.VISIBLE);
            activeT1P2.setVisibility(View.INVISIBLE);
            activeT2P2.setVisibility(View.INVISIBLE);
            aPlayer = 1;
        }
    }
public void red1point (View view) {
        mBallType = 1;
        if (aPlayer == 1) {
            mScoreT1P1 = mScoreT1P1 + 1;
            displayScoreT1P1(mScoreT1P1);
            mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
            displayScoreT1(mScoreT1);

        }
        if (aPlayer == 2){
            mScoreT2P1 = mScoreT2P1 + 1;
            displayScoreT2P1(mScoreT2P1);
            mScoreT2 = mScoreT2P1+ mScoreT2P2;
            displayScoreT2(mScoreT2);
        }
        if (aPlayer == 3){
            mScoreT1P2 = mScoreT1P2 + 1;
            displayScoreT1P2(mScoreT1P2);
            mScoreT1 = mScoreT1P2 + mScoreT1P1;
            displayScoreT1(mScoreT1);
        }
        if (aPlayer == 4){
            mScoreT2P2 = mScoreT2P2 + 1;
            displayScoreT2P2(mScoreT2P2);
            mScoreT2 = mScoreT2P1 + mScoreT2P2;
            displayScoreT2(mScoreT2);
        }

}


public void yellow2point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 2;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 2;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 2;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P2 + mScoreT1P1;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 2;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}

public void green3point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 3;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 3;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 3;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);
    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 3;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}

public void brown4point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 4;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 4;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 4;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);
    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 4;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}

public void blue5point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 5;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 5;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 5;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);
    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 5;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}
public void pink6point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 6;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 6;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 6;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);
    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 6;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}

public void black7point (View view){
    mBallType = 1;
    if (aPlayer == 1) {
        mScoreT1P1 = mScoreT1P1 + 7;
        displayScoreT1P1(mScoreT1P1);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);

    }
    if (aPlayer == 2){
        mScoreT2P1 = mScoreT2P1 + 7;
        displayScoreT2P1(mScoreT2P1);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 3){
        mScoreT1P2 = mScoreT1P2 + 7;
        displayScoreT1P2(mScoreT1P2);
        mScoreT1 = mScoreT1P1+ mScoreT1P2 ;
        displayScoreT1(mScoreT1);
    }
    if (aPlayer == 4){
        mScoreT2P2 = mScoreT2P2 + 7;
        displayScoreT2P2(mScoreT2P2);
        mScoreT2 = mScoreT2P1+ mScoreT2P2;
        displayScoreT2(mScoreT2);
    }
}
public void foul4point (View view){

    if (aPlayer == 1){

        mScoreT2 = mScoreT2-4;
        displayScoreT2(mScoreT2);
    }
    if (aPlayer == 2){
        mScoreT1 = mScoreT1-4;
        displayScoreT1(mScoreT1);
    }

    if (aPlayer == 3){
        mScoreT2 = mScoreT2-4;
        displayScoreT2(mScoreT2);
    }

    if (aPlayer == 4){

        mScoreT1 = mScoreT1-4;
        displayScoreT1(mScoreT1);

    }
}


public void displayScoreT1P1(int number){
    textViewT1P1Score.setText("" + number);
}

public void displayScoreT2P1(int number){
    textViewT2P1Score.setText(""+ number);
}

public void displayScoreT1P2(int number) { textViewT1P2Score.setText(""+ number);}

public void displayScoreT2P2(int number) { textViewT2P2Score.setText(""+ number);}

public void displayScoreT1 ( int number) { textViewT1Score.setText(""+ number);}

   public void displayScoreT2 (int number) { textViewT2Score.setText(""+ number);}

   public void sendResultPage(View view){

     setContentView(R.layout.activity_game_results);
     if ( mScoreT1 > mScoreT2)
     {
         TextView textViewWinner = (TextView) findViewById(R.id.winnerteam);

         textViewWinner.setText(" Team 1 is the winner");

         if ((mScoreT1P1 > mScoreT1P2) && (mScoreT1P1 > mScoreT2P1) && (mScoreT1P1 > mScoreT2P2))
         {


            TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
           Intent c = getIntent();

            String displayteam1player1 = c.getStringExtra("displayteam1player1");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam1player1 );

         }

         else if ( (mScoreT1P2 > mScoreT1P1) && (mScoreT1P2 > mScoreT2P1 ) && (mScoreT1P2 > mScoreT2P2))
         {
             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
             Intent c = getIntent();

           String displayteam1player2 = c.getStringExtra("displayteam1player2");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam1player2 );
         }

         else if ( (mScoreT2P1 > mScoreT1P1) && (mScoreT2P1> mScoreT1P2) && (mScoreT2P1 > mScoreT2P2)){

             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
            Intent c = getIntent();

            String displayteam2player1 = c.getStringExtra("displayteam2player1");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam2player1 );
         }
         else if ((mScoreT2P2 > mScoreT1P1)&& (mScoreT2P2>mScoreT1P2) && (mScoreT2P2> mScoreT2P1))
         {

             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
            Intent c = getIntent();

           String displayteam2player2 = c.getStringExtra("displayteam2player2");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam2player2 );
         }

     }
     else {
         TextView textViewWinner = (TextView) findViewById(R.id.winnerteam);

         textViewWinner.setText(" Team 2 is the winner");
         if ((mScoreT1P1 > mScoreT1P2) && (mScoreT1P1 > mScoreT2P1) && (mScoreT1P1 > mScoreT2P2))
         {


             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
             Intent c = getIntent();

             String displayteam1player1 = c.getStringExtra("displayteam1player1");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam1player1 );

         }

         else if ( (mScoreT1P2 > mScoreT1P1) && (mScoreT1P2 > mScoreT2P1 ) && (mScoreT1P2 > mScoreT2P2))
         {
             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
             Intent c = getIntent();

             String displayteam1player2 = c.getStringExtra("displayteam1player2");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam1player2 );
         }

         else if ( (mScoreT2P1 > mScoreT1P1) && (mScoreT2P1> mScoreT1P2) && (mScoreT2P1 > mScoreT2P2)){

             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
             Intent c = getIntent();

             String displayteam2player1 = c.getStringExtra("displayteam2player1");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam2player1 );
         }
         else if ((mScoreT2P2 > mScoreT1P1)&& (mScoreT2P2>mScoreT1P2) && (mScoreT2P2> mScoreT2P1))
         {

             TextView textViewHighestScore = (TextView) findViewById(R.id.highestscore);
             Intent c = getIntent();

             String displayteam2player2 = c.getStringExtra("displayteam2player2");

             textViewHighestScore.setText(" The one who achieved the highest score is:" + displayteam2player2 );
         }



     }


   }
}
