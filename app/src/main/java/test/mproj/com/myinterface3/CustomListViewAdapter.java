package test.mproj.com.myinterface3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Michael on 5/15/2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    private Context m_context;
    private ArrayList<Movie> movies;
    private static LayoutInflater inflater = null;

    public  CustomListViewAdapter(Context context, ArrayList<Movie> data)
    {
        m_context = context;
        movies = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView == null)
        {
            view = inflater.inflate(R.layout.list_row,null);
            TextView title = (TextView) view.findViewById(R.id.name);
            TextView description = (TextView) view.findViewById(R.id.description);
            Movie m_movie = movies.get(position);
            title.setText(m_movie.getTitle());
            description.setText(m_movie.getTime());


        }
        return view;
    }
}
