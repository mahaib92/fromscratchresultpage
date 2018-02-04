package com.example.mahaalbarrak.fromscratch;


import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.view.View;
        import android.widget.Button;


public class StartActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendPage();
            }
        });
    }
    public void sendPage()
    {
        Intent intent = new Intent(this, GameSetup.class);
        startActivity(intent);
    }
}
