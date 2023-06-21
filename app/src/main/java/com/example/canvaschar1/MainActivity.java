package com.example.canvaschar1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImgView;
    Bitmap mBitmap;
    Canvas mCanvas;
    private int mColorBackground;
    Paint mCirclePaint = new Paint();
    Paint mHeadPaint = new Paint();
    Paint mLinePaint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImgView = findViewById(R.id.my_img_view);

        mCirclePaint.setColor(getResources().getColor(R.color.black));
        mHeadPaint.setColor(getResources().getColor(R.color.white));
        mLinePaint.setColor(getResources().getColor(R.color.black));

        mLinePaint.setStrokeWidth(18f);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int vWidth = mImgView.getWidth();
        int vHeight = mImgView.getHeight();

        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImgView.setImageBitmap(mBitmap);
        mColorBackground = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(mColorBackground);

        drawHead();
        drawRightEye();
        drawLeftEye();
        drawEyeConnector();

    }
    public void drawHead(){
        mCanvas.drawOval(250, 925, 800, 575, mHeadPaint);
    }
    public void drawRightEye(){
        int vWidth = mImgView.getWidth();
        mCanvas.drawCircle(400, 750, 40, mCirclePaint);

    }
    public void drawLeftEye(){
        int vWidth = mImgView.getWidth();
        mCanvas.drawCircle(650, 750, 40, mCirclePaint);
    }
    public void drawEyeConnector(){
        int vWidth = mImgView.getWidth();

        mCanvas.drawLine(650, 750, 400, 750, mLinePaint);
    }



}