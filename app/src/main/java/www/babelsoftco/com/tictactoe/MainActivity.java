package www.babelsoftco.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.babelsoftco.R;


// 0 = yellow , 1 = red
    public class MainActivity extends AppCompatActivity {
        private static int SPLASH_TIME_OUT = 4000;

    int actveplayer = 0;

    boolean gameIsActive = true;

    // 2 means unplayed

    int[] GameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winwingpostion = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        //System.out.println(counter.getTag().toString());

        int tapcounter = Integer.parseInt(counter.getTag().toString());

        if (GameState[tapcounter] == 2 && gameIsActive) {

            GameState[tapcounter] = actveplayer;

            counter.setTranslationY(-1000f);


            if (actveplayer == 0) {

                counter.setImageResource(R.drawable.yellow);
               // counter.setImageResource(www.babelsoftco.com.tictactoe.R.drawable.yellow);
                actveplayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                //counter.setImageResource(www.babelsoftco.com.tictactoe.R.drawable.red);
                actveplayer = 0;
            }


            counter.animate().translationYBy(1000f).rotation(360).setDuration(360);

            for (int[] winningPosition : winwingpostion) {

                if (GameState[winningPosition[0]] == GameState[winningPosition[1]] &&
                        GameState[winningPosition[1]] == GameState[winningPosition[2]] &&
                        GameState[winningPosition[0]] != 2) {

                    // Someone has won!
                    gameIsActive = false;

                    String winner = "Red";

                    if (GameState[winningPosition[0]] == 0) {

                        winner = "Yellow";
                    }

                    // System.out.println(GameState.[winningPosition[0]]);
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage)


                    winnerMessage.setText(winner + " has won!");

                     LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                 //   LinearLayout layout = (LinearLayout) findViewById(www.googel.com.tictactoe.R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);
                } else {

                    boolean gameIsOver = true;

                    for (int counterState : GameState) {

                        if (counterState == 2) gameIsOver = false;

                    }

                    if (gameIsOver) {
                         TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                       // TextView winnerMessage = (TextView) findViewById(www.googel.com.tictactoe.R.id.winnerMessage);

                        winnerMessage.setText("It's a draw");

                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                        //  LinearLayout layout = (LinearLayout) findViewById(www.googel.com.tictactoe.R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);

                    }
                }
            }
        }
    }

    public void playAgain(View view) {

        gameIsActive = true;
           LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
     //   LinearLayout layout = (LinearLayout) findViewById(www.babelsoftco.com.tictactoe.R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        actveplayer = 0;

        for (int i = 0; i < GameState.length; i++) {

            GameState[i] = 2;

        }
           GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        // GridLayout gridLayout = (GridLayout) findViewById(www.babelsoftco.com.tictactoe.R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(www.babelsoftco.com.tictactoe.R.layout.activity_main);
        setContentView(R.layout.activity_main);



    }
}
