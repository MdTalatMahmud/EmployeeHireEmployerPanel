package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowMyStaffSubMenuActivity extends AppCompatActivity {

    private Button staffNameButton, lateNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_staff_sub_menu);

        staffNameButton = findViewById(R.id.staffNameButtonID);
        lateNoteButton = findViewById(R.id.lateNoteButtonID);

        staffNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lateNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}