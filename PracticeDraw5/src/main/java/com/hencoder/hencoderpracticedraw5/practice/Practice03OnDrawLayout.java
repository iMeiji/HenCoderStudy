package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class Practice03OnDrawLayout extends LinearLayout {
    private static final String TAG = "Practice03OnDrawLayout";
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Pattern pattern = new Pattern();

    {
        // 在这里插入 setWillNotDraw(false) 以启用完整的绘制流程
        /**
         * 出于效率的考虑，ViewGroup 默认会绕过 draw() 方法，换而直接执行 dispatchDraw()，以此来简化绘制流程。
         * 所以如果你自定义了某个 ViewGroup 的子类（比如 LinearLayout）
         * 并且需要在它的除  dispatchDraw() 以外的任何一个绘制方法内绘制内容，
         * 你可能会需要调用 View.setWillNotDraw(false) 这行代码来切换到完整的绘制流程
         * （是「可能」而不是「必须」的原因是，有些 ViewGroup 是已经调用过 setWillNotDraw(false) 了的，例如 ScrollView）。
         */
        setWillNotDraw(false);
    }

    public Practice03OnDrawLayout(Context context) {
        super(context);
    }

    public Practice03OnDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OnDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: 启用完整的绘制流程");
        pattern.draw(canvas);
    }

    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;

        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Practice03OnDrawLayout.Pattern.Spot[] spots;

        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }

        private Pattern() {
            spots = new Practice03OnDrawLayout.Pattern.Spot[4];
            spots[0] = new Practice03OnDrawLayout.Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Practice03OnDrawLayout.Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Practice03OnDrawLayout.Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Practice03OnDrawLayout.Pattern.Spot(0.62f, 0.78f, 0.083f);
        }

        private Pattern(Practice03OnDrawLayout.Pattern.Spot[] spots) {
            this.spots = spots;
        }

        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Practice03OnDrawLayout.Pattern.Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }

        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;

            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
