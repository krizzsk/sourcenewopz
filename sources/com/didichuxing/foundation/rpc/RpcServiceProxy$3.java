package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.net.DnsResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

class RpcServiceProxy$3 implements DnsResolver {
    final /* synthetic */ C15585c this$0;
    final /* synthetic */ List val$resolvers;

    RpcServiceProxy$3(C15585c cVar, List list) {
        this.this$0 = cVar;
        this.val$resolvers = list;
    }

    public List<InetAddress> resolve(String str) throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        for (DnsResolver resolve : this.val$resolvers) {
            try {
                List<InetAddress> resolve2 = resolve.resolve(str);
                if (resolve2 != null && resolve2.size() > 0) {
                    arrayList.addAll(resolve2);
                }
            } catch (UnknownHostException unused) {
            }
        }
        return arrayList;
    }
}
