package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class FormFillUpActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog, datePickerDialog2;
    private Button startDateButton, endDateButton;
    private Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up);

        nextPage = findViewById(R.id.nextPageBtnID);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity.this, FormFillUpActivity2.class);
                startActivity(intent);
            }
        });

        initStartDatePicker();
        initEndDatePicker();
        startDateButton = findViewById(R.id.startDatePickerBtnID);
        endDateButton = findViewById(R.id.endDatePickerBtnID);

        startDateButton.setText(getTodaysDate());
        endDateButton.setText(getTodaysDate());
    }

    private String getTodaysDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initStartDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                startDateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }
    private void initEndDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                endDateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog2 = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month){
        if (month==1){
            return "JAN";
        }
        if (month==2){
            return "FEB";
        }
        if (month==3){
            return "MAR";
        }
        if (month==4){
            return "APR";
        }
        if (month==5){
            return "MAY";
        }
        if (month==6){
            return "JUN";
        }
        if (month==7){
            return "JUL";
        }
        if (month==8){
            return "AUG";
        }
        if (month==9){
            return "SEP";
        }
        if (month==10){
            return "OCT";
        }
        if (month==11){
            return "NOV";
        }
        if (month==12){
            return "DEC";
        }
        //default
        return "JAN";
    }

    public void openDatePicker(View view){
        datePickerDialog.show();
    }
    public void openDatePicker2(View view){
        datePickerDialog2.show();
    }

}