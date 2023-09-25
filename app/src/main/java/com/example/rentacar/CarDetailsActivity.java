package com.example.rentacar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
            // TextView brandTextView = findViewById(R.id.brandTextView);
            // brandTextView.setText(selectedCar.getBrand());
            // ... (similarly, set other details)

            // Handle reserve button click
            reserveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showReservationConfirmationDialog();
                }
            });
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
