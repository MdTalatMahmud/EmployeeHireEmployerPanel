package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormFillUpActivity4 extends AppCompatActivity {

    private Button backButton, confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up4);

        backButton = findViewById(R.id.backBtn4ID);
        confirmButton = findViewById(R.id.confirmBtn4ID);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity4.this, FormFillUpActivity3.class);
                startActivity(intent);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity4.this, SubmissionSummeryActivity.class);
                startActivity(intent);
            }
        });
    }
}