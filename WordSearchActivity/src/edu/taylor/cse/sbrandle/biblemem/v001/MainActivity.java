package edu.taylor.cse.sbrandle.biblemem.v001;

import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	private static final String TAG = "Memorizer_MainActivity";
	 DatabaseCreator dbCreator;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set up click listeners for all the buttons
        try {
        	dbCreator		= new DatabaseCreator(getApplicationContext());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        View memorizeButton = findViewById(R.id.memorize_button);
        memorizeButton.setOnClickListener(this);
        View preferencesButton = findViewById(R.id.preferences_button);
        preferencesButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        
    }

    public void onClick(View v) {
    	Intent i = null;
    	int id = v.getId();
       if(id == R.id.memorize_button){
            Log.d(TAG, "clicked on memorizer");
        	i = new Intent(this, VerseChooser.class);
        	startActivity(i);
       }else if(id == R.id.preferences_button){
        	i = new Intent(this, Prefs.class);
        	startActivity(i);
       }else if(id ==R.id.about_button){
        	i = new Intent(this, About.class);
       }else if(id== R.id.exit_button){
        	finish();
        	
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	
    
}
