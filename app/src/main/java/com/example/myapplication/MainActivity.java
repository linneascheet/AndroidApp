package com.example.myapplication;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enables edge-to-edge functionality to allow your content to extend under system bars
        EdgeToEdge.enable(this);

        // Set the content view for this activity
        setContentView(R.layout.activity_main);

        // Handle system insets (e.g., status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Apply padding to ensure content is not overlapped by system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Example: Show a Toast message when the app starts
        Toast.makeText(this, "Welcome to the app!", Toast.LENGTH_SHORT).show();
    }
}
