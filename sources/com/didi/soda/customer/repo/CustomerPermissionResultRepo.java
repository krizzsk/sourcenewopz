package com.didi.soda.customer.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class CustomerPermissionResultRepo extends Repo<PermissionResult> {

    public static class RequestCode {
        public static final int WEB_REQUEST_PERMISSION = 1000;
    }

    public Subscription subscribeResult(ScopeContext scopeContext, final Action2<PermissionResult> action2, final int... iArr) {
        return super.subscribe(scopeContext, new Action2<PermissionResult>() {
            public void call(PermissionResult permissionResult, Subscription subscription) {
                Action2 action2;
                if (permissionResult != null) {
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        int[] iArr = iArr;
                        if (i >= iArr.length) {
                            break;
                        } else if (iArr[i] == permissionResult.requestCode) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z && (action2 = action2) != null) {
                        action2.call(permissionResult, subscription);
                    }
                    CustomerPermissionResultRepo.this.setValue(null);
                }
            }
        });
    }

    public void dispatchResult(int i, String[] strArr, int[] iArr) {
        setValue(new PermissionResult(i, strArr, iArr));
    }

    public static class PermissionResult {
        public int[] grantResults;
        public String[] permissions;
        public int requestCode;

        public PermissionResult(int i, String[] strArr, int[] iArr) {
            this.requestCode = i;
            this.permissions = strArr;
            this.grantResults = iArr;
        }
    }
}
