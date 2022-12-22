package com.didi.entrega.customer.repo;

import android.content.Intent;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;

public class CustomerActivityResultRepo extends Repo<ActivityResult> {

    public static class RequestCode {
        public static final int CART_VALIDATE_CARD_REQUEST = 102;
        public static final int PAY_VALIDATE_CARD_REQUEST = 101;
    }

    public Subscription subscribeResult(ScopeContext scopeContext, final Action1<ActivityResult> action1, final int... iArr) {
        return super.subscribe(scopeContext, new Action1<ActivityResult>() {
            public void call(ActivityResult activityResult) {
                Action1 action1;
                if (activityResult != null) {
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        int[] iArr = iArr;
                        if (i >= iArr.length) {
                            break;
                        } else if (iArr[i] == activityResult.requestCode) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z && (action1 = action1) != null) {
                        action1.call(activityResult);
                    }
                    CustomerActivityResultRepo.this.setValue(null);
                }
            }
        });
    }

    public void dispatchResult(int i, int i2, Intent intent) {
        setValue(new ActivityResult(i, i2, intent));
    }

    public static class ActivityResult {
        public Intent data;
        public int requestCode;
        public int resultCode;

        public ActivityResult(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent;
        }
    }
}
