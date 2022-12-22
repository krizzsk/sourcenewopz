package com.didiglobal.enginecore.constant;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/enginecore/constant/XENetConstant;", "", "()V", "XE_ENGINE_PAGE_REQUEST", "", "XE_ENGINE_SIMPLE_REQUEST", "XE_EXPO_PASSENGER", "XE_KEY_ENGINE_COMMIT", "XE_KEY_ENGINE_DATA_HANDLER", "XE_XENGINE_PASSENGER", "DataHandlerAction", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XENetConstant.kt */
public final class XENetConstant {
    public static final XENetConstant INSTANCE = new XENetConstant();
    public static final String XE_ENGINE_PAGE_REQUEST = "xEngine_request";
    public static final String XE_ENGINE_SIMPLE_REQUEST = "xEngine_refresh";
    public static final String XE_EXPO_PASSENGER = "expo/passenger";
    public static final String XE_KEY_ENGINE_COMMIT = "xEngine_commit";
    public static final String XE_KEY_ENGINE_DATA_HANDLER = "xEngine_data_handle";
    public static final String XE_XENGINE_PASSENGER = "xEngine/passenger";

    private XENetConstant() {
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didiglobal/enginecore/constant/XENetConstant$DataHandlerAction;", "", "()V", "ACTION_DISPATCH", "", "ACTION_INTERCEPT", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XENetConstant.kt */
    public static final class DataHandlerAction {
        public static final String ACTION_DISPATCH = "dispatch";
        public static final String ACTION_INTERCEPT = "intercept";
        public static final DataHandlerAction INSTANCE = new DataHandlerAction();

        private DataHandlerAction() {
        }
    }
}
