package android.example.com.sevens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newGame;
    Button help;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newGame=(Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent=new Intent(MainActivity.this,GameActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
