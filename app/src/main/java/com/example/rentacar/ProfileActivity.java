package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.Customer;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;
import com.example.rentacar.model.Reservation;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        // Bottom navigation bar
        ImageButton btnReservation = findViewById(R.id.reservationsButton);
        ImageButton btnHome = findViewById(R.id.homeButton);
        ImageButton btnProfile = findViewById(R.id.profileButton);

        // Load user data and reserved cars
        Customer user = GlobalVariables.activeUser;
        List<Car> reservedCars = InternalDataBase.getReservedCars(user);

        // Display user information and reserved cars in the UI
        TextView firstNameTextView = findViewById(R.id.tvFirstName);
        TextView lastNameTextView = findViewById(R.id.tvLastName);
        TextView profileTypeTextView = findViewById(R.id.tvProfileType);
        TextView emailTextView = findViewById(R.id.tvEmail);
        TextView totalReservationsTextView = findViewById(R.id.tvTotalReservations);
        TextView spentTextView = findViewById(R.id.tvSpent);
        TextView pointsTextView = findViewById(R.id.tvPoints);


        firstNameTextView.setText(user.getFirstName());
        lastNameTextView.setText(user.getLastName());
        profileTypeTextView.setText(user.getUserType().toString());
        emailTextView.setText(user.getUsername());
        totalReservationsTextView.setText("" + reservedCars.size());
        BigDecimal totalSpent = reservedCars.stream().map(Car::getPricePerDay).reduce(BigDecimal.ZERO, BigDecimal::add);
        spentTextView.setText(totalSpent.toString());
        pointsTextView.setText(reservedCars.isEmpty() ? "0" : totalSpent.divide(BigDecimal.valueOf(reservedCars.size())).toString());
        // Navigate to Reservations
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ReservationsActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Profile
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}

