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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Stack;

public class FormFillUpActivity extends AppCompatActivity {

    private Button nextPage;
    private TextView fromDate, endDate;
    DatePickerDialog.OnDateSetListener setListener, setListener2;
    EditText jobDescription, companyName, suburb, street, state, nameOfThePersonToMeet, phone;
    private RadioButton radioButtonTransport, radioButtonEnglishRequirement, radioButtonWeightLifting, radioButtonEnvironment;
    private RadioGroup radioGroupTransport, radioGroupEnglishRequirement, radioGroupWeightLifting, radioGroupEnvironment;

    //job position
    private CheckBox warehouseCheckBox, pickPackercheckBox, cleanerCheckBox, processWorkerCheckBox, generalLabourCheckBox, forkliftDriverCheckBox, otherCheckBox;
    private CheckBox whiteCard, truckLicense, forkliftLicense, naLicense;
    private TextView licenseRequirements;

    //private String warehouseStr="Warehouse",pickPackerStr="Pick Packer",CleanerStr="Cleaner";
    private TextView testTextView, transportTextView, engReqTextView, weightLiftingTextView, environmentTextView;

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
        phone = findViewById(R.id.phoneETID);

        radioGroupTransport = findViewById(R.id.transportRadioGroup);
        transportTextView = findViewById(R.id.transportTVID);

        radioGroupEnglishRequirement = findViewById(R.id.englishRequirementRadioGroup);
        engReqTextView = findViewById(R.id.engRequTVID);

        radioGroupWeightLifting = findViewById(R.id.liftingCapacityRadioGroup);
        weightLiftingTextView = findViewById(R.id.weightLiftingTVID);

        radioGroupEnvironment = findViewById(R.id.environmentRadioGroup);
        environmentTextView = findViewById(R.id.environmentTVID);

        licenseRequirements = findViewById(R.id.licenseTVID);

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

        //License Requirements check box
        whiteCard = findViewById(R.id.whiteCardID);
        truckLicense = findViewById(R.id.truckLicenseID);
        forkliftLicense = findViewById(R.id.forkliftLicenseID);
        naLicense = findViewById(R.id.naLicenseID);

        jobDescription = findViewById(R.id.jobDescriptionEDID);

        //jobPositionArrayList = new ArrayList<>();

        //License requirements
        whiteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whiteCard.isChecked()){
                    whiteCard.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    whiteCard.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        truckLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (truckLicense.isChecked()){
                    truckLicense.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    truckLicense.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        forkliftLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (forkliftLicense.isChecked()){
                    forkliftLicense.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    forkliftLicense.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        naLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (naLicense.isChecked()){
                    naLicense.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    naLicense.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

        //ok button functioning...........................................................
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

                //transport
                int radioId = radioGroupTransport.getCheckedRadioButtonId();
                radioButtonTransport = findViewById(radioId);
                transportTextView.setText(radioButtonTransport.getText());

                //english requirement
                int radioID_EngRequ = radioGroupEnglishRequirement.getCheckedRadioButtonId();
                radioButtonEnglishRequirement = findViewById(radioID_EngRequ);
                engReqTextView.setText(radioButtonEnglishRequirement.getText());

                //weight lifting
                int radioId_weightLifting = radioGroupWeightLifting.getCheckedRadioButtonId();
                radioButtonWeightLifting = findViewById(radioId_weightLifting);
                weightLiftingTextView.setText(radioButtonWeightLifting.getText());

                //environment
                int env = radioGroupEnvironment.getCheckedRadioButtonId();
                radioButtonEnvironment = findViewById(env);
                environmentTextView.setText(radioButtonEnvironment.getText());

                //license requirements
                String licenseString = "";
                if (whiteCard.isChecked()){
                    licenseString += "\n White Card";
                }
                if (truckLicense.isChecked()){
                    licenseString += "\n Truck License";
                }
                if (forkliftLicense.isChecked()){
                    licenseString += "\n Forklift License";
                }
                if (naLicense.isChecked()){
                    licenseString += "\n N/A";
                }
                licenseRequirements.setText(licenseString);

                //passing License requirements
                String licenseReqStr = licenseRequirements.getText().toString();
                intent.putExtra("licenseReq",licenseReqStr);

                //weight lifting requirement passing
                String weightLiftingStr = weightLiftingTextView.getText().toString();
                intent.putExtra("weightLifting", weightLiftingStr);

                //english requirement passing
                String englishRequirementStr = engReqTextView.getText().toString();
                intent.putExtra("englishRequirement",englishRequirementStr);

                //transport requirement passing
                String transportRequirementStr = transportTextView.getText().toString();
                intent.putExtra("transportRequirement", transportRequirementStr);

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

                //name of the person
                String nameOfPersonStr = nameOfThePersonToMeet.getText().toString();
                intent.putExtra("nameOfPerson", nameOfPersonStr);

                //phone no
                String phoneStr = phone.getText().toString();
                intent.putExtra("phone", phoneStr);

                //environment requirement passing
                String environmentStr = environmentTextView.getText().toString();
                intent.putExtra("environment", environmentStr);

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

    //transport radio group
    public void checkTransport(View view){
        int radioId = radioGroupTransport.getCheckedRadioButtonId();
        radioButtonTransport = findViewById(radioId);
    }

    //english requirement radio group
    public void checkEnglishRequirement(View view){
        int radioID_EngRequ = radioGroupEnglishRequirement.getCheckedRadioButtonId();
        radioButtonEnglishRequirement = findViewById(radioID_EngRequ);
    }

    //lifting capacity radio group
    public void liftingCapacity(View view){
        int liftingCapacity = radioGroupWeightLifting.getCheckedRadioButtonId();
        radioButtonWeightLifting = findViewById(liftingCapacity);
    }

    //environment radio group
    public void environment(View view){
        int env = radioGroupEnvironment.getCheckedRadioButtonId();
        radioButtonEnvironment = findViewById(env);
    }

    //

}