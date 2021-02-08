package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubmissionSummeryActivity extends AppCompatActivity {

    private Button backButton, confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_summery);

        backButton = findViewById(R.id.backSubmissionPageBtnID);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmissionSummeryActivity.this, FormFillUpActivity4.class);
                startActivity(intent);
            }
        });

        confirmButton = findViewById(R.id.finalizingBtnID);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubmissionSummeryActivity.this, FinalizeMessageActivity.class);
                startActivity(intent);
                Toast toast=Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}