package codingwithmitch.com.dialogfragmentactivity;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by User on 12/10/2017.
 */

public class MyCustomDialog extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputListener{
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;

    //widgets
    private EditText mInput;
    private TextView mActionOk, mActionCancel;


    //vars

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_my_custom, container, false);
        mActionCancel = view.findViewById(R.id.action_cancel);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput = view.findViewById(R.id.input);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });


        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capturing input");

                String input = mInput.getText().toString();
//                if(!input.equals("")){
//
//                    //Easiest way: just set the value
//                    ((MainActivity)getActivity()).mInputDisplay.setText(input);
//
//                }

                //"Best Practice" but it takes longer
                mOnInputListener.sendInput(input);

                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage() );
        }
    }
}


















