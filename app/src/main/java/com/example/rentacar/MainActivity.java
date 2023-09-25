package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner pickupLocationSpinner;
    private Button pickupDateButton, returnDateButton, searchButton, myProfileButton;
    private EditText pickupDateEditText, returnDateEditText;
    private Calendar pickupDate, returnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickupLocationSpinner = findViewById(R.id.spinnerPickupLocation);
        pickupDateButton = findViewById(R.id.btnPickupDate);
        returnDateButton = findViewById(R.id.btnReturnDate);
        pickupDateEditText = findViewById(R.id.edtPickupDate);
        returnDateEditText = findViewById(R.id.edtReturnDate);

        pickupDate = Calendar.getInstance();
        returnDate = Calendar.getInstance();
        searchButton = findViewById(R.id.btnSearch);
        myProfileButton = findViewById(R.id.btnMyProfile);

//        // Initialize Calendar instances for pickup and return date/time
//        pickupDateTime = Calendar.getInstance();
//        returnDateTime = Calendar.getInstance();

        // Set up Pickup Location Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pickup_locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickupLocationSpinner.setAdapter(adapter);


        pickupLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedLocation = parentView.getItemAtPosition(position).toString();
                // Handle the selected location here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Handle when nothing is selected
            }
        });

        // Set up Pickup Date Button click listener
        pickupDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(pickupDate);
            }
        });

        // Set up Return Date Button click listener
        returnDateButton.setOnClickListener(v -> showDatePickerDialog(returnDate));

        // Handle Search Button click
        searchButton.setOnClickListener(v -> {
            if (pickupDate.after(returnDate)) {
                Toast.makeText(MainActivity.this, "Pickup date cannot be after return date.", Toast.LENGTH_SHORT).show();
            } else {
                // Perform a search based on the selected values
                String selectedLocation = pickupLocationSpinner.getSelectedItem().toString();
                String pickupDateStr = formatDate(pickupDate);
                String returnDateStr = formatDate(returnDate);

                // Handle search button click
                startActivity(new Intent(MainActivity.this, CarListActivity.class));
            }
        });

        myProfileButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, UserProfileActivity.class));
        });
    }

    private void showDatePickerDialog(final Calendar dateCalendar) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateCalendar.set(Calendar.YEAR, year);
                        dateCalendar.set(Calendar.MONTH, month);
                        dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        // Update the text in the adjacent EditText with the selected date
                        if (dateCalendar == pickupDate) {
                            pickupDateEditText.setText(formatDate(dateCalendar));
                        } else if (dateCalendar == returnDate) {
                            returnDateEditText.setText(formatDate(dateCalendar));
                        }
                    }
                },
                dateCalendar.get(Calendar.YEAR),
                dateCalendar.get(Calendar.MONTH),
                dateCalendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private String formatDate(Calendar dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return sdf.format(dateTime.getTime());
    }
}
