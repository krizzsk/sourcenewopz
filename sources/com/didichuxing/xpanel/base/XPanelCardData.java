package com.didichuxing.xpanel.base;

import android.text.TextUtils;
import android.view.View;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.xpanel.log.CardAllShowLogHelper;
import com.didichuxing.xpanel.log.CardHalfShowLogHelper;
import com.didichuxing.xpanel.log.CardLifecyclerHelper;
import com.didichuxing.xpanel.log.ExtensionLogHelper;
import com.didichuxing.xpanel.log.MisLogHelper;
import com.didichuxing.xpanel.models.IXPanelModel;
import com.didichuxing.xpanel.util.HttpRequestUtil;
import com.didichuxing.xpanel.util.Utils;
import com.didichuxing.xpanel.util.XPanelOmegaUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

public class XPanelCardData<T> {
    public static final String AUTO_REQUEST_LINK = "autoRequestLink";

    /* renamed from: a */
    CardLifecyclerHelper f49323a;
    public int allCardLength;

    /* renamed from: b */
    ExtensionLogHelper f49324b;

    /* renamed from: c */
    private long f49325c;
    public int cardPosition;
    public IXPanelChildView<T> content;

    /* renamed from: d */
    private boolean f49326d;
    public JSONObject dataJson;
    public int defaultStatus;

    /* renamed from: e */
    private CardHalfShowLogHelper f49327e;

    /* renamed from: f */
    private CardAllShowLogHelper f49328f;
    public ICardShow iCardShow;
    public IOmegaMap iOmegaMap;

    /* renamed from: id */
    public String f49329id;
    public int isInitStatus;
    public boolean isMain;
    public boolean isSortMain;
    public Scriptable jsScope;
    public int length;
    public int level;
    public float mCardRoundCorner;
    public String mTemplate;
    public MisLogHelper misLogHelper;
    public T object;
    public int position;

    public interface ICardShow {
        void destroy();

        void moveIn();

        void moveOut();

        void onCardAllShow(Map<String, Object> map);
    }

    public interface IOmegaMap {
        Map<String, Object> createCustomMap();
    }

    public static String getPullType(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "业务方调用拉起" : "xpanel自动拉起" : "滑动拉起" : "点击拉起" : "默认展示";
    }

    private class ViewDataObject {
        public String XML;
        public String data;

        private ViewDataObject() {
        }
    }

    private XPanelCardData() {
        this.isSortMain = false;
        this.isMain = false;
        this.f49325c = -1;
        this.isInitStatus = 0;
        this.defaultStatus = 0;
        this.misLogHelper = new MisLogHelper();
        this.f49323a = new CardLifecyclerHelper();
        this.f49327e = new CardHalfShowLogHelper(this);
        this.f49328f = new CardAllShowLogHelper(this);
    }

    public static class Builder<T> {
        private ICardShow iCardShow;
        private IOmegaMap iOmegaMap;

        /* renamed from: id */
        private String f49330id;
        private Scriptable jsScope;
        private int level;
        private T object;
        private String template;
        private IXPanelChildView view;
        private String viewData;

        public Builder level(int i) {
            this.level = i;
            return this;
        }

        public Builder object(T t) {
            this.object = t;
            return this;
        }

        public Builder template(String str) {
            this.template = str;
            return this;
        }

        public Builder view(IXPanelChildView<T> iXPanelChildView) {
            this.view = iXPanelChildView;
            return this;
        }

        public Builder view(View view2, boolean z) {
            this.view = new CommonXPanelChildView(view2, z);
            return this;
        }

        public Builder view(View view2, boolean z, boolean z2) {
            this.view = new CommonXPanelChildView(view2, z, z2);
            return this;
        }

        public Builder view(View view2) {
            return view(view2, true);
        }

        /* renamed from: id */
        public Builder mo121493id(String str) {
            this.f49330id = str;
            return this;
        }

        public Builder iCardShow(ICardShow iCardShow2) {
            this.iCardShow = iCardShow2;
            return this;
        }

        public Builder iOmegaMap(IOmegaMap iOmegaMap2) {
            this.iOmegaMap = iOmegaMap2;
            return this;
        }

        public Builder jsScope(Scriptable scriptable) {
            this.jsScope = scriptable;
            return this;
        }

