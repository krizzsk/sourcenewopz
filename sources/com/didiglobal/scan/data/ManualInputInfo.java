package com.didiglobal.scan.data;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didiglobal/scan/data/ManualInputInfo;", "Ljava/io/Serializable;", "()V", "infoList", "Ljava/util/ArrayList;", "Lcom/didiglobal/scan/data/ManualInputInfoItem;", "Lkotlin/collections/ArrayList;", "getInfoList", "()Ljava/util/ArrayList;", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ManualInputInfo.kt */
public final class ManualInputInfo implements Serializable {
    private final ArrayList<ManualInputInfoItem> infoList = new ArrayList<>();

    public final ArrayList<ManualInputInfoItem> getInfoList() {
        return this.infoList;
    }
}
