package com.example.myapplicationtest2;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends BaseAdapter  {
    private Context context;
    private List<Chien> dogsList;

    public MyAdapter(Context context, List<Chien> dogsList) {
        this.context = context;
        this.dogsList = dogsList;
    }

    @Override
    public int getCount() {
        return dogsList.size();
    }

    @Override
    public Object getItem(int position) {
        return dogsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Si convertView est null, il n'y a pas de vue recyclée disponible,
            // alors créez une nouvelle vue avec inflate.
            convertView = LayoutInflater.from(context).inflate(R.layout.display, parent, false);
        }

        // Get the current dog
        Chien currentDog = (Chien) getItem(position);

        // Set the dog's image
        ImageView imageViewDog = convertView.findViewById(R.id.imageViewDog);
        int resID = context.getResources().getIdentifier(currentDog.getImageName(), "drawable", context.getPackageName());
        imageViewDog.setImageResource(resID);

        // Set the dog's name, breed, and country of origin
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        textViewName.setText(currentDog.getName());

        TextView textViewBreed = convertView.findViewById(R.id.textViewBreed);
        textViewBreed.setText(currentDog.getBreed());

        TextView textViewCountry = convertView.findViewById(R.id.textViewCountry);
        textViewCountry.setText(currentDog.getCountry());

        // Set click listener for the dog's image
        imageViewDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open InfoActivity and pass information about the clicked dog
                Intent intent = new Intent(context, InfoActivity.class);
                intent.putExtra("imageName", currentDog.getImageName());
                intent.putExtra("dogName", currentDog.getName());
                intent.putExtra("dogBreed", currentDog.getBreed());
                intent.putExtra("dogCountry", currentDog.getCountry());
                if (currentDog.getDescription() != null) {
                    intent.putExtra("dogDescription", currentDog.getDescription());
                }
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
