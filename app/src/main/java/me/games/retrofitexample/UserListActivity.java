package me.games.retrofitexample;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.games.retrofitexample.adapters.UserAdapter;
import me.games.retrofitexample.models.User;
import me.games.retrofitexample.network.ApiService;
import me.games.retrofitexample.network.SampleApiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserListActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView userRecyclerView;

    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);


        apiService = SampleApiClient.getApi();

        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        apiService.getUserList(new Callback<ArrayList<User>>() {
                                   @Override
                                   public void success(ArrayList<User> users, Response response) {
                                       userRecyclerView.setAdapter(new UserAdapter(users));

                                   }

                                   @Override
                                   public void failure(RetrofitError error) {
                                       Snackbar.make(userRecyclerView, "Request Failed", Snackbar.LENGTH_SHORT).show();

                                   }
                               });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_list, menu);
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
