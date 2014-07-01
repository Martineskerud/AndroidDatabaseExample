package hiof.eskerud.databaseexample.app;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Martin on 11.06.2014.
 */
public class JsonURLReader extends AsyncTask implements Runnable {

    public static String path;
    private String input;


    public JsonURLReader(String url) throws IOException {
        path = url;
        Thread networkingThread = new Thread(this);
        networkingThread.start();
    }

    public void init() throws IOException {
        URL url = new URL(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        while ((input = in.readLine()) != null)
            sb.append(input);
        in.close();
        input = sb.toString();
        Log.d(MainActivity.TAG, input);
    }

    @Override
    public void run() {
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
