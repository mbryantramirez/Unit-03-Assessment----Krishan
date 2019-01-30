package org.pursuit.unit_03_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.R;

import org.pursuit.unit_03_assessment.model.Planet;


public class PlanetViewHolder extends RecyclerView.ViewHolder {
    public static final String PLANET_NAME = "planet name" ;
    public  static final String PLANET_IMAGE = "planet image";
    public  static final String PLANET_NUMBER = "planet number";
    private TextView planetTextView;
    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        planetTextView = itemView.findViewById(R.id.recycler_view_textview);

    }
    public void onBind(final Planet planet){
        planetTextView.setText(planet.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra(PLANET_NAME, planet.getName());
                intent.putExtra(PLANET_NUMBER, planet.getNumber());
                intent.putExtra(PLANET_IMAGE, planet.getImage());
                v.getContext().startActivity(intent);
            }
        });
    }
}
