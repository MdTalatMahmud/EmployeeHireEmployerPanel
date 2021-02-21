package au.mgemployeehire.employeehire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Stack;
import java.util.TimeZone;

public class FormFillUpActivity extends AppCompatActivity {

    private Button nextPage, backButton;
    private TextView fromDate, endDate, startTime, endTime;
    DatePickerDialog.OnDateSetListener setListener, setListener2;
    EditText jobDescription, companyName, suburb, street, state, nameOfThePersonToMeet, phone;
    private RadioButton radioButtonJobPosition,radioButtonjobType,radioButtonTransport, radioButtonEnglishRequirement, radioButtonWeightLifting, radioButtonEnvironment;
    private RadioGroup jobPositionRadioGroup,radioGroupJobType,radioGroupTransport, radioGroupEnglishRequirement, radioGroupWeightLifting, radioGroupEnvironment;

    //quantity of staff
    private EditText awardEditText,yourNameEditText, yourEmailEditText, supervisorMobileNoEditText, workSiteSuburbEditText, workSiteStreetEditText, workSiteStateEditText, workerQuantityEditText, divisionEditText;

    private CheckBox whiteCard, truckLicense, forkliftLicense, naLicense; //License requirements CheckBox
    private CheckBox safetyShoes, normalCaveShoes, goggles, safetyHelmet, antiCuttingGloves, boots; //PPE requirements CheckBox
    private CheckBox palletJacket, rfScanner, soundPicking, pickPacking; //additional requirements CheckBox
    private CheckBox fluentEnglishCheckBox, basicEnglishCheckBox, understandingEnglishCheckBox, readWritingEnglishCheckBox, naEnglishCheckBox;

    private TextView licenseRequirements;
    private TextView ppeRequirements;
    private TextView additionalRequirements;
    private TextView jobPosition, jobType;
    private TextView male_FemaleTV, job_PositionTV, fromDateTV, toDateTV, startTimeTV, endTimeTV;
    String maleFemaleString="nothing";


