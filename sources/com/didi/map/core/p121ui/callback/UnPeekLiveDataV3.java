package com.didi.map.core.p121ui.callback;

@Deprecated
/* renamed from: com.didi.map.core.ui.callback.UnPeekLiveDataV3 */
public class UnPeekLiveDataV3<T> extends ProtectedUnPeekLiveDataV3<T> {
    public void setValue(T t) {
        super.setValue(t);
    }

    public void postValue(T t) {
        super.postValue(t);
    }

    /* renamed from: com.didi.map.core.ui.callback.UnPeekLiveDataV3$Builder */
    public static class Builder<T> {
        private int eventSurvivalTime = 1000;
        private boolean isAllowNullValue;
        private boolean isAllowToClear = true;

        public Builder<T> setEventSurvivalTime(int i) {
            this.eventSurvivalTime = i;
            return this;
        }

        public Builder<T> setAllowNullValue(boolean z) {
            this.isAllowNullValue = z;
            return this;
        }

        public Builder<T> setAllowToClear(boolean z) {
            this.isAllowToClear = z;
            return this;
        }

        public UnPeekLiveDataV3<T> create() {
            UnPeekLiveDataV3<T> unPeekLiveDataV3 = new UnPeekLiveDataV3<>();
            unPeekLiveDataV3.DELAY_TO_CLEAR_EVENT = this.eventSurvivalTime;
            unPeekLiveDataV3.isAllowNullValue = this.isAllowNullValue;
            unPeekLiveDataV3.isAllowToClear = this.isAllowToClear;
            return unPeekLiveDataV3;
        }
    }
}
