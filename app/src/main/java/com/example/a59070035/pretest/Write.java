package com.example.a59070035.pretest;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class Write extends Fragment {

    EditText etext;
    String text;
    public Write() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn = getView().findViewById(R.id.write_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etext = getView().findViewById(R.id.write_text);
                text = etext.getText().toString();
                writeFile();
            }
        });

        Button btnRead = getView().findViewById(R.id.write_read);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFile();
            }
        });
    }

    public void writeFile(){

        String file = "name";
        try{
            FileOutputStream outFile = getActivity().openFileOutput(file, Context.MODE_PRIVATE);
            outFile.write(text.getBytes());
            outFile.close();
            Log.d("System", "Message saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile(){
        TextView show = getView().findViewById(R.id.write_show);
        String message;
        try {
            FileInputStream inFile = getActivity().openFileInput("name");
            InputStreamReader inputStreamReader = new InputStreamReader(inFile);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((message=bufferedReader.readLine()) != null){
                stringBuffer.append(message + "\n");
            }
            show.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
