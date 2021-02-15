package au.mgemployeehire.employeehire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
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

import com.google.firebase.auth.FirebaseAuth;

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

    //quantity of staff
    private EditText warehouseQuantityEditText,pickPackerQuantityEditText,cleanerQuantityEditText,processWorkerQuantityEditText,generalLabourQuantityEditText,forkliftDriverQuantityEditText,otherQuantityEditText;

    //job position
    private CheckBox warehouseCheckBox, pickPackercheckBox, cleanerCheckBox, processWorkerCheckBox, generalLabourCheckBox, forkliftDriverCheckBox, otherCheckBox; //job position CheckBox
    private CheckBox whiteCard, truckLicense, forkliftLicense, naLicense; //License requirements CheckBox
    private CheckBox safetyShoes, normalCaveShoes, goggles, safetyHelmet, antiCuttingGloves, boots; //PPE requirements CheckBox
    private CheckBox palletJacket, rfScanner, soundPicking, pickPacking; //additional requirements CheckBox

    private TextView licenseRequirements;
    private TextView ppeRequirements;
    private TextView additionalRequirements;
    private TextView jobPosition;

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
        suburb = findViewById(R.id.suburbETID);
        street = findViewById(R.id.streetETID);
        state = findViewById(R.id.stateETID);
        nameOfThePersonToMeet = findViewById(R.id.nameOfThePersonETID);
        phone = findViewById(R.id.phoneETID);

        //quantity EditText id finding
        warehouseQuantityEditText = findViewById(R.id.warehouseQuantity);
        pickPackerQuantityEditText = findViewById(R.id.pickPackerQuantity);
        cleanerQuantityEditText = findViewById(R.id.cleanerQuantity);
        processWorkerQuantityEditText = findViewById(R.id.processWorkerQuantity);
        generalLabourQuantityEditText = findViewById(R.id.generalLabourQuantity);
        forkliftDriverQuantityEditText = findViewById(R.id.forkliftDriverQuantity);
        otherQuantityEditText = findViewById(R.id.otherQuantity);

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
        jobPosition = findViewById(R.id.jobPositionTVID);

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


        //additional CheckBox id finding
        palletJacket = findViewById(R.id.palletJacketID);
        rfScanner = findViewById(R.id.rfScannerID);
        soundPicking = findViewById(R.id.soundPickingID);
        pickPacking = findViewById(R.id.pickPackingID);

        //job position checkBox id finding
        warehouseCheckBox = findViewById(R.id.warehouseCheckBoxID);
        pickPackercheckBox = findViewById(R.id.pickPackercheckBoxID);
        cleanerCheckBox = findViewById(R.id.cleanerCheckBoxID);
        processWorkerCheckBox = findViewById(R.id.processWorkerCheckBoxID);
        generalLabourCheckBox = findViewById(R.id.generalLabourCheckBoxID);
        forkliftDriverCheckBox = findViewById(R.id.forkliftDriverCheckBoxID);
        otherCheckBox = findViewById(R.id.otherCheckBoxID);

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

        //job position requirement
        warehouseCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (warehouseCheckBox.isChecked()){
                    warehouseCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    warehouseCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        pickPackercheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pickPackercheckBox.isChecked()){
                    pickPackercheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    pickPackercheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        cleanerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cleanerCheckBox.isChecked()){
                    cleanerCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    cleanerCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        processWorkerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (processWorkerCheckBox.isChecked()){
                    processWorkerCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    processWorkerCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        generalLabourCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (generalLabourCheckBox.isChecked()){
                    generalLabourCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    generalLabourCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        forkliftDriverCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (forkliftDriverCheckBox.isChecked()){
                    forkliftDriverCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    forkliftDriverCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        otherCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otherCheckBox.isChecked()){
                    otherCheckBox.setTextColor(getResources().getColor(R.color.teal_200));
                }else {
                    otherCheckBox.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });

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

                //job position data collect
                String jobPositionString = "";
                if (warehouseCheckBox.isChecked()){
                    jobPositionString += "\n Warehouse";
                }
                if (pickPackercheckBox.isChecked()){
                    jobPositionString += "\n Pick Packer";
                }
                if (cleanerCheckBox.isChecked()){
                    jobPositionString += "\n Cleaner";
                }
                if (processWorkerCheckBox.isChecked()){
                    jobPositionString += "\n Process Worker";
                }
                if (generalLabourCheckBox.isChecked()){
                    jobPositionString += "\n General Labour";
                }
                if (forkliftDriverCheckBox.isChecked()){
                    jobPositionString += "\n Forklift Driver";
                }
                if (otherCheckBox.isChecked()){
                    jobPositionString += "\n Others";
                }
                jobPosition.setText(jobPositionString);

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

                //license requirements data collect
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

                //passing job position
                String jobPositionStr = jobPosition.getText().toString();
                intent.putExtra("jobPostition",jobPositionStr);

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

//    public void checkOne(View view){
//        if (warehouseCheckBox.isChecked()){
//            testTextView.setText("Warehouse worker");
//        }else if (pickPackercheckBox.isChecked()){
//            testTextView.setText("Pick Packer");
//        }else if (cleanerCheckBox.isChecked()){
//            testTextView.setText("Cleaner");
//        }else if (processWorkerCheckBox.isChecked()){
//            testTextView.setText("Process Worker");
//        }else if (generalLabourCheckBox.isChecked()){
//            testTextView.setText("General Labour");
//        }else if (forkliftDriverCheckBox.isChecked()){
//            testTextView.setText("Forklift Driver");
//        }else if (otherCheckBox.isChecked()){
//            testTextView.setText("Others");
//        }else {
//            testTextView.setText("");
//        }
//    }

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

    //menu adding
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.userSignOutMenuID){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}