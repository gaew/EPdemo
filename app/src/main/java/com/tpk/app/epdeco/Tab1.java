package com.tpk.app.epdeco;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gaewgan on 3/5/2016.
 */


public class Tab1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1,container,false);
        Button curtain =(Button)v.findViewById(R.id.bt_curtain);

        curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(getActivity(), Eyelet.class);
               // startActivity(intent);
                startActivity(new Intent(getActivity(), EyeletCurtains.class));
            }
        });


        return v;
    }
}
