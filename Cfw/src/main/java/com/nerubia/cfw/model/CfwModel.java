package com.nerubia.cfw.model;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.POST;

/**
 * Created by meldy on 16/06/2015.
 */
public interface CfwModel {

    @POST("")
    public void add(JSONArray info, Callback<JSONObject> callback);

    public void get(JSONArray info, Callback<JSONObject> callback);

    public void delete(JSONArray info, Callback<JSONObject> callback);

    public void update(JSONArray info, Callback<JSONObject> callback);

}
