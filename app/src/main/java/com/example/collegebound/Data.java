package com.example.collegebound;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Data {

    public static ArrayList<Ivy> loadIvy(Context context) {
        ArrayList<Ivy> ivys = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("ivy.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("ivyInfo");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Ivy ivy = new Ivy();
                ivy.setTitle(jsonObject.getString("title"));
                ivy.setInfo(jsonObject.getString("info"));

                ivys.add(ivy);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ivys;

    }
}
