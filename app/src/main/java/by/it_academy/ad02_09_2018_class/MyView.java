package by.it_academy.ad02_09_2018_class;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;

public class MyView extends View {
    private Paint paint = new Paint();
    private OnMyViewOnClickListener listener;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        float radius = Math.min(getWidth() / 2, getHeight() / 2);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth() / 2, getHeight() / 2), paint);
        float xEdge = getHeight() / 2 - radius;
        float xLine = getWidth() / 2;
        float yStartLine = xEdge * 0.9f;
        float yEndLine = xEdge * 1.1f;

        float step = 360 / 12;
        Paint paintLine = new Paint();
        paintLine.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintLine);
        canvas.save();
        for (int i = 0; i < 11; i++) {
            canvas.rotate(step, getWidth() / 2, getHeight() / 2);
            canvas.drawLine(xLine, yStartLine, xLine, yEndLine, paintLine);
        }
        canvas.restore(); //change rotate to canvas.save

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);

        canvas.save();
        canvas.rotate(step * hour + step / 60 * minutes, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(xLine, getHeight() / 2, xLine, getHeight() / 2 - radius / 2, paintLine);
        canvas.restore(); //change rotate to canvas.save
//посекундный invalidate? в отдельный поток

//        RectF rectF = new RectF();
//        rectF.left = getWidth() * 0.1f;
//        rectF.top = getHeight() * 0.2f;
//        rectF.right = getWidth() - rectF.left;
//        rectF.bottom = getHeight() - rectF.top;
//        paint.setAntiAlias(true);

//        canvas.drawRect(rectF, paintLine);


    }


    public void setListener(OnMyViewOnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){
//            Log.e("AAA","Action down");
            return true;
        } else if (event.getAction()==MotionEvent.ACTION_UP){
            return true;

        } else if (event.getAction()==MotionEvent.ACTION_MOVE){
            return true;

        }



        return super.onTouchEvent(event);
    }


    interface OnMyViewOnClickListener{
        void onClick();
    }
}
