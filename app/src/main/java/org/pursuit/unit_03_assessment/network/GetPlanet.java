package org.pursuit.unit_03_assessment.network;

import org.pursuit.unit_03_assessment.model.PlanetOuterClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetPlanet {
    @GET("JDVila/storybook/master/planets.json")
    Call<PlanetOuterClass> getPlanetOuterClass();
}
