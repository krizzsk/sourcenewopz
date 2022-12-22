package com.didichuxing.dfbasesdk.algomodel;

@Deprecated
public interface AlgoModelResourceExtractor {
    String extractModelResource() throws Exception;

    String getModelResourceMd5();
}
