package com.didi.travel.psnger.model.response.estimate.daijiao;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "extension", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/Extension;", "getExtension", "()Lcom/didi/travel/psnger/model/response/estimate/daijiao/Extension;", "setExtension", "(Lcom/didi/travel/psnger/model/response/estimate/daijiao/Extension;)V", "friendId", "", "getFriendId", "()J", "setFriendId", "(J)V", "isSelected", "", "()I", "setSelected", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "portrait", "getPortrait", "setPortrait", "tebridge_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FriendItem.kt */
public final class FriendItem implements BffGsonStruct {
    private Extension extension;
    @SerializedName("friend_id")
    private long friendId;
    @SerializedName("is_selected")
    private int isSelected;
    private String name;
    private String portrait;

    public Object clone() {
        return super.clone();
    }

    public final long getFriendId() {
        return this.friendId;
    }

    public final void setFriendId(long j) {
        this.friendId = j;
    }

    public final String getPortrait() {
        return this.portrait;
    }

    public final void setPortrait(String str) {
        this.portrait = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final int isSelected() {
        return this.isSelected;
    }

    public final void setSelected(int i) {
        this.isSelected = i;
    }

    public final Extension getExtension() {
        return this.extension;
    }

    public final void setExtension(Extension extension2) {
        this.extension = extension2;
    }
}
