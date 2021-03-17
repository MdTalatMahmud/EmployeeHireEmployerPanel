package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExpressLabourSubMenuActivity extends AppCompatActivity {

    private Button iNeedStaffButton, listOfStaffButton, showRosterButton, chatWithHRButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_labour_sub_menu);

        iNeedStaffButton = findViewById(R.id.iNeedStaffButtonID);
        listOfStaffButton = findViewById(R.id.listOfStaffButtonID);
        showRosterButton = findViewById(R.id.showRosterButtonID);
        chatWithHRButton = findViewById(R.id.chatWithHRButtonID);

        iNeedStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpressLabourSubMenuActivity.this, MaleFemaleActivity.class);
                startActivity(intent);
            }
        });

        listOfStaffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });

        showRosterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });

        chatWithHRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
            }
        });
    }
}