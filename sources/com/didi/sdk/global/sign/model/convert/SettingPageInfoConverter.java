package com.didi.sdk.global.sign.model.convert;

import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import java.util.ArrayList;
import java.util.List;

public class SettingPageInfoConverter {
    public static PaySelPageData convert(PayMethodPageResponse payMethodPageResponse) {
        if (payMethodPageResponse == null || payMethodPageResponse.data == null || payMethodPageResponse.data.allEntries == null || payMethodPageResponse.data.allEntries.size() == 0) {
            return null;
        }
        PaySelPageData paySelPageData = new PaySelPageData();
        paySelPageData.pageTitle = payMethodPageResponse.data.title;
        for (PayMethodPageResponse.Entry next : payMethodPageResponse.data.allEntries) {
            if (next != null) {
                if (next.type == 1) {
                    paySelPageData.payMethodTitle = next.name;
                    paySelPageData.ruleUrl = next.url;
                    paySelPageData.payMethodList = m25598a(next.channels);
                }
                if (next.type == 24) {
                    paySelPageData.promotionTitle = next.name;
                    paySelPageData.promotionList = m25599b(next.channels);
                }
            }
        }
        return paySelPageData;
    }

    /* renamed from: a */
    private static List<PaySelItemData> m25598a(List<PayMethodPageResponse.Channel> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (PayMethodPageResponse.Channel next : list) {
                if (next != null) {
                    if (next.channel_id == 150) {
                        arrayList.addAll(m25597a(next));
                    } else {
                        PaySelItemData paySelItemData = new PaySelItemData();
                        paySelItemData.channelId = next.channel_id;
                        paySelItemData.style = 2;
                        paySelItemData.iconUrl = next.icon_url;
                        paySelItemData.title = next.channel_name;
                        paySelItemData.subTitle = next.channel_desc;
                        paySelItemData.info = next.value;
                        paySelItemData.nextPageUrl = next.detail_page_url;
                        int i = 1;
                        if (next.sign_status != 1) {
                            i = 0;
                        }
                        paySelItemData.status = i;
                        paySelItemData.hasRedPoint = next.hot_point_flag;
                        arrayList.add(paySelItemData);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static List<PaySelItemData> m25599b(List<PayMethodPageResponse.Channel> list) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (PayMethodPageResponse.Channel next : list) {
                if (next != null) {
                    PaySelItemData paySelItemData = new PaySelItemData();
                    paySelItemData.channelId = 1000;
                    paySelItemData.style = 2;
                    paySelItemData.iconUrl = next.icon_url;
                    paySelItemData.title = next.channel_name;
                    paySelItemData.subTitle = next.channel_desc;
                    paySelItemData.info = next.value;
                    paySelItemData.nextPageUrl = next.detail_page_url;
                    arrayList.add(paySelItemData);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<PaySelItemData> m25597a(PayMethodPageResponse.Channel channel) {
        ArrayList arrayList = new ArrayList();
        if (channel == null) {
            return arrayList;
        }
        PaySelItemData paySelItemData = new PaySelItemData();
        paySelItemData.channelId = channel.channel_id;
        paySelItemData.style = 2;
        paySelItemData.iconUrl = channel.icon_url;
        paySelItemData.title = channel.channel_name;
        paySelItemData.subTitle = channel.channel_desc;
        paySelItemData.info = channel.value;
        paySelItemData.status = 0;
        paySelItemData.hasRedPoint = channel.hot_point_flag;
        arrayList.add(paySelItemData);
        if (channel.channel_sub_values != null && channel.channel_sub_values.size() > 0) {
            for (PayMethodPageResponse.ChannelItemInfo next : channel.channel_sub_values) {
                PaySelItemData paySelItemData2 = new PaySelItemData();
                paySelItemData2.channelId = channel.channel_id;
                paySelItemData2.iconUrl = next.icon_url;
                paySelItemData2.title = next.card_no;
                paySelItemData2.subTitle = next.status_desc;
                paySelItemData2.cardIndex = next.card_index;
                paySelItemData2.expiryDate = next.expiry_date;
                paySelItemData2.expired = next.expired;
                paySelItemData2.expiredDesc = next.expired_desc;
                if (next.card_status == 1) {
                    paySelItemData2.status = 2;
                } else {
                    paySelItemData2.status = 1;
                }
                if (paySelItemData2.expired == 1) {
                    paySelItemData2.style = 2;
                } else if (paySelItemData2.status == 2) {
                    paySelItemData2.style = 2;
                } else {
                    paySelItemData2.style = 1;
                }
                if (paySelItemData2.status != 1) {
                    paySelItemData2.subTitleStyle = 1;
                }
                arrayList.add(paySelItemData2);
            }
        }
        return arrayList;
    }
}
