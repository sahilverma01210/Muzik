package com.example.sahil.muzik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;


public class list extends AppCompatActivity {
    public static final String My_Tag1="The_Custom_Message1";

    public int i,x;
    public static final String ya ="com.example.application.example.ya";
    private static final int[] idArray={R.id.butt1,R.id.butt2,R.id.butt3,R.id.butt4,R.id.butt5,R.id.butt6,R.id.butt7,R.id.butt8,R.id.butt9,R.id.butt10,R.id.butt11,R.id.butt12,R.id.butt13,R.id.butt14};
    private Button[] buttons=new Button[idArray.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(My_Tag1,"on_create1");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        for(i=0;i<idArray.length;i++)
        {
            buttons[i]=(Button) findViewById(idArray[i]);
        }
        for(int s=0;s<idArray.length;s++) {
            final int finalS = s;
            buttons[s].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(My_Tag1,"on_click1");
                    openNext(finalS);

                }

            });
        }

    }

    public void openNext(int I){
    Intent intent = new Intent(this, sound.class);
    //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    intent.putExtra(ya,I);

// set the new task and clear flags
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(My_Tag1,"on_start1");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(My_Tag1,"on_Resume1");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(My_Tag1,"on_Pause1");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(My_Tag1,"on_stop1");

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(My_Tag1,"on_destroy1");

    }

}
