package com.example.a59070035.pretest.SqlLite;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AccountAdapter extends ArrayAdapter<Account> {

    ArrayList<Account> account;
    Context context;

    public AccountAdapter(Context context, int i, ArrayList<Account> account){
        super(context, i, account);
        this.context = context;
        this.account = account;
    }


}
