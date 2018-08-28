package com.teamproject.plastikproject.plastik.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.teamproject.plastikproject.R;
import com.teamproject.plastikproject.plastik.helper.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class EarthHeroFragment extends Fragment{


    private static final String TAG = "smile";
    private SessionManager manager;

    public EarthHeroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_earth_hero, container, false);
        final TextView edtpoint =(TextView)v.findViewById(R.id.edtpoint);
        Button btncek =(Button) v.findViewById(R.id.btncheck);
        final SmileRating smileRating = (SmileRating) v.findViewById(R.id.smile_rating);
//        smileRating.setOnSmileySelectionListener(this);
//        smileRating.setOnRatingSelectedListener(this);
        view(smileRating);
        manager =new SessionManager(getActivity());
        String rating2 =manager.getTropy();
        Log.d("datanya",rating2);
        int rate= Integer.parseInt(rating2);
        if (rate==0){
            edtpoint.setText("0");
       //     edtpoint.setError("tidak boleh kosong");
        }else {
            edtpoint.setText(rating2);

            if (rate < 100) {
                smileRating.setSelectedSmile(SmileRating.TERRIBLE);
                smileRating.setIndicator(true);
                smileRating.setNameForSmile(BaseRating.TERRIBLE, "<100");
            } else if (rate >= 100 && rate <= 200) {
                smileRating.setSelectedSmile(SmileRating.BAD);
                //  smileRating.setSelectedSmile(SmileRating.GOOD,true);
                smileRating.setNameForSmile(BaseRating.BAD, "100-200");
                //smileRating.set
                smileRating.setIndicator(true);
            } else if (rate > 200 && rate <= 300) {
                smileRating.setSelectedSmile(SmileRating.OKAY);
                smileRating.setIndicator(true);
                smileRating.setNameForSmile(BaseRating.OKAY, ">200-300");

            } else if (rate > 300 && rate <= 400) {
                smileRating.setSelectedSmile(SmileRating.GOOD);
                smileRating.setIndicator(true);
                smileRating.setNameForSmile(BaseRating.GOOD, ">300-400");
            } else if (rate > 400 && rate <= 500) {
                smileRating.setSelectedSmile(SmileRating.GREAT);
                smileRating.setIndicator(true);
                smileRating.setNameForSmile(BaseRating.GREAT, ">400-500");

            } else {
                Toast.makeText(getActivity(), "no response", Toast.LENGTH_SHORT).show();
            }
        }
      //  smileRating.setIndicator(true);
      //    smileRating.setSelectedSmile(BaseRating.TERRIBLE);
btncek.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String rating =edtpoint.getText().toString();

    }
});
        // smileRating.setIndicator(false);

        // Inflate the layout for this fragment
        return v;
    }

    private void view(SmileRating smileRating) {
        smileRating.setNameForSmile(BaseRating.TERRIBLE, "<100");
        smileRating.setNameForSmile(BaseRating.BAD, "100-200");
        smileRating.setNameForSmile(BaseRating.OKAY, ">200-300");
        smileRating.setNameForSmile(BaseRating.GOOD, ">300-400");
        smileRating.setNameForSmile(BaseRating.GREAT, ">400-500");

    }

//    @Override
//    public void onSmileySelected(int smiley, boolean reselected) {
//        switch (smiley) {
//            case SmileRating.BAD:
//                Log.i(TAG, "Bad");
//                break;
//            case SmileRating.GOOD:
//                Log.i(TAG, "Good");
//                break;
//            case SmileRating.GREAT:
//                Log.i(TAG, "Great");
//                break;
//            case SmileRating.OKAY:
//                Log.i(TAG, "Okay");
//                break;
//            case SmileRating.TERRIBLE:
//                Log.i(TAG, "Terrible");
//                break;
//            case SmileRating.NONE:
//                Log.i(TAG, "None");
//                break;
//        }
//    }
//
//    @Override
//    public void onRatingSelected(int level, boolean reselected) {
//        Log.i(TAG, "Rated as: " + level + " - " + reselected);
//    }
}
