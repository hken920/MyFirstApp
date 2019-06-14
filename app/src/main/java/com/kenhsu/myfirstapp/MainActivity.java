package com.kenhsu.myfirstapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    EditText userEmail, userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar jin_toolbar = findViewById(R.id.jin_navi);
        setSupportActionBar(jin_toolbar);

        mAuth = FirebaseAuth.getInstance();
        userEmail = findViewById(R.id.editText7);
        userPass = findViewById(R.id.passText);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }



    private void signIn() {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword("Hken920@gmail.com","apricot")
                .addOnCompleteListener(this, new
                        OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                Log.d("FIREBASE", "signIn:onComplete:" +
                                        task.isSuccessful());
                                if (task.isSuccessful()) {
                                    // update profile
                                    FirebaseUser user =
                                            FirebaseAuth.getInstance().getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new
                                            UserProfileChangeRequest.Builder()
                                            .setDisplayName("value")
                                            .build();
                                    user.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                               @Override
                                                                               public void onComplete(@NonNull
                                                                                                              Task<Void> task) {
                                                                                   if (task.isSuccessful()) {
                                                                                       Log.d("FIREBASE", "User profile updated.");
                                                                                       // Go to FirebaseActivity
                                                                                       startActivity(new
                                                                                               Intent(MainActivity.this, TeamActivity.class));
                                                                                   }
                                                                               }
                                                                           });
                                } else {
                                    Log.d("FIREBASE", "sign-in failed");
                                    Toast.makeText(MainActivity.this, "Sign In Failed",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =(SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("Mainactivity", "onqueryTexChange"+newText);
                return true;
            }

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_search) {
            //return true;
        //}
        switch (item.getItemId()){
            case R.id.action_search:
                return true;
            case R.id.info:
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
//                Intent k = new Intent(MainActivity.this, MapsActivity.class);
//                startActivity(k);
                break;
            case R.id.button2:
                Intent j = new Intent(MainActivity.this, camActivity.class);
                startActivity(j);
                break;
            case R.id.button3:
                Intent i = new Intent(MainActivity.this, zombieMovies.class);
                startActivity(i);
                break;
            case R.id.button4:
                Intent l = new Intent(MainActivity.this, MapActivity.class);
                startActivity(l);
                break;
        }

    }
}
