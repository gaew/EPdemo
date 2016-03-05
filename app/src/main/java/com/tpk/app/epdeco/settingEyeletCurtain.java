package com.tpk.app.epdeco;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tpk.app.epdeco.Eyelet;
import com.tpk.app.epdeco.R;

/**
 * Created by gaewgan on 3/5/2016.
 */


public class settingEyeletCurtain extends Fragment {
    //ตั้งตามสูตรต้อม
    private Spinner setI ;//ตัวดรอบดาวแสดงค่า I
    private EditText edt_D, edt_E, edt_F, edt_G, edt_H, edt_J ;
    private String sD, sE, sF,sG, sH, sI, sJ ;
    private Button chn,noChe;//ปุ่มกด บันทึกค่า ,ใช้ค่ามาตรฐาน


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_setting_eyelet_curtain,container,false);
        setSpinnerI(v);
        chn = (Button) v.findViewById(R.id.changeSet_button);//ปุ่มบันทึกค่า
        noChe = (Button) v.findViewById(R.id.noChSet_button);//ปุ่มใช้ค่ามาตรฐาน
        edt_D = (EditText) v.findViewById(R.id.setD_edittext);
        edt_E = (EditText) v.findViewById(R.id.setE_edittext);
        edt_F = (EditText) v.findViewById(R.id.setF_edittext);
        edt_G = (EditText) v.findViewById(R.id.setG_edittext);
        edt_H = (EditText) v.findViewById(R.id.setH_edittext);
        edt_J = (EditText) v.findViewById(R.id.setJ_edittext);

        final  Spinner setI = (Spinner)v.findViewById(R.id.setI_spin);
        //เมื่อกดปุ่มใช้ค่ามาตรฐาน จะกำหนดค่าใน shered preference เป็นค่ามาตรฐาน
        noChe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //เปิดไฟล์ที่ shered preferrence กำหนดค่าที่เป็น default ใว้
                SharedPreferences sp = getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("My_ValueDtaki",  "2.5");
                editor.putString("My_ValueEtaki",  "10.0");
                editor.putString("My_ValueFtaki",  "10.0");
                editor.putString("My_ValueGtaki",  "15.0");
                editor.putString("My_ValueHtaki",  "30.0");
                editor.putString("My_ValueItaki",  "0.0");
                editor.putString("My_ValueJtaki",  "50.0");
                editor.putString("curtainType1taki",  "ม่านจีบ");
                editor.commit();
                Intent intent = new Intent(getActivity(), Eyelet.class);
                startActivity(intent);
            }
        });
        //แสดงค่าที่บันทึการตั้งค่าใว้ ใน edittext เพื่อทราบในภายหลังว่าเคยตั้งอะไรไว้โดยไปดึงค่าจาก SharedPreferences
        SharedPreferences sp = getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String stg_sharD = sp.getString("My_ValueDtaki", "2.5");
        edt_D.setText(stg_sharD);
        String stg_sharE = sp.getString("My_ValueEtaki", "10.0");
        edt_E.setText(stg_sharE);
        String stg_sharF = sp.getString("My_ValueFtaki", "10.0");
        edt_F.setText(stg_sharF);
        String stg_sharG = sp.getString("My_ValueGtaki", "15.0");
        edt_G.setText(stg_sharG);
        String stg_sharH = sp.getString("My_ValueHtaki", "30.0");
        edt_H.setText(stg_sharH);
        String stg_sharJ = sp.getString("My_ValueJtaki", "50.0");
        edt_J.setText(stg_sharJ);
        //แสดงตั้ง spinner ที่ค่างใว้
        String stg_sharI = sp.getString("My_ValueItaki", "0.0");
        setI.setSelection(getIndex(setI, stg_sharI));
        //เมื่อกดปุ่มบันทึกการตั้งงค่า
        chn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!edt_E.getText().toString().trim().isEmpty())&&
                        (!edt_F.getText().toString().trim().isEmpty())&&
                        (!edt_G.getText().toString().trim().isEmpty())&&
                        (!edt_D.getText().toString().trim().isEmpty())&&
                        (!edt_H.getText().toString().trim().isEmpty())&&
                        (!edt_J.getText().toString().trim().isEmpty())
                        ) {
                    //รับค่าจาก edittext เก็บในตัวแปร
                    sD = edt_D.getText().toString();
                    sE = edt_E.getText().toString();
                    sF = edt_F.getText().toString();
                    sG = edt_G.getText().toString();
                    sH = edt_H.getText().toString();

                    String sI = setI.getSelectedItem().toString();
                    sJ = edt_J.getText().toString();
                    //ส่งค่าตัวแปรไปเก็บในไฟล์ SharedPreferences
                    SharedPreferences sp = getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("My_ValueDtaki",  sD);
                    editor.putString("My_ValueEtaki",  sE);
                    editor.putString("My_ValueFtaki",  sF);
                    editor.putString("My_ValueGtaki",  sG);
                    editor.putString("My_ValueHtaki",  sH);
                    editor.putString("My_ValueItaki",  sI);
                    editor.putString("My_ValueJtaki", sJ);
                    editor.commit();//ส่งการเก็บค่า

                    Intent intent = new Intent(getActivity(), Eyelet.class);
                    startActivity(intent);
                }
                //แสดงในกรณี edttext ว่างป้องกันการ error
                else Toast.makeText(getActivity(), "ต้องใส่ข้อมูลให้ครบทุกช่องเมื่อแก้ไขตั้งค่า", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    //ฟังชั้นหาตัวอินเด็กของ spinner
 /*   private int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                i=spinner.getCount();//will stop the loop, kind of break, by making condition false
            }
        }
        return index;
    }*/
    //สร้าง spinner

    private void setSpinnerI( View view ){
        setI = (Spinner) view.findViewById(R.id.setI_spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.set_i, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        setI.setAdapter(adapter);
    }
    private int getIndex(Spinner spinner, String myString) {
        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                index = i;
                i = spinner.getCount();//will stop the loop, kind of break, by making condition false
            }
        }
        return index;
    }

    public void onBackPressed() {
        Intent intent = new Intent(getActivity(), Eyelet.class);
        startActivity(intent);
    }

}