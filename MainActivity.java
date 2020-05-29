package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;
import android.util.Log;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="Whack-A-Mole!";
    private Button b1;
    private Button b2;
    private Button b3;
    private TextView score;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        score=(TextView)findViewById(R.id.textView);

        b1.setOnClickListener(clicked);
        b2.setOnClickListener(clicked);
        b3.setOnClickListener(clicked);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        setNewMole();

        Log.v(TAG, "Starting GUI!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"restarted");
    }

    public void setNewMole() {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            b1.setText("*");
            b2.setText("O");
            b3.setText("O");
        }
        else if (randomLocation == 1){
            b1.setText("O");
            b2.setText("*");
            b3.setText("O");
        }
        else{
            b1.setText("O");
            b2.setText("O");
            b3.setText("*");
        }
    }

    public void scoreCount(View v){
        Button view = (Button) v;
        if (view.getText() == "*"){
            count += 1;
            score.setText(String.valueOf(count));
            Log.d(TAG, "Hit, score added!");
        }
        else {
            count -= 1;
            score.setText(String.valueOf(count));
            Log.d(TAG, "Missed, score deducted!");
        }
    }

    private View.OnClickListener clicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == b1.getId()){
                Log.d(TAG,"Button Right Clicked!");
            }
            else if (v.getId() == b2.getId()){
                Log.d(TAG,"Button Centre Clicked!");
            }
            else{
                Log.d(TAG,"Button Left Clicked!");
            }
            scoreCount(v);
            setNewMole();
        }
    };
}
