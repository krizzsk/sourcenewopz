package com.didi.map.global.rpc.service;

import com.didi.map.global.rpc.certificate.MapApiCATransporter;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Retry;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.didichuxing.foundation.rpc.annotation.Transportation;

@Retry(3)
@Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
@Transportation({MapApiCATransporter.class})
public interface IMapRpcService extends RpcService {
}
