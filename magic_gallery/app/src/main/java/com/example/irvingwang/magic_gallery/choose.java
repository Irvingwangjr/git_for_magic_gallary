package com.example.irvingwang.magic_gallery;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class choose extends AppCompatActivity {
    private static final String TAG = "choose";
    private static final int REQUEST_CODE_SELECT_PHOTO=1;
    ImageView select;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == MainActivity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_SELECT_PHOTO: {
                    // 获取图片
                    try {
                        Uri image_uri=data.getData();
                        if (image_uri!=null){
                            Intent in1 = new Intent(this, generate.class);
                            in1.putExtra("picture",image_uri.toString());
                            startActivity(in1);
                            Log.d(TAG, "onActivityResult: start");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdesign_test);
        select=(ImageView)findViewById(R.id.choose_photo);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打开相册或者相机
                Intent intent = new Intent();
                intent.setType("image/*");// 开启Pictures画面Type设定为image
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_SELECT_PHOTO );
            }
        });
    }

}
