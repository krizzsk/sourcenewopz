package com.didi.app.nova.skeleton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.didi.app.nova.skeleton.internal.page.PageWrapper;

public abstract class Page extends PageWrapper {
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onRestoreViewState(View view, Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onSaveViewState(View view, Bundle bundle) {
    }

    public void setupComponents(View view) {
    }

    public Page() {
    }

    public Page(Bundle bundle) {
        super(bundle);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setupComponents(view);
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPageChangeEnded() {
        super.onPageChangeEnded();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
