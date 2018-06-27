package com.jonnelabonita.weatherlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jonnel.abonita on 6/27/2018.
 */

public class WeatherDetails extends Activity {

    @BindView(R.id.txtcitylist)
    TextView txcitylist;

    @BindView(R.id.txtlistdegree)
    TextView txdegreelist;

    @BindView(R.id.txtmist)
    TextView txmist;

    @BindView(R.id.txtpressure)
    TextView txpressure;

    @BindView(R.id.txthumidity)
    TextView txhumidity;

    @BindView(R.id.txtmin)
    TextView txmin;

    @BindView(R.id.txtmax)
    TextView txmax;

    @BindView(R.id.txtspeed)
    TextView txspeed;

    @BindView(R.id.txtdegree)
    TextView txdegree;

    @BindView(R.id.imgcondition)
    ImageView imgcon;

//    @BindView(R.id.btnrefresh)
//    ImageView btnref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_city_details);
        ButterKnife.bind(WeatherDetails.this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String valuename = extras.getString("NAME");
            String valuetemp = extras.getString("TEMP");
            String valuepressure = extras.getString("PRESSURE");
            String valuehuminidity = extras.getString("HUMINIDITY");
            String valuemin = extras.getString("MIN");
            String valuemax = extras.getString("MAX");
            String valuespeed = extras.getString("SPEED");
            String valuedegree = extras.getString("DEGREE");
            String valuemist = extras.getString("MIST");
            //The key argument here must match that used in the other activity

            txcitylist.setText(valuename);
            txdegreelist.setText(valuetemp + "°");
            txmist.setText(valuemist);
            txpressure.setText(valuepressure);
            txhumidity.setText(valuehuminidity);
            txmin.setText(valuemin);
            txmax.setText(valuemax);
            txspeed.setText(valuespeed);
            txdegree.setText(valuedegree);
//            btnref.setText(valuename);



        }

    }
}
