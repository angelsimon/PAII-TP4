package com.grupo06.tp04.system.helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

public class ArticuloInsertAsync extends AsyncTask<String, Void, String> {
    Context context;
    View view;
    Long insertedID;

    public ArticuloInsertAsync(Context context, View view) {
        this.context = context;
        this.view = view;
        this.insertedID = null;
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(String response) {

    }
}
