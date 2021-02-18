package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MaleFemaleActivity extends AppCompatActivity {

    private Button nextButton, backButton;
    private RadioGroup maleFemaleRadioGroup;
    private RadioButton maleFemaleRadioButton;
    private TextView maleFemaleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_female);

        maleFemaleTextView = findViewById(R.id.maleFemaleTVID);

        nextButton = findViewById(R.id.maleFemaleNextBtnID);
        backButton = findViewById(R.id.backMaleFemalePageBtnID);

        maleFemaleRadioGroup = findViewById(R.id.maleFemaleRadioGroup);



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MaleFemaleActivity.this, JobPositionSelectionActivity.class);

                try{
                    //environment
                    int maleFemale = maleFemaleRadioGroup.getCheckedRadioButtonId();
                    maleFemaleRadioButton = findViewById(maleFemale);
                    maleFemaleTextView.setText(maleFemaleRadioButton.getText());
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Please, select one",Toast.LENGTH_LONG).show();
                }
                //phone no
                String maleFemaleStr = maleFemaleTextView.getText().toString();
                intent.putExtra("maleFemale", maleFemaleStr);

                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaleFemaleActivity.super.onBackPressed();
            }
        });
    }

    public void checkMaleFemale(View view){
        int maleFemale = maleFemaleRadioGroup.getCheckedRadioButtonId();
        maleFemaleRadioButton = findViewById(maleFemale);
    }
}