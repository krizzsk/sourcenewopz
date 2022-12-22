package com.didichuxing.bigdata.p173dp.locsdk.spi;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
/* renamed from: com.didichuxing.bigdata.dp.locsdk.spi.IUserInfoProvider */
public interface IUserInfoProvider {
    String getPhone();

    String getPlateNumber();

    String getToken();

    String getUid();
}
