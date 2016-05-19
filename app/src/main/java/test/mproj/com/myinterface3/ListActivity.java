package test.mproj.com.myinterface3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private TextView list_title;
    private ListView m_list;
    private CustomListViewAdapter m_adapter;
    private ArrayList<Movie> data;
    private Button m_button;
    private String date_url;

    final String[] mov_titles = new String[]{
            "Iron man",
            "Kung fu Panda",
            "Avengers",
            "Lord of the Rings",
            "Power Rangers",
            "Neighbours",
            "Naruto",
            "The Last Samurai",
            "Kill Bill",
            "Jurassic Park"};
    final String[] mov_time = new String[]{"12:30","11:00","10:00", "2:20","3:45","1:00","5:50","6:12","7:30","11:30"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list_title = (TextView)findViewById(R.id.display_title);
        data = new ArrayList<Movie>();
        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            String m_string = extras.getString("date");
            String m_title = "Movies on " + m_string;
            list_title.setText(m_title);
            date_url = extras.getString("url");
        }

        for(int i = 0; i < 10; i++)
        {
            //create Movie objects and put to data arraylist
            Movie current = new Movie(mov_titles[i],mov_time[i]);
            data.add(current);
        }

        m_list = (ListView) findViewById(R.id.list);
        m_adapter = new CustomListViewAdapter(getApplicationContext(),data);
        m_list.setAdapter(m_adapter);

        m_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;
                String itemClickedId = m_list.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "Clicked " + itemClickedId, Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}