package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.dimina.starbox.p107ui.base.AbsRecyclerAdapter;
import com.didi.dimina.starbox.p107ui.base.AbsViewBinder;
import com.didi.dimina.starbox.util.FileUtil;
import com.taxis99.R;

public class FileInfoAdapter extends AbsRecyclerAdapter<AbsViewBinder<FileInfo>, FileInfo> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnViewClickListener f18060a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnViewLongClickListener f18061b;

    public interface OnViewClickListener {
        void onViewClick(View view, FileInfo fileInfo);
    }

    public interface OnViewLongClickListener {
        boolean onViewLongClick(View view, FileInfo fileInfo);
    }

    public FileInfoAdapter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public AbsViewBinder<FileInfo> createViewHolder(View view, int i) {
        return new FileInfoViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        return layoutInflater.inflate(R.layout.dimina_starbox_item_file_info, viewGroup, false);
    }

    public class FileInfoViewHolder extends AbsViewBinder<FileInfo> {
        private ImageView mIcon;
        private ImageView mMoreBtn;
        private TextView mName;

        public FileInfoViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mName = (TextView) getView(R.id.name);
            this.mIcon = (ImageView) getView(R.id.icon);
            this.mMoreBtn = (ImageView) getView(R.id.more);
        }

        public void bind(final FileInfo fileInfo) {
            getView().setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    return FileInfoAdapter.this.f18061b != null && FileInfoAdapter.this.f18061b.onViewLongClick(view, fileInfo);
                }
            });
            this.mName.setText(fileInfo.file.getName());
            if (fileInfo.file.isDirectory()) {
                this.mIcon.setImageResource(R.drawable.dimina_starbox_dir_icon);
                this.mMoreBtn.setVisibility(0);
            } else if (FileUtil.getSuffix(fileInfo.file).equals(FileUtil.JPG)) {
                this.mIcon.setImageResource(R.drawable.dimina_starbox_jpg_icon);
            } else if (FileUtil.getSuffix(fileInfo.file).equals("txt")) {
                this.mIcon.setImageResource(R.drawable.dimina_starbox_txt_icon);
            } else {
                this.mIcon.setImageResource(R.drawable.dimina_starbox_file_icon);
            }
        }

        /* access modifiers changed from: protected */
        public void onViewClick(View view, FileInfo fileInfo) {
            super.onViewClick(view, fileInfo);
            if (FileInfoAdapter.this.f18060a != null) {
                FileInfoAdapter.this.f18060a.onViewClick(view, fileInfo);
            }
        }
    }

    public void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.f18060a = onViewClickListener;
    }

    public void setOnViewLongClickListener(OnViewLongClickListener onViewLongClickListener) {
        this.f18061b = onViewLongClickListener;
    }
}
