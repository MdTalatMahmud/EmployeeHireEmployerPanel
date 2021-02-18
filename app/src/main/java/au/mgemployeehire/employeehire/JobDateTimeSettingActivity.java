package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class JobDateTimeSettingActivity extends AppCompatActivity {

    private TextView startTime,endTime,fromDate,endDate;
    private DatePickerDialog.OnDateSetListener setListener, setListener2;
    private Button nextButton, backButton;
    private TextView jobPositionTextView,maleFemaleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_date_time_setting);

        jobPositionTextView = findViewById(R.id.jobPositionTextViewID);
        maleFemaleTextView = findViewById(R.id.maleFemaleTextViewID);

        nextButton = findViewById(R.id.JobJobDateTimeNextBtnID);
        backButton = findViewById(R.id.backJobDateTimePageBtnID);

        //time table setup
        startTime = findViewById(R.id.startTimeSelectID);
        endTime = findViewById(R.id.endTimeSelectID);

        //startTime TextView functioning
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialogStartTime = new TimePickerDialog(
                        JobDateTimeSettingActivity.this,
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
                        JobDateTimeSettingActivity.this,
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
                        JobDateTimeSettingActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
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
                        JobDateTimeSettingActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
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


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobDateTimeSettingActivity.this, FormFillUpActivity.class);
                //code goes here
                //sending jobPosition
                String jobPosStr = jobPositionTextView.getText().toString();
                intent.putExtra("jobPosition", jobPosStr);

                //sending male/female
                String maleFemaleStr = maleFemaleTextView.getText().toString();
                intent.putExtra("maleFemale",maleFemaleStr);

                //sending date and time
                String from_date = (String) fromDate.getText();
                String to_date = (String) endDate.getText();

                //passing data
                //from date & to date
                intent.putExtra("fromDate", from_date);
                intent.putExtra("toDate", to_date);

                //time table passing
                String startTimeStr = startTime.getText().toString();
                intent.putExtra("startTime",startTimeStr);

                String endTimeStr = endTime.getText().toString();
                intent.putExtra("endTime",endTimeStr);

                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JobDateTimeSettingActivity.super.onBackPressed();
            }
        });

    }
}