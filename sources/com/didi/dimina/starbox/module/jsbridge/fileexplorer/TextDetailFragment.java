package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.p107ui.base.BaseFragment;
import com.didi.dimina.starbox.p107ui.widget.TitleBar;
import com.taxis99.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class TextDetailFragment extends BaseFragment {

    /* renamed from: a */
    private static final String f18064a = "TextDetailFragment";

    /* renamed from: b */
    private RecyclerView f18065b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextContentAdapter f18066c;

    /* renamed from: d */
    private File f18067d;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_text_detail;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TitleBar) findViewById(R.id.title_bar)).setOnTitleBarClickListener(new TitleBar.OnTitleBarClickListener() {
            public void onRightClick() {
            }

            public void onLeftClick() {
                TextDetailFragment.this.finish();
            }
        });
        initContent();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18067d = (File) arguments.getSerializable(BundleKey.FILE_KEY);
        }
        m13495a(this.f18067d);
    }

    public void initContent() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.text_list);
        this.f18065b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TextContentAdapter textContentAdapter = new TextContentAdapter(getContext());
        this.f18066c = textContentAdapter;
        this.f18065b.setAdapter(textContentAdapter);
    }

    /* renamed from: a */
    private void m13495a(File file) {
        if (this.f18067d != null) {
            new FileReadTask(this).execute(new File[]{file});
        }
    }

    private static class FileReadTask extends AsyncTask<File, String, Void> {
        private final WeakReference<TextDetailFragment> mReference;

        public FileReadTask(TextDetailFragment textDetailFragment) {
            this.mReference = new WeakReference<>(textDetailFragment);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(File... fileArr) {
            try {
                FileReader fileReader = new FileReader(fileArr[0]);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        publishProgress(new String[]{readLine});
                    } else {
                        bufferedReader.close();
                        fileReader.close();
                        return null;
                    }
                }
            } catch (IOException e) {
                LogUtil.m13410e(TextDetailFragment.f18064a, e.toString());
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            if (this.mReference.get() != null) {
                ((TextDetailFragment) this.mReference.get()).f18066c.append(strArr[0]);
            }
        }
    }
}
