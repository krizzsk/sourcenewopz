package p001a;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.jumio.sdk.enums.JumioDataCenter;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: a.b */
/* compiled from: JumioViewModelFactory.kt */
public final class C0019b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a */
    public String f28a;

    /* renamed from: b */
    public JumioDataCenter f29b;

    /* renamed from: c */
    public int f30c;

    /* renamed from: d */
    public final Application f31d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0019b(SavedStateRegistryOwner savedStateRegistryOwner, String str, JumioDataCenter jumioDataCenter, int i, Application application) {
        super(savedStateRegistryOwner, (Bundle) null);
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(jumioDataCenter, "datacenter");
        Intrinsics.checkNotNullParameter(application, "application");
        this.f28a = str;
        this.f29b = jumioDataCenter;
        this.f30c = i;
        this.f31d = application;
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "state");
        return new C0010a(savedStateHandle, this.f31d, this.f28a, this.f29b, this.f30c);
    }
}