    //private String warehouseStr="Warehouse",pickPackerStr="Pick Packer",CleanerStr="Cleaner";
    private TextView testTextView, transportTextView, engReqTextView, weightLiftingTextView, environmentTextView;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up);

        mAuth = FirebaseAuth.getInstance();

        //finding id
        testTextView=findViewById(R.id.testTVID);
        companyName = findViewById(R.id.yourCompanyNameETID);
        suburb = findViewById(R.id.suburbETID);//company suburb
        street = findViewById(R.id.streetETID);//company street
        state = findViewById(R.id.stateETID);//company state
        nameOfThePersonToMeet = findViewById(R.id.nameOfThePersonETID);
        phone = findViewById(R.id.phoneETID);
        yourEmailEditText = findViewById(R.id.yourEmailETID);
        supervisorMobileNoEditText = findViewById(R.id.managerPhoneNoETID);
        yourNameEditText = findViewById(R.id.yourNameETID);
        workSiteSuburbEditText = findViewById(R.id.workSiteSuburbETID);
        workSiteStreetEditText = findViewById(R.id.workSiteStreetETID);
        workSiteStateEditText = findViewById(R.id.workSiteStateETID);
        workerQuantityEditText = findViewById(R.id.workerQuantityETID);
        divisionEditText = findViewById(R.id.divisionETID);
        awardEditText = findViewById(R.id.awardETID);
        male_FemaleTV = findViewById(R.id.male_FemaleTVID);
        job_PositionTV = findViewById(R.id.job_PositionTVID);
        fromDateTV = findViewById(R.id.fromDate_TVID);
        toDateTV = findViewById(R.id.toDate_TVID);
        startTimeTV = findViewById(R.id.startTime_TVID);
        endTimeTV = findViewById(R.id.endTime_TVID);

        //male/female
        Bundle maleFemaleBundle = getIntent().getExtras();
        if (maleFemaleBundle!=null){
            String maleFemaleStr = maleFemaleBundle.getString("maleFemale");
            male_FemaleTV.setText(maleFemaleStr);
        }

        //job position data getting
        Bundle jobPositionBundle = getIntent().getExtras();
        if (jobPositionBundle!=null){
            String jobPosStr = jobPositionBundle.getString("jobPosition");
            job_PositionTV.setText(jobPosStr);
        }

        //date getting
        Bundle fromDateBundle = getIntent().getExtras();
        if (fromDateBundle!=null){
            String fd = fromDateBundle.getString("fromDate");
            fromDateTV.setText(fd);
        }
        Bundle toDateBundle = getIntent().getExtras();
        if (toDateBundle!=null){
            String td = toDateBundle.getString("toDate");
            toDateTV.setText(td);
        }
        Bundle startTimeBundle = getIntent().getExtras();
        if (startTimeBundle!=null){
            String st = startTimeBundle.getString("startTime");
            startTimeTV.setText(st);
        }
        Bundle endTimeBundle = getIntent().getExtras();
        if (endTimeBundle!=null){
            String et = endTimeBundle.getString("endTime");
            endTimeTV.setText(et);
        }

        //radio groups id finding
        jobPositionRadioGroup = findViewById(R.id.jobPositionRadioGroup);
        jobPosition = findViewById(R.id.jobPositionTVID);

        radioGroupJobType = findViewById(R.id.jobTypeRadioGroup);
        jobType = findViewById(R.id.jobTypeTVID);

        radioGroupTransport = findViewById(R.id.transportRadioGroup);
        transportTextView = findViewById(R.id.transportTVID);

        radioGroupEnglishRequirement = findViewById(R.id.englishRequirementRadioGroup);
        engReqTextView = findViewById(R.id.engRequTVID);

        radioGroupWeightLifting = findViewById(R.id.liftingCapacityRadioGroup);
        weightLiftingTextView = findViewById(R.id.weightLiftingTVID);

        radioGroupEnvironment = findViewById(R.id.environmentRadioGroup);
        environmentTextView = findViewById(R.id.environmentTVID);

        licenseRequirements = findViewById(R.id.licenseTVID);
        ppeRequirements = findViewById(R.id.ppeTVID);
        additionalRequirements = findViewById(R.id.additionalRequirementTVID);

        //time table setup
        startTime = findViewById(R.id.startTimeSelectID);
        endTime = findViewById(R.id.endTimeSelectID);

        //startTime TextView functioning
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialogStartTime = new TimePickerDialog(
                        FormFillUpActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);
                                calendar.setTimeZone(TimeZone.getDefault());
                                SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
                                String time = format.format(calendar.getTime());
                                startTime.setText(time);
                            }
                        },12,0,false);
                        timePickerDialogStartTime.show();
//                );
            }
        });

        //endTime TextView Functioning
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialogStartTime = new TimePickerDialog(
                        FormFillUpActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);
                                calendar.setTimeZone(TimeZone.getDefault());
                                SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
                                String time = format.format(calendar.getTime());
                                endTime.setText(time);
                            }
                        },12,0,false);
                timePickerDialogStartTime.show();
