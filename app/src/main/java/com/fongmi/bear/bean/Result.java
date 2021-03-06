package com.fongmi.bear.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("list")
    private List<Vod> list;

    public static Result objectFrom(String str) {
        return new Gson().fromJson(str, Result.class);
    }

    public List<Vod> getList() {
        return list;
    }
}
