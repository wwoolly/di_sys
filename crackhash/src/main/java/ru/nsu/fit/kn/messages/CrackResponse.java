package ru.nsu.fit.kn.messages;


/*
{
    "requestId":"630e04f6-4229-41f9-9d5b-63b21b16afac"
}
*/
public class CrackResponse {
    private String requestId;

    public CrackResponse() {}

    public CrackResponse(final String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(final String requestId)
    {
        this.requestId = requestId;
    }
}
