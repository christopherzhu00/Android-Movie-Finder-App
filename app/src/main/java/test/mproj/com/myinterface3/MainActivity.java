package test.mproj.com.myinterface3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private String location;
    private int location_id;
    private enum locations{}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    // add items into spinner dynamically


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                location = String.valueOf(spinner1.getSelectedItem());
                switch(location)
                {
                    case "Agoura Hills Stadium 8 - Agoura Hills":
                        location_id = 22;
                        break;
                    case "Bruin - Westwood Village":
                        location_id = 28;
                        break;
                    case "Commerce 14 - City of Commerce":
                        location_id = 31;
                        break;
                    case "Granada Hills 9 - Granada Hills":
                        location_id = 26;
                        break;
                    case "Norwalk 8 - Norwalk":
                        location_id = 36;
                        break;
                    case "Valley Plaza 6 - North Hollywood":
                        location_id = 30;
                        break;
                    case "Van Nuys Plant 16 - Van Nuys":
                        location_id = 32;
                        break;
                    case "Village - Westwood Village":
                        location_id = 27;
                        break;
                }
                Intent main_intent = new Intent(MainActivity.this,CalendarActivity.class);
                main_intent.putExtra("location_id",location_id);
                startActivity(main_intent);
            }

        });
    }
}
