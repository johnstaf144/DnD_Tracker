package com.johnstaf.test_2020;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {

    //declare variables

    private TextView results_text;
    private Button roll_button;
    private SeekBar seekbar;
    private TextView critical;
    private Spinner player_spinner;
    private Button add_player;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String text;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (savedInstanceState == null) {
//            results_text.setText("");
//        } else {
//            results_text.setText(savedInstanceState.getString("result_text"));
//        }
//    }

    public tab1() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        super.onCreate(savedInstanceState);

        results_text = v.findViewById(R.id.resultsTextView);
        roll_button = v.findViewById(R.id.rollButton);
        seekbar = v.findViewById(R.id.seekBar_dicetype);
        critical = v.findViewById(R.id.critTextView);
        player_spinner = v.findViewById(R.id.spinnerPlayer);
        add_player = v.findViewById(R.id.addplayer_button);

        loadData();
        updateViews();

//        if (savedInstanceState == null) {
//            results_text.setText("");
//        } else {
//            results_text.setText(savedInstanceState.getString("result_text"));
//        }



//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String result = (d6.isChecked())?"D6":(d100.isChecked())?"D100":"";
//
//                Random rand = new Random();
//
//                    if (result == "D6") {
//                        int number = rand.nextInt(6) + 1;
//                        ed1.setText(String.valueOf(number));
//                    } else if (result == "D100") {
//                        int number = rand.nextInt(100) + 1;
//                        ed1.setText(String.valueOf(number));
//                    }
//            }
//        });

        //When Roll Dice is clicked

        roll_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                String crit = "Critical!";
                String ace = "Ace!!!";

                if (seekbar.getProgress() == 0) {
                    int number = rand.nextInt(4) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 4) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 1) {
                    int number = rand.nextInt(6) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 6) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 2) {
                    int number = rand.nextInt(8) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 8) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 3) {
                    int number = rand.nextInt(10) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 10) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 4) {
                    int number = rand.nextInt(12) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 12) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 5) {
                    int number = rand.nextInt(20) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 20) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                } else if (seekbar.getProgress() == 6) {
                    int number = rand.nextInt(100) + 1;
                    results_text.setText(String.valueOf(number));
                    if (number == 1) {
                        critical.setText(crit);
                    } else if  (number == 100) {
                        critical.setText(ace);
                    } else {
                        critical.setText("");
                    }
                }
                saveData();
            }
        });

        //Initializing an empty list for players
        String[] players = new String[]{
        };

        final List<String> playerList = new ArrayList<>(Arrays.asList(players));

        //Initializing an ArrayAdapter

        final ArrayAdapter<String> playerSpinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.addplayer_spinner_item, playerList);

        playerSpinnerArrayAdapter.setDropDownViewResource(R.layout.addplayer_spinner_item);
        player_spinner.setAdapter(playerSpinnerArrayAdapter);

        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerList.add("New Player");
                playerSpinnerArrayAdapter.notifyDataSetChanged();
            }
        });




        return v;

        }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("result_text", results_text.getText().toString());
//    }

    public void saveData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, results_text.getText().toString());

        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
    }

    public void updateViews() {
        results_text.setText(text);
    }
    // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tab1, container, false);
}

