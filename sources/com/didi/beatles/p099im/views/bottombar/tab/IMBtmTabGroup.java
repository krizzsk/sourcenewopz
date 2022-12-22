package com.didi.beatles.p099im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup */
public class IMBtmTabGroup extends LinearLayout {

    /* renamed from: a */
    private static final String f10122a = IMBtmTabGroup.class.getSimpleName();

    /* renamed from: b */
    private static final float f10123b = 1.0f;

    /* renamed from: c */
    private static final float f10124c = 0.5f;

    /* renamed from: d */
    private OnTabCheckedChangeListener f10125d;

    /* renamed from: e */
    private int f10126e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Map<String, String> f10127f;

    /* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabGroup$OnTabCheckedChangeListener */
    public interface OnTabCheckedChangeListener {
        void onTabCheckedChanged(int i, boolean z, boolean z2);
    }

    public IMBtmTabGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10126e = -1;
        this.f10127f = null;
        setOrientation(0);
    }

    public void setExtraTraceMap(Map<String, String> map) {
        this.f10127f = map;
    }

    public void setOnTabCheckedChangeListener(OnTabCheckedChangeListener onTabCheckedChangeListener) {
        this.f10125d = onTabCheckedChangeListener;
    }

    public void setCheckId(int i, boolean z) {
        m6903a(i, z);
    }

    public int getCheckedId() {
        return this.f10126e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6903a(int i, boolean z) {
        boolean z2 = i != this.f10126e;
        IMLog.m6631d(f10122a, C4234I.m6591t("[check] pluginId=", Integer.valueOf(i), " |mCheckedPluginId=", Integer.valueOf(this.f10126e), " |needNotify=", Boolean.valueOf(z2)));
        int i2 = this.f10126e;
        if (i2 != -1) {
            m6904a(i2, false, z2, z);
        }
        if (i != -1) {
            m6904a(i, true, z2, z);
        }
        this.f10126e = i;
    }

    public void reset() {
        if (getVisibility() != 8) {
            m6903a(-1, false);
        }
    }

    public void bindData(List<IMTabActionItem> list) {
        removeAllViews();
        for (IMTabActionItem next : list) {
            addView(m6910b(next));
            if (next.pluginId == this.f10126e && !next.enable) {
                this.f10126e = -1;
                IMLog.m6631d(f10122a, C4234I.m6591t("[bindData] reset checked but disable tab -> ", Integer.valueOf(next.pluginId)));
            }
        }
        m6903a(this.f10126e, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6906a(IMTabActionItem iMTabActionItem) {
        if (iMTabActionItem.pluginId == 5) {
            int btmTabRedDotShowedCount = IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5);
            if (btmTabRedDotShowedCount >= 3) {
                View defaultTabView = iMTabActionItem.getDefaultTabView();
                if (defaultTabView instanceof IMBtmTabContentView) {
                    ((IMBtmTabContentView) defaultTabView).setDotVisible(8);
                }
            }
            if (btmTabRedDotShowedCount < 3) {
                IMPreference.getInstance(IMContextInfoHelper.getContext()).saveBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5, btmTabRedDotShowedCount + 1);
            }
        }
    }

    /* renamed from: b */
    private View m6910b(final IMTabActionItem iMTabActionItem) {
        IMBtmTabItemView iMBtmTabItemView = new IMBtmTabItemView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        iMBtmTabItemView.setLayoutParams(layoutParams);
        if (iMTabActionItem.enable) {
            iMBtmTabItemView.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMBtmTabGroup.this.m6903a(iMTabActionItem.pluginId, true);
                    IMBtmTabGroup.this.m6906a(iMTabActionItem);
                    IMTraceUtil.addBusinessEvent("wyc_ddim_changetab_ck").add("ck_type", Integer.valueOf(iMTabActionItem.pluginId)).add(IMBtmTabGroup.this.f10127f).report();
                }
            });
            iMBtmTabItemView.setAlpha(1.0f);
        } else {
            iMBtmTabItemView.setOnClickListener((View.OnClickListener) null);
            iMBtmTabItemView.setSelected(false);
            iMBtmTabItemView.setAlpha(0.5f);
        }
        if (iMTabActionItem.customTabView != null) {
            iMBtmTabItemView.addTabView(iMTabActionItem.customTabView);
        } else {
            View defaultTabView = iMTabActionItem.getDefaultTabView();
            if (defaultTabView instanceof IMBtmTabContentView) {
                IMBtmTabContentView iMBtmTabContentView = (IMBtmTabContentView) defaultTabView;
                iMBtmTabContentView.bindData(iMTabActionItem.text, iMTabActionItem.iconId);
                m6907a(iMTabActionItem, iMBtmTabContentView);
            }
            iMBtmTabItemView.addTabView(defaultTabView);
        }
        m6905a((View) iMBtmTabItemView, iMTabActionItem.pluginId);
        return iMBtmTabItemView;
    }

    /* renamed from: a */
    private void m6907a(IMTabActionItem iMTabActionItem, IMBtmTabContentView iMBtmTabContentView) {
        if (iMTabActionItem.pluginId == 5 && IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 5) < 3) {
            iMBtmTabContentView.setDotVisible(0);
        }
    }

    /* renamed from: a */
    private void m6904a(int i, boolean z, boolean z2, boolean z3) {
        OnTabCheckedChangeListener onTabCheckedChangeListener;
        View a = m6901a(i);
        if (a != null && (a instanceof IMBtmTabItemView)) {
            ((IMBtmTabItemView) a).setChecked(z);
        }
        if (a != null) {
            a.setSelected(z);
        }
        if (z2 && (onTabCheckedChangeListener = this.f10125d) != null) {
            onTabCheckedChangeListener.onTabCheckedChanged(i, z, z3);
        }
    }

    /* renamed from: a */
    private View m6901a(int i) {
        View findViewWithTag = findViewWithTag(String.valueOf(i));
        if (findViewWithTag == null) {
            IMLog.m6632e(f10122a, "[findViewByPluginId] NULL VIEW. pluginId=", Integer.valueOf(i));
        }
        return findViewWithTag;
    }

    /* renamed from: a */
    private void m6905a(View view, int i) {
        view.setTag(String.valueOf(i));
    }
}
