package com.example.sahil.muzik;

import android.content.Intent;
        import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Service;
        import android.widget.Button;
import android.widget.TextView;

import com.example.sahil.muzik.R;

public class sound extends AppCompatActivity implements View.OnClickListener {
    public static final String My_Tag="The_Custom_Message";
    //Bundle bundle=getIntent().getExtras();
    int x;
    Button play,pause,stop;
    private static final int[] idA={R.raw.castle,R.raw.roll,R.raw.some,R.raw.monster,R.raw.rapgod,R.raw.ashiq_tera,R.raw.bhoolbhulaiya,R.raw.dhokadhadi,R.raw.khaab,R.raw.mitwa,R.raw.noorekhuda,R.raw.rangde,R.raw.castleofglass,R.raw.animals};
    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;
    //public int p=getIntent().getIntExtra("ya",0);

    String[] name={"Castle","Roll","Some","Monster","Rap God","Aashiq Tera","Bhool Bhulaiyaa","Dhokha Dhadi","Khaab","Mitwa","Noore Khuda","Rang De","Castle of Glass","Animals"};
    TextView song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(My_Tag,"on_create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound);
        song=(TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        int p=intent.getIntExtra(list.ya,0);//getIntent().getIntExtra("ya",0);
        song.setText(name[p]);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        x=p;






        mediaPlayer=MediaPlayer.create(getApplicationContext(),idA[p]);
        mediaPlayer.start();


        play=(Button) findViewById(R.id.btn_play);
        pause=(Button) findViewById(R.id.btn_pause);
        stop=(Button) findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        //Log.i(My_Tag,"on_click");

        //int p= bundle.getInt("ya");
        //private static final int[] id={R.raw.roll,R.raw.castle};
        switch (view.getId()){
            case R.id.btn_play:
               if(mediaPlayer==null){
                    mediaPlayer=MediaPlayer.create(getApplicationContext(),idA[x]);
                    mediaPlayer.start();}
                else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pauseCurrentPosition);
                    mediaPlayer.start();
                }



                break;
            case R.id.btn_pause:
                if(mediaPlayer!=null){
                    mediaPlayer.pause();
                    pauseCurrentPosition=mediaPlayer.getCurrentPosition();

                }
                break;
            case R.id.btn_stop:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;
        }
    }

    @Override
    public void onBackPressed ()
    {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        super.onBackPressed();
    }
    @Override
    public void onPause ()
    {
        if (mediaPlayer!= null)
        {
            mediaPlayer.pause();
            mediaPlayer.stop();
        }
        super.onPause();
        Log.i(My_Tag,"on_Pause");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(My_Tag,"on_start");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(My_Tag,"on_Resume");

    }


    @Override
    protected void onStop(){
        super.onStop();
        Log.i(My_Tag,"on_stop");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(My_Tag,"on_destroy");

    }
}
