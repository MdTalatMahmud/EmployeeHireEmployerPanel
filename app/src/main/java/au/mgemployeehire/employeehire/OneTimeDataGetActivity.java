package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class OneTimeDataGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_data_get);

        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        String FirstTime = preferences.getString("FirstTime","");

        if (FirstTime.equals("Yes")){
            Intent intent = new Intent(OneTimeDataGetActivity.this, MaleFemaleActivity.class);
            startActivity(intent);
        }else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("FirstTime", "Yes");
            editor.apply();
        }



    }
}