        public XPanelCardData<T> build() {
            String str;
            XPanelCardData<T> xPanelCardData = new XPanelCardData<>();
            xPanelCardData.level = this.level;
            xPanelCardData.object = this.object;
            if (TextUtils.isEmpty(this.template)) {
                T t = this.object;
                if (t instanceof IXPanelModel) {
                    str = ((IXPanelModel) t).getTemplate();
                    xPanelCardData.mTemplate = str;
                    xPanelCardData.content = this.view;
                    xPanelCardData.f49329id = this.f49330id;
                    xPanelCardData.iCardShow = this.iCardShow;
                    xPanelCardData.iOmegaMap = this.iOmegaMap;
                    xPanelCardData.jsScope = this.jsScope;
                    return xPanelCardData;
                }
            }
            str = this.template;
            xPanelCardData.mTemplate = str;
            xPanelCardData.content = this.view;
            xPanelCardData.f49329id = this.f49330id;
            xPanelCardData.iCardShow = this.iCardShow;
            xPanelCardData.iOmegaMap = this.iOmegaMap;
            xPanelCardData.jsScope = this.jsScope;
            return xPanelCardData;
        }
    }

    public void bindData() {
        IXPanelChildView<T> iXPanelChildView = this.content;
        if (iXPanelChildView != null) {
            iXPanelChildView.setRoundCorner(this.mCardRoundCorner);
            this.content.initData(this);
            this.content.bind(this.object);
        }
    }