//                );
            }
        });


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

        //english requirement check box
        fluentEnglishCheckBox = findViewById(R.id.fluentEngCheckBoxID);
        basicEnglishCheckBox = findViewById(R.id.basicEngCheckBoxID);
        understandingEnglishCheckBox = findViewById(R.id.understandingEngCheckBoxID);
        readWritingEnglishCheckBox = findViewById(R.id.readingWritingEngCheckBoxID);
        naEnglishCheckBox = findViewById(R.id.naEngCheckBoxID);

        //additional CheckBox id finding
        palletJacket = findViewById(R.id.palletJacketID);
        rfScanner = findViewById(R.id.rfScannerID);
        soundPicking = findViewById(R.id.soundPickingID);
        pickPacking = findViewById(R.id.pickPackingID);

        //License Requirements check box id find
        whiteCard = findViewById(R.id.whiteCardID);
        truckLicense = findViewById(R.id.truckLicenseID);
        forkliftLicense = findViewById(R.id.forkliftLicenseID);
        naLicense = findViewById(R.id.naLicenseID);

        //ppe requirements check box id find
        safetyShoes = findViewById(R.id.safetyShoesID);
        normalCaveShoes = findViewById(R.id.normalCaveShoesID);
        goggles = findViewById(R.id.gogglesID);
        safetyHelmet = findViewById(R.id.safetyHelmetID);
        antiCuttingGloves = findViewById(R.id.antiCuttingGlovesID);
        boots = findViewById(R.id.bootsID);

        //job description
        jobDescription = findViewById(R.id.jobDescriptionEDID);


        //Additional Requirement
        palletJacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (palletJacket.isChecked()){
                    palletJacket.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    palletJacket.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        rfScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rfScanner.isChecked()){
                    rfScanner.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    rfScanner.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        soundPicking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundPicking.isChecked()){
                    soundPicking.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    soundPicking.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        pickPacking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pickPacking.isChecked()){
                    pickPacking.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    pickPacking.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });


        //PPE requirements
        safetyShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (safetyShoes.isChecked()){
                    safetyShoes.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    safetyShoes.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        normalCaveShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (normalCaveShoes.isChecked()){
                    normalCaveShoes.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    normalCaveShoes.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        goggles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goggles.isChecked()){
                    goggles.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    goggles.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        safetyHelmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (safetyHelmet.isChecked()){
                    safetyHelmet.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    safetyHelmet.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        antiCuttingGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antiCuttingGloves.isChecked()){
                    antiCuttingGloves.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    antiCuttingGloves.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        boots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boots.isChecked()){
                    boots.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    boots.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });


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

        //back button functioning
        backButton = findViewById(R.id.backBtnID);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormFillUpActivity.super.onBackPressed();
            }
        });

        //ok button functioning...........................................................
        nextPage = findViewById(R.id.nextPageBtnID);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity.this, SubmissionSummeryActivity.class);
                //putting the values to the Strings
                String from_date = (String) fromDateTV.getText();
                String to_date = (String) toDateTV.getText();

                //passing data
                //from date & to date
                intent.putExtra("fromDate", from_date);
                intent.putExtra("toDate", to_date);

                try {
                    //job position
                    int radioID_jobPosition = jobPositionRadioGroup.getCheckedRadioButtonId();
                    radioButtonJobPosition = findViewById(radioID_jobPosition);
                    jobPosition.setText(radioButtonJobPosition.getText());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Select job position",Toast.LENGTH_LONG).show();
                }

                try {
                    //job type
                    int jobTypeRadioID = radioGroupJobType.getCheckedRadioButtonId();
                    radioButtonjobType = findViewById(jobTypeRadioID);
                    jobType.setText(radioButtonjobType.getText());
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Select Job Type",Toast.LENGTH_LONG).show();
                }

                try {
                    //transport
                    int radioId = radioGroupTransport.getCheckedRadioButtonId();
                    radioButtonTransport = findViewById(radioId);
                    transportTextView.setText(radioButtonTransport.getText());
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Select Transport",Toast.LENGTH_LONG).show();
                }


