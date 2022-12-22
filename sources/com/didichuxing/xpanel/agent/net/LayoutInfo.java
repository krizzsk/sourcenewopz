package com.didichuxing.xpanel.agent.net;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class LayoutInfo implements Serializable {
    private static final String X_PANEL_AUTO_SCROLL_CARD = "auto_scroll_card";
    private static final String X_PANEL_AUTO_SCROLL_LENGTH = "auto_scroll_length";
    private static final String X_PANEL_MAX_CONTENT_MAX_SHOW_HEIGHT_PERCENT = "max_show_percent";
    private static final String X_PANEL_MAX_SHOW_LENGTH = "max_show_length";
    public AutoScrollCard autoScrollCard;
    public int autoScrollLength = -1;
    public int maxShowLength = -1;
    public int maxShowPercent = -1;

    public static LayoutInfo parse(JSONObject jSONObject) {
        LayoutInfo layoutInfo = new LayoutInfo();
        try {
            if (!jSONObject.isNull(X_PANEL_AUTO_SCROLL_CARD)) {
                layoutInfo.autoScrollCard = AutoScrollCard.parse(jSONObject.getJSONObject(X_PANEL_AUTO_SCROLL_CARD));
            }
            if (!jSONObject.isNull(X_PANEL_MAX_CONTENT_MAX_SHOW_HEIGHT_PERCENT)) {
                try {
                    int optInt = jSONObject.optInt(X_PANEL_MAX_CONTENT_MAX_SHOW_HEIGHT_PERCENT);
                    layoutInfo.maxShowPercent = optInt;
                    if (optInt < 30) {
                        layoutInfo.maxShowPercent = 30;
                    } else if (optInt > 80) {
                        layoutInfo.maxShowPercent = 80;
                    }
                } catch (Exception unused) {
                    layoutInfo.maxShowPercent = -1;
                }
            }
            if (!jSONObject.isNull(X_PANEL_AUTO_SCROLL_LENGTH)) {
                layoutInfo.autoScrollLength = jSONObject.optInt(X_PANEL_AUTO_SCROLL_LENGTH);
            }
            if (!jSONObject.isNull(X_PANEL_MAX_SHOW_LENGTH)) {
                layoutInfo.maxShowLength = jSONObject.optInt(X_PANEL_MAX_SHOW_LENGTH);
            }
        } catch (JSONException unused2) {
        }
        return layoutInfo;
    }

    public static class AutoScrollCard {
        private static final String X_PANEL_AUTO_SCROLL_CARD_ID = "card_id";
        private static final String X_PANEL_AUTO_SCROLL_RULE = "auto_scroll_rule";
        private static final String X_PANEL_CARD_HALF_REVEAL_HEIGHT = "card_half_reveal_height";
        public int autoScrollRule = 0;
        public int cardHalfRevealHeight;
        public String cardId;
        public boolean isAutoPull = false;
        public boolean isPull = false;

        public void setIsPull(boolean z) {
            this.isPull = z;
        }

        public void setCardHalfRevealHeight(int i) {
            this.cardHalfRevealHeight = i;
        }

        public void setAutoPull(boolean z) {
            this.isAutoPull = z;
        }

        public boolean isFullAutoPull() {
            return this.cardHalfRevealHeight == 65535 || this.isAutoPull;
        }

        public boolean isForcePull() {
            return this.autoScrollRule == 1;
        }

        public String toString() {
            return "cardId = " + this.cardId + ", cardHalfRevealHeight = " + this.cardHalfRevealHeight;
        }

        public static AutoScrollCard parse(JSONObject jSONObject) {
            AutoScrollCard autoScrollCard = new AutoScrollCard();
            autoScrollCard.cardId = jSONObject.optString("card_id");
            autoScrollCard.cardHalfRevealHeight = jSONObject.optInt(X_PANEL_CARD_HALF_REVEAL_HEIGHT);
            autoScrollCard.autoScrollRule = jSONObject.optInt(X_PANEL_AUTO_SCROLL_RULE);
            if (TextUtils.isEmpty(autoScrollCard.cardId) || autoScrollCard.cardHalfRevealHeight <= 0) {
                return null;
            }
            return autoScrollCard;
        }
    }
}
