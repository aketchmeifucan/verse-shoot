package edu.taylor.cse.sbrandle.biblemem.v001;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.View.OnTouchListener;

public class SearchGrid extends GridView implements  OnTouchListener{
  //private Listener mListener;
  
  Canvas gridCanvas;
  Paint paint;
  float downx = 0, downy = 0, upx = 0, upy = 0;
  View myView;

  public SearchGrid(Context context, AttributeSet attrs) {
    super(context, attrs);
    setOnTouchListener(this);
    myView = this;
    
  }

  @Override
protected void onDraw(Canvas canvas) {
	// TODO Auto-generated method stub
	super.onDraw(canvas);
	gridCanvas = canvas;
	paint = new Paint();
	paint.setColor(Color.GREEN);
    gridCanvas.drawLine(50, 60, 30, 8, paint);
}


  
public boolean onTouch(View v, MotionEvent event) {
	    int action = event.getAction();
	    Log.i("DRAING", "in SEARCHGRID");
	    switch (action) {
	    case MotionEvent.ACTION_DOWN:
	      downx = event.getX();
	      downy = event.getY();
	      
	      break;
	    case MotionEvent.ACTION_MOVE:
	    	  paint = new Paint();
		  	  paint.setColor(Color.GREEN);
		  	myView.postInvalidate();
		  	myView.invalidate();
		  	this.invalidate();
		  	this.postInvalidate();
		  	this.invalidateViews();
		  	v.invalidate();
		  	v.postInvalidate();
		  	v.refreshDrawableState();
		  	this.refreshDrawableState();
		  	myView.refreshDrawableState();
		  	
		  	
	      break;
	    case MotionEvent.ACTION_UP:
	      upx = event.getX();
	      upy = event.getY();
	      paint = new Paint();
	  	  paint.setColor(Color.GREEN);
	      gridCanvas.drawLine(downx, downy, upx, upy, paint);
	      
	      myView.postInvalidate();
		  	myView.invalidate();
		  	this.invalidate();
		  	this.postInvalidate();
		  	this.invalidateViews();
		  	v.invalidate();
		  	v.postInvalidate();
		  	v.refreshDrawableState();
		  	this.refreshDrawableState();
		  	myView.refreshDrawableState();
	      break;
	    case MotionEvent.ACTION_CANCEL:
	      break;
	    default:
	      break;
	    }
	    return true;
	  }


}