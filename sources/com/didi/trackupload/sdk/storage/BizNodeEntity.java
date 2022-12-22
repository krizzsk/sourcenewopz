package com.didi.trackupload.sdk.storage;

import com.didi.trackupload.sdk.datachannel.protobuf.BizNode;
import com.didi.trackupload.sdk.datachannel.protobuf.ClientType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import okio.ByteString;

public class BizNodeEntity {
    private Integer client_type;
    private byte[] extra_data;
    private String tag;

    public BizNodeEntity(String str, Integer num, byte[] bArr) {
        this.tag = str;
        this.client_type = num;
        this.extra_data = bArr;
    }

    public BizNodeEntity() {
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public Integer getClient_type() {
        return this.client_type;
    }

    public void setClient_type(Integer num) {
        this.client_type = num;
    }

    public byte[] getExtra_data() {
        return this.extra_data;
    }

    public void setExtra_data(byte[] bArr) {
        this.extra_data = bArr;
    }

    public static BizNodeEntity fromPBMessage(BizNode bizNode) {
        BizNodeEntity bizNodeEntity = new BizNodeEntity();
        bizNodeEntity.setClient_type(Integer.valueOf(bizNode.client_type.getValue()));
        bizNodeEntity.setExtra_data(bizNode.extra_data.toByteArray());
        bizNodeEntity.setTag(bizNode.tag);
        return bizNodeEntity;
    }

    public static BizNode toPBMessage(BizNodeEntity bizNodeEntity) {
        return new BizNode.Builder().client_type(ClientType.valueOf(bizNodeEntity.getClient_type().intValue())).extra_data(bizNodeEntity.getExtra_data() != null ? ByteString.m3607of(bizNodeEntity.getExtra_data()) : null).tag(bizNodeEntity.getTag()).build();
    }

    public static List<BizNode> toPBMessages(List<BizNodeEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (BizNodeEntity next : list) {
            if (next != null) {
                arrayList.add(toPBMessage(next));
            }
        }
        return arrayList;
    }

    public static List<BizNode> toPBMessages(Collection<BizNodeEntity> collection) {
        ArrayList arrayList = new ArrayList();
        for (BizNodeEntity next : collection) {
            if (next != null) {
                arrayList.add(toPBMessage(next));
            }
        }
        return arrayList;
    }

    public static String buildClientsString(Map<String, BizNodeEntity> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (BizNodeEntity client_type2 : map.values()) {
                sb.append(client_type2.getClient_type());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
