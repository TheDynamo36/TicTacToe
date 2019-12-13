package com.example.gaurav_sharma.tictactoe;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main_TicTacToe extends AppCompatActivity {
   int activePlayer = 0;
    //0 for Cross and 1 for Circle
    //Initial Game State
    int[] GameState = {2,2,2,2,2,2,2,2,2};

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;


    int playerText;

    public void imageTapped(View view) {
        ImageView myTapped = (ImageView) view;
        TextView message = (TextView) findViewById(R.id.playerNumber);

  //      Log.i("tag","Image number is " + myTapped.getTag().toString());
        int imageTag = Integer.parseInt(myTapped.getTag().toString());

        if(GameState[imageTag] == 2) {
            if (activePlayer == 0) {
                myTapped.animate().rotationBy(360).setDuration(500);
                mediaPlayer2.start();
                myTapped.setImageResource(R.drawable.cross);

                GameState[imageTag] = activePlayer;



                if(     GameState[0] == activePlayer && GameState[1] == activePlayer && GameState[2] == activePlayer ||
                        GameState[3] == activePlayer && GameState[4] == activePlayer && GameState[5] == activePlayer ||
                        GameState[6] == activePlayer && GameState[7] == activePlayer && GameState[8] == activePlayer ||
                        GameState[0] == activePlayer && GameState[3] == activePlayer && GameState[6] == activePlayer ||
                        GameState[1] == activePlayer && GameState[4] == activePlayer && GameState[7] == activePlayer ||
                        GameState[2] == activePlayer && GameState[5] == activePlayer && GameState[8] == activePlayer ||
                        GameState[0] == activePlayer && GameState[4] == activePlayer && GameState[8] == activePlayer ||
                        GameState[2] == activePlayer && GameState[4] == activePlayer && GameState[6] == activePlayer )
                {

                    playerText = activePlayer+1;
                    message.setText("WooHoo!!\nPlayer "+playerText + " Won");
                    mediaPlayer.start();
                    Button b1 = (Button) findViewById(R.id.button);
                    b1.performClick();

                }else {
                    activePlayer = 1;
                     playerText = activePlayer+1;
                    message.setText("Player " + playerText + " Turn");

                }


            } else {
                myTapped.animate().rotationYBy(360);
                mediaPlayer2.start();
                myTapped.setImageResource(R.drawable.circle);
                GameState[imageTag] = activePlayer;
                if(     GameState[0] == activePlayer && GameState[1] == activePlayer && GameState[2] == activePlayer ||
                        GameState[3] == activePlayer && GameState[4] == activePlayer && GameState[5] == activePlayer ||
                        GameState[6] == activePlayer && GameState[7] == activePlayer && GameState[8] == activePlayer ||
                        GameState[0] == activePlayer && GameState[3] == activePlayer && GameState[6] == activePlayer ||
                        GameState[1] == activePlayer && GameState[4] == activePlayer && GameState[7] == activePlayer ||
                        GameState[2] == activePlayer && GameState[5] == activePlayer && GameState[8] == activePlayer ||
                        GameState[0] == activePlayer && GameState[4] == activePlayer && GameState[8] == activePlayer ||
                        GameState[2] == activePlayer && GameState[4] == activePlayer && GameState[6] == activePlayer )
                {

                    playerText = activePlayer+1;
                    message.setText("WooHoo!!\nPlayer "+playerText + " Won");
                    mediaPlayer.start();
                    Button b1 = (Button) findViewById(R.id.button);
                    b1.performClick();
                }
                else {
                    activePlayer = 0;
                    playerText = activePlayer+1;
                    message.setText("Player "+playerText+" Turn");

                }
            }

        }else {
            Log.i("tap","Already tapped");
            message.setText("Oops! Already tapped");

        }
    }

    // PLAY AGIN :)
    public void playAgain(View view) {

        //Reset active player
        activePlayer = 0;
        //Reset GameState
        for(int i =0 ; i < GameState.length ; i++){
            GameState[i] = 2;
        }
        //Reset Images

        LinearLayout linearlayout1 = (LinearLayout) findViewById(R.id.l1);
        for(int i = 0 ; i < linearlayout1.getChildCount() ; i++) {
            ((ImageView)linearlayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
        LinearLayout linearlayout2 = (LinearLayout) findViewById(R.id.l2);
        for(int i = 0 ; i < linearlayout2.getChildCount() ; i++) {
            ((ImageView)linearlayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
        LinearLayout linearlayout3 = (LinearLayout) findViewById(R.id.l3);
        for(int i = 0 ; i < linearlayout3.getChildCount() ; i++) {
            ((ImageView)linearlayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher_round);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__tic_tac_toe);
         mediaPlayer = MediaPlayer.create(this,R.raw.winning);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.tap);

    }
}
