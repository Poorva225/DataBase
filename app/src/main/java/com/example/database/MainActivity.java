package com.example.database;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.database.data.MyDbHandler;
import com.example.database.model.Contact;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String tid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDbHandler db = new MyDbHandler(MainActivity.this);
        //adding contact to db
        Contact poorva = new Contact();
        poorva.setPhoneNumber("9090909090");
        poorva.setName("Poorva");

        // Adding a contact to the db
        db.addContact(poorva);

        // Creating a contact object for the db
        Contact larry = new Contact();
        larry.setPhoneNumber("9090459090");
        larry.setName("Larry");

        // Adding a contact to the db
        db.addContact(larry);

        // Creating a contact object for the db
        Contact tehri = new Contact();
        tehri.setPhoneNumber("9090675409");
        tehri.setName("Tehri");

        db.addContact(tehri);
        Log.d("dbpoorva", "Id for tehri and larry are successfully added to the db");


        tehri.setName("changed tehri");
        tehri.setPhoneNumber("928273737");
        int affesctedRows = db.updateContact(tehri);

        Log.d("dbpoorva", "No of affected rows are: " + tid);
       db.deleteContact(1);


        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact: allContacts){
            Log.d("dbpoorva", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n" + "Phone Number: " +
                    contact.getPhoneNumber() + "\n");
        }

        Log.d("dbpoorva", "bro uh have"+ db.getCount()+"contacts in your database");
    }
}