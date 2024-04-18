package com.example.sireen_assignment1;



import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Display item details
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDetails = findViewById(R.id.tv_details);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("name") && intent.hasExtra("details")) {
            String name = intent.getStringExtra("name");
            String details = intent.getStringExtra("details");

            tvName.setText(  name);
            tvDetails.setText( details);
        }
    }
}
