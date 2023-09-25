package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.GlobalVariables;
import com.example.rentacar.model.InternalDataBase;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView reservationPeriodTextView;
    private CarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reservationPeriodTextView = findViewById(R.id.tvReservationPeriod);
        String baseText = reservationPeriodTextView.getText().toString();
        String reservationPeriod = baseText + GlobalVariables.getStartAt().toString() + " - " + GlobalVariables.getReturnAt().toString();
        reservationPeriodTextView.setText(reservationPeriod);

        // Initialize and populate the adapter with car data
        List<Car> carList = getCarData();
        adapter = new CarListAdapter(carList);

        recyclerView.setAdapter(adapter);

        // Handle item click to navigate to the third screen
        adapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(CarListActivity.this, CarDetailsActivity.class);
            intent.putExtra("car_position", position);
            startActivity(intent);
        });
    }

    private List<Car> getCarData() {
        List<Car> carList = InternalDataBase.getCarList();
        //filter the data for dates
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if(car.getAvailability().isAvailable(GlobalVariables.getStartAt(), GlobalVariables.getReturnAt())) {
                result.add(car);
            }
        }
        return result;
    }


}
