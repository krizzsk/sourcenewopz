package com.didi.travel.psnger.model.response.estimate.daijiao;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006'"}, mo175978d2 = {"Lcom/didi/travel/psnger/model/response/estimate/daijiao/AddPhoneModel;", "Lcom/android/didi/bfflib/business/BffGsonStruct;", "()V", "confirmBtnText", "", "getConfirmBtnText", "()Ljava/lang/String;", "setConfirmBtnText", "(Ljava/lang/String;)V", "confirmIntro", "Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "getConfirmIntro", "()Lcom/didi/travel/psnger/model/response/GlobalRichInfo;", "setConfirmIntro", "(Lcom/didi/travel/psnger/model/response/GlobalRichInfo;)V", "contactsImgTips", "getContactsImgTips", "setContactsImgTips", "introductions", "", "getIntroductions", "()Ljava/util/List;", "setIntroductions", "(Ljava/util/List;)V", "nameHint", "getNameHint", "setNameHint", "nameIntro", "getNameIntro", "setNameIntro", "phoneNumHint", "getPhoneNumHint", "setPhoneNumHint", "phone_intro", "getPhone_intro", "setPhone_intro", "title", "getTitle", "setTitle", "tebridge_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddPhoneModel.kt */
public final class AddPhoneModel implements BffGsonStruct {
    @SerializedName("confirm_btn_text")
    private String confirmBtnText;
    @SerializedName("confirm_intro")
    private GlobalRichInfo confirmIntro;
    @SerializedName("contacts_img_tips")
    private String contactsImgTips;
    @SerializedName("introductions")
    private List<String> introductions;
    @SerializedName("name_hint")
    private String nameHint;
    @SerializedName("name_intro")
    private GlobalRichInfo nameIntro;
    @SerializedName("phone_num_hint")
    private String phoneNumHint;
    @SerializedName("phone_intro")
    private GlobalRichInfo phone_intro;
    @SerializedName("title")
    private String title;

    public Object clone() {
        return super.clone();
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<String> getIntroductions() {
        return this.introductions;
    }

    public final void setIntroductions(List<String> list) {
        this.introductions = list;
    }

    public final String getContactsImgTips() {
        return this.contactsImgTips;
    }

    public final void setContactsImgTips(String str) {
        this.contactsImgTips = str;
    }

    public final GlobalRichInfo getPhone_intro() {
        return this.phone_intro;
    }

    public final void setPhone_intro(GlobalRichInfo globalRichInfo) {
        this.phone_intro = globalRichInfo;
    }

    public final String getNameHint() {
        return this.nameHint;
    }

    public final void setNameHint(String str) {
        this.nameHint = str;
    }

    public final GlobalRichInfo getNameIntro() {
        return this.nameIntro;
    }

    public final void setNameIntro(GlobalRichInfo globalRichInfo) {
        this.nameIntro = globalRichInfo;
    }

    public final GlobalRichInfo getConfirmIntro() {
        return this.confirmIntro;
    }

    public final void setConfirmIntro(GlobalRichInfo globalRichInfo) {
        this.confirmIntro = globalRichInfo;
    }

    public final String getConfirmBtnText() {
        return this.confirmBtnText;
    }

    public final void setConfirmBtnText(String str) {
        this.confirmBtnText = str;
    }

    public final String getPhoneNumHint() {
        return this.phoneNumHint;
    }

    public final void setPhoneNumHint(String str) {
        this.phoneNumHint = str;
    }
}
