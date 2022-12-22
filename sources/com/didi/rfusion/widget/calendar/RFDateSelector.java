package com.didi.rfusion.widget.calendar;

import android.os.Parcelable;
import androidx.core.util.Pair;
import java.util.Collection;

public interface RFDateSelector<S> extends Parcelable {
    Collection<Long> getSelectedDays();

    Collection<Pair<Long, Long>> getSelectedRanges();

    S getSelection();

    boolean isSelectionComplete();

    void select(long j);

    void setSelection(S s);
}
