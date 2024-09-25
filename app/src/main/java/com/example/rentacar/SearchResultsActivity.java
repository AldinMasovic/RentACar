package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;
import com.example.rentacar.util.DateUtilFormatter;

import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {

    private TextView periodResultTextView, pickupLocationResultTextView;
    private RecyclerView recyclerView;
    private CarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // Bottom navigation bar
        ImageButton btnReservation = findViewById(R.id.reservationsButton);
        ImageButton btnHome = findViewById(R.id.homeButton);
        ImageButton btnProfile = findViewById(R.id.profileButton);
        periodResultTextView = findViewById(R.id.periodResult);
        pickupLocationResultTextView = findViewById(R.id.pickup_location_result);

        periodResultTextView.setText(DateUtilFormatter.toString(GlobalVariables.getStartAt()) + " - " + DateUtilFormatter.toString(GlobalVariables.getReturnAt()));
        pickupLocationResultTextView.setText(GlobalVariables.pickupLocation);

        // Initialize and populate the adapter with car data
        List<Car> carList = InternalDataBase.getCarAvailable();
        adapter = new CarListAdapter(carList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Handle item click to navigate to the third screen
        adapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(SearchResultsActivity.this, CarDetailsActivity.class);
            intent.putExtra("car_position", position);
            startActivity(intent);
        });

        // Navigate to Reservations
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchResultsActivity.this, ReservationsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Navigate to Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalVariables.startAt = null;
                GlobalVariables.returnAt = null;

                Intent intent = new Intent(SearchResultsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Navigate to Profile
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchResultsActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
