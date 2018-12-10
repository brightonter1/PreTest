package com.example.a59070035.pretest.SqlLite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a59070035.pretest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountForm extends Fragment {

    EditText name,surname,age;
    String Sname,Ssurname,Sage;
    Button btn;
    public AccountForm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_form, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn = getView().findViewById(R.id.account_from_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBtn();
            }
        });
    }

    public void addBtn(){
        name = getView().findViewById(R.id.account_from_name);
        surname = getView().findViewById(R.id.account_from_surname);
        age = getView().findViewById(R.id.account_from_age);

        Sname = name.getText().toString();
        Ssurname = surname.getText().toString();
        Sage = age.getText().toString();

        SQLiteDatabase myDB = getActivity().openOrCreateDatabase("My.DB", Context.MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS account (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200), surname VARCHAR(200), age VARCHAR(200))");
        ContentValues row = new ContentValues();
        row.put("name", Sname);
        row.put("surname", Ssurname);
        row.put("age", Sage);

        myDB.insert("Account", null, row);
        myDB.close();

        fetch();

    }

    public void fetch(){
        SQLiteDatabase myDB = getActivity().openOrCreateDatabase("My.DB", Context.MODE_PRIVATE, null);

        myDB.execSQL("CREATE TABLE IF NOT EXISTS account (_id INTEGER PRIMARY KEY AUTOINCREMENT,uid VARCHAR(200), date VARCHAR(200), sleep VARCHAR(200), wake VARCHAR(200))");

        final Cursor myCursor = myDB.rawQuery("select * from Account", null);

        while (myCursor.moveToNext()){
            String dt = myCursor.getString(0);
            String sp = myCursor.getString(1);
            String we = myCursor.getString(2);

            Log.d("System", dt + sp + we);
        }
    }
}
