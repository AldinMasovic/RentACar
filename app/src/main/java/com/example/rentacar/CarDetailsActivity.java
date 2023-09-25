package com.example.rentacar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.rentacar.adapter.GalleryAdapter;
import com.example.rentacar.model.Car;

import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {

    private ViewPager galleryViewPager;
    private Button reserveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        galleryViewPager = findViewById(R.id.gallery);
        reserveButton = findViewById(R.id.btnReserve);

        int carPosition = getIntent().getIntExtra("car_position", -1);
        if (carPosition != -1) {
            // Load car details and images for the selected car
            List<Car> carList = InternalDataBase.getCarList(); // Implement a method to fetch car data
            Car selectedCar = carList.get(carPosition);

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
    }

    private void showReservationConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Reservation");
        builder.setMessage("Are you sure you want to reserve this car?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Handle reservation confirmation
                // Show a pop-up confirmation message
                // Redirect to the fourth screen
                startActivity(new Intent(CarDetailsActivity.this, UserProfileActivity.class));
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }
}
