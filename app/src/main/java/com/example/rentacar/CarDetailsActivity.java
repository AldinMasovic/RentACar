package com.example.rentacar;

import static java.time.temporal.ChronoUnit.DAYS;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.rentacar.adapter.GalleryAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;
import com.example.rentacar.model.Reservation;

import java.math.BigDecimal;
import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {

    private ViewPager galleryViewPager;
    private Button reserveButton;
    private Car selectedCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        // Bottom navigation bar
        ImageButton btnReservation = findViewById(R.id.reservationsButton);
        ImageButton btnHome = findViewById(R.id.homeButton);
        ImageButton btnProfile = findViewById(R.id.profileButton);

        galleryViewPager = findViewById(R.id.gallery);
        reserveButton = findViewById(R.id.btnReserve);

        int carPosition = getIntent().getIntExtra("car_position", -1);
        if (carPosition != -1) {
            // Load car details and images for the selected car
            List<Car> carList = InternalDataBase.getCarList(); // Implement a method to fetch car data

            selectedCar = carList.get(carPosition);

            // Set up the GalleryView with car images (you'll need to create a GalleryAdapter)
            GalleryAdapter galleryAdapter = new GalleryAdapter(this, selectedCar.getGallery().getImages());
            galleryViewPager.setAdapter(galleryAdapter);

            // Display other car details
            TextView tvPrice = findViewById(R.id.tvPrice);
            tvPrice.setText(selectedCar.getPricePerDay().toString() + " KM");
            TextView tvFuel = findViewById(R.id.tvFuel);
            tvFuel.setText(selectedCar.getFuel().toString());
            TextView brandTextView = findViewById(R.id.tvBrandDetail);
            brandTextView.setText(selectedCar.getBrand().toString());
            TextView tvLocation = findViewById(R.id.tvLocation);
            tvLocation.setText(selectedCar.getLocation().toString());
            TextView tvCarType = findViewById(R.id.tvCarType);
            tvCarType.setText(selectedCar.getCarType().toString());
            TextView tvNavigation = findViewById(R.id.tvNavigation);
            tvNavigation.setText(selectedCar.getNavigation().toString());
            TextView tvTransmission = findViewById(R.id.tvTransmission);
            tvTransmission.setText(selectedCar.getTransmission().toString());
            TextView tvProductionYear = findViewById(R.id.tvProductionYear);
            tvProductionYear.setText(selectedCar.getProductionYear().toString());
            TextView tvHorsePower = findViewById(R.id.tvHorsePower);
            tvHorsePower.setText(selectedCar.getHorsePower().toString());
            TextView tvNumberOfSeats = findViewById(R.id.tvNumberOfSeats);
            tvNumberOfSeats.setText(selectedCar.getNumberOfSeats().toString());
            TextView tvNumberOfDoors = findViewById(R.id.tvNumberOfDoors);
            tvNumberOfDoors.setText(selectedCar.getNumberOfDoors().toString());

            // Handle reserve button click
            reserveButton.setOnClickListener(view -> showReservationConfirmationDialog());
        }

        // Navigate to Reservations
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetailsActivity.this, ReservationsActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetailsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Profile
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetailsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showReservationConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Reservation");
        builder.setMessage("Are you sure you want to reserve this car?");
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            // Handle reservation confirmation
            // Show a pop-up confirmation message
            // Redirect to the my reservation screen

            long between = DAYS.between(GlobalVariables.getStartAt(), GlobalVariables.getReturnAt());
            Reservation reservation = new Reservation(GlobalVariables.getStartAt(),
                    GlobalVariables.getReturnAt(),
                    GlobalVariables.activeUser,
                    selectedCar.getPricePerDay().multiply(BigDecimal.valueOf(between)),
                    selectedCar);
            selectedCar.getAvailability().getReservations().add(reservation);
            GlobalVariables.activeUser.getReservations().add(reservation);
            startActivity(new Intent(CarDetailsActivity.this, ReservationsActivity.class));
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }
}
