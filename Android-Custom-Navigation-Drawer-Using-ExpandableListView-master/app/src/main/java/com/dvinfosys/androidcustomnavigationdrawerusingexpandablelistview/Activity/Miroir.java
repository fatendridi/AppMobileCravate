package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Miroir extends Activity {
    private ViewGroup mainLayout;
    private ImageView imageTranslate;
    private int xDelta;
    private int yDelta;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miroir);
        mainLayout = (RelativeLayout) findViewById(R.id.main);
        imageTranslate = (ImageView) findViewById(R.id.image);


        imageTranslate.setOnTouchListener(onTouchListener());

        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        imageView = (ImageView) findViewById(R.id.imageView);

        Button btnenregistrer = (Button) findViewById(R.id.btnenregistrer);
        btnenregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap pic = takeScreenshot(mainLayout);
                        try {
                            if (pic != null){
                                saveScreenShot(pic);
                            }

                        }catch (Exception e ){
                            e.printStackTrace();
                        }
                    }
                });

            }
        });



        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent , 0);
            }
        });

    }
    //mettre l'image capturer dans l'activité
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }
    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:

                        break;


                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }

                mainLayout.invalidate();
                return true;
            }




        } ;
    }

    // capture d'image
    public static Bitmap takeScreenshot(View v){

        Bitmap screenShot = null;
        try {
            int width =v.getMeasuredWidth();
            int height = v.getMeasuredHeight();
            screenShot=Bitmap.createBitmap(width , height ,Bitmap.Config.ARGB_8888);

            //Draw To Convas
            Canvas c = new Canvas(screenShot);
            v.draw(c);
        }catch (Exception e){
            e.printStackTrace();
        }
        return screenShot;
    }

    //save to External storage
    private void saveScreenShot(Bitmap bm){

        ByteArrayOutputStream bao = null;
        File file = null;

        try{

            //Compress and write to  output stream
            bao = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG , 40 ,bao );

            //write AS a FILE To sd CARD

            file= new File(Environment.getExternalStorageDirectory()+File.separator+"player.png");
            file.createNewFile();
            FileOutputStream  fos = new FileOutputStream(file);
            fos.write(bao.toByteArray());
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }





}