package me.games.retrofitexample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.games.retrofitexample.models.UserSubmitResponse;
import me.games.retrofitexample.network.ApiService;
import me.games.retrofitexample.network.SampleApiClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

      ApiService api;

    @Bind(R.id.etFirstName) EditText etFirstName;
    @Bind(R.id.etLastName) EditText etLastName;
    @Bind(R.id.etAddress) EditText etAddress;
    @Bind(R.id.etCountry) EditText etCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        api = SampleApiClient.getApi();
    }



    @OnClick(R.id.btnSubmit)
    void onFornSubmit(){
       submitForm();
    }

    @OnClick(R.id.btnList)
    void showUsers(){
        startActivity(new Intent(MainActivity.this, UserListActivity.class));
    }


    private  void submitForm(){

        Map<String, String> fieldMap = new HashMap<String, String>();
        fieldMap.put("firstName", etFirstName.getText().toString());
        fieldMap.put("lastName", etLastName.getText().toString());
        fieldMap.put("address", etAddress.getText().toString());
        fieldMap.put("country", etCountry.getText().toString());


       api.submitUser(fieldMap,
               new Callback<UserSubmitResponse>() {
                   @Override
                   public void success(UserSubmitResponse userSubmitResponse, Response response) {
                       etFirstName.setText("");
                       etLastName.setText("");
                       etAddress.setText("");
                       etCountry.setText("");

                       Snackbar.make(etAddress,"Response : " + userSubmitResponse.getStatus(), Snackbar.LENGTH_SHORT).show();
                   }

                   @Override
                   public void failure(RetrofitError error) {
                       Snackbar.make(etAddress,"Request Failed", Snackbar.LENGTH_SHORT).show();

                   }
               });

    }




}
