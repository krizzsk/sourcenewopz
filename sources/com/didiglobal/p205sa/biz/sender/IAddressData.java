package com.didiglobal.p205sa.biz.sender;

import com.didi.component.never.core.sender.DataSender;
import com.didi.component.never.core.sender.NullData;
import com.didi.component.never.core.sender.SenderName;
import com.didi.sdk.address.address.entity.Address;

@SenderName(name = "sender_start_address_data")
/* renamed from: com.didiglobal.sa.biz.sender.IAddressData */
public interface IAddressData extends DataSender<Address, NullData> {
}
