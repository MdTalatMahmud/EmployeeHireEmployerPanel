package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmissionSummeryActivity extends AppCompatActivity{

    private TextView fromDateTV, toDateTV, jobPositionTV, jobTypeTV, jobDescriptionTV, companyNameTV ,streetTV,
            suburbTV, stateTV, nameOfThePersonTV, phoneTV, ppeTV, transportRequirementsTV,
            engRequirementTV, liftingCapacityTV, additionalRequirementTV, licenseRequiredTV, environmentTV, emailTV,
            supervisorMobileNumberTV, yourNameTV, workSiteStreetTV, workSiteSuburbTV,
            workSiteStateTV, workerQuantityTV, workingDivisionTV, startTimeTV, endTimeTV ;//26 variables

    private Button confirmButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_summery);

        databaseReference = FirebaseDatabase.getInstance().getReference("JobAdvertisementInfo");

        //finding id
        fromDateTV = findViewById(R.id.fromDateTVID);
        toDateTV = findViewById(R.id.toDateTVID);
        jobPositionTV = findViewById(R.id.jobPositionTVID);
        jobTypeTV = findViewById(R.id.jobTypeInfoTVID);
        jobDescriptionTV = findViewById(R.id.jobDescriptionTVID);
        companyNameTV = findViewById(R.id.companyNameTVID);
        streetTV = findViewById(R.id.streetTVID);
        suburbTV = findViewById(R.id.suburbTVID);
        stateTV = findViewById(R.id.stateTVID);
        nameOfThePersonTV = findViewById(R.id.nameOfThePersonTVID);
        phoneTV = findViewById(R.id.phoneTVID);
        ppeTV = findViewById(R.id.ppeTVID);
        transportRequirementsTV = findViewById(R.id.transportRequirementsTVID);
        engRequirementTV = findViewById(R.id.engRequirementTVID);
        liftingCapacityTV = findViewById(R.id.liftingCapacityTVID);
        additionalRequirementTV = findViewById(R.id.additionalRequirementTVID);
        licenseRequiredTV = findViewById(R.id.licenseRequiredTVID);
        environmentTV = findViewById(R.id.temparatureTVID);
        confirmButton = findViewById(R.id.confirmBtnID);
        emailTV = findViewById(R.id.emailTVID);
        supervisorMobileNumberTV = findViewById(R.id.managerMobileNumberTVID);
        yourNameTV = findViewById(R.id.yourNameTVID);
        workSiteStreetTV = findViewById(R.id.workSiteStreetTVID);
        workSiteSuburbTV = findViewById(R.id.workSiteSuburbTVID);
        workSiteStateTV = findViewById(R.id.workSiteStateTVID);
        workerQuantityTV = findViewById(R.id.workerQuantityTVID);
        workingDivisionTV = findViewById(R.id.divisionTVID);
        startTimeTV = findViewById(R.id.startTimeTVID);
        endTimeTV = findViewById(R.id.endTimeTVID);

        //getting the values
        //getting from date
        Bundle fromDate = getIntent().getExtras();
        if (fromDate!=null){
            //putting vales in the strings & setText
            String fromDatevalue = fromDate.getString("fromDate");
            fromDateTV.setText(fromDatevalue);
        }

        //getting to date
        Bundle toDate = getIntent().getExtras();
        if (toDate!=null){
            String toDatevalue = toDate.getString("toDate");
            toDateTV.setText(toDatevalue);
        }

        //getting job description
        Bundle jobDes = getIntent().getExtras();
        if (jobDes!=null){
            String jobDesValue = jobDes.getString("jobDesStr");
            jobDescriptionTV.setText(jobDesValue);
        }

        //getting company name
        Bundle companyName = getIntent().getExtras();
        if (companyName!=null){
            String companyNameValue = companyName.getString("companyName");
            companyNameTV.setText(companyNameValue);
        }

        //getting company suburb
        Bundle suburb = getIntent().getExtras();
        if (suburb!=null){
            String suburbValue = suburb.getString("suburb");
            suburbTV.setText(suburbValue);
        }

        //getting company street
        Bundle street = getIntent().getExtras();
        if (street!=null){
            String streetValue = street.getString("street");
            streetTV.setText(streetValue);
        }

        //getting company state
        Bundle state = getIntent().getExtras();
        if (state!=null){
            String stateValue = state.getString("state");
            stateTV.setText(stateValue);
        }

        //getting state
        Bundle nameOfPerson = getIntent().getExtras();
        if (nameOfPerson!=null){
            String nameOfPersonValue = nameOfPerson.getString("nameOfPerson");
            nameOfThePersonTV.setText(nameOfPersonValue);
        }

        //getting state
        Bundle phone = getIntent().getExtras();
        if (phone!=null){
            String phoneValue = phone.getString("phone");
            phoneTV.setText(phoneValue);
        }

        //getting transport info
        Bundle transport = getIntent().getExtras();
        if (transport!=null){
            String transportValue = transport.getString("transportRequirement");
            transportRequirementsTV.setText(transportValue);
        }

        //getting english requirement info
        Bundle englishRequirement = getIntent().getExtras();
        if (englishRequirement!=null){
            String englishRequirementValue = englishRequirement.getString("englishRequirement");
            engRequirementTV.setText(englishRequirementValue);
        }

        //getting weight lifting requirement info
        Bundle weightLift = getIntent().getExtras();
        if (weightLift!=null){
            String weightLiftingRequirementValue = weightLift.getString("weightLifting");
            liftingCapacityTV.setText(weightLiftingRequirementValue);
        }

        //getting environment info
        Bundle env = getIntent().getExtras();
        if (env!=null){
            String environmentValue = env.getString("environment");
            environmentTV.setText(environmentValue);
        }

        //license requirements info getting
        Bundle license = getIntent().getExtras();
        if (license!=null){
            String licenseValue = license.getString("licenseReq");
            licenseRequiredTV.setText(licenseValue);
        }

        //ppe requirements info getting
        Bundle ppe = getIntent().getExtras();
        if (ppe!=null){
            String ppeValue = ppe.getString("ppeReq");
            ppeTV.setText(ppeValue);
        }

        //additional requirements info getting
        Bundle additionalRequirement = getIntent().getExtras();
        if (additionalRequirement!=null){
            String additionalReqValue = additionalRequirement.getString("additionalReq");
            additionalRequirementTV.setText(additionalReqValue);
        }

        //job position info getting
        Bundle jobPosit = getIntent().getExtras();
        if (jobPosit!=null){
            String jobPositValue = jobPosit.getString("jobPostition");
            jobPositionTV.setText(jobPositValue);
        }

        //job type info getting
        Bundle jobType = getIntent().getExtras();
        if (jobType!=null){
            String jobTypeValue = jobType.getString("jobType");
            jobTypeTV.setText(jobTypeValue);
        }

        //email getting
        Bundle email = getIntent().getExtras();
        if (email!=null){
            String emailValue = email.getString("email");
            emailTV.setText(emailValue);
        }

        //supervisor/site manager mobile number
        Bundle supervisorMobileNo = getIntent().getExtras();
        if (supervisorMobileNo!=null){
            String supervisorMobileNumberValue = supervisorMobileNo.getString("managerMobileNumber");
            supervisorMobileNumberTV.setText(supervisorMobileNumberValue);
        }

        //your name getting
        Bundle yourName = getIntent().getExtras();
        if (yourName!=null){
            String yourNameStr = yourName.getString("yourName");
            yourNameTV.setText(yourNameStr);
        }

        //work site location
        //work site suburb
        Bundle worksiteSuburb = getIntent().getExtras();
        if (worksiteSuburb!=null){
            String worksiteSuburbStr = worksiteSuburb.getString("workSiteSuburb");
            workSiteSuburbTV.setText(worksiteSuburbStr);
        }

        //work site street
        Bundle worksiteStreet = getIntent().getExtras();
        if (worksiteStreet!=null){
            String worksiteStreetStr = worksiteStreet.getString("workSiteStreet");
            workSiteStreetTV.setText(worksiteStreetStr);
        }

        //work site
        Bundle workSiteState = getIntent().getExtras();
        if (workSiteState!=null){
            String workSiteStateStr = workSiteState.getString("workSiteState");
            workSiteStateTV.setText(workSiteStateStr);
        }

        //worker quantity
        Bundle workerQuantity = getIntent().getExtras();
        if (workerQuantity!=null){
            String workerQuantityStr = workerQuantity.getString("workerQuantity");
            workerQuantityTV.setText(workerQuantityStr);
        }

        //working division
        Bundle workingDivision = getIntent().getExtras();
        if (workingDivision!=null){
            String workingDivisionStr = workingDivision.getString("workingDivision");
            workingDivisionTV.setText(workingDivisionStr);
        }

        //start time getting
        Bundle startTime = getIntent().getExtras();
        if (startTime!=null){
            String startTimeStr = startTime.getString("startTime");
            startTimeTV.setText(startTimeStr);
        }

        //end time getting
        Bundle endTime = getIntent().getExtras();
        if (endTime!=null){
            String endTimeStr = endTime.getString("endTime");
            endTimeTV.setText(endTimeStr);
        }


        //functioning confirm button. Sending data to firebase Database
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToDatabase();
            }
        });

    }

    private void saveDataToDatabase() {
        String fromDateStr = fromDateTV.getText().toString().trim();
        String toDateStr = toDateTV.getText().toString().trim();
        String jobPositionStr = jobPositionTV.getText().toString().trim();
        String jobDescriptionStr = jobDescriptionTV.getText().toString().trim();
        String companyNameStr = companyNameTV.getText().toString().trim();
        String streetStr = streetTV.getText().toString().trim();
        String suburbStr = suburbTV.getText().toString().trim();
        String stateStr = stateTV.getText().toString().trim();
        String nameOfThePersonStr = nameOfThePersonTV.getText().toString().trim();//site manager name
        String phoneStr = phoneTV.getText().toString().trim();
        String ppeStr = ppeTV.getText().toString().trim();
        String transportRequirementsStr = transportRequirementsTV.getText().toString().trim();
        String engRequirementStr = engRequirementTV.getText().toString().trim();
        String liftingCapacityStr = liftingCapacityTV.getText().toString().trim();
        String additionalRequirementStr = additionalRequirementTV.getText().toString().trim();
        String licenseRequiredStr = licenseRequiredTV.getText().toString().trim();
        String environmentStr = environmentTV.getText().toString().trim();//temperature
        String jobTypeStr = jobTypeTV.getText().toString().trim();
        String emailStr = emailTV.getText().toString().trim();
        String yourNameStr = yourNameTV.getText().toString().trim();
        String supervisorMobileNumberStr = supervisorMobileNumberTV.getText().toString().trim();
        String workSiteStreetStr = workSiteStreetTV.getText().toString().trim();
        String workSiteSuburbStr = workSiteSuburbTV.getText().toString().trim();
        String workSiteStateStr = workSiteStateTV.getText().toString().trim();
        String workerQuantityStr = workerQuantityTV.getText().toString().trim();
        String workingDivisionStr = workingDivisionTV.getText().toString().trim();
        String startTimeStr = startTimeTV.getText().toString().trim();
        String endTimeStr = endTimeTV.getText().toString().trim();

        //key generate
        String key = databaseReference.push().getKey();

        JobAdvertisementData jobAdvertisement = new JobAdvertisementData(
                companyNameStr,
                streetStr,
                suburbStr,
                stateStr,
                yourNameStr,
                emailStr,
                phoneStr,
                nameOfThePersonStr,
                supervisorMobileNumberStr,
                workingDivisionStr,
                workSiteStreetStr,
                workSiteSuburbStr,
                workSiteStateStr,
                fromDateStr,
                toDateStr,
                startTimeStr,
                endTimeStr,
                jobPositionStr,
                workerQuantityStr,
                jobTypeStr,
                jobDescriptionStr,
                ppeStr,
                transportRequirementsStr,
                engRequirementStr,
                liftingCapacityStr,
                additionalRequirementStr,
                environmentStr,
                licenseRequiredStr
                );

        //sending job advertisement data to database
        databaseReference.child(key).setValue(jobAdvertisement);
        Toast.makeText(getApplicationContext(), "Your job advertisement has been posted",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(SubmissionSummeryActivity.this, FormFillUpActivity.class);
        startActivity(intent);
    }
}