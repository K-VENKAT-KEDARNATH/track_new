package com.example.trackntriggery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class dash extends AppCompatActivity {
    Button logout;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        logout=findViewById(R.id.logout);
        name =findViewById(R.id.name);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        GoogleSignInAccount signInAccount=GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null){
            name.setText("Signed in as: "+signInAccount.getDisplayName());
        }

        FirebaseDatabase.getInstance().getReference().child("track_data1").child("data1").setValue("NewDatat1");
        HashMap<String,Object>map=new HashMap<>();
        map.put("Kedar","pass");
        HashMap<String,Object> number=new HashMap<>();
        //map.put();
        FirebaseDatabase.getInstance().getReference().child("track2").updateChildren(map);

    }

}