package org.example.verse_shoot;

import java.lang.reflect.Array;

import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import org.example.verse_shoot.answerText;

//import org.example.verse_shoot.FlowLayout;

public class VerseShootHome extends Activity implements OnClickListener {
	
	ImageView leftButton, rightButton,lightBeam;
	Button beamL, beamR;
	TextView lt, mt, rt,la,ra;
	ArrayList<String> randWords;
	private static final String tag = "blah";
	public answerText answerText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verse_shoot_home);
    	Intent intent = getIntent();
    	String VERSE = intent.getStringExtra("VERSE");
    	String VERSE_TEXT = intent.getStringExtra("VERSE_TEXT");
    	System.out.println(VERSE);
    	System.out.println(VERSE_TEXT);
    	answerText = new answerText(VERSE,VERSE_TEXT);
    	String[] wordList = {"John","Mary","Jesus","God","Lord",
    			"Christ","Matthew","Judas","Peter","Paul"};
    	randWords = new ArrayList<String>(Arrays.asList(wordList));
//    	String verseString = "John 3:16" + "For God so loved the world, that " +
//    	    			"he gave his only Son, that whoever believes in him should not perish but have " +
//    	    			"eternal life.";
    	String verseString = VERSE + " " + VERSE_TEXT;
    	String[] verseArray = verseString.split("\\s+");
    	
    	Log.d(tag,"HELLO");
    	
    	ArrayList<TextView> wordViews = new ArrayList<TextView> ();
    	int wordCount = verseArray.length;
    	int currentWordIndex = 0;
        boolean[] hiddenWords = new boolean[wordCount];
        for (int i=0; i<wordCount; i++) {
        	hiddenWords[i] = false;
        }
        int numToFill = 5;
		for(int i = 0; i < numToFill; i++)		// Iterate each blank and fill it with a randomly selected index that does not already exist in filled strings
		{
			Random rand = new Random(); 
			int x = 1;
			while(x < 2 || hiddenWords[x]) {
				x = rand.nextInt(wordCount - 1);
			}
			hiddenWords[x] = true;
		}
        FlowLayout l = null;
        l = (FlowLayout) findViewById(R.id.flow_layout);
        if( l != null) {
        	Toast msg = Toast.makeText(getBaseContext(), verseArray[7],Toast.LENGTH_LONG);
     		msg.show();
        	// Create a TextView per word, set its text, and display it.
	        for (int i = 0; i < verseArray.length; i++) {
	        	TextView t = new TextView(this);
	        	wordViews.add(t);
	            t.setText(verseArray[i]);
	            t.setBackgroundColor(Color.WHITE);
	            if (hiddenWords[i]) {
	            	t.setTextColor(Color.WHITE);
	            } else {
	            	t.setTextColor(Color.BLACK);
	            }
	            
	            // padding: left, top, right, bottom
	            t.setPadding(10, 5, 10, 5);
	            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
	            t.setSingleLine(true);
	            t.setClickable(true);
	            final int locInverseArrayIndex = i;
		    	final int wordCountCopy = wordCount; 
//	            t.setOnClickListener(new OnClickListener() {
//	                @Override
//	                public void onClick(View v) {
//	    		    	boolean hidden = hiddenWords[locInverseArrayIndex];
//	    		    	// Don't process if not hidden
//	    		    	if(hidden) {
//		                    TextView tmp = (TextView) v;
//		    		    	String normalizedWord = normalizeString(verseArray[locInverseArrayIndex]);
//		    		    	
//		    		    	// If user clicked on a valid location
//		    		    	if(normalizedWord.equals(normalizeString((String)wordToTouchView.getText())) ){   
//		    		    		resetTryCount();
//		    		    		tmp.setTextColor(Color.BLACK);
//		    		    		hiddenWords[locInverseArrayIndex] = false;
//				    			currentWordIndex++;
//				    			if(currentWordIndex == wordCountCopy) {
//				    				// Finished last word
//			            			doneButton.setBackgroundColor(Color.parseColor("#00ffef"));
//			            			wordToTouchView.setBackgroundColor(Color.parseColor("#000000"));
//			            			wordToTouchView.setText("");
//				    			}
//				    			else if(currentWordIndex < wordCountCopy) {
//				    				// Else move to next word
//		    		    			wordToTouchView.setText(normalizeString(mixedWords[currentWordIndex]));
//		    		    		}
//		    		    	} else {
//		    		    		// Guessed location incorrectly and clicked on a hidden word. Check whether should show answer.
//		    		    		showIfExceedGuesses();
//		    		    	}
//	    		    	}

	//                }
	      //      });
	            l.addView(t, new FlowLayout.LayoutParams(5, 5));
	        }
        }
        
      
        
    	//answerText verseText = new answerText("John 3:16","For God so loved the world, that " +
    	//		"he gave his only Son, that whoever believes in him should not perish but have " +
    		//	"eternal life.");
        
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
        		lt.setText(answerText.currentWord());
        		break;
        	case 1:
        		mt.setText(answerText.currentWord());
        		break;
        	case 2:
        		rt.setText(answerText.currentWord());
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
                            }, 100);
                        }
                    }, 100);
                }
            }, 100);
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
                            }, 100);
                        }
                    }, 100);
                }
            }, 100);
    		break;
        case R.id.beamButtonl:
        		lightBeam.setVisibility(0);
        		if(mt.getText() == answerText.currentWord()) {
        			answerText.fillWord();
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
        	        		lt.setText(answerText.currentWord());
        	        		break;
        	        	case 1:
        	        		mt.setText(answerText.currentWord());
        	        		break;
        	        	case 2:
        	        		rt.setText(answerText.currentWord());
        	        		break;
        	        }
        			
        		}
        		else {
        			//play sound error
//        			MediaPlayer mp = MediaPlayer.create(Test.this, R.raw.mysound);
//                    mp.setOnCompletionListener(new OnCompletionListener() {
//
//                        //@Override
//                        public void onCompletion(MediaPlayer mp) {
//                            // TODO Auto-generated method stub
//                            mp.release();
//                        }
//
//                    });   
//                    mp.start();
        		}
        		lightBeam.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                 		lightBeam.setVisibility(4);
                    }
                }, 250);
        		break;
        case R.id.beamButtonr:
    		lightBeam.setVisibility(0);
    		if(mt.getText() == answerText.currentWord()) {
    			answerText.fillWord();
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
    	        		lt.setText(answerText.currentWord());
    	        		break;
    	        	case 1:
    	        		mt.setText(answerText.currentWord());
    	        		break;
    	        	case 2:
    	        		rt.setText(answerText.currentWord());
    	        		break;
    	        }
    			
    		}	
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
