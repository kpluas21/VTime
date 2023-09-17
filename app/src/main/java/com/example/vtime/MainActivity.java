package com.example.vtime;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vtime.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView new_date_result;
    EditText num_of_days_edit;
    Button submit_button;
    DatePicker date_picker;
    androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.vtime.databinding.ActivityMainBinding binding =
                ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);



        date_picker = findViewById(R.id.date_picker);
        new_date_result = findViewById(R.id.new_date_result);
        num_of_days_edit = findViewById(R.id.number_input);
        submit_button = findViewById(R.id.submit_button);

        submit_button.setOnClickListener(
                view -> calculateDate()
        );
    }


    private void calculateDate() {
        if(TextUtils.isEmpty(num_of_days_edit.getText())) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d("Debug text: ", String.valueOf(date_picker.getDayOfMonth()));

        Calendar calendar = Calendar.getInstance();
        calendar.set(
                date_picker.getYear(),
                date_picker.getMonth(),
                date_picker.getDayOfMonth());
        calendar.add(Calendar.DAY_OF_MONTH,
                Integer.parseInt(num_of_days_edit.getText().toString()));
        Date new_date = calendar.getTime();
        new_date_result.setText(new_date.toString());

    }
}