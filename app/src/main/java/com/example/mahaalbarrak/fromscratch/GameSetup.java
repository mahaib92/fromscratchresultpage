package com.example.mahaalbarrak.fromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class GameSetup extends AppCompatActivity {

    private Button button;
    private EditText team1player1;
    private EditText team1player2;
    private EditText team2player1;
    private EditText team2player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPage();
            }
        });
      team1player1 = findViewById(R.id.team1player1);
      team1player2 = findViewById(R.id.team1player2);
      team2player1 = findViewById(R.id.team2player1);
      team2player2 = findViewById(R.id.team2player2);
    }
    public void sendPage()
    {
        Intent intent = new Intent(this, GameCounter.class);
        intent.putExtra("team1player1", team1player1.getText().toString());
        intent.putExtra("team1player2", team1player2.getText().toString());
        intent.putExtra("team2player1", team2player1.getText().toString());
        intent.putExtra("team2player2", team2player2.getText().toString());
        startActivity(intent);
    }
}
