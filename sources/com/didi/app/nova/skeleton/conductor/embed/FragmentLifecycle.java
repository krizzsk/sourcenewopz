package com.didi.app.nova.skeleton.conductor.embed;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface FragmentLifecycle {
    void onActivityResult(int i, int i2, Intent intent);

    void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onPrepareOptionsMenu(Menu menu);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    boolean shouldShowRequestPermissionRationale(String str);
}
