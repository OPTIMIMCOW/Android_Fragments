package com.example.kennethallan.fragmenttutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        Fragment_08.interface_Frag08,Fragment_07.interface_Frag07,Fragment_06.interface_Frag06,
        Fragment_05.interface_Frag05,Fragment_04.interface_Frag04, Fragment_03.interface_Frag03 {

    // I have to implement each fragements interface separately. I think I can implement as many times as I
    //like but I am not so sure.

    View fragmentHolder;
    int SpecialNumber = 7; // will make this a saved instance state variable later in development7
    Button bnTest;
    TextView tvAnswer;
    List<Integer> compiledValues = new ArrayList<>();
//    String testString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHolder = findViewById(R.id.Fragment_Holder);
        bnTest = findViewById(R.id.Button_Test);
        tvAnswer = findViewById(R.id.tvAnswer);

        // load fragment
        if(fragmentHolder != null){


            if(savedInstanceState != null){
                return;
            }// this is like an exit if something has gone wrong for this to load????
            if (SpecialNumber == 8){
                Fragment_08 myFragment = new Fragment_08();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }
            if (SpecialNumber == 7){
                Fragment_07 myFragment = new Fragment_07();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }
            if (SpecialNumber == 6){
                Fragment_06 myFragment = new Fragment_06();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }
            if (SpecialNumber == 5){
                Fragment_05 myFragment = new Fragment_05();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }
            if (SpecialNumber == 4){
                Fragment_04 myFragment = new Fragment_04();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }
            if (SpecialNumber == 3){
                Fragment_03 myFragment = new Fragment_03();
                FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
                fragementTransaction.commit();
            }



//            FragmentTransaction fragementTransaction = getSupportFragmentManager().beginTransaction().add(R.id.Fragment_Holder,myFragment,null);
//            // used R.id.fragement_Holder instead of pasing a view object because it wanted an int so maybe just a
//            // id rather than an actual object. fragmentHolder.getId() should probably work too.
//            fragementTransaction.commit();

        }

        bnTest.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                    }
                }
        );



    }

//    public void compileData(){
//        if (SpecialNumber == 4){
//            for (int i=0;i<=SpecialNumber;i++){
//                compiledValues
//
//            }
//
//        } else if (SpecialNumber ==3){
//
//        }
//
//    }

    public void updateDB(){

    }

// this is the override method used to communicate with interfaces.
    @Override
    public void onMessageRead(List<Integer> message) {

        compiledValues = message;
        tvAnswer.setText("");// used to clear the textview before

        for (int i=0; i<compiledValues.size();i++){

            tvAnswer.append(compiledValues.get(i).toString()+ "\n");
        }
//        testString = message;
//        tvAnswer.setText(testString);
    }

//    @Override
//    public void onMessageRead(String message) {
//
//    }
}
