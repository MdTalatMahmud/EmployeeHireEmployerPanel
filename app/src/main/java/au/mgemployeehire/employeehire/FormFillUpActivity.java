package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Stack;

public class FormFillUpActivity extends AppCompatActivity {

    private Button nextPage;
    private TextView fromDate, endDate;
    DatePickerDialog.OnDateSetListener setListener, setListener2;
    EditText jobDescription, companyName, suburb, street, state, nameOfThePersonToMeet;

    //job position
    private CheckBox warehouseCheckBox, pickPackercheckBox, cleanerCheckBox, processWorkerCheckBox, generalLabourCheckBox, forkliftDriverCheckBox, otherCheckBox;

    //private String warehouseStr="Warehouse",pickPackerStr="Pick Packer",CleanerStr="Cleaner";
    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up);

        //finding id
        testTextView=findViewById(R.id.testTVID);
        companyName = findViewById(R.id.yourCompanyNameETID);
        suburb = findViewById(R.id.suburbETID);
        street = findViewById(R.id.streetETID);
        state = findViewById(R.id.stateETID);
        nameOfThePersonToMeet = findViewById(R.id.nameOfThePersonETID);

        //Date TextView Functioning
        fromDate = findViewById(R.id.fromDateID);
        endDate = findViewById(R.id.endDateID);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        FormFillUpActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                fromDate.setText(date);
            }
        };

        Calendar calendar2 = Calendar.getInstance();
        final int year2 = calendar.get(Calendar.YEAR);
        final int month2 = calendar.get(Calendar.MONTH);
        final int day2 = calendar.get(Calendar.DAY_OF_MONTH);

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        FormFillUpActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener2, year2, month2, day2);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                endDate.setText(date);
            }
        };

        //position check box id finding
        warehouseCheckBox = findViewById(R.id.warehouseCheckBoxID);
        pickPackercheckBox = findViewById(R.id.pickPackercheckBoxID);
        cleanerCheckBox = findViewById(R.id.cleanerCheckBoxID);
        processWorkerCheckBox = findViewById(R.id.processWorkerCheckBoxID);
        generalLabourCheckBox = findViewById(R.id.generalLabourCheckBoxID);
        forkliftDriverCheckBox = findViewById(R.id.forkliftDriverCheckBoxID);
        otherCheckBox = findViewById(R.id.otherCheckBoxID);

        jobDescription = findViewById(R.id.jobDescriptionEDID);

        //jobPositionArrayList = new ArrayList<>();

        //ok button functioning
        nextPage = findViewById(R.id.nextPageBtnID);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity.this, SubmissionSummeryActivity.class);
                //putting the values to the Strings
                String from_date = (String) fromDate.getText();
                String to_date = (String) endDate.getText();

                //passing data
                //from date & to date
                intent.putExtra("fromDate", from_date);
                intent.putExtra("toDate", to_date);

                //job post passing
                String jobPostStr = testTextView.getText().toString();
                intent.putExtra("jobPost", jobPostStr);

                //job description
                String jobDesStr = jobDescription.getText().toString();
                intent.putExtra("jobDesStr", jobDesStr);

                //company name
                String companyNameStr = companyName.getText().toString();
                intent.putExtra("companyName",companyNameStr);

                //suburb
                String suburbStr = suburb.getText().toString();
                intent.putExtra("suburb", suburbStr);

                //street
                String streetStr = street.getText().toString();
                intent.putExtra("street", streetStr);

                //state
                String stateStr = state.getText().toString();
                intent.putExtra("state", stateStr);

                String nameOfPersonStr = nameOfThePersonToMeet.getText().toString();
                intent.putExtra("nameOfPerson", nameOfPersonStr);

                startActivity(intent);
            }
        });

    }

    public void checkOne(View view){
        if (warehouseCheckBox.isChecked()){
            testTextView.setText("Warehouse worker");
        }else if (pickPackercheckBox.isChecked()){
            testTextView.setText("Pick Packer");
        }else if (cleanerCheckBox.isChecked()){
            testTextView.setText("Cleaner");
        }else if (processWorkerCheckBox.isChecked()){
            testTextView.setText("Process Worker");
        }else if (generalLabourCheckBox.isChecked()){
            testTextView.setText("General Labour");
        }else if (forkliftDriverCheckBox.isChecked()){
            testTextView.setText("Forklift Driver");
        }else if (otherCheckBox.isChecked()){
            testTextView.setText("Others");
        }else {
            testTextView.setText("");
        }
    }

}