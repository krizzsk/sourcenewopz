package com.didi.entrega.security;

import android.content.Intent;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/security/Contract;", "", "AbsSecurityPresenter", "AbsSecurityView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/security/Contract$AbsSecurityPresenter;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/entrega/security/Contract$AbsSecurityView;", "()V", "bindCard", "", "disable", "id", "", "hasEnable", "", "verifyCpf", "verifyCurp", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsSecurityPresenter extends CustomerRecyclerPresenter<AbsSecurityView> {
        public abstract void bindCard();

        public abstract void disable(int i);

        public abstract boolean hasEnable();

        public abstract void verifyCpf();

        public abstract void verifyCurp();
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/security/Contract$AbsSecurityView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/entrega/security/Contract$AbsSecurityPresenter;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsSecurityView extends CustomerRecyclerView<AbsSecurityPresenter> {
        public abstract void onActivityResult(int i, int i2, Intent intent);
    }
}
