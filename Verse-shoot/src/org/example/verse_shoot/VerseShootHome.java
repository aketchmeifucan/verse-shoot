package org.example.verse_shoot;

import java.lang.reflect.Array;
import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class VerseShootHome extends Activity implements OnClickListener {
	
	ImageView leftButton, rightButton,lightBeam;
	Button beamL, beamR;
	TextView lt, mt, rt,la,ra;
	ArrayList<String> randWords;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	String[] wordList = {"John","Mary","Jesus","God","Lord",
    			"Christ","Matthew","Judas","Peter","Paul"};
    	randWords = new ArrayList<String>(Arrays.asList(wordList));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_shoot_home);
        //leftButton = (Button) findViewById(R.id.leftButton);
        leftButton = (ImageView) findViewById(R.id.leftButton);
        leftButton.setOnClickListener(this);
        rightButton = (ImageView) findViewById(R.id.rightButton);
        rightButton.setOnClickListener(this);
        lightBeam = (ImageView) findViewById(R.id.lightBeam);
        beamL = (Button) findViewById(R.id.beamButtonl);
        beamL.setOnClickListener(this);
        beamR = (Button) findViewById(R.id.beamButtonr);
        beamR.setOnClickListener(this);
        lt = (TextView) findViewById(R.id.w1);
        mt = (TextView) findViewById(R.id.w2);
        rt = (TextView) findViewById(R.id.w3);
        Random rand = new Random();
        int lRand = rand.nextInt(randWords.size() - 1);
        lt.setText(randWords.get(lRand));
        randWords.remove(lRand);
        randWords.trimToSize(); 
        int mRand = rand.nextInt(randWords.size() - 1);
        mt.setText(randWords.get(mRand));
        randWords.remove(mRand);
        randWords.trimToSize();
        int rRand = rand.nextInt(randWords.size() - 1);
        rt.setText(randWords.get(rRand));
        randWords.remove(rRand);
        randWords.trimToSize();
        switch(rand.nextInt(3)) {
        	case 0:
        		lt.setText("FROMVERSE");
        		break;
        	case 1:
        		mt.setText("FROMVERSE");
        		break;
        	case 2:
        		rt.setText("FROMVERSE");
        		break;
        }
        la = (TextView) findViewById(R.id.leftAnim);
        ra = (TextView) findViewById(R.id.rightAnim);
    }
    
    @Override
    public void onClick (View v) {
    	switch (v.getId()) {
        case R.id.leftButton:
        	la.setText("        --");
            ra.setText("        --");
        	la.setVisibility(0);
        	ra.setVisibility(0);
        	la.postDelayed(new Runnable() {
                @Override
                public void run() {
                    la.setText("    --    ");
                    ra.setText("    --    ");
                    la.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        	la.setText("--        ");  
                        	ra.setText("--        ");  
                        	CharSequence left = lt.getText();
                     		lt.setText(mt.getText());
                     		mt.setText(rt.getText());
                     		rt.setText(left);
                     		//Toast msg = Toast.makeText(getBaseContext(), "Left Button",Toast.LENGTH_SHORT);
                     		//msg.show();
                     		la.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                             		la.setVisibility(4);
                             		ra.setVisibility(4);
                                }
                            }, 250);
                        }
                    }, 250);
                }
            }, 250);
    		break;
        case R.id.rightButton:
        	la.setText("--        ");  
        	ra.setText("--        ");
        	la.setVisibility(0);
        	ra.setVisibility(0);
        	la.postDelayed(new Runnable() {
                @Override
                public void run() {
                    la.setText("    --    ");
                    ra.setText("    --    ");
                    la.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        	la.setText("        --");
                            ra.setText("        --");
                        	CharSequence right = rt.getText();
                    		rt.setText(mt.getText());
                    		mt.setText(lt.getText());
                    		lt.setText(right);
                    		//Toast msg = Toast.makeText(getBaseContext(), "Right Button", Toast.LENGTH_SHORT);
                    		//msg.show();
                     		la.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                             		la.setVisibility(4);
                             		ra.setVisibility(4);
                                }
                            }, 250);
                        }
                    }, 250);
                }
            }, 250);
    		break;
        case R.id.beamButtonl:
        		lightBeam.setVisibility(0);
        		lightBeam.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                 		lightBeam.setVisibility(4);
                    }
                }, 250);
        		break;
        case R.id.beamButtonr:
    		lightBeam.setVisibility(0);
    		lightBeam.postDelayed(new Runnable() {
                @Override
                public void run() {
             		lightBeam.setVisibility(4);
                }
            }, 250);
    		break;
    	}
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_verse_shoot_home, menu);
        return true;
    }
    
}
