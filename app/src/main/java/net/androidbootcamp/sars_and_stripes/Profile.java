package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
<<<<<<< HEAD

import org.w3c.dom.Text;

import java.nio.charset.StandardCharsets;
=======
import android.widget.Toast;
>>>>>>> 3f717fa7cf3ddf7bc49bbd154a89890130d2a218

public class Profile extends AppCompatActivity {
    //REFERENCE ALL TEXT FIELDS
    TextView userNameProfile, firstNameProfile, lastNameProfile, emailProfile, phoneProfile, addressProfile;
    //TextView editTextTextPersonName;
    String mUserName;


    TextView userNameProfile, firstNameProfile, lastNameProfile, emailProfile, phoneProfile, addressProfile;
     String userName;
    UserInfo userInfo;
    MyDBHandler myDBHandler = new MyDBHandler(Profile.this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

<<<<<<< HEAD
        firstNameProfile = (TextView) findViewById(R.id.firstNameProfile);


        firstNameProfile.setText(myDBHandler.find_firstName(userName));
=======
        MyDBHandler myDBHandler = new MyDBHandler(Profile.this);
        firstNameProfile = (TextView) findViewById(R.id.firstNameProfile);

        try{
            firstNameProfile.setText(myDBHandler.getFName(mUserName));
            //Toast.makeText(getApplicationContext(), "no results found", Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "no results found", Toast.LENGTH_LONG).show();
        }
        //firstNameProfile.setText(myDBHandler.getFName(mUserName));
>>>>>>> 3f717fa7cf3ddf7bc49bbd154a89890130d2a218
        /*lastNameProfile = (TextView)  findViewById(R.id.lastNameProfile);
        userNameProfile = (TextView) findViewById(R.id.userNameProfile);
        emailProfile = (TextView) findViewById(R.id.emailProfile);
        phoneProfile = (TextView)  findViewById(R.id.phoneProfile);
        addressProfile = (TextView) findViewById(R.id.addressProfile);*/


<<<<<<< HEAD




    }

    public void getProfileUsername(String uInfo){
        userName = uInfo;
    }





}
=======
    }//END ONCREATE

    // ---------------------- GETTERS AND SETTERS --------------
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        this.mUserName = userName;
    }

    public TextView getUserNameProfile() {
        return userNameProfile;
    }

    public void setUserNameProfile(TextView userNameProfile) {
        this.userNameProfile = userNameProfile;
    }

    public TextView getFirstNameProfile() {
        return firstNameProfile;
    }

    public void setFirstNameProfile(TextView firstNameProfile) {
        this.firstNameProfile = firstNameProfile;
    }

    public TextView getLastNameProfile() {
        return lastNameProfile;
    }

    public void setLastNameProfile(TextView lastNameProfile) {
        this.lastNameProfile = lastNameProfile;
    }

    public TextView getEmailProfile() {
        return emailProfile;
    }

    public void setEmailProfile(TextView emailProfile) {
        this.emailProfile = emailProfile;
    }

    public TextView getPhoneProfile() {
        return phoneProfile;
    }

    public void setPhoneProfile(TextView phoneProfile) {
        this.phoneProfile = phoneProfile;
    }

    public TextView getAddressProfile() {
        return addressProfile;
    }

    public void setAddressProfile(TextView addressProfile) {
        this.addressProfile = addressProfile;
    }
}//END PROFILE CLASS
>>>>>>> 3f717fa7cf3ddf7bc49bbd154a89890130d2a218
