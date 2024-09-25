package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;

import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservation);

        // Bottom navigation bar
        ImageButton btnReservation = findViewById(R.id.reservationsButton);
        ImageButton btnHome = findViewById(R.id.homeButton);
        ImageButton btnProfile = findViewById(R.id.profileButton);

        // Initialize and populate the adapter with car data
        List<Car> carList = InternalDataBase.getReservedCars(GlobalVariables.activeUser);
        adapter = new CarListAdapter(carList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Navigate to Reservations
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationsActivity.this, ReservationsActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Profile
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservationsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
