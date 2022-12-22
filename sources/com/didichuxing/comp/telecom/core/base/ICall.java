package com.didichuxing.comp.telecom.core.base;

import com.didichuxing.comp.telecom.core.CallState;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/base/ICall;", "", "answerCall", "", "cancelMakeCall", "forceStop", "getModel", "getState", "Lcom/didichuxing/comp/telecom/core/CallState;", "handleCallEvent", "event", "hangUp", "makeCall", "notifyRinging", "onDestroy", "rejectIncomeCall", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: base.kt */
public interface ICall {
    void answerCall();

    void cancelMakeCall();

    void forceStop();

    Object getModel();

    CallState getState();

    void handleCallEvent(Object obj);

    void hangUp();

    void makeCall();

    void notifyRinging();

    void onDestroy();

    void rejectIncomeCall();
}
