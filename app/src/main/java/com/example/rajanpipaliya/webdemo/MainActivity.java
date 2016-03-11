package com.example.rajanpipaliya.webdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listview;
    ArrayList<craft_class> arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.list);
        arraylist=new ArrayList<>();
        AsyncHttpClient client=new AsyncHttpClient();
        client.addHeader("Accept","application/json");
        client.addHeader("Content-type","application/json");
        client.get(MainActivity.this,"http://www.jinalshah.brainoorja.com/craft_web.asmx/getallcraftsname",new JsonHttpResponseHandler(){
            ProgressDialog pre;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray array=response.getJSONArray("d");
                    JSONObject object=null;
                    for(int i=0;i<array.length();i++){
                        object=array.getJSONObject(i);
                        arraylist.add(new craft_class(object.getString("craft_name")));
                    }
                    listview.setAdapter(new craft_adapter(MainActivity.this,arraylist));
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(MainActivity.this,"INTERNET PROBLEM",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStart() {
                super.onStart();

                pre=ProgressDialog.show(MainActivity.this,"Loading","Please wait.....");
            }

            @Override
            public void onFinish() {
                super.onFinish();
                pre.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
