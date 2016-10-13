package com.example.swathi.communicationbetweenfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Switch;


/**
 * Created by user on 10/13/2016.
 */

public class ColorFragment extends Fragment {

    RadioGroup radioGroup;

    OnColorChangeListener onColorChangeListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_fragment_layout,container,false);

        radioGroup = (RadioGroup) view.findViewById(R.id.color_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.red_id:
                        onColorChangeListener.colorChanged("RED");
                        break;
                    case R.id.green_id:
                        onColorChangeListener.colorChanged("GREEN");
                        break;
                    case R.id.blue_id:
                        onColorChangeListener.colorChanged("BLUE");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onColorChangeListener = (OnColorChangeListener) context;
    }

    public interface OnColorChangeListener
    {
        public void colorChanged(String color_name);
    }
}
