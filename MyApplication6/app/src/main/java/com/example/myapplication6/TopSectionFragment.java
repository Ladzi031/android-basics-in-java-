package com.example.myapplication6;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;

import androidx.annotation.Nullable;

public class TopSectionFragment extends Fragment{

    private static EditText topTextInput;
    private static EditText bottomTextInput;
    public interface TopSectionListener{
        void createMeme(String topText, String bottomText);
    }

    TopSectionListener activityCommander;

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        try{
            activityCommander = (TopSectionListener) childFragment;
        }catch (Exception e){
            Log.e(TopSectionFragment.class.getName(), "failed to cast fragment");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);
        topTextInput = view.findViewById(R.id.topTextInput);
        bottomTextInput = view.findViewById(R.id.bottomTextInput);
        final Button mybutton = view.findViewById(R.id.myButton);

        //lambda here
        mybutton.setOnClickListener( (view1) -> {
            activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
        });
        return view;
    }

}
