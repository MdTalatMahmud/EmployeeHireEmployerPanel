package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FinalizeMessageActivity extends AppCompatActivity {

    private Button backToHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_message);

        backToHomeButton = findViewById(R.id.backToHomeBtnID);
        backToHomeButton.setOnClickListener(v -> {
            Intent intent = new Intent(FinalizeMessageActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}