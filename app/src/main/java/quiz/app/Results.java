package quiz.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Results extends AppCompatActivity {

    public TextView Result;
    Button Exit;

    public void SetText(){
        double scoreP = ((double) MainActivity.score /3) * 100;

        Result.setText(scoreP + " %");
    }

    public void Restart(View view){
        MainActivity.score = 0;
        Intent newJump = new Intent(this, MainActivity.class);
        startActivity(newJump);
    }

    public void exit(View view) {
        exit(null);
        System.exit(0);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);

        Result = findViewById(R.id.ResultText);
        SetText();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}