//                try {
//                    //english requirement
//                    int radioID_EngRequ = radioGroupEnglishRequirement.getCheckedRadioButtonId();
//                    radioButtonEnglishRequirement = findViewById(radioID_EngRequ);
//                    engReqTextView.setText(radioButtonEnglishRequirement.getText());
//                }catch (Exception e){
//                    Toast.makeText(getApplicationContext(), "Select English Requirement",Toast.LENGTH_LONG).show();
//                }

                try {
                    //weight lifting
                    int radioId_weightLifting = radioGroupWeightLifting.getCheckedRadioButtonId();
                    radioButtonWeightLifting = findViewById(radioId_weightLifting);
                    weightLiftingTextView.setText(radioButtonWeightLifting.getText());
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Select Lifting Capacity",Toast.LENGTH_LONG).show();
                }

                try{
                    //environment
                    int env = radioGroupEnvironment.getCheckedRadioButtonId();
                    radioButtonEnvironment = findViewById(env);
                    environmentTextView.setText(radioButtonEnvironment.getText());
                }catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "Select environment",Toast.LENGTH_LONG).show();
                }



                //additional requirement data collect
                String additionalRequirementsString = "";
                if (palletJacket.isChecked()){
                    additionalRequirementsString += "\n Pallet Jacket";
                }
                if (rfScanner.isChecked()){
                    additionalRequirementsString += "\n RF Scanner";
                }
                if (soundPicking.isChecked()){
                    additionalRequirementsString += "\n Sound Picking";
                }
                if (pickPacking.isChecked()){
                    additionalRequirementsString += "\n Pick Packing";
                }
                additionalRequirements.setText(additionalRequirementsString);

                //license requirements data collect..
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

                //english requirement
                String englishRequirementString = "";
                if (fluentEnglishCheckBox.isChecked()){
                    englishRequirementString += "\n Fluent";
                }
                if (basicEnglishCheckBox.isChecked()){
                    englishRequirementString += "\n Basic";
                }
                if (understandingEnglishCheckBox.isChecked()){
                    englishRequirementString += "\n Understanding";
                }
                if (readWritingEnglishCheckBox.isChecked()){
                    englishRequirementString += "\n Reading/Writing";
                }
                if (naEnglishCheckBox.isChecked()){
                    englishRequirementString += "\n N/A";
                }
                engReqTextView.setText(englishRequirementString);

                //ppe requirements data collect
                String ppeString = "";
                if (safetyShoes.isChecked()){
                    ppeString += "\n Safety Shoes";
                }
                if (normalCaveShoes.isChecked()){
                    ppeString += "\n Normal Cave Shoes";
                }
                if (goggles.isChecked()){
                    ppeString += "\n Goggles";
                }
                if (safetyHelmet.isChecked()){
                    ppeString += "\n Safety Helmet";
                }
                if (antiCuttingGloves.isChecked()){
                    ppeString += "\n Anti Cutting Gloves";
                }
                if (boots.isChecked()){
                    ppeString += "\n Boots";
                }
                ppeRequirements.setText(ppeString);

                //.............................................passing data
                //company AWARD passing data
                String awardStr = awardEditText.getText().toString();
                intent.putExtra("award",awardStr);

                //male/female
                String maleFemaleStr = male_FemaleTV.getText().toString();
                intent.putExtra("maleFemale",maleFemaleStr);

                //time table passing
                String startTimeStr = startTimeTV.getText().toString();
                intent.putExtra("startTime",startTimeStr);

                String endTimeStr = endTimeTV.getText().toString();
                intent.putExtra("endTime",endTimeStr);

                //working division
                String workingDivisionStr = divisionEditText.getText().toString();
                intent.putExtra("workingDivision", workingDivisionStr);

                //worker quantity
                String workerQuantityStr = workerQuantityEditText.getText().toString();
                intent.putExtra("workerQuantity", workerQuantityStr);

                //work site location passing
                //work site suburb
                String workSiteSuburbStr = workSiteSuburbEditText.getText().toString();
                intent.putExtra("workSiteSuburb",workSiteSuburbStr);
                //work site street
                String workSiteStreetStr = workSiteStreetEditText.getText().toString();
                intent.putExtra("workSiteStreet",workSiteStreetStr);
                //work site workSiteStateEditText
                String workSiteStateStr = workSiteStateEditText.getText().toString();
                intent.putExtra("workSiteState",workSiteStateStr);

                //your name passing
                String yourNameStr = yourNameEditText.getText().toString();
                intent.putExtra("yourName",yourNameStr);

                //manager mobile number passing
                String managerMobileNumberStr = supervisorMobileNoEditText.getText().toString();
                intent.putExtra("managerMobileNumber",managerMobileNumberStr);

                //your email passing
                String emailStr = yourEmailEditText.getText().toString();
                intent.putExtra("email",emailStr);

                //passing job position
                String jobPositionStr = job_PositionTV.getText().toString();
                intent.putExtra("jobPostition",jobPositionStr);

                //passing job type
                String jobTypeStr = jobType.getText().toString();
                intent.putExtra("jobType",jobTypeStr);

                //passing additional requirements
                String additionalReqStr = additionalRequirements.getText().toString();
                intent.putExtra("additionalReq",additionalReqStr);

                //passing License requirements
                String ppeReqStr = ppeRequirements.getText().toString();
                intent.putExtra("ppeReq",ppeReqStr);

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

    //job position radio group
    public void jobPosition(View view){
        int jobPositionRadioID = jobPositionRadioGroup.getCheckedRadioButtonId();
        radioButtonJobPosition = findViewById(jobPositionRadioID);
    }

    //job type
    public void jobType(View view){
        int jobTypeID = radioGroupJobType.getCheckedRadioButtonId();
        radioButtonjobType = findViewById(jobTypeID);
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

//    //menu adding
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_layout,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.userSignOutMenuID){
//            FirebaseAuth.getInstance().signOut();
//            finish();
//            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}