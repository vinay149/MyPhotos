package com.example.vinay_thakur.myphotos;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.vinay_thakur.myphotos.R.drawable.abhi;

public class MainActivity extends AppCompatActivity implements Interface {
    GridView mgridView;
    List<String> songlist;
    ImageView mImageview;
    @Override
    public void setImage(Drawable img) {

    }
    Dialog nagDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songlist1();
        mgridView = (GridView) findViewById(R.id.gridview);
        mgridView.setAdapter(new CustomAdopter(this));
        mgridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int f=0;
                MediaPlayer mediaPlayer = null;
                // ImageView image = (ImageView) mgridView.getItemAtPosition(position);
                nagDialog = new Dialog(MainActivity.this,android.R.style.Theme_DeviceDefault_Panel);
                nagDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                nagDialog.setCancelable(false);
                nagDialog.setContentView(R.layout.full_image);
                //ImageView m=CustomAdopter.getImageView();
                mImageview=(ImageView)nagDialog.findViewById(R.id.iv_preview_image);
                view.findViewById(R.id.iv_preview_image);
                Log.d("hey12343","e"+mImageview);
                CustomAdopter c1=new CustomAdopter(MainActivity.this);
                mImageview.setImageResource(c1.getImage(position));
                nagDialog.show();

                switch (position) {
                    case 0:
                        Uri myUri =Uri.parse(songlist.get(0)); // initialize Uri here
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(), myUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer.start();
                        f=1;
                        break;
                    case 1:
                        Uri myUri1 =Uri.parse(songlist.get(1)); // initialize Uri here
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(), myUri1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer.start();
                        f=1;
                        break;
                    default:
                        Uri myUri2 =Uri.parse(songlist.get(position)); // initialize Uri here
                        mediaPlayer = new MediaPlayer();
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        try {
                            mediaPlayer.setDataSource(getApplicationContext(), myUri2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayer.start();
                        f=1;
                        break;
                }
            }
        });
    }
    private void songlist1() {
        songlist = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor == null) {
        } else if (!cursor.moveToFirst()) {
        } else {
            do {
                String fullPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                Log.e("Full Path : ", fullPath);
                songlist.add(fullPath);
            } while (cursor.moveToNext());
        }

        Log.d("heysimplifyandroid","w"+songlist);
        return;
    }

    @Override
    public void onBackPressed() {
        Log.d("ANKIT","ANKIT");
        super.onBackPressed();
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d("ANKIT", "ANKIT");
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            nagDialog.cancel();
            Log.d("ANKIT", "ANKIT");
        }
        return true;
    }

    @Override
    public Integer getImage(int pos) {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.filter,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.filter_this:
                Log.d("ankit","aNKIT");
                Intent i=new Intent(this,Pre.class);
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
            //break;

        }
    }

}
