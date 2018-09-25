package by.it_academy.ad02_09_2018_class;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {


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
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()), paint);
        RectF rectF = new RectF();
        rectF.left = getWidth() * 0.1f;
        rectF.top = getHeight() * 0.2f;
        rectF.right = getWidth() - rectF.left;
        rectF.bottom = getHeight() - rectF.top;
        paint.setAntiAlias(true);

        Paint paint2 = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(rectF, paint2);


    }
}
