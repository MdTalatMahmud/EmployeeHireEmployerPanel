package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormFillUpActivity2 extends AppCompatActivity {

    private Button back, nextPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up2);

        back = findViewById(R.id.backBtn2ID);
        nextPageButton = findViewById(R.id.nextPageBtn2ID);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity2.this, FormFillUpActivity.class);
                startActivity(intent);
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity2.this, FormFillUpActivity3.class);
                startActivity(intent);
            }
        });
    }
}