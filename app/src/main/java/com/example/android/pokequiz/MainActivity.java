package com.example.android.pokequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Submit Answers button is clicked.
     * It checks all chosen answers and compares them to the correct answers,
     * adding 1 point to the score for each correct answer. At the end the
     * score is presented as a toast.
     * @param view
     */
    public void checkAnswers(View view){
        int correctAnswers = 0;

        //Checking question 1
        EditText creatorNameField = (EditText) findViewById(R.id.creator_name_field);
        String creatorName = creatorNameField.getText().toString().trim();

        if (creatorName.equalsIgnoreCase("Satoshi Tajiri")){
            correctAnswers += 1;
        }

        //Checking question 2
        RadioGroup releasedTypeRadioGroup = (RadioGroup) findViewById(R.id.releaseType_radio_group);
        int checkedReleaseTypeID = releasedTypeRadioGroup.getCheckedRadioButtonId(); //Getting checked radio button

        if (checkedReleaseTypeID == R.id.videogame_radio_button) {
            correctAnswers += 1;
        }

        //Checking question 3
        //Getting checked state for each checkbox
        CheckBox yellowCheckBox = (CheckBox) findViewById(R.id.pokemon_yellow_checkbox);
        boolean isYellowChecked = yellowCheckBox.isChecked();

        CheckBox redCheckBox = (CheckBox) findViewById(R.id.pokemon_red_checkbox);
        boolean isRedChecked = redCheckBox.isChecked();

        CheckBox greenCheckBox = (CheckBox) findViewById(R.id.pokemon_green_checkbox);
        boolean isGreenChecked = greenCheckBox.isChecked();

        CheckBox blueCheckBox = (CheckBox) findViewById(R.id.pokemon_blue_checkbox);
        boolean isBlueChecked = blueCheckBox.isChecked();

        if (isRedChecked && isGreenChecked && !isYellowChecked && !isBlueChecked) {
            correctAnswers += 1;
        }

        //Checking question 4
        RadioGroup noStarterGameRadioGroup = (RadioGroup) findViewById(R.id.noStarterGame_radio_group);
        int checkedReleaseGameID = noStarterGameRadioGroup.getCheckedRadioButtonId(); //Getting checked radio button

        if (checkedReleaseGameID == R.id.yellow_radio_button) {
            correctAnswers += 1;
        }

        //Checking question 5
        RadioGroup inspirationRadioGroup = (RadioGroup) findViewById(R.id.inspiration_radio_group);
        int checkedInspirationID = inspirationRadioGroup.getCheckedRadioButtonId(); //Getting checked radio button

        if (checkedInspirationID == R.id.bugs_radio_button) {
            correctAnswers += 1;
        }

        //Checking question 6
        EditText pokeBallVariantField = (EditText) findViewById(R.id.pokeball_variant_text_field);
        String pokeBallVariant = pokeBallVariantField.getText().toString().trim();

        if (pokeBallVariant.equalsIgnoreCase("Master Ball")) {
            correctAnswers += 1;
        }

        //Checking question 7
        RadioGroup genOneNumberRadioGroup = (RadioGroup) findViewById(R.id.gen_one_number_radio_group);
        int checkedPokeNumberID = genOneNumberRadioGroup.getCheckedRadioButtonId(); //Getting checked radio button

        if (checkedPokeNumberID == R.id.d_radio_button) {
            correctAnswers += 1;
        }

        //Calculating final score as a percentage
        double score = (correctAnswers/7.0) * 100;
        String percentage = String.format(Locale.US, "%.2f", score);

        if (score < 100) {
            Toast.makeText(this, "You got "  + correctAnswers + " out of 7 questions right. \nYour score is " +
                    percentage + "%", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Awesome! You scored " + percentage + "%! You're a Pokémon Master!", Toast.LENGTH_LONG).show();
        }
    }
}
