package org.pursuit.unit_03_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.R;

import org.pursuit.unit_03_assessment.model.Planet;
import org.pursuit.unit_03_assessment.view.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {

    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.planet_itemview, viewGroup, false);
        return new PlanetViewHolder(childView);
    }

    /**
     * you dont need to create a seperate instance of Planet here you can just pass planetList.get(i) into the onBind() method
     */
    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int i) {
        Planet planet = planetList.get(i);
        planetViewHolder.onBind(planet);

    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}
