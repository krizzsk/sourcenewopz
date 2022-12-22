package com.didi.onekeyshare;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import java.util.ArrayList;

public class ShareConfig {
    public static final int WITHOUT_CORNER = 2;
    public static final int WITH_CORNER = 1;

    /* renamed from: a */
    private static ShareConfig f29755a = new ShareConfig();

    /* renamed from: b */
    private Nation f29756b = Nation.CHINA;

    /* renamed from: c */
    private ShareFragmentListener f29757c;

    /* renamed from: d */
    private int f29758d = 1;

    /* renamed from: e */
    private ShareFragmentFactory f29759e;

    public enum Nation {
        CHINA,
        GLOBAL
    }

    public interface ShareFragmentFactory {
        ShareFragment createShareFragment(ShareInfo shareInfo);

        ShareFragment createShareFragment(ArrayList<OneKeyShareInfo> arrayList);
    }

    public void setCornerStyle(int i) {
        this.f29758d = i;
    }

    public int getCornerStyle() {
        return this.f29758d;
    }

    public static ShareConfig getConfig() {
        return f29755a;
    }

    public ShareConfig setNation(Nation nation) {
        this.f29756b = nation;
        return f29755a;
    }

    public void addFragmentListener(ShareFragmentListener shareFragmentListener) {
        this.f29757c = shareFragmentListener;
    }

    public ShareFragmentListener getFragmentListener() {
        return this.f29757c;
    }

    public Nation getNation() {
        return this.f29756b;
    }

    public ShareFragmentFactory getShareFragmentFactory() {
        return this.f29759e;
    }

    public void setShareFragmentFactory(ShareFragmentFactory shareFragmentFactory) {
        this.f29759e = shareFragmentFactory;
    }
}
