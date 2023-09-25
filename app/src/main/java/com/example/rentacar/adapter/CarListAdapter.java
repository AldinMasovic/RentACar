package com.example.rentacar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentacar.R;
import com.example.rentacar.model.Car;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarDetailsViewHolder> {

    private List<Car> carList;
    private OnItemClickListener onItemClickListener;

    public CarListAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @NonNull
    @Override
    public CarDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View carView = inflater.inflate(R.layout.car_details_item, parent, false);
        return new CarDetailsViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarDetailsViewHolder holder, int position) {
        Car car = carList.get(position);

        holder.carImageView.setImageResource(car.getGallery().getImages().get(0));
        holder.brandTextView.setText(car.getBrand().toString());
        holder.nameTextView.setText(car.getCarType().toString());
        holder.transmissionTextView.setText(car.getTransmission().toString());
        holder.priceTextView.setText(car.getPricePerDay().toString());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public class CarDetailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView carImageView;
        public TextView brandTextView;
        public TextView nameTextView;
        public TextView transmissionTextView;
        public TextView priceTextView;

        public CarDetailsViewHolder(View itemView) {
            super(itemView);
            carImageView = itemView.findViewById(R.id.carImage);
            brandTextView = itemView.findViewById(R.id.brandTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            transmissionTextView = itemView.findViewById(R.id.transmissionTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
