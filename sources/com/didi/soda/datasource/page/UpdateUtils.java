package com.didi.soda.datasource.page;

import java.util.ArrayList;
import java.util.List;

public final class UpdateUtils {

    public interface DiffCallback<Target> {
        boolean isTarget(int i, Target target);
    }

    public interface UpdateCallback<Target> {
        void doUpdate(int i, Target target);
    }

    public interface UpdateCompleteCallback<Target> {
        void onCompleted(List<Target> list);
    }

    private UpdateUtils() {
    }

    public static <Target> void dispatchUpdate(DiffCallback<Target> diffCallback, UpdateCallback<Target> updateCallback, UpdateCompleteCallback updateCompleteCallback, List<Target> list) {
        UpdateResult updateResult = new UpdateResult(updateCompleteCallback);
        if (diffCallback != null) {
            for (int i = 0; i < list.size(); i++) {
                Target target = list.get(i);
                if (diffCallback.isTarget(i, target)) {
                    updateResult.addUpdateList(target);
                }
            }
        }
        for (int i2 = 0; i2 < updateResult.toUpdateList.size(); i2++) {
            updateCallback.doUpdate(i2, updateResult.toUpdateList.get(i2));
        }
        updateResult.dispatchUpdateResult();
    }

    public static <Target> void dispatchRemove(DiffCallback<Target> diffCallback, UpdateCompleteCallback updateCompleteCallback, List<Target> list) {
        UpdateResult updateResult = new UpdateResult(updateCompleteCallback);
        if (diffCallback != null) {
            for (int i = 0; i < list.size(); i++) {
                Target target = list.get(i);
                if (diffCallback.isTarget(i, target)) {
                    updateResult.addUpdateList(target);
                }
            }
        }
        list.removeAll(updateResult.toUpdateList);
        updateResult.dispatchUpdateResult();
    }

    public static <Target> boolean contains(DiffCallback<Target> diffCallback, List<Target> list) {
        UpdateResult updateResult = new UpdateResult((UpdateCompleteCallback) null);
        if (diffCallback != null) {
            for (int i = 0; i < list.size(); i++) {
                Target target = list.get(i);
                if (diffCallback.isTarget(i, target)) {
                    updateResult.addUpdateList(target);
                }
            }
        }
        return !updateResult.toUpdateList.isEmpty();
    }

    public static <Target> int find(DiffCallback<Target> diffCallback, List<Target> list) {
        if (diffCallback == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (diffCallback.isTarget(i, list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static class UpdateResult<Target> {
        UpdateCompleteCallback completeCallback;
        List<Target> toUpdateList = new ArrayList();

        public UpdateResult(UpdateCompleteCallback updateCompleteCallback) {
            this.completeCallback = updateCompleteCallback;
        }

        public void dispatchUpdateResult() {
            UpdateCompleteCallback updateCompleteCallback = this.completeCallback;
            if (updateCompleteCallback != null) {
                updateCompleteCallback.onCompleted(this.toUpdateList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addUpdateList(Target target) {
            this.toUpdateList.add(target);
        }
    }
}
