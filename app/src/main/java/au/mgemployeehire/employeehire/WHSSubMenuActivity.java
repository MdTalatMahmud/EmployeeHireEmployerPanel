package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WHSSubMenuActivity extends AppCompatActivity {

    private Button recordTemperatureButton,inductionButton, evaquationPlanButton, incidentReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_h_s_sub_menu);

        recordTemperatureButton = findViewById(R.id.recordTemperatureButtonID);
        inductionButton = findViewById(R.id.inductionButtonID);
        evaquationPlanButton = findViewById(R.id.evaquationPlanButtonID);
        incidentReportButton = findViewById(R.id.incidentReportButtonID);

        recordTemperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        inductionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        evaquationPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        incidentReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}