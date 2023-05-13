package ru.nsu.fit.kn.messages;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class InternalRequestFactory {
    public static CrackHashManagerRequest forgeRequest(
            CrackRequest crackRequest, Integer partCount, Integer partNumber, UUID uuid) {
        CrackHashManagerRequest request = new CrackHashManagerRequest();
        request.setRequestId(uuid.toString());
        request.setHash(crackRequest.getHash());
        request.setPartCount(partCount);
        request.setPartNumber(partNumber);
        request.setMaxLength(crackRequest.getMaxLength());
        request.setAlphabet(defaultAlphabet());
        return request;
    }

    private static CrackHashManagerRequest.Alphabet defaultAlphabet() {
        var res = new CrackHashManagerRequest.Alphabet();
        IntStream.rangeClosed('a', 'z').forEach(c -> res.getSymbols().add("" + (char)c));
        IntStream.rangeClosed('0', '9').forEach(c -> res.getSymbols().add("" + (char)c));
        return res;
    }

    public static CrackHashWorkerResponse forgeResponse(CrackHashManagerRequest workRequest, List<String> results) {
        CrackHashWorkerResponse response = new CrackHashWorkerResponse();
        response.setRequestId(workRequest.getRequestId());
        response.setPartNumber(workRequest.getPartNumber());
        response.setAnswers(forgeAnswers(results));
        return response;
    }

    private static CrackHashWorkerResponse.Answers forgeAnswers(List<String> results) {
        var answers = new CrackHashWorkerResponse.Answers();
        results.forEach(s -> answers.getWords().add(s));
        return answers;
    }
}
