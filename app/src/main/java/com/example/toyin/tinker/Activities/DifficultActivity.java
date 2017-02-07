package com.example.toyin.tinker.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.toyin.tinker.R;

/**
 * Created by Toyin on 29/12/2016.
 */
public class DifficultActivity extends AppCompatActivity {

    public EditText name1;
    public RadioGroup radio;
    public Button start;
    public String difficult;
    public String name;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_page);
        start = (Button) findViewById(R.id.start_button);
        name1 = (EditText) findViewById(R.id.player_name);

    }
    //Gets activated when start button is clicked to activate new activity and pass details to the activity
    public void buttonClicked(View view) {
        int id = radio.getCheckedRadioButtonId();
        //Checks if both a radio is picked and a name is inputted
        if (id == -1 && name == null) {
            Toast.makeText(this, "You have to pick a difficulty level", Toast.LENGTH_SHORT);
        }
        else
        {
            RadioButton button = (RadioButton)findViewById(id);
            if(button.getId() == R.id.easybutton)
            {
                difficult = "easy";
            }
            else if(button.getId() == R.id.mediumbutton)
            {
                difficult = "medium";
            }
            else if(button.getId() == R.id.hardbutton)
            {
                difficult = "hard";
            }
            name = name1.getText().toString();
            Intent intent = new Intent(this, QuestionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("player_name", name);
            intent.putExtra("difficult", difficult);
            startActivity(intent);

        }

    }
}
