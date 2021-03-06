package com.example.kennethallan.fragmenttutorial;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_02 extends Fragment {


    private SeekBar seekbar01;
    private SeekBar seekbar02;
    SeekBar.OnSeekBarChangeListener mlistener;
    List<Integer> testList = new ArrayList<>();

    Fragment_02.interface_Frag02 sendValuesInterface_Frag02;


    public Fragment_02() {
        // Required empty public constructor
    }

    public interface interface_Frag02 {

        public void onMessageRead(List<Integer> message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_02, container, false);
        // need to call the inflater a view object so we can find our seekbar views inside it by
        //referencing it below. Otherwise cannot use findViewById straight up.

        seekbar01 = view.findViewById(R.id.seekBar2);
        seekbar02 = view.findViewById(R.id.seekBar2);
        // linking variables to view objects

        // set seekBar listeners

        mlistener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                bounceback();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                compileProgress();

            }

        };

        seekbar01.setOnSeekBarChangeListener(mlistener);
        seekbar02.setOnSeekBarChangeListener(mlistener);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        // making a try catch to check if this is initialised or not.
        try {
            sendValuesInterface_Frag02 = (Fragment_02.interface_Frag02) activity;
            // we are just trying to get the interface linked to the activity this fragement
            // attaches to. We use the context of what this is Attached to to do this.
            //The context is cast to an activity and that is cast to the interface object.
        } catch (ClassCastException e){
            throw new ClassCastException((activity.toString()+"Must override onMessageRead...."));
        }

    }

    // this method is used to gather the seekbar progress and send it onto the activity for display.
    private void compileProgress(){
        testList.clear();
        testList.add(seekbar01.getProgress());
        testList.add(seekbar02.getProgress());

        if (testList.size()==3){

            sendValuesInterface_Frag02.onMessageRead(testList);

        }
    }


    // this is used to alter the other seekbars on the fly.
    // this method works surprisingly ok given it is suppose to set back the progressbar being used at
    // the time it is being envoked. Not gonna fix anything if it isnt broken though :-)

    private void bounceback() {
        int pro01 = seekbar01.getProgress();
        int pro02 = seekbar02.getProgress();
        int sum = pro01 + pro02;
        double max = 100.00;

        if (sum > max) {
            double ratio = max / (double) sum;
            int newpro01 = (int) Math.round(pro01 * ratio);
            int newpro02 = (int) Math.round(pro02 * ratio);
            seekbar01.setProgress(newpro01);
            seekbar02.setProgress(newpro02);
        }

    }

}
