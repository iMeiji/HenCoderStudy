package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice08SetTextSkewXView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder";

    {
        paint.setTextSize(60);
    }

    public Practice08SetTextSkewXView(Context context) {
        super(context);
    }

    public Practice08SetTextSkewXView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08SetTextSkewXView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 50, 100, paint);
        // 使用 Paint.setTextSkewX() 来让文字倾斜
        paint.setTextSkewX(-0.5f);
        canvas.drawText(text, 50, 300, paint);

        paint.setTextSkewX(-0.8f);
        canvas.drawText(text, 50, 500, paint);
    }
}
