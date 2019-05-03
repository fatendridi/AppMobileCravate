package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String Response ;

    @SerializedName("name")
    private String name;

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return name;
    }
}
