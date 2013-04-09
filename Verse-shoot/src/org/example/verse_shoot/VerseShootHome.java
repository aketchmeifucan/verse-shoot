package org.example.verse_shoot;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class VerseShootHome extends Activity {

	Button leftButton, rightButton, beamL, beamR;
	TextView lt, mt, rt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_shoot_home);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        beamL = (Button) findViewById(R.id.beamButtonl);
        beamR = (Button) findViewById(R.id.beamButtonr);
        lt = (TextView) findViewById(R.id.w1);
        mt = (TextView) findViewById(R.id.w2);
        rt = (TextView) findViewById(R.id.w3);
        leftButton.setOnClickListener(new OnClickListener ()
        {
        	public void onClick(View v)
        	{
        		CharSequence left = lt.getText();
        		lt.setText(mt.getText());
        		mt.setText(rt.getText());
        		rt.setText(left);
        		Toast msg = Toast.makeText(getBaseContext(), "Left Button",Toast.LENGTH_SHORT);
        		msg.show();
        	}
        });
        rightButton.setOnClickListener(new OnClickListener ()
        {
        	public void onClick(View v)
        	{
        		CharSequence right = rt.getText();
        		rt.setText(mt.getText());
        		mt.setText(lt.getText());
        		lt.setText(right);
        		Toast msg = Toast.makeText(getBaseContext(), "Right Button", Toast.LENGTH_SHORT);
        		msg.show();
        	}
        });
        beamL.setOnClickListener(new OnClickListener ()
        {
        	public void onClick(View v)
        	{
        		Toast msg = Toast.makeText(getBaseContext(), "BEAM!!", Toast.LENGTH_SHORT);
        		msg.show();
        	}
        });
        beamR.setOnClickListener(new OnClickListener ()
        {
        	public void onClick(View v)
        	{
        		Toast msg = Toast.makeText(getBaseContext(), "BEAM!!", Toast.LENGTH_SHORT);
        		msg.show();
        	}
        });
    }

 /*   private void addListenerOnButton() {
    	leftButton = (Button) findViewById(R.id.leftButton);	 
		leftButton.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
//				Toast.makeText(VerseShootHome.this,
//					"LeftButton is clicked!",
//					Toast.LENGTH_SHORT).show();
			}
		});		
	}*/

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_verse_shoot_home, menu);
        return true;
    }
    
}
