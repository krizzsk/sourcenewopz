package com.didi.map.core.p121ui.callback;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* renamed from: com.didi.map.core.ui.callback.UnPeekLiveData */
public class UnPeekLiveData<T> extends ProtectedUnPeekLiveData<T> {
    public void setValue(T t) {
        super.setValue(t);
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    @Deprecated
    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        throw new IllegalArgumentException("请不要在 UnPeekLiveData 中使用 observe 方法。取而代之的是在 Activity 和 Fragment 中分别使用 observeInActivity 和 observeInFragment 来观察。\n\nTaking into account the normal permission of preventing backflow logic,  do not use observeForever to communicate between pages.Instead, you can use ObserveInActivity and ObserveInFragment methods to observe in Activity and Fragment respectively.");
    }

    @Deprecated
    public void observeForever(Observer<? super T> observer) {
        throw new IllegalArgumentException("出于生命周期安全的考虑，请不要在 UnPeekLiveData 中使用 observeForever 方法。\n\nConsidering avoid lifecycle security issues, do not use observeForever for communication between pages.");
    }

    /* renamed from: com.didi.map.core.ui.callback.UnPeekLiveData$Builder */
    public static class Builder<T> {
        private boolean isAllowNullValue;

        public Builder<T> setAllowNullValue(boolean z) {
            this.isAllowNullValue = z;
            return this;
        }

        public UnPeekLiveData<T> create() {
            UnPeekLiveData<T> unPeekLiveData = new UnPeekLiveData<>();
            unPeekLiveData.isAllowNullValue = this.isAllowNullValue;
            return unPeekLiveData;
        }
    }
}
