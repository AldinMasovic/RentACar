package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.adapter.CarListAdapter;
import com.example.rentacar.model.Car;
import com.example.rentacar.model.Gallery;
import com.example.rentacar.model.enums.Brand;
import com.example.rentacar.model.enums.CarType;
import com.example.rentacar.model.enums.Fuel;
import com.example.rentacar.model.enums.Location;
import com.example.rentacar.model.enums.Transmission;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize and populate the adapter with car data
        List<Car> carList = getCarData();
        adapter = new CarListAdapter(carList);

        recyclerView.setAdapter(adapter);

        // Handle item click to navigate to the third screen
        adapter.setOnItemClickListener(new CarListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(CarListActivity.this, CarDetailsActivity.class);
                intent.putExtra("car_position", position);
                startActivity(intent);
            }
        });
    }

    private List<Car> getCarData() {
        // Implement code to fetch car data from a source (e.g., API or database)
        // and return a list of Car objects
        // For simplicity, here's a dummy data example:
        List<Car> carList = InternalDataBase.getCarList();
//        carList.add(new Car("Car 1", "Brand 1", "Automatic", "$50", R.drawable.car1));
//        carList.add(new Car("Car 2", "Brand 2", "Manual", "$45", R.drawable.car2));
        // Add more cars as needed
        return carList;
    }


}
