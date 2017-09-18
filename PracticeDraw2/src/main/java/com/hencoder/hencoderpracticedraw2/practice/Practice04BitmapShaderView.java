package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice04BitmapShaderView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bigBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    Bitmap smailBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman_120);

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader bigShader = new BitmapShader(bigBitmap,
                Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        Shader smailShader = new BitmapShader(smailBitmap,
                Shader.TileMode.MIRROR,
                Shader.TileMode.MIRROR);
        Shader smailShader2 = new BitmapShader(smailBitmap,
                Shader.TileMode.REPEAT,
                Shader.TileMode.REPEAT);
        paint.setShader(bigShader);

        canvas.drawCircle(200, 200, 200, paint);

        canvas.save();
        canvas.translate(0, 450);
        paint.setShader(smailShader);
        canvas.drawRect(100, 0, 1000, 400, paint);
        canvas.restore();


        canvas.save();
        canvas.translate(0, 900);
        paint.setShader(smailShader2);
        canvas.drawRect(100, 0, 1000, 400, paint);
        canvas.restore();
    }
}
