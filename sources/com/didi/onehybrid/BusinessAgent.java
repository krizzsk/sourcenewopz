package com.didi.onehybrid;

import android.content.Context;
import android.support.p003v4.media.session.PlaybackStateCompat;
import com.didi.onehybrid.resource.FusionCacheConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BusinessAgent {
    protected Context appContext;

    public String addCommonQuery(String str) {
        return str;
    }

    public String getBundleBlackList() {
        return "";
    }

    public String getBusinessUA() {
        return "";
    }

    public Map<String, String> getCommonHeaders() {
        return null;
    }

    public long getFlowLimit() {
        return PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
    }

    public String getHighPriorityBundleName() {
        return "";
    }

    public String getOfflineBundleFilePath() {
        return "offlineBundles";
    }

    public abstract String getUserPhone();

    public boolean interceptWhenOverrideUrlLoading(String str) {
        return false;
    }

    public boolean isOfflineOpen() {
        return false;
    }

    public abstract boolean isWhiteUrl(Context context, String str);

    public boolean needPreInitWebView() {
        return true;
    }

    public void refreshAppLocale(Context context) {
    }

    public boolean shouldIntercept(Context context, String str) {
        return false;
    }

    public boolean verifyFile(String str) {
        return true;
    }

    public BusinessAgent(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public List<String> getPreloadUrlList() {
        return Collections.emptyList();
    }

    public FusionCacheConfig getCacheConfig() {
        return new FusionCacheConfig();
    }

    public Map<String, Object> getBundleParams() {
        return new HashMap();
    }

    public static class DummyBusinessAgent extends BusinessAgent {
        public String getUserPhone() {
            return "";
        }

        public boolean isWhiteUrl(Context context, String str) {
            return false;
        }

        public void refreshAppLocale(Context context) {
        }

        public boolean shouldIntercept(Context context, String str) {
            return false;
        }

        public DummyBusinessAgent(Context context) {
            super(context);
        }
    }
}
