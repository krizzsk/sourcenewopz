package com.didiglobal.p205sa.biz.sender;

import com.didi.component.never.core.sender.DataSender;
import com.didi.component.never.core.sender.NullData;
import com.didi.component.never.core.sender.SenderName;
import com.didiglobal.p205sa.biz.component.ridecard.model.RideCardModel;

@SenderName(name = "sender_home_page_data")
/* renamed from: com.didiglobal.sa.biz.sender.IHomepData */
public interface IHomepData extends DataSender<RideCardModel, NullData> {
}
