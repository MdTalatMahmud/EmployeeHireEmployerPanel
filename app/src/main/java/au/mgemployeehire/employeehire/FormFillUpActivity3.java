package au.mgemployeehire.employeehire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class FormFillUpActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button nextPage, backPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_fill_up3);

        backPage = findViewById(R.id.backBtn3ID);
        nextPage = findViewById(R.id.nextPageBtn3ID);

        backPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity3.this, FormFillUpActivity2.class);
                startActivity(intent);
            }
        });

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFillUpActivity3.this, FormFillUpActivity4.class);
                startActivity(intent);
            }
        });

        //spinner PPE requirements
        Spinner spinner = findViewById(R.id.ppeSpinnerID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.ppe_requirements, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}