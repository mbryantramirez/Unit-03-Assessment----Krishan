package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_03_assessment.controller.PlanetAdapter;
import org.pursuit.unit_03_assessment.model.Planet;
import org.pursuit.unit_03_assessment.model.PlanetOuterClass;
import org.pursuit.unit_03_assessment.network.GetPlanet;
import org.pursuit.unit_03_assessment.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {
    public static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        final RecyclerView recyclerView = findViewById(R.id.planet_recyclerview);
        Retrofit retrofit = RetrofitSingleton.getInstance();
        GetPlanet getPlanet = retrofit.create(GetPlanet.class);
        Call<PlanetOuterClass> planetOuterClassCall = getPlanet.getPlanetOuterClass();
        Log.d(TAG, "onCreate: " + planetOuterClassCall.request());
        planetOuterClassCall.enqueue(new Callback<PlanetOuterClass>() {
            @Override
            public void onResponse(Call<PlanetOuterClass> call, Response<PlanetOuterClass> response) {
                /**
                 * you should check if response.body() is null otherwise your app has a chance of crashing if it is and you gall .getPlanets
                 */
                List<Planet> planetList = response.body().getPlanets();
                Log.d(TAG, "onResponse: "+ planetList);
                PlanetAdapter planetAdapter = new PlanetAdapter(planetList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setAdapter(planetAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<PlanetOuterClass> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });




        /*
         * TODO: Add logic that will:
         *
         * TODO 7. Pass list to RecyclerView
         * TODO 8. Display planet name in a RecyclerView tile
         * TODO 9. Implement an OnClickListener for the itemview
         * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
         */

    }
}
/*
           TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
        * TODO 2. Make data model objects based on JSON
        * TODO 3. Make a service interface with method(s) to make a GET request
        * TODO 5. Subclass a RecyclerView Adapter
        * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
        * TODO 6. Subclass a RecyclerView ViewHolder

*/

