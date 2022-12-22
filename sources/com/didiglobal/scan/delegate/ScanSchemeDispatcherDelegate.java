package com.didiglobal.scan.delegate;

import com.google.gson.JsonObject;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate;", "", "handleScheme", "", "scheme", "", "actionType", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "extraData", "Lcom/google/gson/JsonObject;", "ActionType", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ScanSchemeDispatcherDelegate.kt */
public interface ScanSchemeDispatcherDelegate {
    boolean handleScheme(String str, ActionType actionType, JsonObject jsonObject);

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "OPENRIDE", "CASHIERCODE", "PIX", "NONE", "scan_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ScanSchemeDispatcherDelegate.kt */
    public enum ActionType {
        OPENRIDE("openride"),
        CASHIERCODE("cashiercode"),
        PIX("pixcode"),
        NONE("none");
        
        private final String type;

        private ActionType(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }
}
