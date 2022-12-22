package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.util.Version;

public interface RpcProtocol {
    String getFamily();

    Version getVersion();

    String toString();
}
