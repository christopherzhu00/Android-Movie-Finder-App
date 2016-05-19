package test.mproj.com.myinterface3;

/**
 * Created by Michael on 5/15/2016.
 */
public class Movie
{
    private String m_title;
    private String m_time;

    public Movie(String title, String time)
    {
        this.m_title = title;
        this.m_time = time;
    }

    public String getTime() {
        return m_time;
    }

    public void setTime(String time) {
        this.m_time = time;
    }

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        this.m_title = title;
    }
}
