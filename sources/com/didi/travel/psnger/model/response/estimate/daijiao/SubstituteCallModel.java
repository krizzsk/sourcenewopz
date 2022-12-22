package com.didi.travel.psnger.model.response.estimate.daijiao;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001c\u00101\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014¨\u00064"}, mo175978d2 = {"Lcom/didi/travel/psnger/model/response/estimate/daijiao/SubstituteCallModel;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "addAnother", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddAnother;", "getAddAnother", "()Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddAnother;", "setAddAnother", "(Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddAnother;)V", "addPhoneModel", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddPhoneModel;", "getAddPhoneModel", "()Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddPhoneModel;", "setAddPhoneModel", "(Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddPhoneModel;)V", "content", "Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "getContent", "()Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;", "setContent", "(Lcom/didi/global/globaluikit/richinfo/LEGORichInfo;)V", "defaultIcon", "", "getDefaultIcon", "()Ljava/lang/String;", "setDefaultIcon", "(Ljava/lang/String;)V", "defaultText", "getDefaultText", "setDefaultText", "errmsg", "getErrmsg", "setErrmsg", "errno", "", "getErrno", "()I", "setErrno", "(I)V", "friendItems", "", "Lcom/didi/travel/psnger/model/response/estimate/daijiao/FriendItem;", "getFriendItems", "()Ljava/util/List;", "setFriendItems", "(Ljava/util/List;)V", "style", "getStyle", "setStyle", "title", "getTitle", "setTitle", "tebridge_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteCallModel.kt */
public final class SubstituteCallModel implements BffGsonStruct {
    @SerializedName("add_another")
    private AddAnother addAnother;
    @SerializedName("add_phone")
    private AddPhoneModel addPhoneModel;
    private LEGORichInfo content;
    @SerializedName("default_icon")
    private String defaultIcon;
    @SerializedName("default_text")
    private String defaultText;
    private String errmsg;
    private int errno;
    @SerializedName("friends_items")
    private List<FriendItem> friendItems;
    private int style;
    private LEGORichInfo title;

    public Object clone() {
        return super.clone();
    }

    public final int getErrno() {
        return this.errno;
    }

    public final void setErrno(int i) {
        this.errno = i;
    }

    public final String getErrmsg() {
        return this.errmsg;
    }

    public final void setErrmsg(String str) {
        this.errmsg = str;
    }

    public final String getDefaultIcon() {
        return this.defaultIcon;
    }

    public final void setDefaultIcon(String str) {
        this.defaultIcon = str;
    }

    public final String getDefaultText() {
        return this.defaultText;
    }

    public final void setDefaultText(String str) {
        this.defaultText = str;
    }

    public final int getStyle() {
        return this.style;
    }

    public final void setStyle(int i) {
        this.style = i;
    }

    public final LEGORichInfo getTitle() {
        return this.title;
    }

    public final void setTitle(LEGORichInfo lEGORichInfo) {
        this.title = lEGORichInfo;
    }

    public final LEGORichInfo getContent() {
        return this.content;
    }

    public final void setContent(LEGORichInfo lEGORichInfo) {
        this.content = lEGORichInfo;
    }

    public final List<FriendItem> getFriendItems() {
        return this.friendItems;
    }

    public final void setFriendItems(List<FriendItem> list) {
        this.friendItems = list;
    }

    public final AddAnother getAddAnother() {
        return this.addAnother;
    }

    public final void setAddAnother(AddAnother addAnother2) {
        this.addAnother = addAnother2;
    }

    public final AddPhoneModel getAddPhoneModel() {
        return this.addPhoneModel;
    }

    public final void setAddPhoneModel(AddPhoneModel addPhoneModel2) {
        this.addPhoneModel = addPhoneModel2;
    }
}
