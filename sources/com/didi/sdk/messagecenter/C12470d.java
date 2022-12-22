package com.didi.sdk.messagecenter;

import android.text.TextUtils;
import com.didi.sdk.messagecenter.interfaces.IHandler;
import com.didi.sdk.messagecenter.interfaces.IStore;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.interpreter.IInterpreter;
import com.didi.sdk.messagecenter.interpreter.InterpreterFactory;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;
import com.didi.sdk.push.manager.DPushType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.sdk.messagecenter.d */
/* compiled from: SubscribeWrapper */
class C12470d implements ISubscribe.ISubscribeWrapper {

    /* renamed from: a */
    private Object f36766a;

    /* renamed from: b */
    private Set<Class<? extends PushMessage>> f36767b = new HashSet();

    /* renamed from: c */
    private IStore f36768c;

    public C12470d(Object obj, IStore iStore) {
        this.f36766a = obj;
        this.f36768c = iStore;
    }

    public ISubscribe.ISubscribeWrapper subscribe(Class<? extends PushMessage> cls) {
        this.f36767b.add(cls);
        return this;
    }

    public void handler(IHandler iHandler) {
        m26033a(iHandler);
    }

    /* renamed from: a */
    private void m26033a(IHandler iHandler) {
        if (!this.f36767b.isEmpty() && iHandler != null) {
            IInterpreter iInterpreter = null;
            for (Class next : this.f36767b) {
                if (iInterpreter == null) {
                    iInterpreter = InterpreterFactory.getInterpreter(next);
                }
                Set<String> explainTopic = iInterpreter.explainTopic(next);
                String explainType = iInterpreter.explainType(next);
                int explainUnifyId = iInterpreter.explainUnifyId(next);
                if (m26034a(explainTopic, explainType, explainUnifyId)) {
                    for (String next2 : explainTopic) {
                        if (!TextUtils.isEmpty(next2)) {
                            this.f36768c.add(this.f36766a, new Subscription(this.f36766a, next2, explainUnifyId, explainType, iHandler, next));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m26034a(Set<String> set, String str, int i) {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = set != null && !set.isEmpty();
        if (i <= 0) {
            z = false;
        }
        if (!z2) {
            return false;
        }
        if (!z && !TextUtils.equals(str, DPushType.TENCENT_PUSH.getName())) {
            return false;
        }
        return z3;
    }
}
