package net.androidbootcamp.sars_and_stripes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    //VARIABLES
    TextView userNameProfile, firstNameProfile, lastNameProfile, emailProfile, phoneProfile, addressProfile;
    Button buttonChangePassword, buttonDelete;
    public static String mUserName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //REFERENCE ALL TEXTVIEWS ON THE PAGE THAT WILL BE UPDATED TO DISPLAY USER PROFILE INFO
        MyDBHandler myDBHandler = new MyDBHandler(Profile.this);
        userNameProfile = findViewById(R.id.userNameProfile);
        firstNameProfile = findViewById(R.id.firstNameProfile);
        lastNameProfile = findViewById(R.id.lastNameProfile);
        addressProfile = findViewById(R.id.addressProfile);
        phoneProfile = findViewById(R.id.phoneProfile);
        emailProfile = findViewById(R.id.emailProfile);
        //buttonChangePassword = (Button) findViewById(R.id.buttonChangePassword);  <<---- DELETE
        //buttonDelete = (Button) findViewById(R.id.buttonDelete);                  <<---- DELETE

        //USING A TRY CATCH HERE TO VERIFY THE DISPLAY DATA UPDATES WITHOUT BREAKING THE APP
        try{
            userNameProfile.setText(mUserName);
            firstNameProfile.setText(myDBHandler.getFName(mUserName));
            lastNameProfile.setText(myDBHandler.getLName(mUserName));
            addressProfile.setText(myDBHandler.getAddress(mUserName));
            phoneProfile.setText(myDBHandler.getPhone(mUserName));
            emailProfile.setText(myDBHandler.getEmail(mUserName));
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "no results found", Toast.LENGTH_LONG).show();
        }

        //CREATE ON CLICK FOR CHANGE PASSWORD BUTTON
        buttonChangePassword = findViewById(R.id.buttonChangePassword);
        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //need to create the change password page

            }
        }); //END OF CHANGE PASSWORD ONCLICK

        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //work on delet3e function within database and here!!!

            }
        }); //END OF DELETE BUTTON ONCLICK


    }//END ONCREATE

    // ---------------------- GET USERNAME & SET USERNAME --------------
    public String getUserName() {
        return mUserName;
    }

    public static void setUserName(String userName) {
        mUserName = userName;
    }

}//END PROFILE CLASS