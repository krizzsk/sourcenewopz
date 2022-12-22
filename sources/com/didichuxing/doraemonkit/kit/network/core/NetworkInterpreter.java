package com.didichuxing.doraemonkit.kit.network.core;

import java.io.IOException;

public class NetworkInterpreter {

    public interface InspectorHeaders {
        String firstHeaderValue(String str);

        int headerCount();

        String headerName(int i);

        String headerValue(int i);
    }

    public interface InspectorRequest extends InspectorRequestCommon {
        byte[] body() throws IOException;

        String method();

        String url();
    }

    public interface InspectorRequestCommon extends InspectorHeaders {
        /* renamed from: id */
        int mo117100id();
    }

    public interface InspectorResponse extends InspectorResponseCommon {
        String url();
    }

    public interface InspectorResponseCommon extends InspectorHeaders {
        int requestId();

        int statusCode();
    }
}
