
package com.teamproject.plastikproject.alarmapp.models.modeldataschedule;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelDataSchedule implements Serializable
{

    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    private final static long serialVersionUID = 7755848748981043011L;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

}
