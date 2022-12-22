package com.didi.sdk.messagecenter.exceptions;

public class NullTopicException extends Exception {
    public NullTopicException() {
        super("Topic is null");
    }
}
