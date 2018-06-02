package com.hencoder.hencoderpracticedraw7.practice.practice03;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.meiji.hencoderstudy.practicedraw7.R;


public class Practice03OfObjectLayout extends RelativeLayout {
    private static final String TAG = "Practice03OfObjectLayou";
    Practice03OfObjectView view;
    Button animateBt;

    public Practice03OfObjectLayout(Context context) {
        super(context);
    }

    public Practice03OfObjectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofObject(view, "position",
                        new PointFEvaluator(), new PointF(0, 0), new PointF(1, 1));
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(1000);
                animator.start();
            }
        });
    }

    private class PointFEvaluator implements TypeEvaluator<PointF> {
        PointF newPoint = new PointF();

        // 重写 evaluate() 方法，让 PointF 可以作为属性来做动画
        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (fraction * (endValue.x - startValue.x));
            float y = startValue.y + (fraction * (endValue.y - startValue.y));

            newPoint.set(x, y);
            Log.d(TAG, "evaluate: " + x + "  " + y);

            return newPoint;
        }
    }
}
