package com.example.kennethallan.fragmenttutorial;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_08 extends Fragment {

    private SeekBar seekbar01;
    private SeekBar seekbar02;
    private SeekBar seekbar03;
    private SeekBar seekbar04;
    private SeekBar seekbar05;
    private SeekBar seekbar06;
    private SeekBar seekbar07;
    private SeekBar seekbar08;

    private TextView tv_Pro_01;
    private TextView tv_Pro_02;
    private TextView tv_Pro_03;
    private TextView tv_Pro_04;
    private TextView tv_Pro_05;
    private TextView tv_Pro_06;
    private TextView tv_Pro_07;
    private TextView tv_Pro_08;

    SeekBar.OnSeekBarChangeListener mlistener;
    //int testValue;
    List<Integer> testList = new ArrayList<>();

    Fragment_08.interface_Frag08 sendValuesInterface_Frag08;


    public Fragment_08() {
        // Required empty public constructor
    }

    public interface interface_Frag08 {

        public void onMessageRead(List<Integer> message);
        // I think you send through this to get to the activity but data flow is only in
        // this direction.
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_08, container, false);

        seekbar01 = view.findViewById(R.id.seekBar1);
        seekbar02 = view.findViewById(R.id.seekBar2);
        seekbar03 = view.findViewById(R.id.seekBar3);
        seekbar04 = view.findViewById(R.id.seekBar4);
        seekbar05 = view.findViewById(R.id.seekBar5);
        seekbar06 = view.findViewById(R.id.seekBar6);
        seekbar07 = view.findViewById(R.id.seekBar7);
        seekbar08 = view.findViewById(R.id.seekBar8);

        tv_Pro_01 = view.findViewById(R.id.tv_num_01);
        tv_Pro_02 = view.findViewById(R.id.tv_num_02);
        tv_Pro_03 = view.findViewById(R.id.tv_num_03);
        tv_Pro_04 = view.findViewById(R.id.tv_num_04);
        tv_Pro_05 = view.findViewById(R.id.tv_num_05);
        tv_Pro_06 = view.findViewById(R.id.tv_num_06);
        tv_Pro_07 = view.findViewById(R.id.tv_num_07);
        tv_Pro_08 = view.findViewById(R.id.tv_num_08);
        // linking variables to view objects




        mlistener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                switch (seekBar.getId()) {
//                    case R.id.seekBar1:
//                        compileProgress();
//                        break;
//                    case R.id.seekBar2:
//                        compileProgress();
//                        break;
//                    case R.id.seekBar3:
//                        compileProgress();
//                        break;
//                    case R.id.seekBar4:
//                        compileProgress();
//
//                        break;
//                }

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
        seekbar03.setOnSeekBarChangeListener(mlistener);
        seekbar04.setOnSeekBarChangeListener(mlistener);
        seekbar05.setOnSeekBarChangeListener(mlistener);
        seekbar06.setOnSeekBarChangeListener(mlistener);
        seekbar07.setOnSeekBarChangeListener(mlistener);
        seekbar08.setOnSeekBarChangeListener(mlistener);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;


        // making a try catch to check if this is initialised or not.
        try {
            sendValuesInterface_Frag08 = (Fragment_08.interface_Frag08) activity;
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
        testList.add(seekbar03.getProgress());
        testList.add(seekbar04.getProgress());
        testList.add(seekbar05.getProgress());
        testList.add(seekbar06.getProgress());
        testList.add(seekbar07.getProgress());
        testList.add(seekbar08.getProgress());


        if (testList.size()==8){

            sendValuesInterface_Frag08.onMessageRead(testList);

        }
    }


    // this is used to alter the other seekbars on the fly.
    // this method works surprisingly ok given it is suppose to set back the progressbar being used at
    // the time it is being envoked. Not gonna fix anything if it isnt broken though :-)

    private void bounceback(){
        int pro01 = seekbar01.getProgress();
        int pro02 = seekbar02.getProgress();
        int pro03 = seekbar03.getProgress();
        int pro04 = seekbar04.getProgress();
        int pro05 = seekbar05.getProgress();
        int pro06 = seekbar06.getProgress();
        int pro07 = seekbar07.getProgress();
        int pro08 = seekbar08.getProgress();
        int sum = pro01+pro02+pro03+pro04+pro05+pro06+pro07+pro08;
        double max =100.00;

        if (sum>max){
            double ratio = max/(double)sum;
            int newpro01 = (int) Math.round(pro01*ratio);
            int newpro02 = (int) Math.round(pro02*ratio);
            int newpro03 = (int) Math.round(pro03*ratio);
            int newpro04 = (int) Math.round(pro04*ratio);
            int newpro05 = (int) Math.round(pro05*ratio);
            int newpro06 = (int) Math.round(pro06*ratio);
            int newpro07 = (int) Math.round(pro07*ratio);
            int newpro08 = (int) Math.round(pro08*ratio);
//            seekbar01.setProgress(newpro01);
//            seekbar02.setProgress(newpro02);
//            seekbar03.setProgress(newpro03);
//            seekbar04.setProgress(newpro04);
//            seekbar05.setProgress(newpro05);
            // this is to do the bouceback
            // instead do this to just update figures
            tv_Pro_01.setText( Integer.toString(newpro01));
            tv_Pro_02.setText( Integer.toString(newpro02));
            tv_Pro_03.setText( Integer.toString(newpro03));
            tv_Pro_04.setText( Integer.toString(newpro04));
            tv_Pro_05.setText( Integer.toString(newpro05));
            tv_Pro_06.setText( Integer.toString(newpro06));
            tv_Pro_07.setText( Integer.toString(newpro07));
            tv_Pro_08.setText( Integer.toString(newpro08));
        }


    }

}
