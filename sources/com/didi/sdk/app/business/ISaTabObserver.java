package com.didi.sdk.app.business;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/sdk/app/business/ISaTabObserver;", "", "notifyTabDown", "", "groupId", "", "notifyTabRedPoint", "show", "", "notifyTabTip", "tip", "notifyTabUp", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ISaTabObserver.kt */
public interface ISaTabObserver {
    void notifyTabDown(String str);

    void notifyTabRedPoint(String str, boolean z);

    void notifyTabTip(String str, String str2);

    void notifyTabUp(String str);
}
