package com.didiglobal.p205sa.biz.component.guide;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.guide.IGuide */
public interface IGuide {
    void showGuid(Context context, RecyclerView recyclerView, List<SACardProperty> list);
}
