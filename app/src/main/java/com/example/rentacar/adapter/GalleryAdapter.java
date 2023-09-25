package com.example.rentacar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide; // You may need to add Glide or another image loading library
import com.example.rentacar.R;

import java.util.List;

public class GalleryAdapter extends PagerAdapter {

    private Context context;
    private List<Integer> imageList; // You can change the type to match your image data type

    public GalleryAdapter(Context context, List<Integer> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.gallery_item, container, false);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        int imageResource = imageList.get(position);

        // Load the image into the ImageView using Glide or your preferred image loading library
        Glide.with(context)
                .load(imageResource)
                .into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
