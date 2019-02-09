package beangate.datta.fragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private static final String url = "https://beangate.in/barber_app/fetch_men";
    RecyclerViewAdapter recyclerviewAdapter;
    RecyclerView recyclerView;
    List<Item> item_models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView)findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);
        /*  RecyclerviewAdapter viewAdapter = new RecyclerviewAdapter( item_models,getContext());*/
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        item_models=new ArrayList<>();
        /* recyclerView.setAdapter(viewAdapter);*/
        loadRecyclerViewData();

    }


    private void loadRecyclerViewData() {
        StringRequest stringRequest =new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObject1 = new JSONObject(response);
                            JSONArray array=jsonObject1.getJSONArray("server_response");
                            Log.d("######", String.valueOf(array));
                            for ( int i=0; i<array.length(); i++){
                                JSONObject jsonObject2 = array.getJSONObject(i);

                                Item item_model =new Item(jsonObject2.getString("item"),jsonObject2.getString("price"),jsonObject2.getString("category_id"));
                                item_models.add(item_model);


                            }

                            recyclerviewAdapter=new RecyclerViewAdapter(item_models,getApplicationContext());
                            recyclerView.setAdapter(recyclerviewAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this.getApplicationContext());
        requestQueue.add(stringRequest);

    }
}
