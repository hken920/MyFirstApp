package com.kenhsu.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

public class zombieMovies extends AppCompatActivity {

    ListView listView;

    String[] moviePrem = new String[] {"1984", "2009, Tommy Wirkola", "2004, Michele Soavi", "2007, Juan Carlos Fresnadillo",
            "1986, Fred Dekker", "2012, Chris Butler,  Sam Fell", "2009, Ruben Fleischer", "2007, Robert Rodriguez",
            "2016, Sang-ho Yen", "1981, Lucio Fulci", "1985, George Romero", "1988, Wes Craven" , "1985, Stuart Gordon",
            "1971, Lucio Fulci", "2004, Zack Snyder", "1985, Dan O'Bannon", "1992, Peter Jackson", "2002, Danny Boyle",
            "1968, George Romero", "2004, Edgar Wright", "1978, George Romero"};

    String[] movieNames = {"Night of the Comet","Dead Snow","Cemetery Man", "28 Weeks Later",
            "Night of the Creeps", "ParaNorman", "Zombieland", "Planet Terror", "Train to Busan",
            "The Beyond", "Day of the Dead","The Serpent & the Rainbow", "Re-Animator", "Zombi 2",
            "Dawn of the Dead", "Return of the Living Dead", "Dead Alive", "28 Days Later",
            "Night of the Living Dead", "Shawn of the Dead", "Dawn of the Dead"};

    String[] movieDesc = {"1984", "2009, Tommy Wirkola", "2004, Michele Soavi", "2007, Juan Carlos Fresnadillo",
            "1986, Fred Dekker", "2012, Chris Butler,  Sam Fell", "2009, Ruben Fleischer", "2007, Robert Rodriguez",
            "2016, Sang-ho Yen", "1981, Lucio Fulci", "1985, George Romero", "1988, Wes Craven" , "1985, Stuart Gordon",
            "1971, Lucio Fulci", "2004, Zack Snyder", "1985, Dan O'Bannon", "1992, Peter Jackson", "2002, Danny Boyle",
            "1968, George Romero", "2004, Edgar Wright", "1978, George Romero"};

    int[] moviePic = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten,
            R.drawable.eleven,
            R.drawable.twelve,
            R.drawable.thirteen,
            R.drawable.fourteen,
            R.drawable.fifteen,
            R.drawable.sixteen,
            R.drawable.seventeen,
            R.drawable.eighteen,
            R.drawable.nineteen,
            R.drawable.twenty,
            R.drawable.twentyone};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombie_movies);

        listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(zombieMovies.this, DetailActivity.class);
                intent.putExtra("name" , movieDesc[position]);
                intent.putExtra("image", moviePic[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return moviePic.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.list_view_items, null);
            TextView name = view1.findViewById(R.id.textView);
            ImageView image = view1.findViewById(R.id.imageView);
            name.setText(movieDesc[position]);
            image.setImageResource(moviePic[position]);
            return view1;
        }
    }
}
