package org.example.verse_shoot;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class VerseShootHome extends Activity {

	Button leftButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_shoot_home);
        addListenerOnButton();
    }

    private void addListenerOnButton() {
    	leftButton = (Button) findViewById(R.id.leftButton);	 
		leftButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				Toast.makeText(VerseShootHome.this,
					"LeftButton is clicked!",
					Toast.LENGTH_SHORT).show();
			}
		});		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_verse_shoot_home, menu);
        return true;
    }
    
}
