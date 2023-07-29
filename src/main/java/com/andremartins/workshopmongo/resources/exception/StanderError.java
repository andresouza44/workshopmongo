package com.andremartins.workshopmongo.resources.exception;

import java.io.Serializable;

public class StanderError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String error;

    private String messag;
    private String path;

    public StanderError(){

    }

    public StanderError(Long timestamp, Integer status, String error, String messag, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messag = messag;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessag() {
        return messag;
    }

    public void setMessag(String messag) {
        this.messag = messag;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
