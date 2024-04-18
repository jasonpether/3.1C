package quiz.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static int score;
    public static double scorepercentage;
    SharedPreferences sharedPreferences;
    EditText InputName;
    String UserName;
    public void StartClick(View view){
        Intent secondjump = new Intent(this, Question1.class);
        startActivity(secondjump);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(UserName, InputName.getText().toString());
        editor.apply();
    }

    public void InitialiseName()
    {
        String previoususer = sharedPreferences.getString(UserName,"");
        InputName.setText(previoususer);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("quiz.app;", MODE_PRIVATE);
        InputName = findViewById(R.id.InputName);
        InitialiseName();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}