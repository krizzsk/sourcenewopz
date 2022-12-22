package com.jumio.core.extraction.barcode.model;

import android.util.Base64;
import com.jumio.commons.PersistWith;
import com.jumio.core.models.DocumentDataModel;
import com.jumio.core.models.ScanPartModel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/core/extraction/barcode/model/BarcodeDataModel;", "Lcom/jumio/core/models/DocumentDataModel;", "Lorg/json/JSONObject;", "request", "Lcom/jumio/core/models/ScanPartModel;", "scanPart", "", "fillRequest", "", "v", "Ljava/lang/String;", "getRawBarcodeData", "()Ljava/lang/String;", "setRawBarcodeData", "(Ljava/lang/String;)V", "rawBarcodeData", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("BarcodeDataModel")
/* compiled from: BarcodeDataModel.kt */
public final class BarcodeDataModel extends DocumentDataModel {

    /* renamed from: v */
    public String f54730v;

    public void fillRequest(JSONObject jSONObject, ScanPartModel scanPartModel) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "request");
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPart");
        super.fillRequest(jSONObject, scanPartModel);
        String str = this.f54730v;
        boolean z = false;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            String str2 = this.f54730v;
            Intrinsics.checkNotNull(str2);
            Charset charset = Charsets.UTF_8;
            if (str2 != null) {
                byte[] bytes = str2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                appendValue(jSONObject, "rawBarcodeData", Base64.encodeToString(bytes, 2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final String getRawBarcodeData() {
        return this.f54730v;
    }

    public final void setRawBarcodeData(String str) {
        this.f54730v = str;
    }
}
