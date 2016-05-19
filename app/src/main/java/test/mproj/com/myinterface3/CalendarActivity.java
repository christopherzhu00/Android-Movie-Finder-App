package test.mproj.com.myinterface3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarActivity extends Activity {

    private CalendarView m_calendar;
    private String location_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        m_calendar = (CalendarView) findViewById(R.id.calendar);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            int loc_id = extras.getInt("location_id");
            location_url = "http://regencymovies.com/main.php?theaterId=" + loc_id;
            Toast.makeText(CalendarActivity.this, location_url, Toast.LENGTH_SHORT).show();
        }



        m_calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(getApplicationContext(),dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
                int m_month = month + 1;
                String date = year + "-" + m_month + "-" + dayOfMonth;
                Intent intent = new Intent(CalendarActivity.this, ListActivity.class);
                intent.putExtra("date",date);
                intent.putExtra("url",location_url);
                startActivity(intent);
            }
        });
    }
}
