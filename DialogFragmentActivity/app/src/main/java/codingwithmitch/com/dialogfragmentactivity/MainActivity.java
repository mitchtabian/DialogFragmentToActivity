package codingwithmitch.com.dialogfragmentactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnInputListener {

    private static final String TAG = "MainActivity";

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: got the input: " + input);

//        mInputDisplay.setText(input);
        mInput = input;

        setInputToTextView();
    }

    //widgets
    private Button mOpenDialog;
    public TextView mInputDisplay;

    //vars
    public String mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenDialog = findViewById(R.id.open_dialog);
        mInputDisplay = findViewById(R.id.input_display);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog.");

                MyCustomDialog dialog = new MyCustomDialog();
                dialog.show(getFragmentManager(), "MyCustomDialog");

            }
        });

    }

    private void setInputToTextView(){
        mInputDisplay.setText(mInput);
    }


}















