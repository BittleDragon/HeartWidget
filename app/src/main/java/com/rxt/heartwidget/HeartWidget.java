package com.rxt.heartwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Desc:心形控件
 *
 * @author raoxuting
 * since 2018/9/23
 */
public class HeartWidget extends View {

    /**
     * 外框线条宽度
     */
    public static final float PATH_WIDTH = 5f;
    /**
     * 线条画笔
     */
    private Paint mLinePaint;
    /**
     * 线条路径
     */
    private Path mLinePath;
    /**
     * 起点
     */
    public static final int[] START_POINT = new int[] {400, 200};
    /**
     * 左控制点1
     */
    public static final int[] LEFT_CONTROL_POINT1 = new int[] {200, 150};
    /**
     * 左控制点2
     */
    public static final int[] LEFT_CONTROL_POINT2 = new int[] {240, 240};
    /**
     * 右控制点1
     */
    public static final int[] RIGHT_CONTROL_POINT1 = new int[] {600, 150};
    /**
     * 右控制点2
     */
    public static final int[] RIGHT_CONTROL_POINT2 = new int[] {560, 240};
    /**
     * 底部端点
     */
    public static final int[] BOTTOM_POINT = new int[] {400, 350};
    private Path partPath;

    public HeartWidget(Context context) {
        this(context, null);
    }

    public HeartWidget(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeartWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int[][] line1PointArray = new int[][] {new int[] {}, };
        init();
    }

    private void init() {
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(PATH_WIDTH);
        mLinePaint.setColor(Color.CYAN);

        mLinePath = new Path();
        mLinePath.moveTo(START_POINT[0], START_POINT[1]);
        mLinePath.cubicTo(LEFT_CONTROL_POINT1[0], LEFT_CONTROL_POINT1[1],
                LEFT_CONTROL_POINT2[0], LEFT_CONTROL_POINT2[1],
                BOTTOM_POINT[0], BOTTOM_POINT[1]);
        mLinePath.cubicTo(RIGHT_CONTROL_POINT2[0], RIGHT_CONTROL_POINT2[1],
                RIGHT_CONTROL_POINT1[0], RIGHT_CONTROL_POINT1[1],
                START_POINT[0], START_POINT[1]);

        PathMeasure pathMeasure = new PathMeasure(mLinePath, true);
        partPath = new Path();
        pathMeasure.getSegment(0f,
                pathMeasure.getLength() * 0.5f, partPath, true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(mLinePath, mLinePaint);
        mLinePaint.setColor(Color.RED);
        canvas.drawPath(partPath, mLinePaint);

    }
}
