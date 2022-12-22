package com.didi.app.nova.skeleton;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.title.TitleBar;
import com.didichuxing.sofa.permission.PermissionRequest;

public abstract class AbstractPage extends ContextWrapper implements ILive, INavigator {
    /* access modifiers changed from: protected */
    public abstract boolean addComponent(Component component);

    public abstract void addLifecycleCallback(IScopeLifecycle iScopeLifecycle);

    public abstract String alias();

    /* access modifiers changed from: protected */
    public abstract <T extends View> T findViewById(int i);

    public abstract void finish();

    public abstract Bundle getArgs();

    /* access modifiers changed from: protected */
    public abstract Component getComponent(Class<? extends Component> cls);

    public abstract PageInstrument getInstrument();

    public abstract PageInstrument getInstrument(ViewGroup viewGroup, String str, boolean z);

    public abstract ControllerChangeHandler getPopHandler();

    public abstract ControllerChangeHandler getPushHandler();

    public abstract ScopeContext getScopeContext();

    /* access modifiers changed from: protected */
    public abstract String getTitle();

    /* access modifiers changed from: protected */
    public abstract TitleBar getTitleBar();

    /* access modifiers changed from: protected */
    public abstract View getView();

    public abstract void onActivityResult(int i, int i2, Intent intent);

    public abstract void onCreate(View view);

    public abstract void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    public abstract void onDestroy();

    public abstract void onFinalize();

    public abstract boolean onHandleBack();

    public abstract View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract void onInitialize();

    public abstract boolean onOptionsItemSelected(MenuItem menuItem);

    public abstract void onPause();

    public abstract void onPermissionDenied(String[] strArr);

    public abstract void onPermissionGranted();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onRestoreInstanceState(Bundle bundle);

    public abstract void onRestoreViewState(View view, Bundle bundle);

    public abstract void onResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onSaveViewState(View view, Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    /* access modifiers changed from: protected */
    public abstract boolean removeComponent(Component component);

    public abstract void removeLifecycleCallback(IScopeLifecycle iScopeLifecycle);

    public abstract void requestPermissions(String[] strArr);

    public abstract void setArgs(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void setFlags(int i);

    public abstract void setHasOptionsMenu(boolean z);

    public abstract void setOptionsMenuHidden(boolean z);

    /* access modifiers changed from: protected */
    public abstract void setTitleBarEnable(boolean z);

    public abstract void setupComponents(View view);

    public abstract boolean showPermissionExplanation(PermissionRequest permissionRequest);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    public abstract void startActivityForResult(Intent intent, int i, Bundle bundle);

    public AbstractPage() {
        super((Context) null);
    }

    public AbstractPage(Bundle bundle) {
        super((Context) null);
    }
}
