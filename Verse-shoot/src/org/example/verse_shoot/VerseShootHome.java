package org.example.verse_shoot;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VerseShootHome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_shoot_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_verse_shoot_home, menu);
        return true;
    }
    
}
