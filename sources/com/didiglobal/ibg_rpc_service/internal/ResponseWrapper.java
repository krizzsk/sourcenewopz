package com.didiglobal.ibg_rpc_service.internal;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001f\b\b\u0018\u0000 (2\u00020\u0001:\u0001(BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JJ\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tJ\t\u0010'\u001a\u00020\u0007HÖ\u0001R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006)"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "Ljava/io/Serializable;", "platformError", "", "errorCode", "", "errorMsg", "", "data", "", "", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "setData", "(Ljava/util/Map;)V", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "getPlatformError", "()Z", "setPlatformError", "(Z)V", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "equals", "other", "hashCode", "toMap", "toString", "Companion", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ResponseWrapper.kt */
public final class ResponseWrapper implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Map<String, ? extends Object> data;
    private Integer errorCode;
    private String errorMsg;
    private boolean platformError;

    public ResponseWrapper() {
        this(false, (Integer) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResponseWrapper copy$default(ResponseWrapper responseWrapper, boolean z, Integer num, String str, Map<String, ? extends Object> map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = responseWrapper.platformError;
        }
        if ((i & 2) != 0) {
            num = responseWrapper.errorCode;
        }
        if ((i & 4) != 0) {
            str = responseWrapper.errorMsg;
        }
        if ((i & 8) != 0) {
            map = responseWrapper.data;
        }
        return responseWrapper.copy(z, num, str, map);
    }

    public final boolean component1() {
        return this.platformError;
    }

    public final Integer component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorMsg;
    }

    public final Map<String, Object> component4() {
        return this.data;
    }

    public final ResponseWrapper copy(boolean z, Integer num, String str, Map<String, ? extends Object> map) {
        return new ResponseWrapper(z, num, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseWrapper)) {
            return false;
        }
        ResponseWrapper responseWrapper = (ResponseWrapper) obj;
        return this.platformError == responseWrapper.platformError && Intrinsics.areEqual((Object) this.errorCode, (Object) responseWrapper.errorCode) && Intrinsics.areEqual((Object) this.errorMsg, (Object) responseWrapper.errorMsg) && Intrinsics.areEqual((Object) this.data, (Object) responseWrapper.data);
    }

    public int hashCode() {
        boolean z = this.platformError;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        Integer num = this.errorCode;
        int i2 = 0;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.errorMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, ? extends Object> map = this.data;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "ResponseWrapper(platformError=" + this.platformError + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", data=" + this.data + VersionRange.RIGHT_OPEN;
    }

    public ResponseWrapper(boolean z, Integer num, String str, Map<String, ? extends Object> map) {
        this.platformError = z;
        this.errorCode = num;
        this.errorMsg = str;
        this.data = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseWrapper(boolean z, Integer num, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : map);
    }

    public final boolean getPlatformError() {
        return this.platformError;
    }

    public final void setPlatformError(boolean z) {
        this.platformError = z;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final void setData(Map<String, ? extends Object> map) {
        this.data = map;
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J7\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper$Companion;", "", "()V", "failed", "Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "errorMsg", "", "success", "errorCode", "", "data", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)Lcom/didiglobal/ibg_rpc_service/internal/ResponseWrapper;", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ResponseWrapper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResponseWrapper success(Integer num, String str, Map<String, ? extends Object> map) {
            return new ResponseWrapper(false, num, str, map, 1, (DefaultConstructorMarker) null);
        }

        public final ResponseWrapper failed(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMsg");
            return new ResponseWrapper(true, -1, str, (Map) null, 8, (DefaultConstructorMarker) null);
        }
    }

    public final Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("platformError", Boolean.valueOf(getPlatformError()));
        hashMap.put(Constants.ERROR_CODE, getErrorCode());
        hashMap.put("errorMsg", getErrorMsg());
        hashMap.put("data", getData());
        return hashMap;
    }
}
