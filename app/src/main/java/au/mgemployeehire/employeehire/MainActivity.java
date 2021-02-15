package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button INeedStaffButton, chatButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        INeedStaffButton = findViewById(R.id.iNeedStaffBtnId);
        chatButton = findViewById(R.id.chatWithHRBtnID);

        INeedStaffButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormFillUpActivity.class);
            startActivity(intent);
        });

        chatButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });

    }
}