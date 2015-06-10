package com.example.priyakarambelkar.paintapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    Button palette;
    RadioGroup colors;
    public boolean visible = false;
    private DrawableViewClass drawableView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
               View view = inflater.inflate(R.layout.fragment_main, container, false);
        initialiseParameters(view);
        palette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setColorVisible();
                if (visible) {
                    setColorInvisible(v);
                }
                else if (!visible) {
                    setColorVisible(v);
                }
            }
        });
        return view;
    }

    private void initialiseParameters(View view) {
        palette = (Button) view.findViewById(R.id.button);
        drawableView = (DrawableViewClass) view.findViewById(R.id.drawCustomView);
        colors = (RadioGroup)view.findViewById(R.id.radio_group);
        colors.setVisibility(View.INVISIBLE);

    }

    private void setColorVisible(View view) {
        colors.setVisibility(View.VISIBLE);
        visible = true;
    }

   public void setColorInvisible(View view){
       colors.setVisibility(View.INVISIBLE);
       visible = false;
   }
}
