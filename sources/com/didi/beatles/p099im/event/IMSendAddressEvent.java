package com.didi.beatles.p099im.event;

import com.didi.beatles.p099im.module.entity.IMAddress;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.event.IMSendAddressEvent */
public class IMSendAddressEvent implements Serializable {
    public IMAddress address;

    public IMSendAddressEvent(IMAddress iMAddress) {
        this.address = iMAddress;
    }
}
