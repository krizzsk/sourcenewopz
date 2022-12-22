package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.starbox.module.jsbridge.fileexplorer.FileInfoAdapter;
import com.didi.dimina.starbox.p107ui.base.BaseFragment;
import com.didi.dimina.starbox.p107ui.widget.TitleView;
import com.didi.dimina.starbox.util.FileUtil;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExplorerFragment extends BaseFragment {

    /* renamed from: a */
    private FileInfoAdapter f18056a;

    /* renamed from: b */
    private RecyclerView f18057b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public File f18058c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TitleView f18059d;

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return R.layout.dimina_starbox_fragment_file_explorer;
    }

    /* renamed from: a */
    private void m13484a() {
        this.f18059d = (TitleView) findViewById(R.id.title_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.file_list);
        this.f18057b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FileInfoAdapter fileInfoAdapter = new FileInfoAdapter(getContext());
        this.f18056a = fileInfoAdapter;
        fileInfoAdapter.setOnViewClickListener(new FileInfoAdapter.OnViewClickListener() {
            public void onViewClick(View view, FileInfo fileInfo) {
                if (fileInfo.file.isFile()) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(BundleKey.FILE_KEY, fileInfo.file);
                    if (FileUtil.isImage(fileInfo.file)) {
                        FileExplorerFragment.this.showContent(ImageDetailFragment.class, bundle);
                    } else {
                        FileExplorerFragment.this.showContent(TextDetailFragment.class, bundle);
                    }
                } else {
                    File unused = FileExplorerFragment.this.f18058c = fileInfo.file;
                    FileExplorerFragment.this.f18059d.setTitle(FileExplorerFragment.this.f18058c.getName());
                    FileExplorerFragment fileExplorerFragment = FileExplorerFragment.this;
                    fileExplorerFragment.m13486a((List<FileInfo>) fileExplorerFragment.m13483a(fileExplorerFragment.f18058c));
                }
            }
        });
        this.f18056a.setOnViewLongClickListener(new FileInfoAdapter.OnViewLongClickListener() {
            public boolean onViewLongClick(View view, FileInfo fileInfo) {
                if (!fileInfo.file.isFile()) {
                    return false;
                }
                FileUtil.systemShare(FileExplorerFragment.this.getContext(), fileInfo.file);
                return true;
            }
        });
        m13486a(m13482a(getContext()));
        this.f18057b.setAdapter(this.f18056a);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f18058c = null;
        m13484a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<FileInfo> m13483a(File file) {
        ArrayList arrayList = new ArrayList();
        for (File fileInfo : file.listFiles()) {
            arrayList.add(new FileInfo(fileInfo));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed() {
        if (this.f18058c == null) {
            getActivity().finish();
            return true;
        } else if (m13487a(getContext(), this.f18058c)) {
            this.f18059d.setTitle((int) R.string.dm_kit_file_explorer);
            m13486a(m13482a(getContext()));
            this.f18058c = null;
            return true;
        } else {
            File parentFile = this.f18058c.getParentFile();
            this.f18058c = parentFile;
            this.f18059d.setTitle(parentFile.getName());
            m13486a(m13483a(this.f18058c));
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13486a(List<FileInfo> list) {
        if (list.isEmpty()) {
            this.f18056a.clear();
        } else {
            this.f18056a.setData(list);
        }
    }

    /* renamed from: a */
    private List<FileInfo> m13482a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileInfo(context.getFilesDir().getParentFile()));
        arrayList.add(new FileInfo(context.getExternalCacheDir()));
        arrayList.add(new FileInfo(context.getExternalFilesDir((String) null)));
        return arrayList;
    }

    /* renamed from: a */
    private boolean m13487a(Context context, File file) {
        if (file == null) {
            return false;
        }
        if (file.equals(context.getExternalCacheDir()) || file.equals(context.getExternalFilesDir((String) null)) || file.equals(context.getFilesDir().getParentFile())) {
            return true;
        }
        return false;
    }
}
