package ru.nsu.fit.kn.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

public class HashStatus {
    private String uuid;

    private String status;
    private List<String> data;
    private Integer toDo;
    private Integer done;

    public HashStatus(String uuid, String status, List<String> data, Integer toDo, Integer done) {
        this.uuid = uuid;
        this.status = status;
        this.data = data;
        this.toDo = toDo;
        this.done = done;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(final String uuid)
    {
        this.uuid = uuid;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }

    public List<String> getData()
    {
        return data;
    }

    public void setData(final List<String> data)
    {
        this.data = data;
    }

    public Integer getToDo()
    {
        return toDo;
    }

    public void setToDo(final Integer toDo)
    {
        this.toDo = toDo;
    }

    public Integer getDone()
    {
        return done;
    }

    public void setDone(final Integer done)
    {
        this.done = done;
    }
}
