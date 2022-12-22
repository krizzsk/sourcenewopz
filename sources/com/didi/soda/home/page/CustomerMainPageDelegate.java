package com.didi.soda.home.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.base.pages.CustomerPage;

public class CustomerMainPageDelegate {

    /* renamed from: a */
    private CustomerPageCallback f42692a;

    public interface CustomerPageCallback {
        boolean addComponent(Component component);

        Context getApplicationContext();

        Context getBaseContext();

        CustomerPage getOwner();

        ScopeContext getScopeContext();

        boolean removeComponent(Component component);
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public void onCreate(View view) {
    }

    public void onDestroy() {
    }

    public boolean onHandleBack() {
        return false;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void onInitialize() {
    }

    public void onPageChangeEnded() {
    }

    public void onPageResult(Bundle bundle) {
    }

    public void onStart() {
    }

    public CustomerMainPageDelegate(CustomerPageCallback customerPageCallback) {
        this.f42692a = customerPageCallback;
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
    }

    /* access modifiers changed from: protected */
    public ScopeContext getScopeContext() {
        return this.f42692a.getScopeContext();
    }

    /* access modifiers changed from: protected */
    public Context getApplicationContext() {
        return this.f42692a.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public boolean removeComponent(Component component) {
        return this.f42692a.removeComponent(component);
    }

    /* access modifiers changed from: protected */
    public boolean addComponent(Component component) {
        return this.f42692a.addComponent(component);
    }

    /* access modifiers changed from: protected */
    public CustomerPage getOwner() {
        return this.f42692a.getOwner();
    }

    /* access modifiers changed from: protected */
    public Context getBaseContext() {
        return this.f42692a.getBaseContext();
    }
}
