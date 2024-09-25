package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.InternalDataBase;
import com.example.rentacar.model.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        recyclerView = findViewById(R.id.reservedCarsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        homeButton = findViewById(R.id.btnHome);

        // Load user data and reserved cars
        String firstName = "John";
        String lastName = "Doe";
        List<Car> reservedCars = getReservedCars(); // Implement a method to fetch reserved cars

        // Display user information and reserved cars in the UI
         TextView firstNameTextView = findViewById(R.id.tvFirstName);
         firstNameTextView.setText(InternalDataBase.getCustomer().getFirstName());
        TextView lastNameTextView = findViewById(R.id.tvLastName);
        lastNameTextView.setText(InternalDataBase.getCustomer().getLastName());

        // Create and set an adapter for the ListView to display reserved cars
        CarListAdapter adapter = new CarListAdapter(reservedCars);
        recyclerView.setAdapter(adapter);

        homeButton.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
        });
    }

    private List<Car> getReservedCars() {
        return InternalDataBase.getCustomer().getReservations()
                .stream()
                .map(Reservation::getCar)
                .collect(Collectors.toList());
    }
}

