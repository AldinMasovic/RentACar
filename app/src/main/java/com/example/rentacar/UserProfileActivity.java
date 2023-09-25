package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;

import java.util.List;

public class UserProfileActivity extends AppCompatActivity {

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
        // TextView firstNameTextView = findViewById(R.id.tvFirstName);
        // firstNameTextView.setText(firstName);
        // ... (similarly, set last name and populate the ListView)

        // Create and set an adapter for the ListView to display reserved cars
        CarListAdapter adapter = new CarListAdapter(reservedCars);
        recyclerView.setAdapter(adapter);

        homeButton.setOnClickListener(v -> {
            startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
        });
    }

    private List<Car> getReservedCars() {
        // Implement code to fetch the list of cars reserved by the user
        // Return a list of Car objects representing reserved cars
        // For simplicity, here's a dummy data example:
        //TODO: it is reserved cars for user not all cars
        List<Car> reservedCars = InternalDataBase.getCarList();
//        reservedCars.add(new Car("Reserved Car 1", "Brand X", "Automatic", "$60", R.drawable.car3));
//        reservedCars.add(new Car("Reserved Car 2", "Brand Y", "Manual", "$55", R.drawable.car4));
        // Add more reserved cars as needed
        return reservedCars;
    }
}

