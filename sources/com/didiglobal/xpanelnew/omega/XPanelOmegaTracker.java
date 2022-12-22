package com.didiglobal.xpanelnew.omega;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.view.XpanelView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class XPanelOmegaTracker {

    /* renamed from: a */
    private static final String f51617a = XPanelOmegaTracker.class.toString();

    /* renamed from: b */
    private final List<XpCardProperty> f51618b = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    private final List<XpCardProperty> f51619c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private final Set<OmegaCardProperties> f51620d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e */
    private final Set<XpCardProperty> f51621e = Collections.synchronizedSet(new HashSet());

    /* renamed from: f */
    private XPanelOmegaCallback f51622f;

    /* renamed from: g */
    private XpanelView f51623g;

    public XPanelOmegaTracker(XpanelView xpanelView) {
        this.f51623g = xpanelView;
    }

    public void setCurrentCardProperties(List<XpCardProperty> list) {
        this.f51618b.clear();
        this.f51618b.addAll(list);
    }

    public void addCurrentCardProperties(XpCardProperty xpCardProperty, int i) {
        try {
            this.f51618b.add(i, xpCardProperty);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void removeCurrentCardProperties(int i) {
        try {
            this.f51618b.remove(i);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void removeCurrentCardProperties() {
        this.f51618b.clear();
    }

    public void setXPanelItemShowCallback(XPanelOmegaCallback xPanelOmegaCallback) {
        this.f51622f = xPanelOmegaCallback;
    }

    public void omegaShowTrack(boolean z) {
        this.f51619c.clear();
        if (z) {
            for (int i = 0; i < this.f51618b.size(); i++) {
                XpCardProperty xpCardProperty = this.f51618b.get(i);
                if (xpCardProperty.getView() != null) {
                    if (xpCardProperty.getView().getGlobalVisibleRect(new Rect())) {
                        this.f51619c.add(xpCardProperty);
                    }
                }
            }
        }
        if (z) {
            try {
                getShowingViesWhenScrollStopped();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        ArrayList<OmegaCardProperties> arrayList = new ArrayList<>();
        for (OmegaCardProperties next : this.f51620d) {
            if (!z) {
                arrayList.add(next);
            } else if (m36918b(next)) {
                arrayList.add(next);
            }
        }
        for (OmegaCardProperties a : arrayList) {
            m36915a(a);
        }
        for (int i2 = 0; i2 < this.f51619c.size(); i2++) {
            XpCardProperty xpCardProperty2 = this.f51619c.get(i2);
            if (xpCardProperty2.getView() != null) {
                if (!m36917a(xpCardProperty2)) {
                    m36914a(i2, xpCardProperty2, false);
                }
                m36913a(i2, xpCardProperty2);
            }
        }
    }

    public void getShowingViesWhenScrollStopped() {
        if (!this.f51618b.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f51618b.size(); i++) {
                XpCardProperty xpCardProperty = this.f51618b.get(i);
                if (xpCardProperty.getView() != null) {
                    Rect rect = new Rect();
                    if (xpCardProperty.getView().getGlobalVisibleRect(rect)) {
                        XpCardTrackProperty xpCardTrackProperty = new XpCardTrackProperty();
                        xpCardTrackProperty.property = xpCardProperty;
                        xpCardTrackProperty.f51624id = xpCardProperty.getId();
                        xpCardTrackProperty.height = rect.bottom - rect.top;
                        int[] iArr = new int[2];
                        xpCardProperty.getView().getLocationOnScreen(iArr);
                        xpCardTrackProperty.top = iArr[1] - this.f51623g.getScrollerRealHeight();
                        arrayList.add(xpCardTrackProperty);
                    }
                }
            }
            XPanelOmegaCallback xPanelOmegaCallback = this.f51622f;
            if (xPanelOmegaCallback != null) {
                xPanelOmegaCallback.onItemShowingWhenScrollStopped(arrayList);
            }
        }
    }

    /* renamed from: a */
    private void m36913a(int i, XpCardProperty xpCardProperty) {
        if (!m36916a(xpCardProperty.getView())) {
            this.f51621e.remove(xpCardProperty);
        } else if (!this.f51621e.contains(xpCardProperty)) {
            m36914a(i, xpCardProperty, true);
        }
    }

    /* renamed from: a */
    private void m36915a(OmegaCardProperties omegaCardProperties) {
        for (OmegaCardProperties next : this.f51620d) {
            if (next != null && next.property != null && omegaCardProperties != null && omegaCardProperties.property != null && omegaCardProperties.property.getId() != null && TextUtils.equals(next.property.getId(), omegaCardProperties.property.getId())) {
                this.f51620d.remove(next);
                m36919c(next);
                return;
            }
        }
    }

    /* renamed from: b */
    private boolean m36918b(OmegaCardProperties omegaCardProperties) {
        XpCardProperty next;
        if (!(omegaCardProperties == null || omegaCardProperties.property == null || omegaCardProperties.property.getId() == null)) {
            Iterator<XpCardProperty> it = this.f51619c.iterator();
            while (it.hasNext() && (next = it.next()) != null && next.getId() != null) {
                if (next.getId().equals(omegaCardProperties.property.getId())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m36916a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.bottom - rect.top >= view.getHeight();
    }

    /* renamed from: a */
    private boolean m36917a(XpCardProperty xpCardProperty) {
        if (!this.f51620d.isEmpty() && xpCardProperty != null && !TextUtils.isEmpty(xpCardProperty.getId())) {
            for (OmegaCardProperties next : this.f51620d) {
                if (!TextUtils.isEmpty(next.property.getId()) && TextUtils.equals(xpCardProperty.getId(), next.property.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m36914a(int i, XpCardProperty xpCardProperty, boolean z) {
        String str = z ? "xpanel_card_all_sw" : "xpanel_card_sw";
        HashMap hashMap = new HashMap();
        String id = xpCardProperty.getId();
        hashMap.put(BaseCard.KEY_CARD_ID, id);
        hashMap.put("position", Integer.valueOf(i));
        try {
            Map<String, Object> extension = xpCardProperty.getExtension();
            if (extension != null) {
                hashMap.putAll(extension);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaCardProperties omegaCardProperties = new OmegaCardProperties(i, System.currentTimeMillis(), xpCardProperty);
        if (!z) {
            this.f51620d.add(omegaCardProperties);
        } else {
            this.f51621e.add(xpCardProperty);
        }
        String str2 = f51617a;
        SystemUtils.log(6, str2, str + ":" + id, (Throwable) null, "com.didiglobal.xpanelnew.omega.XPanelOmegaTracker", 249);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: c */
    private void m36919c(OmegaCardProperties omegaCardProperties) {
        HashMap hashMap = new HashMap();
        XpCardProperty xpCardProperty = omegaCardProperties.property;
        if (xpCardProperty != null) {
            String id = xpCardProperty.getId();
            hashMap.put(BaseCard.KEY_CARD_ID, id);
            hashMap.put("position", Integer.valueOf(omegaCardProperties.pos));
            long currentTimeMillis = System.currentTimeMillis() - omegaCardProperties.currentMillsOnShowing;
            hashMap.put("time", Long.valueOf(currentTimeMillis));
            try {
                Map<String, Object> extension = xpCardProperty.getExtension();
                if (extension != null) {
                    hashMap.putAll(extension);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = f51617a;
            SystemUtils.log(6, str, "xpanel_card_sw_time:" + id + "...time:" + currentTimeMillis, (Throwable) null, "com.didiglobal.xpanelnew.omega.XPanelOmegaTracker", 277);
            OmegaSDKAdapter.trackEvent("xpanel_card_sw_time", (Map<String, Object>) hashMap);
        }
    }
}
