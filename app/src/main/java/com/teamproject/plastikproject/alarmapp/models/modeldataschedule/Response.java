
package com.teamproject.plastikproject.alarmapp.models.modeldataschedule;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("status_on")
    @Expose
    private Boolean statusOn;
    @SerializedName("id_increment")
    @Expose
    private Integer idIncrement;
    @SerializedName("milisecond_time")
    @Expose
    private Integer milisecondTime;
    @SerializedName("id_local")
    @Expose
    private Integer idLocal;
    private final static long serialVersionUID = 2681670604745362947L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getStatusOn() {
        return statusOn;
    }

    public void setStatusOn(Boolean statusOn) {
        this.statusOn = statusOn;
    }

    public Integer getIdIncrement() {
        return idIncrement;
    }

    public void setIdIncrement(Integer idIncrement) {
        this.idIncrement = idIncrement;
    }

    public Integer getMilisecondTime() {
        return milisecondTime;
    }

    public void setMilisecondTime(Integer milisecondTime) {
        this.milisecondTime = milisecondTime;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

}
