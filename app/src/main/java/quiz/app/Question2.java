package quiz.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlinx.coroutines.Delay;

public class Question2 extends AppCompatActivity {
    Button Choice1, Choice2, Choice3, SubmitB;
    public void Choice1 (View view){
        choices = 1;
    }
    public void Choice2 (View view){
        choices = 2;
    }
    public void Choice3 (View view){
        choices = 3;
    }
    public void Submit (View view){
        if (choices == 2)
        {
            Choice2.setBackgroundColor(0xFFFF0000);
        }
        else if  (choices == 3)
        {
            Choice3.setBackgroundColor(0xFFFF0000);
        }
        else
        {
            Choice1.setBackgroundColor(0xFF00FF00);
            MainActivity.score++;
        }
        Intent newJump = new Intent(this, Question3.class);
        startActivity(newJump);
    }
    int choices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);

        Choice1 = findViewById(R.id.Choice1);
        Choice2 = findViewById(R.id.Choice2);
        Choice3 = findViewById(R.id.Choice3);;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}