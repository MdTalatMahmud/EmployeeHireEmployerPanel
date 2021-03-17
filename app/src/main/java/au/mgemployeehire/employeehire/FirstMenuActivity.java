package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstMenuActivity extends AppCompatActivity {

    private Button expressLabourBtn, showMyStaffBtn, whsBtn, expressAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_menu);

        expressLabourBtn = findViewById(R.id.expressLabourBtnID);
        showMyStaffBtn = findViewById(R.id.showMyStaffBtnID);
        whsBtn = findViewById(R.id.whsBtnID);
        expressAdminBtn = findViewById(R.id.expressAdminBtnID);

        expressLabourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressLabourSubMenuActivity.class);
                startActivity(intent);
            }
        });

        showMyStaffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ShowMyStaffSubMenuActivity.class);
                startActivity(intent);
            }
        });

        whsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, WHSSubMenuActivity.class);
                startActivity(intent);
            }
        });

        expressAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstMenuActivity.this, ExpressAdminSubMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}