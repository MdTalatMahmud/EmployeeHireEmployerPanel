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

    private TextView fromDateTV, toDateTV, jobPositionTV, jobDescriptionTV, companyNameTV ,streetTV, suburbTV, stateTV, nameOfThePersonTV, phoneTV, ppeTV, transportRequirementsTV,
            engRequirementTV, liftingCapacityTV, additionalRequirementTV, licenseRequiredTV, environmentTV;

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

        //getting job position
//        Bundle warehouseCB = getIntent().getExtras();
//        if (warehouseCB!=null){
//            String warehouseValue = warehouseCB.getString("jobPost");
//            jobPositionTV.setText(warehouseValue);
//        }

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

        //getting suburb
        Bundle suburb = getIntent().getExtras();
        if (suburb!=null){
            String suburbValue = suburb.getString("suburb");
            suburbTV.setText(suburbValue);
        }

        //getting street
        Bundle street = getIntent().getExtras();
        if (street!=null){
            String streetValue = street.getString("street");
            streetTV.setText(streetValue);
        }

        //getting state
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

        Bundle ppe = getIntent().getExtras();
        if (ppe!=null){
            String ppeValue = ppe.getString("ppeReq");
            ppeTV.setText(ppeValue);
        }

        Bundle additionalRequirement = getIntent().getExtras();
        if (additionalRequirement!=null){
            String additionalReqValue = additionalRequirement.getString("additionalReq");
            additionalRequirementTV.setText(additionalReqValue);
        }

        Bundle jobPosit = getIntent().getExtras();
        if (jobPosit!=null){
            String jobPositValue = jobPosit.getString("jobPostition");
            jobPositionTV.setText(jobPositValue);
        }

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
        String nameOfThePersonStr = nameOfThePersonTV.getText().toString().trim();
        String phoneStr = phoneTV.getText().toString().trim();
        String ppeStr = ppeTV.getText().toString().trim();
        String transportRequirementsStr = transportRequirementsTV.getText().toString().trim();
        String engRequirementStr = engRequirementTV.getText().toString().trim();
        String liftingCapacityStr = liftingCapacityTV.getText().toString().trim();
        String additionalRequirementStr = additionalRequirementTV.getText().toString().trim();
        String licenseRequiredStr = licenseRequiredTV.getText().toString().trim();
        String environmentStr = environmentTV.getText().toString().trim();

        //key generate
        String key = databaseReference.push().getKey();

        JobAdvertisementData jobAdvertisement = new JobAdvertisementData(fromDateStr, toDateStr, jobPositionStr, jobDescriptionStr, companyNameStr, streetStr,
                suburbStr, stateStr, nameOfThePersonStr, phoneStr, ppeStr, transportRequirementsStr, engRequirementStr,
                liftingCapacityStr, additionalRequirementStr,licenseRequiredStr,environmentStr);

        //sending job advertisement data to database
        databaseReference.child(key).setValue(jobAdvertisement);
        Toast.makeText(getApplicationContext(), "Your job advertisement has been posted",Toast.LENGTH_LONG).show();
    }
}