    public void destroy() {
        IXPanelChildView<T> iXPanelChildView = this.content;
        if (iXPanelChildView != null) {
            iXPanelChildView.destroy();
        }
        ICardShow iCardShow2 = this.iCardShow;
        if (iCardShow2 != null) {
            iCardShow2.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public final String getXPanelKey() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(TextUtils.isEmpty(this.f49329id) ? str : this.f49329id);
        if (!TextUtils.isEmpty(this.mTemplate)) {
            str = this.mTemplate;
        }
        sb.append(str);
        return sb.toString();
    }

    public final boolean moveIn() {
        return moveIn((Map<String, Object>) null);
    }

    public final boolean moveIn(Map<String, Object> map) {
        if (this.f49326d) {
            return false;
        }
        this.f49323a.dispatchViewLifecycle(this, "cardMoveIn");
        this.f49325c = System.currentTimeMillis();
        this.f49326d = true;
        if (!TextUtils.isEmpty(this.f49329id)) {
            XPanelOmegaUtils.trackEvent("xpanel_card_sw", getOmegaParams(map));
            m35570a();
        }
        ICardShow iCardShow2 = this.iCardShow;
        if (iCardShow2 != null) {
            iCardShow2.moveIn();
        }
        return true;
    }

    public boolean isMain(boolean z) {
        return z ? this.isMain : this.isSortMain;
    }

    /* renamed from: a */
    private void m35570a() {
        String str;
        T t = this.object;
        if (t instanceof IXPanelModel) {
            HashMap<String, Object> extensions = ((IXPanelModel) t).getExtensions();
            if (extensions != null) {
                str = (String) extensions.get(AUTO_REQUEST_LINK);
            } else {
                return;
            }
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            HttpRequestUtil.requestUrl(str);
        }
    }

    public final boolean moveOut() {
        return moveOut((Map<String, Object>) null);
    }

    public final boolean moveOut(Map<String, Object> map) {
        if (!this.f49326d) {
            return false;
        }
        this.f49323a.dispatchViewLifecycle(this, "cardMoveOut");
        this.f49326d = false;
        ICardShow iCardShow2 = this.iCardShow;
        if (iCardShow2 != null) {
            iCardShow2.moveOut();
        }
        Map<String, Object> omegaParams = getOmegaParams(map);
        omegaParams.put("time", Long.valueOf(System.currentTimeMillis() - this.f49325c));
        XPanelOmegaUtils.trackEvent("xpanel_card_sw_time", omegaParams);
        return true;
    }

    public final boolean moveHalfIn() {
        return this.f49327e.moveHalfIn();
    }

    public final boolean moveHalfOut(Map<String, Object> map) {
        return this.f49327e.moveHalfOut(map);
    }

    public final boolean isEfficientShow() {
        return this.f49327e.isCurrentEfficientShow();
    }

    public final boolean moveAllIn(Map<String, Object> map) {
        return this.f49328f.moveAllIn(map);
    }

    public final boolean moveAllOut(Map<String, Object> map) {
        return this.f49328f.moveAllOut(map);
    }

    public void setMisLogHelper(MisLogHelper misLogHelper2) {
        this.misLogHelper = misLogHelper2;
    }

    public void setExtensionLogHelper(ExtensionLogHelper extensionLogHelper) {
        this.f49324b = extensionLogHelper;
    }

    public Map<String, Object> getOmegaParams(Map<String, Object> map) {
        Map<String, Object> createCustomMap;
        if (map == null) {
            map = new HashMap<>();
        }
        if (!TextUtils.isEmpty(this.mTemplate)) {
            map.put("template", this.mTemplate);
        }
        if (!TextUtils.isEmpty(this.f49329id)) {
            map.put(BaseCard.KEY_CARD_ID, this.f49329id);
        }
        map.put("card_position", Integer.valueOf(this.cardPosition));
        map.put("position", Integer.valueOf(this.position));
        map.put("default_status", Integer.valueOf(this.defaultStatus));
        map.put("bottom_index", Integer.valueOf(this.length));
        map.put("length", Integer.valueOf(this.allCardLength));
        MisLogHelper misLogHelper2 = this.misLogHelper;
        if (misLogHelper2 != null && misLogHelper2.isMis) {
            map.put(MisLogHelper.IS_MIS, true);
            map.put(MisLogHelper.CLICK_TRACKS, this.misLogHelper.clickTracks);
            map.put(MisLogHelper.IMP_TRACKS, this.misLogHelper.impTracks);
        }
        T t = this.object;
        if (t instanceof IXPanelModel) {
            HashMap<String, Object> extensions = ((IXPanelModel) t).getExtensions();
            if (!(extensions == null || extensions.size() == 0)) {
                map.putAll(extensions);
            }
        } else {
            ExtensionLogHelper extensionLogHelper = this.f49324b;
            if (extensionLogHelper != null) {
                extensionLogHelper.addLogData(map);
            }
        }
        IOmegaMap iOmegaMap2 = this.iOmegaMap;
        if (!(iOmegaMap2 == null || (createCustomMap = iOmegaMap2.createCustomMap()) == null)) {
            for (String next : createCustomMap.keySet()) {
                if (!map.containsKey(next)) {
                    map.put(next, createCustomMap.get(next));
                }
            }
        }
        return map;
    }

    public void clickCardOmega(Map<String, Object> map) {
        if (!TextUtils.isEmpty(this.f49329id)) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("effect_ck", Integer.valueOf(isEfficientShow() ? 1 : 0));
            XPanelOmegaUtils.trackEvent("xpanel_card_ck", getOmegaParams(map));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XPanelCardData)) {
            return false;
        }
        XPanelCardData xPanelCardData = (XPanelCardData) obj;
        if (!TextUtils.equals(this.f49329id, xPanelCardData.f49329id) || !TextUtils.equals(this.mTemplate, xPanelCardData.mTemplate) || this.isSortMain != xPanelCardData.isSortMain || this.isMain != xPanelCardData.isMain || this.level != xPanelCardData.level || !Utils.equals(this.object, xPanelCardData.object)) {
            return false;
        }
        return true;
    }

    public void showTipIcon() {
        View findViewById;
        IXPanelChildView<T> iXPanelChildView = this.content;
        if (iXPanelChildView != null && iXPanelChildView.getView() != null && (findViewById = this.content.getView().findViewById(R.id.corn_mark)) != null) {
            findViewById.setVisibility(0);
        }
    }

    public void hideTipIcon() {
        View findViewById;
        IXPanelChildView<T> iXPanelChildView = this.content;
        if (iXPanelChildView != null && iXPanelChildView.getView() != null && (findViewById = this.content.getView().findViewById(R.id.corn_mark)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public boolean isAllInScreen() {
        CardAllShowLogHelper cardAllShowLogHelper = this.f49328f;
        if (cardAllShowLogHelper != null) {
            return cardAllShowLogHelper.isAllInScreen();
        }
        return false;
    }

    public Object callJsFunction(String str, Object[] objArr) {
        Scriptable scriptable = this.jsScope;
        if (scriptable == null) {
            return null;
        }
        try {
            Object obj = scriptable.get(str, scriptable);
            if (obj instanceof Function) {
                return ((Function) obj).call(Context.enter(), this.jsScope, this.jsScope, objArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
