package com.jumio.core;

import android.content.Context;
import android.content.ContextWrapper;
import com.jumio.core.models.AuthorizationModel;
import jumio.core.C21375q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0005\u001a\u00060\u0003R\u00020\u0004H\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, mo175978d2 = {"Lcom/jumio/core/MobileContext;", "Landroid/content/ContextWrapper;", "Ljumio/core/q;", "Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "Lcom/jumio/core/models/AuthorizationModel;", "getSessionKey", "", "b", "I", "getCustomThemeId", "()I", "customThemeId", "Landroid/content/Context;", "base", "authorizationModel", "<init>", "(Landroid/content/Context;Lcom/jumio/core/models/AuthorizationModel;I)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: MobileContext.kt */
public final class MobileContext extends ContextWrapper implements C21375q {

    /* renamed from: a */
    public final AuthorizationModel f54615a;

    /* renamed from: b */
    public final int f54616b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileContext(Context context, AuthorizationModel authorizationModel, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        this.f54615a = authorizationModel;
        this.f54616b = i;
    }

    public final int getCustomThemeId() {
        return this.f54616b;
    }

    public AuthorizationModel.SessionKey getSessionKey() {
        return this.f54615a.getSessionKey();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileContext(Context context, AuthorizationModel authorizationModel, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authorizationModel, (i2 & 4) != 0 ? 0 : i);
    }
}
