package com.jonnelabonita.weatherlist;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonnelabonita.weatherlist.Data.datas;
import com.jonnelabonita.weatherlist.api.ApiService;
import com.jonnelabonita.weatherlist.models.OpenWeather;
import com.jonnelabonita.weatherlist.utils.InternetConnection;
import com.jonnelabonita.weatherlist.utils.RetroClient;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtdates)
    TextView txDate;

    @BindView(R.id.txtdays)
    TextView txDay;

    @BindView(R.id.txtlondon)
    TextView txlondon;

    @BindView(R.id.txtdescriptlondon)
    TextView londonDesc;

    @BindView(R.id.imgweatherlondon)
    ImageView imagelondon;

    @BindView(R.id.txtdegreelondon)
    TextView londonDegree;

    @BindView(R.id.txtSeoul)
    TextView txseoul;

    @BindView(R.id.txtdescriptseoul)
    TextView seoulDesc;

    @BindView(R.id.imgweatherseoul)
    ImageView imageseoul;

    @BindView(R.id.txtdegreeseoul)
    TextView seoulDegree;

    @BindView(R.id.txtnewyork)
    TextView txnewyork;

    @BindView(R.id.txtdescriptnewyork)
    TextView newyorkDesc;

    @BindView(R.id.imgweathernewyork)
    ImageView imagenewyork;

    @BindView(R.id.txtdegreenewyork)
    TextView newyorkDegree;

    @BindView(R.id.txttokyo)
    TextView txtokyo;

    @BindView(R.id.txtdescripttokyo)
    TextView tokyoDesc;

    @BindView(R.id.imgweathertokyo)
    ImageView imagetokyo;

    @BindView(R.id.txtdegreetokyo)
    TextView tokyoDegree;

    @BindView(R.id.txtortigas)
    TextView txortigas;

    @BindView(R.id.txtdescriptortigas)
    TextView ortigasDesc;

    @BindView(R.id.imgweatherortigas)
    ImageView imageortigas;

    @BindView(R.id.txtdegreeortigas)
    TextView ortigasDegree;

    @BindView(R.id.btnrefresh)
    Button btnRefresh;

    private String BASE_URL = "http://openweathermap.org/img/w/";

    String londontemp;
    String londonpressure;
    String londonhumidity;
    String londonmin;
    String londonmax;
    String londonspeed;
    String londondegree;
    String londonmist;

    String seoultemp;
    String seoultemppressure;
    String seoultemphumidity;
    String seoultempmin;
    String seoultempmax;
    String seoultempspeed;
    String seoultempdegree;
    String seoultempmist;

    String newyorktemp;
    String newyorkpressure;
    String newyorkhumidity;
    String newyorkmin;
    String newyorkmax;
    String newyorkspeed;
    String newyorkdegree;
    String newyorkmist;

    String tokyotemp;
    String tokyopressure;
    String tokyohumidity;
    String tokyomin;
    String tokyomax;
    String tokyospeed;
    String tokyodegree;
    String tokyomist;

    String ortigastemp;
    String ortigaspressure;
    String ortigashumidity;
    String ortigasmin;
    String ortigasmax;
    String ortigasspeed;
    String ortigasdegree;
    String ortigasmist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String currentDateandTime = new SimpleDateFormat("MMM dd, yyyy").format(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);

        Log.e("awfawd", dayOfTheWeek + currentDateandTime);

        txDate.setText(currentDateandTime);
        txDay.setText(dayOfTheWeek);

        getlondon();
        getseoul();
        getnewyork();
        gettokyo();
        getortigas();
    }

    @OnClick(R.id.clklondon) void getLondon(){

        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        intent.putExtra("NAME", String.valueOf(txlondon.getText()));
        intent.putExtra("TEMP", String.valueOf(londontemp));
        intent.putExtra("PRESSURE", String.valueOf(londonpressure));
        intent.putExtra("HUMINIDITY", String.valueOf(londonhumidity));
        intent.putExtra("MIN", String.valueOf(londonmin));
        intent.putExtra("MAX", String.valueOf(londonmax));
        intent.putExtra("SPEED", String.valueOf(londonspeed));
        intent.putExtra("DEGREE", String.valueOf(londondegree));
        intent.putExtra("MIST", String.valueOf(londonmist));
        intent.putExtra("IMAGE",R.id.imgcondition);
        startActivity(intent);
    }

    @OnClick(R.id.clkseoul) void getSeoul(){

        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        intent.putExtra("NAME", String.valueOf(txseoul.getText()));
        intent.putExtra("TEMP", String.valueOf(seoultemp));
        intent.putExtra("PRESSURE", String.valueOf(seoultemppressure));
        intent.putExtra("HUMINIDITY", String.valueOf(seoultemphumidity));
        intent.putExtra("MIN", String.valueOf(seoultempmin));
        intent.putExtra("MAX", String.valueOf(seoultempmax));
        intent.putExtra("SPEED", String.valueOf(seoultempspeed));
        intent.putExtra("DEGREE", String.valueOf(seoultempdegree));
        intent.putExtra("MIST", String.valueOf(seoultempmist));
        startActivity(intent);
    }

    @OnClick(R.id.clknewyork) void getNewYork(){

        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        intent.putExtra("NAME", String.valueOf(txnewyork.getText()));
        intent.putExtra("TEMP", String.valueOf(newyorktemp));
        intent.putExtra("PRESSURE", String.valueOf(newyorkpressure));
        intent.putExtra("HUMINIDITY", String.valueOf(newyorkhumidity));
        intent.putExtra("MIN", String.valueOf(newyorkmin));
        intent.putExtra("MAX", String.valueOf(newyorkmax));
        intent.putExtra("SPEED", String.valueOf(newyorkspeed));
        intent.putExtra("DEGREE", String.valueOf(newyorkdegree));
        intent.putExtra("MIST", String.valueOf(newyorkmist));
        startActivity(intent);
    }

    @OnClick(R.id.clktokyo) void getTokyo(){

        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        intent.putExtra("NAME", String.valueOf(txtokyo.getText()));
        intent.putExtra("TEMP", String.valueOf(tokyotemp));
        intent.putExtra("PRESSURE", String.valueOf(tokyopressure));
        intent.putExtra("HUMINIDITY", String.valueOf(tokyohumidity));
        intent.putExtra("MIN", String.valueOf(tokyomin));
        intent.putExtra("MAX", String.valueOf(tokyomax));
        intent.putExtra("SPEED", String.valueOf(tokyospeed));
        intent.putExtra("DEGREE", String.valueOf(tokyodegree));
        intent.putExtra("MIST", String.valueOf(tokyomist));
        startActivity(intent);
    }

    @OnClick(R.id.clkortigas) void getOrtigas(){

        Intent intent = new Intent(MainActivity.this, WeatherDetails.class);
        intent.putExtra("NAME", String.valueOf(txortigas.getText()));
        intent.putExtra("TEMP", String.valueOf(ortigastemp));
        intent.putExtra("PRESSURE", String.valueOf(ortigaspressure));
        intent.putExtra("HUMINIDITY", String.valueOf(ortigashumidity));
        intent.putExtra("MIN", String.valueOf(ortigasmin));
        intent.putExtra("MAX", String.valueOf(ortigasmax));
        intent.putExtra("SPEED", String.valueOf(ortigasspeed));
        intent.putExtra("DEGREE", String.valueOf(ortigasdegree));
        intent.putExtra("MIST", String.valueOf(ortigasmist));
        startActivity(intent);
    }

    @OnClick(R.id.btnrefresh) void getrefresh(){

        getlondon();
        getseoul();
        getnewyork();
        gettokyo();
        getortigas();
    }

    public void getlondon(){
        if (InternetConnection.checkConnection(getApplicationContext())) {

            final ProgressDialog dialogs;
            /**
             * Progress Dialog for User Interaction
             */

            dialogs = new ProgressDialog(MainActivity.this);
            dialogs.setTitle("Loading");
            dialogs.setMessage("WAITING CONNECTION");
            dialogs.show();

            ApiService api = RetroClient.getApiService();

            Call<OpenWeather> call = api.getWeatherLondon(datas.LONDON, datas.APPID, datas.METRIC);

            call.enqueue(new Callback<OpenWeather>() {
                             @Override
                             public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                                 OpenWeather weatherres = response.body();

                                 Log.e("response","");

                                 txlondon.setText(weatherres.getName());
                                 londonDesc.setText(weatherres.getWeather().get(0).getDescription());
                                 londonDegree.setText(weatherres.getMain().getTemp().toString()+"°");
                                 Picasso.get().load(BASE_URL + weatherres.getWeather().get(0).getIcon()+".png").into(imagelondon);
                                 londontemp = weatherres.getMain().getTemp().toString();
                                 londonpressure = String.valueOf(weatherres.getMain().getPressure());
                                 londonhumidity = String.valueOf(weatherres.getMain().getHumidity());
                                 londonmin = String.valueOf(weatherres.getMain().getTempMin());
                                 londonmax = String.valueOf(weatherres.getMain().getTempMax());
                                 londonspeed = String.valueOf(weatherres.getWind().getSpeed());
                                 londondegree = String.valueOf(weatherres.getWind().getDeg());
                                 londonmist = weatherres.getWeather().get(0).getDescription();
                                 dialogs.dismiss();
                             }

                             @Override
                             public void onFailure(Call<OpenWeather> call, Throwable t) {

                             }
                         });
        }
    }

    public void getseoul(){

        if (InternetConnection.checkConnection(getApplicationContext())) {

            ApiService api = RetroClient.getApiService();

            Call<OpenWeather> call = api.getWeatherSeoul(datas.SEOUL, datas.APPID, datas.METRIC);

            call.enqueue(new Callback<OpenWeather>() {
                @Override
                public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                    OpenWeather weatherres = response.body();

                    Log.e("response",  weatherres.getName());

                    txseoul.setText(weatherres.getName());
                    seoulDesc.setText(weatherres.getWeather().get(0).getDescription());
                    seoulDegree.setText(weatherres.getMain().getTemp().toString()+"°");
                    Picasso.get().load(BASE_URL+weatherres.getWeather().get(0).getIcon()+".png").into(imageseoul);
                    seoultemp = weatherres.getMain().getTemp().toString();
                    seoultemppressure = String.valueOf(weatherres.getMain().getPressure());
                    seoultemphumidity = String.valueOf(weatherres.getMain().getHumidity());
                    seoultempmin = String.valueOf(weatherres.getMain().getTempMin());
                    seoultempmax = String.valueOf(weatherres.getMain().getTempMax());
                    seoultempspeed = String.valueOf(weatherres.getWind().getSpeed());
                    seoultempdegree = String.valueOf(weatherres.getWind().getDeg());
                    seoultempmist = weatherres.getWeather().get(0).getDescription();

                }

                @Override
                public void onFailure(Call<OpenWeather> call, Throwable t) {

                }
            });

        }
    }

    public void getnewyork(){

        if (InternetConnection.checkConnection(getApplicationContext())) {

            ApiService api = RetroClient.getApiService();

            Call<OpenWeather> call = api.getWeatherNewYork(datas.NEWYORK, datas.APPID, datas.METRIC);

            call.enqueue(new Callback<OpenWeather>() {
                @Override
                public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                    OpenWeather weatherres = response.body();

                    Log.e("response",  weatherres.getName());

                    txnewyork.setText(weatherres.getName());
                    newyorkDesc.setText(weatherres.getWeather().get(0).getDescription());
                    newyorkDegree.setText(weatherres.getMain().getTemp().toString()+"°");
                    Picasso.get().load(BASE_URL+weatherres.getWeather().get(0).getIcon()+".png").into(imagenewyork);
                    newyorktemp = weatherres.getMain().getTemp().toString();
                    newyorkpressure = String.valueOf(weatherres.getMain().getPressure());
                    newyorkhumidity = String.valueOf(weatherres.getMain().getHumidity());
                    newyorkmin = String.valueOf(weatherres.getMain().getTempMin());
                    newyorkmax = String.valueOf(weatherres.getMain().getTempMax());
                    newyorkspeed = String.valueOf(weatherres.getWind().getSpeed());
                    newyorkdegree = String.valueOf(weatherres.getWind().getDeg());
                    newyorkmist = weatherres.getWeather().get(0).getDescription();

                }

                @Override
                public void onFailure(Call<OpenWeather> call, Throwable t) {

                }
            });

        }
    }

    public void gettokyo(){

        if (InternetConnection.checkConnection(getApplicationContext())) {

            ApiService api = RetroClient.getApiService();

            Call<OpenWeather> call = api.getWeatherTokyo(datas.TOKYO, datas.APPID, datas.METRIC);

            call.enqueue(new Callback<OpenWeather>() {
                @Override
                public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                    OpenWeather weatherres = response.body();

                    Log.e("response",  weatherres.getName());

                    txtokyo.setText(weatherres.getName());
                    tokyoDesc.setText(weatherres.getWeather().get(0).getDescription());
                    tokyoDegree.setText(weatherres.getMain().getTemp().toString()+"°");
                    Picasso.get().load(BASE_URL+weatherres.getWeather().get(0).getIcon()+".png").into(imagetokyo);
                    tokyotemp = weatherres.getMain().getTemp().toString();
                    tokyopressure = String.valueOf(weatherres.getMain().getPressure());
                    tokyohumidity = String.valueOf(weatherres.getMain().getHumidity());
                    tokyomin = String.valueOf(weatherres.getMain().getTempMin());
                    tokyomax = String.valueOf(weatherres.getMain().getTempMax());
                    tokyospeed = String.valueOf(weatherres.getWind().getSpeed());
                    tokyodegree = String.valueOf(weatherres.getWind().getDeg());
                    tokyomist = weatherres.getWeather().get(0).getDescription();

                }

                @Override
                public void onFailure(Call<OpenWeather> call, Throwable t) {

                }
            });

        }
    }

    public void getortigas(){

        if (InternetConnection.checkConnection(getApplicationContext())) {

            ApiService api = RetroClient.getApiService();

            Call<OpenWeather> call = api.getWeatherOrtigas(datas.ORTIGAS_PSE_LATITUDE, datas.ORTIGAS_PSE_LONGITUDE, datas.APPID, datas.METRIC);

            call.enqueue(new Callback<OpenWeather>() {
                @Override
                public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                    OpenWeather weatherres = response.body();

                    Log.e("response",  weatherres.getName());

                    txortigas.setText(weatherres.getName());
                    ortigasDesc.setText(weatherres.getWeather().get(0).getDescription());
                    ortigasDegree.setText(weatherres.getMain().getTemp().toString()+"°");
                    Picasso.get().load(BASE_URL+weatherres.getWeather().get(0).getIcon()+".png").into(imageortigas);
                    ortigastemp = weatherres.getMain().getTemp().toString();
                    ortigaspressure = String.valueOf(weatherres.getMain().getPressure());
                    ortigashumidity = String.valueOf(weatherres.getMain().getHumidity());
                    ortigasmin = String.valueOf(weatherres.getMain().getTempMin());
                    ortigasmax = String.valueOf(weatherres.getMain().getTempMax());
                    ortigasspeed = String.valueOf(weatherres.getWind().getSpeed());
                    ortigasdegree = String.valueOf(weatherres.getWind().getDeg());
                    ortigasmist = weatherres.getWeather().get(0).getDescription();

                }

                @Override
                public void onFailure(Call<OpenWeather> call, Throwable t) {

                }
            });

        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("Connection");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Network Error")
                    .setCancelable(false)
                    .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();

            Log.d("onResponse", "internet connection failed");
        }
    }
}
