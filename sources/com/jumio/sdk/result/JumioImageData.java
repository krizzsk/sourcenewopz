package com.jumio.sdk.result;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.utils.C19948a;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\b¨\u0006\u0016"}, mo175978d2 = {"Lcom/jumio/sdk/result/JumioImageData;", "Ljava/io/Serializable;", "Landroid/content/Context;", "context", "", "data", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "", "addImage$jumio_core_release", "(Landroid/content/Context;[BLcom/jumio/sdk/enums/JumioScanSide;)V", "addImage", "getByteArray", "Landroid/graphics/Bitmap;", "getBitmap", "", "hasSide", "clear", "Lcom/jumio/core/models/AuthorizationModel;", "authorizationModel", "<init>", "(Lcom/jumio/core/models/AuthorizationModel;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioImageData.kt */
public final class JumioImageData implements Serializable {

    /* renamed from: a */
    public final AuthorizationModel.SessionKey f55117a;

    /* renamed from: b */
    public final HashMap<JumioScanSide, String> f55118b = new HashMap<>();

    public JumioImageData(AuthorizationModel authorizationModel) {
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        AuthorizationModel.SessionKey sessionKey = new AuthorizationModel.SessionKey(authorizationModel);
        this.f55117a = sessionKey;
        sessionKey.generate();
    }

    public final void addImage$jumio_core_release(Context context, byte[] bArr, JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        File dataDirectory = Environment.getDataDirectory(context);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        String name = jumioScanSide.name();
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        if (name != null) {
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            objArr[1] = lowerCase;
            String format = String.format(locale, "%d_%s.bin", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            File file = new File(dataDirectory, format);
            C19948a.m39482a(bArr, file, this.f55117a);
            HashMap<JumioScanSide, String> hashMap = this.f55118b;
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            hashMap.put(jumioScanSide, absolutePath);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final void clear() {
        this.f55117a.clear();
        for (Map.Entry<JumioScanSide, String> value : this.f55118b.entrySet()) {
            String str = (String) value.getValue();
            if (str != null) {
                File file = new File(str);
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        this.f55118b.clear();
    }

    public final Bitmap getBitmap(JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        try {
            if (!this.f55118b.containsKey(jumioScanSide)) {
                return null;
            }
            return CameraUtils.readBitmap(this.f55118b.get(jumioScanSide), this.f55117a);
        } catch (Exception unused) {
        }
    }

    public final byte[] getByteArray(JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        try {
            if (!this.f55118b.containsKey(jumioScanSide)) {
                return null;
            }
            return C19948a.m39483a(this.f55118b.get(jumioScanSide), this.f55117a);
        } catch (Exception unused) {
        }
    }

    public final boolean hasSide(JumioScanSide jumioScanSide) {
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        return this.f55118b.containsKey(jumioScanSide);
    }
}
