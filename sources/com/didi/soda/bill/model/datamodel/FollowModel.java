package com.didi.soda.bill.model.datamodel;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.soda.customer.foundation.util.FontUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u000209H\u0016J\u0010\u0010:\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u000209R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001c\u0010 \u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001c\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001c\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u001c\u0010,\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000e¨\u0006;"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/FollowModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "activityId", "", "getActivityId", "()I", "setActivityId", "(I)V", "benefitDesc", "", "getBenefitDesc", "()Ljava/lang/String;", "setBenefitDesc", "(Ljava/lang/String;)V", "benefitId", "getBenefitId", "setBenefitId", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "getEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "setEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;)V", "isSelected", "setSelected", "leftTitle", "getLeftTitle", "setLeftTitle", "oriPackPriceDisplay", "getOriPackPriceDisplay", "setOriPackPriceDisplay", "oriPriceDisplay", "getOriPriceDisplay", "setOriPriceDisplay", "packPriceDisplay", "getPackPriceDisplay", "setPackPriceDisplay", "priceDisplay", "getPriceDisplay", "setPriceDisplay", "productId", "getProductId", "setProductId", "rightTitle", "getRightTitle", "setRightTitle", "title", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "url", "getUrl", "setUrl", "convertModel", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "convertModelV2", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FollowModel.kt */
public final class FollowModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f39103a;

    /* renamed from: b */
    private String f39104b;

    /* renamed from: c */
    private String f39105c;

    /* renamed from: d */
    private String f39106d;

    /* renamed from: e */
    private String f39107e;

    /* renamed from: f */
    private String f39108f;

    /* renamed from: g */
    private String f39109g;

    /* renamed from: h */
    private int f39110h;

    /* renamed from: i */
    private CharSequence f39111i;

    /* renamed from: j */
    private FollowingInfoEntity f39112j;

    /* renamed from: k */
    private String f39113k;

    /* renamed from: l */
    private String f39114l;

    /* renamed from: m */
    private int f39115m;

    /* renamed from: n */
    private int f39116n;

    public final String getProductId() {
        return this.f39103a;
    }

    public final void setProductId(String str) {
        this.f39103a = str;
    }

    public final String getUrl() {
        return this.f39104b;
    }

    public final void setUrl(String str) {
        this.f39104b = str;
    }

    public final String getBenefitDesc() {
        return this.f39105c;
    }

    public final void setBenefitDesc(String str) {
        this.f39105c = str;
    }

    public final String getPriceDisplay() {
        return this.f39106d;
    }

    public final void setPriceDisplay(String str) {
        this.f39106d = str;
    }

    public final String getPackPriceDisplay() {
        return this.f39107e;
    }

    public final void setPackPriceDisplay(String str) {
        this.f39107e = str;
    }

    public final String getOriPriceDisplay() {
        return this.f39108f;
    }

    public final void setOriPriceDisplay(String str) {
        this.f39108f = str;
    }

    public final String getOriPackPriceDisplay() {
        return this.f39109g;
    }

    public final void setOriPackPriceDisplay(String str) {
        this.f39109g = str;
    }

    public final int isSelected() {
        return this.f39110h;
    }

    public final void setSelected(int i) {
        this.f39110h = i;
    }

    public final CharSequence getTitle() {
        return this.f39111i;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f39111i = charSequence;
    }

    public final FollowingInfoEntity getEntity() {
        return this.f39112j;
    }

    public final void setEntity(FollowingInfoEntity followingInfoEntity) {
        this.f39112j = followingInfoEntity;
    }

    public final String getLeftTitle() {
        return this.f39113k;
    }

    public final void setLeftTitle(String str) {
        this.f39113k = str;
    }

    public final String getRightTitle() {
        return this.f39114l;
    }

    public final void setRightTitle(String str) {
        this.f39114l = str;
    }

    public final int getActivityId() {
        return this.f39115m;
    }

    public final void setActivityId(int i) {
        this.f39115m = i;
    }

    public final int getBenefitId() {
        return this.f39116n;
    }

    public final void setBenefitId(int i) {
        this.f39116n = i;
    }

    public FollowModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        FollowingInfoEntity followingInfo = billComponentDataEntity.getFollowingInfo();
        if (followingInfo == null) {
            return null;
        }
        String string = TextUtils.isEmpty(followingInfo.url) ? "" : ResourceHelper.getString(R.string.customer_common_icon_notes);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(followingInfo.valueDesc);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString.setSpan(new CustomerVerticalCenterSpan(12), 0, string.length(), 33);
        spannableStringBuilder.append(ResourceHelper.getString(R.string.customer_global_blank));
        spannableStringBuilder.append(spannableString);
        setEntity(followingInfo);
        setBenefitDesc(followingInfo.benefitDesc);
        setPriceDisplay(followingInfo.priceDisplay);
        setOriPriceDisplay(followingInfo.oriPriceDisplay);
        setSelected(followingInfo.isSelected);
        setUrl(followingInfo.url);
        setTitle(spannableStringBuilder);
        setProductId(followingInfo.productId);
        return this;
    }

    public final FollowModel convertModelV2(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        FollowingInfoEntity followingInfo = billComponentDataEntity.getFollowingInfo();
        if (followingInfo == null) {
            return null;
        }
        setEntity(followingInfo);
        setBenefitDesc(followingInfo.benefitDesc);
        setPriceDisplay(followingInfo.priceDisplay);
        setOriPriceDisplay(followingInfo.oriPriceDisplay);
        setSelected(followingInfo.isSelected);
        setUrl(followingInfo.url);
        setTitle(followingInfo.valueDesc);
        setProductId(followingInfo.productId);
        setLeftTitle(followingInfo.leftTitle);
        setRightTitle(followingInfo.rightTitle);
        setActivityId(followingInfo.activityId);
        setBenefitId(followingInfo.benefitId);
        setPackPriceDisplay(followingInfo.packPriceDisplay);
        setOriPackPriceDisplay(followingInfo.oriPackPriceDisplay);
        return this;
    }
}
