package com.example.vtime;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vtime.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    CalendarView calendar_view;
    TextView new_date_result;
    EditText num_of_days_edit;
    Button submit_button;
    DatePicker date_picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        date_picker = (DatePicker) findViewById(R.id.date_picker);
        new_date_result = (TextView) findViewById(R.id.new_date_result);
        num_of_days_edit = (EditText) findViewById(R.id.number_input);
        submit_button = (Button) findViewById(R.id.submit_button);

        submit_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        calculateDate();
                    }
                }
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