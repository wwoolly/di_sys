package ru.nsu.fit.kn.messages;

/*
POST /api/hash/crack
Request body:
{
    "hash":"e2fc714c4727ee9395f324cd2e7f331f",
    "maxLength": 4
}

curl -s -X POST -H "Content-Type: application/json" -d '{"hash": "'e2fc714c4727ee9395f324cd2e7f331f'", "maxLength": '8'}' localhost:8081/api/hash/crack
*/
//@Data
public class CrackRequest {
    private String hash;
    private Integer maxLength;

    public String getHash()
    {
        return hash;
    }

    public void setHash(final String hash)
    {
        this.hash = hash;
    }

    public Integer getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(final Integer maxLength)
    {
        this.maxLength = maxLength;
    }
}
