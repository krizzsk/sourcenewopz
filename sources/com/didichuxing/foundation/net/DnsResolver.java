package com.didichuxing.foundation.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface DnsResolver {
    public static final DnsResolver SYSTEM = new DnsResolver() {
        public List<InetAddress> resolve(String str) throws UnknownHostException {
            return Arrays.asList(InetAddress.getAllByName(str));
        }
    };

    List<InetAddress> resolve(String str) throws UnknownHostException;
}
