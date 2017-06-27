package innopolis.fragmentexample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import innopolis.fragmentexample.R;

/**
 * Created by davlet on 6/27/17.
 */

public class MyFragment extends Fragment {
    private EditText editTextFragment;
    private Button buttonFragment;
    private TextView textViewFragment;
    private View.OnClickListener buttonClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_fragment,
                container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        editTextFragment = (EditText) getView().findViewById(R.id.editFragment);
        buttonFragment = (Button) getView().findViewById(R.id.buttonFragment);
        textViewFragment = (TextView) getView().findViewById(R.id.textFragment);
        buttonFragment.setOnClickListener(buttonClick);
//        textViewFragment.setText(getArguments().getString("key"));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        buttonClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewFragment.setText(editTextFragment.getText().toString());
            }
        };
    }
}
