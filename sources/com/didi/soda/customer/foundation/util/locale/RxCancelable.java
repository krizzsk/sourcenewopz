package com.didi.soda.customer.foundation.util.locale;

import com.didi.app.nova.skeleton.tools.Cancelable;
import p242io.reactivex.disposables.Disposable;

public class RxCancelable implements Cancelable {

    /* renamed from: a */
    private Disposable f41266a;

    public RxCancelable(Disposable disposable) {
        this.f41266a = disposable;
    }

    public void cancel() {
        Disposable disposable = this.f41266a;
        if (disposable != null && !disposable.isDisposed()) {
            this.f41266a.dispose();
        }
    }
}
