package com.didichuxing.apollo.sdk.log;

public interface ILogDelegate {
    void saveErrorLog(ApolloErrorLog apolloErrorLog);

    void saveLog(ApolloLog apolloLog);
}
