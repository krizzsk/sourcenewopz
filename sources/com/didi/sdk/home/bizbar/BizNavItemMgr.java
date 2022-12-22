package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.HotInfo;
import com.didi.sdk.util.SPUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BizNavItemMgr {

    /* renamed from: b */
    private static final String f36361b = "nav_red_point_md5";

    /* renamed from: c */
    private static final String f36362c = "nav_red_point_hide_after_actived";

    /* renamed from: d */
    private static final String f36363d = "nav_red_point_hide_after_shown";

    /* renamed from: a */
    List<TopCarGroupWrapper> f36364a;

    /* renamed from: e */
    private Context f36365e;

    /* renamed from: f */
    private HotInfo f36366f;

    /* renamed from: g */
    private boolean f36367g = false;

    /* renamed from: h */
    private boolean f36368h = false;

    /* renamed from: i */
    private final int f36369i = 5;

    /* renamed from: j */
    private BizNavItemView f36370j;
    public int mHideAfterActived = 0;
    public int mHideAfterShown = 0;

    public int getMaxColumnNum() {
        return 5;
    }

    public BizNavItemMgr(Context context) {
        this.f36365e = context;
    }

    public HotInfo getHotInfo() {
        return this.f36366f;
    }

    public void setHotInfo(HotInfo hotInfo) {
        if (hotInfo == null || ((TextUtils.isEmpty(hotInfo.hotTab) && TextUtils.isEmpty(hotInfo.navTag)) || this.f36364a == null)) {
            this.mHideAfterActived = 0;
            this.mHideAfterShown = 0;
            this.f36366f = null;
            BizNavItemView bizNavItemView = this.f36370j;
            if (bizNavItemView != null) {
                bizNavItemView.setRedPointVisibility(8);
                return;
            }
            return;
        }
        HotInfo hotInfo2 = this.f36366f;
        if (hotInfo2 == null || !TextUtils.equals(hotInfo2.MD5, hotInfo.MD5)) {
            this.f36370j = null;
            this.f36366f = hotInfo;
            m25741a();
            if (this.f36366f.hotShowType == 1) {
                this.f36367g = true;
                return;
            }
            String str = (String) SPUtils.get(this.f36365e, f36361b, "");
            if (str == null || !TextUtils.equals(str, hotInfo.MD5)) {
                this.mHideAfterActived = hotInfo.hideAfterActived;
                this.mHideAfterShown = hotInfo.hideAfterShown;
                SPUtils.put(this.f36365e, f36361b, hotInfo.MD5);
                SPUtils.put(this.f36365e, f36362c, Integer.valueOf(this.mHideAfterActived));
            } else {
                this.mHideAfterActived = ((Integer) SPUtils.get(this.f36365e, f36362c, 0)).intValue();
                int intValue = ((Integer) SPUtils.get(this.f36365e, f36363d, 0)).intValue();
                this.mHideAfterShown = intValue;
                this.mHideAfterShown = intValue - 1;
            }
            SPUtils.put(this.f36365e, f36363d, Integer.valueOf(this.mHideAfterShown));
            if (isRedPointNeedShow()) {
                HashMap hashMap = new HashMap();
                hashMap.put("hot_tab", this.f36366f.hotTab);
                hashMap.put("hot_show_type", Integer.valueOf(this.f36366f.hotShowType));
                OmegaSDKAdapter.trackEvent("ibt_gp_business_label_sw", (Map<String, Object>) hashMap);
            }
        }
    }

    public boolean hasRedPoint(String str, String str2) {
        HotInfo hotInfo = this.f36366f;
        return hotInfo != null && (TextUtils.equals(hotInfo.hotTab, str) || TextUtils.equals(this.f36366f.navTag, str2));
    }

    public boolean isRedPointNeedShow() {
        if (!this.f36367g) {
            return this.mHideAfterActived > 0 && this.mHideAfterShown > 0;
        }
        return true;
    }

    public boolean isRedPointShowOnMore() {
        return this.f36368h;
    }

    public void activeRedPointCount() {
        int i;
        if (!this.f36367g && (i = this.mHideAfterActived) > 0) {
            int i2 = i - 1;
            this.mHideAfterActived = i2;
            SPUtils.put(this.f36365e, f36362c, Integer.valueOf(i2));
        }
    }

    public void setNavRedPointItemView(BizNavItemView bizNavItemView) {
        this.f36370j = bizNavItemView;
    }

    public void updateNavRedPointItemView() {
        BizNavItemView bizNavItemView = this.f36370j;
        if (bizNavItemView != null && bizNavItemView.getRedPointVisibility() == 0 && !isRedPointNeedShow()) {
            this.f36370j.setRedPointVisibility(8);
        }
    }

    public List<TopCarGroupWrapper> getList() {
        return this.f36364a;
    }

    public void setList(List<TopCarGroupWrapper> list) {
        int size = list.size();
        boolean z = size > 5;
        for (int i = 0; i < size; i++) {
            TopCarGroupWrapper topCarGroupWrapper = list.get(i);
            if (topCarGroupWrapper.isSelected && i >= 4 && z) {
                list.remove(topCarGroupWrapper);
                list.add(3, topCarGroupWrapper);
            }
        }
        this.f36364a = list;
    }

    public void changeItemToMainBar(TopCarGroupWrapper topCarGroupWrapper) {
        this.f36364a.remove(topCarGroupWrapper);
        this.f36364a.add(3, topCarGroupWrapper);
        m25741a();
    }

    /* renamed from: a */
    private void m25741a() {
        this.f36368h = false;
        if (this.f36364a.size() > 5) {
            int i = 4;
            while (i < this.f36364a.size()) {
                HotInfo hotInfo = this.f36366f;
                if (hotInfo == null || (!hotInfo.hotTab.equals(this.f36364a.get(i).carGrop.getGroupType()) && (this.f36366f.navTag == null || !this.f36366f.navTag.equals(this.f36364a.get(i).carGrop.getNavTag())))) {
                    i++;
                } else {
                    this.f36368h = true;
                    return;
                }
            }
        }
    }
}
