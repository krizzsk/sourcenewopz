package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.commons.utils.C19948a;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.C19969b;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.network.C19999c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import jumio.core.C21351f;
import jumio.core.C21375q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014R\u0016\u0010\n\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/core/api/calls/UploadCall;", "Lcom/jumio/core/network/c;", "Lorg/json/JSONObject;", "", "plainTextAnswer", "parseResponse", "", "prepareData", "getUri", "()Ljava/lang/String;", "uri", "Ljumio/core/f;", "apiCallSettings", "Lcom/jumio/core/models/ApiCallDataModel;", "apiCallDataModel", "<init>", "(Ljumio/core/f;Lcom/jumio/core/models/ApiCallDataModel;)V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: UploadCall.kt */
public final class UploadCall extends C19999c<JSONObject> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_CREDENTIAL_ID = "DATA_CREDENTIAL_ID";
    public static final String DATA_PARTS = "DATA_PARTS";
    public static final String DATA_UPLOAD_TYPE = "DATA_UPLOAD_TYPE";
    public static final String DATA_UPLOAD_TYPE_DEFAULT = "DATA_UPLOAD_TYPE_DEFAULT";
    public static final String DATA_UPLOAD_TYPE_LIVENESS = "DATA_UPLOAD_TYPE_LIVENESS";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, mo175978d2 = {"Lcom/jumio/core/api/calls/UploadCall$Companion;", "", "", "CONTENT_LENGTH", "Ljava/lang/String;", "CONTENT_TYPE", "DATA_CREDENTIAL_ID", "DATA_PARTS", "DATA_UPLOAD_TYPE", "DATA_UPLOAD_TYPE_DEFAULT", "DATA_UPLOAD_TYPE_LIVENESS", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: UploadCall.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.jumio.core.api.calls.UploadCall$a */
    /* compiled from: UploadCall.kt */
    public /* synthetic */ class C19962a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f54653a;

        static {
            int[] iArr = new int[ImageData.FileType.values().length];
            iArr[ImageData.FileType.JPG.ordinal()] = 1;
            iArr[ImageData.FileType.WEBP.ordinal()] = 2;
            iArr[ImageData.FileType.PNG.ordinal()] = 3;
            f54653a = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadCall(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        if (!apiCallDataModel.getData().containsKey(DATA_CREDENTIAL_ID)) {
            throw new IllegalArgumentException("Credential ID is missing".toString());
        } else if (!apiCallDataModel.getData().containsKey(DATA_PARTS)) {
            throw new IllegalArgumentException("Upload Parts are missing".toString());
        }
    }

    /* renamed from: a */
    public final void mo162589a(C19969b bVar, LivenessDataModel livenessDataModel, JSONArray jSONArray) {
        int length;
        ImageData[] frames = livenessDataModel.getFrames();
        if (frames != null && frames.length - 1 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = new JSONObject();
                String str = null;
                String substringAfterLast$default = StringsKt.substringAfterLast$default(frames[i].getImage().getPath(), "/", (String) null, 2, (Object) null);
                jSONObject.put("multipartName", substringAfterLast$default);
                jSONObject.put("fileType", frames[i].getImage().getType().name());
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ENGLISH, "%s_%d", Arrays.copyOf(new Object[]{bVar.name(), Integer.valueOf(i2)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                jSONObject.put("uploadType", format);
                ScanMode type = livenessDataModel.getType();
                if (type != null) {
                    str = type.name();
                }
                jSONObject.put("extractionMethod", str);
                jSONArray.put(jSONObject);
                mo162588a(frames[i].getImage().getType(), frames[i].getImage().getPath(), substringAfterLast$default);
                if (i2 <= length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final String mo162591b() {
        Serializable serializable = getApiCallDataModel().getData().get(DATA_CREDENTIAL_ID);
        if (serializable != null) {
            return (String) serializable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* renamed from: c */
    public final HashMap<C19969b, Object> mo162592c() {
        Serializable serializable = getApiCallDataModel().getData().get(DATA_PARTS);
        if (serializable != null) {
            return (HashMap) serializable;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<com.jumio.core.enums.UploadType, kotlin.Any>");
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{105, 45, 69, 79, Ascii.f53588GS, Ascii.SUB, -19, 4, -62, 62, -18}, 7954085481774384125L) + mo162591b() + StringDeobfuscator.deobfuscate(new byte[]{Ascii.DC2, -65, 7, -10, 84, -40, -103}, 2727321516117831622L);
    }

    public void prepareData() throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : mo162592c().entrySet()) {
            C19969b bVar = (C19969b) next.getKey();
            Object value = next.getValue();
            if (value instanceof LivenessDataModel) {
                mo162589a(bVar, (LivenessDataModel) value, jSONArray);
            } else if (value instanceof ScanPartModel) {
                mo162590a(bVar, (ScanPartModel) value, jSONArray);
            } else if (value instanceof JSONObject) {
                String obj = value.toString();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ENGLISH, "Content-Length: %d", Arrays.copyOf(new Object[]{Integer.valueOf(obj.length())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                C19999c.addPart$default(this, new String[]{"Content-Disposition: form-data; name=\"data\"", "Content-Type: application/json; charset=UTF-8", format}, obj, 0, 4, (Object) null);
            } else if ((value instanceof String) && bVar == C19969b.DATA) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(Locale.ENGLISH, "Content-Length: %d", Arrays.copyOf(new Object[]{Integer.valueOf(((String) value).length())}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                C19999c.addPart$default(this, new String[]{"Content-Disposition: form-data; name=\"data\"", "Content-Type: application/json; charset=UTF-8", format2}, value, 0, 4, (Object) null);
            }
        }
        if (jSONArray.length() != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("files", jSONArray);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(Locale.ENGLISH, "Content-Length: %d", Arrays.copyOf(new Object[]{Integer.valueOf(jSONObject2.length())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, format, *args)");
            addPart(new String[]{"Content-Disposition: form-data; name=\"uploadFilesMetadata\"", "Content-Type: application/json; charset=UTF-8", format3}, jSONObject2, 0);
        }
    }

    public JSONObject parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Log.m39477w(this.TAG, "Exception", (Throwable) e);
            return new JSONObject();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007d, code lost:
        if ((r4.length() == 0) != false) goto L_0x007f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo162590a(com.jumio.core.enums.C19969b r6, com.jumio.core.models.ScanPartModel r7, org.json.JSONArray r8) {
        /*
            r5 = this;
            com.jumio.commons.camera.ImageData r0 = r7.getImageData()
            com.jumio.commons.camera.ImageData$Image r0 = r0.getImage()
            boolean r0 = r0.getHasPath()
            if (r0 == 0) goto L_0x00c3
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.jumio.commons.camera.ImageData r1 = r7.getImageData()
            com.jumio.commons.camera.ImageData$Image r1 = r1.getImage()
            java.lang.String r1 = r1.getPath()
            r2 = 2
            java.lang.String r3 = "/"
            r4 = 0
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r1, (java.lang.String) r3, (java.lang.String) r4, (int) r2, (java.lang.Object) r4)
            java.lang.String r2 = "multipartName"
            r0.put(r2, r1)
            com.jumio.commons.camera.ImageData r2 = r7.getImageData()
            com.jumio.commons.camera.ImageData$Image r2 = r2.getImage()
            com.jumio.commons.camera.ImageData$FileType r2 = r2.getType()
            java.lang.String r2 = r2.name()
            java.lang.String r3 = "fileType"
            r0.put(r3, r2)
            java.lang.String r6 = r6.name()
            java.lang.String r2 = "uploadType"
            r0.put(r2, r6)
            boolean r6 = r7.getUsability()
            java.lang.String r2 = "usabilityExpected"
            r0.put(r2, r6)
            com.jumio.core.data.ScanMode r6 = r7.getMode()
            java.lang.String r6 = r6.name()
            java.lang.String r2 = "extractionMethod"
            r0.put(r2, r6)
            boolean r6 = r7 instanceof com.jumio.core.models.IDScanPartModel
            if (r6 == 0) goto L_0x00a5
            r6 = r7
            com.jumio.core.models.IDScanPartModel r6 = (com.jumio.core.models.IDScanPartModel) r6
            com.jumio.core.models.DocumentDataModel r2 = r6.getDocumentData()
            if (r2 != 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            java.lang.String r4 = r2.getIssuingCountry()
        L_0x0072:
            if (r4 == 0) goto L_0x007f
            int r2 = r4.length()
            if (r2 != 0) goto L_0x007c
            r2 = 1
            goto L_0x007d
        L_0x007c:
            r2 = 0
        L_0x007d:
            if (r2 == 0) goto L_0x008b
        L_0x007f:
            com.jumio.core.models.SelectionModel r2 = r6.getSelectionModel()
            com.jumio.core.data.country.Country r2 = r2.getCountry()
            java.lang.String r4 = r2.getIsoCode()
        L_0x008b:
            java.lang.String r2 = "country"
            r0.put(r2, r4)
            com.jumio.core.models.SelectionModel r6 = r6.getSelectionModel()
            com.jumio.core.data.document.DocumentType r6 = r6.getDocumentType()
            com.jumio.sdk.document.JumioDocumentType r6 = r6.getIdType()
            java.lang.String r6 = r6.name()
            java.lang.String r2 = "idType"
            r0.put(r2, r6)
        L_0x00a5:
            r8.put(r0)
            com.jumio.commons.camera.ImageData r6 = r7.getImageData()
            com.jumio.commons.camera.ImageData$Image r6 = r6.getImage()
            com.jumio.commons.camera.ImageData$FileType r6 = r6.getType()
            com.jumio.commons.camera.ImageData r7 = r7.getImageData()
            com.jumio.commons.camera.ImageData$Image r7 = r7.getImage()
            java.lang.String r7 = r7.getPath()
            r5.mo162588a((com.jumio.commons.camera.ImageData.FileType) r6, (java.lang.String) r7, (java.lang.String) r1)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.calls.UploadCall.mo162590a(com.jumio.core.enums.b, com.jumio.core.models.ScanPartModel, org.json.JSONArray):void");
    }

    /* renamed from: a */
    public final void mo162588a(ImageData.FileType fileType, String str, String str2) {
        String str3;
        int i = C19962a.f54653a[fileType.ordinal()];
        if (i == 1) {
            str3 = "image/jpeg";
        } else if (i == 2) {
            str3 = "image/webp";
        } else if (i == 3) {
            str3 = "image/png";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        try {
            byte[] a = C19948a.m39483a(str, ((C21375q) getApiCallSettings().getContext()).getSessionKey());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "Content-Length: %d", Arrays.copyOf(new Object[]{Integer.valueOf(a.length)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            String[] strArr = {"Content-Disposition: form-data; name=\"" + str2 + Typography.quote, Intrinsics.stringPlus("Content-Type: ", str3), format};
            Intrinsics.checkNotNullExpressionValue(a, "file");
            C19999c.addPart$default(this, strArr, a, 0, 4, (Object) null);
        } catch (Exception e) {
            Log.m39462e("ImageData", "Error reading File", (Throwable) e);
            throw e;
        }
    }
}
