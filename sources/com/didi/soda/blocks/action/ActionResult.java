package com.didi.soda.blocks.action;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB9\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007¢\u0006\u0002\u0010\bR^\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00072&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionResult;", "", "status", "Lcom/didi/soda/blocks/action/ActionResult$Status;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Lcom/didi/soda/blocks/action/ActionResult$Status;Ljava/util/HashMap;)V", "<set-?>", "getParams", "()Ljava/util/HashMap;", "getStatus", "()Lcom/didi/soda/blocks/action/ActionResult$Status;", "Companion", "Status", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ActionResult.kt */
public final class ActionResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap<String, Object> params;
    private Status status;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionResult$Status;", "", "(Ljava/lang/String;I)V", "RESOLVE", "REJECT", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ActionResult.kt */
    public enum Status {
        RESOLVE,
        REJECT
    }

    @JvmStatic
    public static final ActionResult reject() {
        return Companion.reject$default(Companion, (HashMap) null, 1, (Object) null);
    }

    @JvmStatic
    public static final ActionResult reject(HashMap<String, Object> hashMap) {
        return Companion.reject(hashMap);
    }

    @JvmStatic
    public static final ActionResult resolve() {
        return Companion.resolve$default(Companion, (HashMap) null, 1, (Object) null);
    }

    @JvmStatic
    public static final ActionResult resolve(HashMap<String, Object> hashMap) {
        return Companion.resolve(hashMap);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final HashMap<String, Object> getParams() {
        return this.params;
    }

    public ActionResult(Status status2, HashMap<String, Object> hashMap) {
        Intrinsics.checkParameterIsNotNull(status2, "status");
        this.status = status2;
        this.params = hashMap;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\bH\u0007J2\u0010\t\u001a\u00020\u00042(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\bH\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/blocks/action/ActionResult$Companion;", "", "()V", "reject", "Lcom/didi/soda/blocks/action/ActionResult;", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "resolve", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ActionResult.kt */
    public static final class Companion {
        @JvmStatic
        public final ActionResult reject() {
            return reject$default(this, (HashMap) null, 1, (Object) null);
        }

        @JvmStatic
        public final ActionResult resolve() {
            return resolve$default(this, (HashMap) null, 1, (Object) null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ActionResult resolve$default(Companion companion, HashMap hashMap, int i, Object obj) {
            if ((i & 1) != 0) {
                hashMap = null;
            }
            return companion.resolve(hashMap);
        }

        @JvmStatic
        public final ActionResult resolve(HashMap<String, Object> hashMap) {
            return new ActionResult(Status.RESOLVE, hashMap);
        }

        public static /* synthetic */ ActionResult reject$default(Companion companion, HashMap hashMap, int i, Object obj) {
            if ((i & 1) != 0) {
                hashMap = null;
            }
            return companion.reject(hashMap);
        }

        @JvmStatic
        public final ActionResult reject(HashMap<String, Object> hashMap) {
            return new ActionResult(Status.REJECT, hashMap);
        }
    }
}
