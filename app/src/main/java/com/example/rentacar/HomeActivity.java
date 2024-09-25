package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rentacar.model.GlobalVariables;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    private TextView fromDateText, toDateText;
    private Spinner pickupPlaceSpinner;
    private Button choosePeriodButton, searchButton;
    private ImageButton reservationsButton, profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fromDateText = findViewById(R.id.fromDateText);
        toDateText = findViewById(R.id.toDateText);
        choosePeriodButton = findViewById(R.id.choosePeriodButton);
        searchButton = findViewById(R.id.searchButton);
        pickupPlaceSpinner = findViewById(R.id.pickupPlaceSpinner);
        reservationsButton = findViewById(R.id.reservationsButton);
        profileButton = findViewById(R.id.profileButton);

        // Setting up the drop-down menu for pickup places
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pickup_locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickupPlaceSpinner.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromDateText.getText().toString().isEmpty() || toDateText.getText().toString().isEmpty()) {
                    Toast.makeText(HomeActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                GlobalVariables.pickupLocation = pickupPlaceSpinner.getSelectedItem().toString();
                Intent intent = new Intent(HomeActivity.this, SearchResultsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Date Range Picker using MaterialDatePicker
        choosePeriodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateRangePicker();
            }
        });

        // Navigation button actions
        reservationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ReservationsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void showDateRangePicker() {
        // Configure constraints (e.g., no past dates)
        CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
        constraintsBuilder.setValidator(DateValidatorPointForward.now());

        // Build a MaterialDatePicker for a range
        MaterialDatePicker.Builder<androidx.core.util.Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Select rental period");
        builder.setCalendarConstraints(constraintsBuilder.build());

        final MaterialDatePicker<?> picker = builder.build();
        picker.show(getSupportFragmentManager(), picker.toString());

        // Handle positive button click to get selected dates
        picker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Object>() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                // The selection contains both dates
                Pair<Long, Long> selectedDates = (Pair<Long, Long>) selection;

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                GlobalVariables.startAt = Instant.ofEpochMilli(selectedDates.first).atZone(ZoneId.systemDefault()).toLocalDate();;
                GlobalVariables.returnAt = Instant.ofEpochMilli(selectedDates.second).atZone(ZoneId.systemDefault()).toLocalDate();;
                // Convert the timestamp into human-readable date format
                String fromDate = sdf.format(selectedDates.first);
                String toDate = sdf.format(selectedDates.second);

                fromDateText.setText(fromDate);
                toDateText.setText(toDate);
            }
        });
    }
}
