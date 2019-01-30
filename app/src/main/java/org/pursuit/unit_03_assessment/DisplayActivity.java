package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.view.PlanetViewHolder;

public class DisplayActivity extends AppCompatActivity {

    /**
     * You can make these views local variables instead since theyre not being used outside of your onCreate method
     */
    private TextView displayNameTextView;
    private TextView displayNumberTextView;
    private ImageView planetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();

        displayNameTextView = findViewById(R.id.display_name_textview);
        displayNumberTextView = findViewById(R.id.display_number_textview);
        planetImageView = findViewById(R.id.display_planet_imageview);

        int getNumber = intent.getIntExtra(PlanetViewHolder.PLANET_NUMBER, 0);
        String turnNumberToString = String.valueOf(getNumber);
        String getImageUrl = intent.getStringExtra(PlanetViewHolder.PLANET_IMAGE);


        displayNameTextView.setText(intent.getStringExtra(PlanetViewHolder.PLANET_NAME));
        /**
         * avoid concatenating strings in the set text method this takes up resources
         */
        displayNumberTextView.setText("Planet Number : " +turnNumberToString);
        Picasso.get().load(getImageUrl).into(planetImageView);


        /*
        * TODO: Add logic that will:
        * TODO 1. Receive values from sending intent
        * TODO 2. Create a TextView instance for the Planet Name
        * TODO 3. Create a TextView instance for the Planet Number count
        * TODO 4. Create an ImageView for the image url
        * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
        */
    }
}
