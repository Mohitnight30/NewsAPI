package com.example.newsapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    ProgressBar progressBar;
    RecyclerView recyclerView;
    TextView textView;
    ArrayList<NewsModel> newsModelArrayList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        textView = findViewById(R.id.error_tv);

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), newsModelArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(recyclerAdapter);

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        RequestQueue requestQueue = new RequestQueue(cache, network);

        requestQueue.start();

        String newsUrl = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-09-01&sortBy=publishedAt&apiKey=userdefined";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, newsUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                Log.d(TAG, response.toString());
                        try {
                            int results = response.getInt("totalResults");
                            Log.d(TAG, "Results found: " + results);

                            JSONArray newsArticles = response.getJSONArray("articles");

                            for (int i = 0; i < newsArticles.length(); i++) {
                                JSONObject article = newsArticles.getJSONObject(i);

                                String title = article.getString("title");
                                String description = article.getString("description");
                                String date = article.getString("publishedAt");
                                String urlToImage = article.getString("urlToImage");

                                newsModelArrayList.add(new NewsModel(title, description, date, urlToImage));
                            }

                            recyclerAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);

                        } catch (JSONException e) {

                            progressBar.setVisibility(View.GONE);
                            textView.setText("Error in parsing content. Please check the code.");
                            textView.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(), "Error in parsing results", Toast.LENGTH_LONG).show();
                        }
//                progressBar.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}
