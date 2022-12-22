package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.rpc.RpcProtocol;
import com.didichuxing.foundation.util.Version;

enum HttpRpcProtocol implements RpcProtocol {
    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1"),
    HTTP_2_0("h2", "HTTP", "2.0");
    
    final String family;
    final String identifier;
    final Version version;

    private HttpRpcProtocol(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            this.identifier = str;
            this.family = str.substring(0, indexOf);
            this.version = Version.parse(str.substring(indexOf + 1));
            return;
        }
        throw new IllegalArgumentException("Protocol version is not specified");
    }

    private HttpRpcProtocol(String str, String str2, String str3) {
        this.identifier = str;
        this.family = str2;
        this.version = Version.parse(str3);
    }

    public String getFamily() {
        return this.family;
    }

    public Version getVersion() {
        return this.version;
    }

    public String toString() {
        return this.identifier;
    }

    public static HttpRpcProtocol parse(String str) {
        for (HttpRpcProtocol httpRpcProtocol : values()) {
            if (httpRpcProtocol.identifier.equalsIgnoreCase(str)) {
                return httpRpcProtocol;
            }
        }
        throw new IllegalArgumentException("Unsupported protocol: " + str);
    }
}
