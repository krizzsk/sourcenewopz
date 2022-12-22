package com.didiglobal.p205sa.biz.tab.manager;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.SPUtils;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabHotInfo;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0019R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabHotInfoManager;", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "(Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;)V", "appContext", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "getData", "()Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "setData", "groupId", "", "hasClickCount", "", "hasShowCount", "hotInfo", "Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;", "keyHideAfterActived", "keyHideAfterShown", "keyMd5", "savedMD5", "clickHot", "", "needShowHot", "", "updateHot", "view", "Landroid/widget/ImageView;", "hasTip", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabHotInfoManager */
/* compiled from: SaTabHotInfoManager.kt */
public final class SaTabHotInfoManager {

    /* renamed from: a */
    private SaTabFragment.TabModel f51232a;

    /* renamed from: b */
    private final String f51233b;

    /* renamed from: c */
    private final SaTabHotInfo f51234c;

    /* renamed from: d */
    private final String f51235d;

    /* renamed from: e */
    private final String f51236e;

    /* renamed from: f */
    private final String f51237f;

    /* renamed from: g */
    private final Application f51238g;

    /* renamed from: h */
    private int f51239h;

    /* renamed from: i */
    private int f51240i;

    /* renamed from: j */
    private String f51241j;

    public SaTabHotInfoManager(SaTabFragment.TabModel tabModel) {
        Intrinsics.checkNotNullParameter(tabModel, "data");
        this.f51232a = tabModel;
        SaTabMenuModel tabMenu = tabModel.getTabMenu();
        SaTabHotInfo saTabHotInfo = null;
        this.f51233b = tabMenu == null ? null : tabMenu.getTabId();
        SaTabMenuModel tabMenu2 = this.f51232a.getTabMenu();
        this.f51234c = tabMenu2 != null ? tabMenu2.getHotInfo() : saTabHotInfo;
        this.f51235d = Intrinsics.stringPlus("SaTabHotInfoManager_keyMd5_", this.f51233b);
        this.f51236e = Intrinsics.stringPlus("SaTabHotInfoManager_keyHideAfterActived_", this.f51233b);
        this.f51237f = Intrinsics.stringPlus("SaTabHotInfoManager_keyMd5_keyHideAfterShown_", this.f51233b);
        Application appContext = DIDIApplication.getAppContext();
        this.f51238g = appContext;
        Object obj = SPUtils.get(appContext, this.f51237f, 0);
        if (obj != null) {
            this.f51239h = ((Integer) obj).intValue();
            Object obj2 = SPUtils.get(this.f51238g, this.f51236e, 0);
            if (obj2 != null) {
                this.f51240i = ((Integer) obj2).intValue();
                this.f51241j = (String) SPUtils.get(this.f51238g, this.f51235d, "");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final SaTabFragment.TabModel getData() {
        return this.f51232a;
    }

    public final void setData(SaTabFragment.TabModel tabModel) {
        Intrinsics.checkNotNullParameter(tabModel, "<set-?>");
        this.f51232a = tabModel;
    }

    public final void updateHot(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(8);
                return;
            }
            SaTabFragment.TabModel.TabPointInfo tabPointInfo = this.f51232a.getTabPointInfo();
            if (tabPointInfo == null || !tabPointInfo.getHasPoint()) {
                SaTabHotInfo saTabHotInfo = this.f51234c;
                if (saTabHotInfo == null) {
                    imageView.setVisibility(8);
                    return;
                }
                SPUtils.put(this.f51238g, this.f51235d, saTabHotInfo.getMd5());
                if (this.f51234c.getHotShowType() == 1) {
                    imageView.setVisibility(0);
                    ((RequestBuilder) Glide.with((Context) this.f51238g).load(this.f51234c.getHotUrl()).placeholder((int) R.drawable.sa_business_more_item_default)).into(imageView);
                    return;
                }
                if (TextUtils.equals(this.f51241j, this.f51234c.getMd5())) {
                    int i = this.f51239h - 1;
                    this.f51239h = i;
                    if (i <= 0) {
                        this.f51239h = 0;
                    }
                    SPUtils.put(this.f51238g, this.f51237f, Integer.valueOf(this.f51239h));
                } else {
                    this.f51239h = this.f51234c.getHideAfterShown();
                    this.f51240i = this.f51234c.getHideAfterActived();
                    SPUtils.put(this.f51238g, this.f51236e, Integer.valueOf(this.f51234c.getHideAfterActived()));
                    SPUtils.put(this.f51238g, this.f51237f, Integer.valueOf(this.f51234c.getHideAfterShown()));
                }
                if (m36698a()) {
                    imageView.setVisibility(0);
                    ((RequestBuilder) Glide.with((Context) this.f51238g).load(this.f51234c.getHotUrl()).placeholder((int) R.drawable.sa_business_more_item_default)).into(imageView);
                    return;
                }
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            Glide.with((Context) this.f51238g).load(Integer.valueOf(R.drawable.icon_sa_tab_reddot)).into(imageView);
        }
    }

    /* renamed from: a */
    private final boolean m36698a() {
        return this.f51239h > 0 && this.f51240i > 0;
    }

    public final void clickHot() {
        SaTabFragment.TabModel.TabPointInfo tabPointInfo = this.f51232a.getTabPointInfo();
        if (tabPointInfo == null || (TextUtils.isEmpty(tabPointInfo.getTipPoint()) && !tabPointInfo.getHasPoint())) {
            int i = this.f51240i - 1;
            this.f51240i = i;
            if (i <= 0) {
                this.f51240i = 0;
            }
            SPUtils.put(this.f51238g, this.f51236e, Integer.valueOf(this.f51240i));
        }
    }
}
