package com.example.hw2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            Message message = (Message) bundle.getSerializable("message");

            // Ensure the message object is not null
            if (message != null) {

                TextView Name = findViewById(R.id.name);
                TextView Text = findViewById(R.id.text);
                ImageView Avatar = findViewById(R.id.avatar);

                // Setting the image using Glide with a check for null
                if (message.Avatar != null) {
                    Glide.with(this).load(message.Avatar).into(Avatar);
                } else {
                    // Optionally set a default image if Avatar URL is null
                    Glide.with(this).load(R.drawable.default_avatar).into(Avatar);
                }


                Name.setText(message.Name != null ? message.Name : "Unknown Name");
                Text.setText(message.Text != null ? message.Text : "No message text available.");
            } else {


                finish();
            }
        } else {

            finish();
        }
    }
}
