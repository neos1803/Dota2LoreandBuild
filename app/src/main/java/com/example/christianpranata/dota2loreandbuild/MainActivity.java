package com.example.christianpranata.dota2loreandbuild;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.christianpranata.dota2loreandbuild.adapter.ListAdapter;
import com.example.christianpranata.dota2loreandbuild.model.Hero;
import com.example.christianpranata.dota2loreandbuild.model.HeroesDetail;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvmain;
    private ArrayList<Hero> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isOnline(MainActivity.this)) builDialog(MainActivity.this).show();

        else {

            setContentView(R.layout.activity_main);
            rvmain =  findViewById(R.id.rv_main);
            rvmain.setHasFixedSize(true);

            list.addAll(HeroesDetail.getListData());
            showRecyclerList();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public boolean isOnline(Context context) {

        ConnectivityManager connection = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = connection.getActiveNetworkInfo();

        if (network != null && network.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = connection.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = connection.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public AlertDialog.Builder builDialog (Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("This application required an internet connection. Please press OK to Exit and turn your Internet Connection");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        return builder;
    }

    public void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.about:
                Intent move =  new Intent(MainActivity.this, AboutActivity.class);
                startActivity(move);
                break;
        }
    }

    private void showRecyclerList(){
        rvmain.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvmain.setAdapter(listAdapter);

        listAdapter.setOnItemCallBack(new ListAdapter.OnItemCallback() {
            @Override
            public void onItemClicked(Hero data) {
                Intent moveIntent = new Intent(MainActivity.this, HeroesDetailActivity.class);

                moveIntent.putExtra(HeroesDetailActivity.EXTRA_NAME, data.getName());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_LORE_NAME, data.getLore_name());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_PHOTO, data.getPhoto());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_LORE, data.getLore());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_ROLE, data.getRole());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_TYPE, data.getType());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_SET1, data.getSet1());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_SET2, data.getSet2());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_SET3, data.getSet3());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_COMPLEXITY, data.getComplexity());
                moveIntent.putExtra(HeroesDetailActivity.EXTRA_SKILL, data.getSkill());
                startActivity(moveIntent);
            }
        });
    }

}
