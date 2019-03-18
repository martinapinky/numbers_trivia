package com.martina.numbers.numbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.martina.numbers.numbers.network.GetDataService;
import com.martina.numbers.numbers.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView showTrivia;
    Button getTrivia;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTrivia = findViewById(R.id.text_view_show_trivia);
        getTrivia = findViewById(R.id.button_get_trivia);
        number = findViewById(R.id.edit_text_enter_number);
    }

    public void getTrivia (View view) {

//      Create Url
        String urlString = "http://numbersapi.com/";
        String numberString = "" + number.getText() + "/";
        urlString = urlString + numberString;

//      Create handle for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<String> call = service.getTrivia(urlString);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                showTrivia.setText(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
