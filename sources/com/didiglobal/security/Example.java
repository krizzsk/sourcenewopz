package com.didiglobal.security;

import com.didiglobal.security.SharedPrefsDataStore;
import com.didiglobal.security.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/security/Example;", "", "dataStore", "Lcom/didiglobal/security/SharedPrefsDataStore;", "(Lcom/didiglobal/security/SharedPrefsDataStore;)V", "value", "Lcom/didiglobal/security/Example$StateStorage;", "stateStorage", "getStateStorage", "()Lcom/didiglobal/security/Example$StateStorage;", "setStateStorage", "(Lcom/didiglobal/security/Example$StateStorage;)V", "remove", "", "StateStorage", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: Example.kt */
public final class Example {

    /* renamed from: a */
    private final SharedPrefsDataStore f51407a;

    public Example(SharedPrefsDataStore sharedPrefsDataStore) {
        Intrinsics.checkParameterIsNotNull(sharedPrefsDataStore, "dataStore");
        this.f51407a = sharedPrefsDataStore;
    }

    @SharedPrefsDataStore.Key(key = "StateStore")
    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo175978d2 = {"Lcom/didiglobal/security/Example$StateStorage;", "", "count", "", "content", "", "(ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "security_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: Example.kt */
    public static final class StateStorage {
        private String content;
        private int count;

        public static /* synthetic */ StateStorage copy$default(StateStorage stateStorage, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = stateStorage.count;
            }
            if ((i2 & 2) != 0) {
                str = stateStorage.content;
            }
            return stateStorage.copy(i, str);
        }

        public final int component1() {
            return this.count;
        }

        public final String component2() {
            return this.content;
        }

        public final StateStorage copy(int i, String str) {
            return new StateStorage(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StateStorage)) {
                return false;
            }
            StateStorage stateStorage = (StateStorage) obj;
            return this.count == stateStorage.count && Intrinsics.areEqual((Object) this.content, (Object) stateStorage.content);
        }

        public int hashCode() {
            int i = this.count * 31;
            String str = this.content;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "StateStorage(count=" + this.count + ", content=" + this.content + ")";
        }

        public StateStorage(int i, String str) {
            this.count = i;
            this.content = str;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }
    }

    public final void setStateStorage(StateStorage stateStorage) {
        if (stateStorage != null) {
            this.f51407a.save(stateStorage, new Example$stateStorage$1(GsonUtils.INSTANCE));
        }
    }

    public final StateStorage getStateStorage() {
        return (StateStorage) this.f51407a.restore(StateStorage.class, Example$stateStorage$2.INSTANCE);
    }

    public final void remove() {
        this.f51407a.remove(StateStorage.class);
    }
}
