package ru.nsu.fit.kn.messages;


import java.util.List;

/*
Response body:
{
    "status":"IN_PROGRESS",
    "data": null
}

{
   "status":"READY",
   "data": ["aaaa"]
}
*/

public class StatusResponse {
    private String status;
    private List<String> data;

    public StatusResponse() {}

    public StatusResponse(final String status, final List<String> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(final List<String> data)
    {
        this.data = data;
    }
}
