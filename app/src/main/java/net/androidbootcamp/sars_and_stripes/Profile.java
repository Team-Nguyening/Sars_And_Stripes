package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;

public class Profile extends AppCompatActivity {

    TextView userNameProfile, firstNameProfile, lastNameProfile, emailProfile, phoneProfile, addressProfile;
     String userName;
    UserInfo userInfo;
    MyDBHandler myDBHandler = new MyDBHandler(Profile.this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstNameProfile = (TextView) findViewById(R.id.firstNameProfile);


        firstNameProfile.setText(myDBHandler.find_firstName(userName));
        /*lastNameProfile = (TextView)  findViewById(R.id.lastNameProfile);
        userNameProfile = (TextView) findViewById(R.id.userNameProfile);
        emailProfile = (TextView) findViewById(R.id.emailProfile);
        phoneProfile = (TextView)  findViewById(R.id.phoneProfile);
        addressProfile = (TextView) findViewById(R.id.addressProfile);*/






    }

    public void getProfileUsername(String uInfo){
        userName = uInfo;
    }





}