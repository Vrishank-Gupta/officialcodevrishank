package com.mandeep.officialcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mandeep.officialcode.Vrishank.LoginActivity_Vr;

/**
 * Created by Mandeepsingh on 3/1/2018.
 */

public class profileuser extends AppCompatActivity implements View.OnClickListener {
    Button b;
    String username;
    TextView nammi;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    public static final String TAG = "Home";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.profile);
            //nammi=(TextView)findViewById(R.id.conman);
            Bundle bundle = getIntent().getExtras();
            username = bundle.getString("PersonName");
            b=(Button)findViewById(R.id.button2);
            b.setOnClickListener(this);
        setupFirebaseAuth();

    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(profileuser.this,MapsActivity.class);
        i.putExtra("PersonName",username);
        startActivity(i);
    }

    private void setupFirebaseAuth()
    {
        Log.d(TAG, "setupFirebaseAuth: setting up firebase auth");
        auth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                checkCurrentUser(user);
                if(user != null)
                {
                    Log.d(TAG, "onAuthStateChanged: signed In" + user.getUid());
                }
                else
                {
                    Log.d(TAG, "onAuthStateChanged: SignedOut");
                }
            }
        };
    }

    private void checkCurrentUser(FirebaseUser user)
    {
        Log.d(TAG, "checkCurrentUser: Check if logged in");
        if(user == null)
        {
            Log.d(TAG, "checkCurrentUser: no user");
            Intent intent = new Intent(getApplicationContext(), LoginActivity_Vr.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
        checkCurrentUser(auth.getCurrentUser());
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authStateListener);
    }
}
