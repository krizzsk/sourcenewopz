package com.example.compapollovisitor;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashSet;
import java.util.Set;

public class ApolloVisitHelper {
    private static final String TAG = "ApolloVisitHelper";
    private boolean ismHasVisitInPickup;
    private Set<String> mApolloKeySet;
    private boolean mHasVisitInHomePage;

    private static class ApolloVisitHelperHolder {
        /* access modifiers changed from: private */
        public static final ApolloVisitHelper mInstance = new ApolloVisitHelper();

        private ApolloVisitHelperHolder() {
        }
    }

    public static ApolloVisitHelper getInstance() {
        return ApolloVisitHelperHolder.mInstance;
    }

    private ApolloVisitHelper() {
        this.mHasVisitInHomePage = false;
        this.ismHasVisitInPickup = false;
        this.mApolloKeySet = new HashSet();
    }

    public void addApolloKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mApolloKeySet.add(str);
        }
    }

    private void visitApollo() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.mApolloKeySet) {
            IToggle toggle = Apollo.getToggle(next);
            if (toggle != null) {
                toggle.allow();
            }
            sb.append(next);
            sb.append(",");
        }
        DLog.m7384d(TAG, "visitApollo = " + sb.toString(), new Object[0]);
    }

    public void visitApolloInHomePage() {
        DLog.m7384d(TAG, "[visitApolloInHomePage] enter ", new Object[0]);
        if (this.mHasVisitInHomePage) {
            DLog.m7384d(TAG, "[visitApolloInHomePage] return ", new Object[0]);
            return;
        }
        visitApollo();
        this.mHasVisitInHomePage = true;
    }

    public void visitApolloPickup() {
        DLog.m7384d(TAG, "[visitApolloPickup] enter ", new Object[0]);
        if (this.ismHasVisitInPickup) {
            DLog.m7384d(TAG, "[visitApolloPickup] return ", new Object[0]);
            return;
        }
        visitApollo();
        this.ismHasVisitInPickup = true;
    }
}
