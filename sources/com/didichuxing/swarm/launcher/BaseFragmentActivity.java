package com.didichuxing.swarm.launcher;

import android.app.ActionBar;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity {
    /* access modifiers changed from: protected */
    public void setupActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
