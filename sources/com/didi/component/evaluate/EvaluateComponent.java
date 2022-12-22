package com.didi.component.evaluate;

import android.view.ViewGroup;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluate.presenter.AbsEvaluatePresenter;
import com.didi.component.evaluate.presenter.impl.ExceptHomeEvaluatePresenter;
import com.didi.component.evaluate.presenter.impl.HomeEvaluatePresenter;
import com.didi.component.evaluate.view.EvaluateCompleteView;
import com.didi.component.evaluate.view.EvaluateView;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.NewEvaluateCompleteView;
import com.didi.component.evaluate.view.NewEvaluateView;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CommentOnPanel;

@ComponentRegister(product = "ride", type = "evaluate")
public class EvaluateComponent extends AbsEvaluateComponent {
    /* access modifiers changed from: protected */
    public IEvaluateView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        IEvaluateView iEvaluateView;
        CarOrder order;
        CommentOnPanel commentOnPanel = (CommentOnPanel) componentParams.getExtra(BaseExtras.Home.EXTRAS_UNEVALUATED_COMMENT_DATA);
        int i = componentParams.extras.getInt(BaseExtras.Home.EXTRAS_EVALUATE_STYLE, 0);
        if (commentOnPanel == null && (order = CarOrderHelper.getOrder()) != null && order.evaluateModel.evaluateMark == 1) {
            iEvaluateView = GlobalApolloUtil.isNewEvaluate() ? new NewEvaluateCompleteView(componentParams.bizCtx.getContext(), i) : new EvaluateCompleteView(componentParams.getActivity());
        } else {
            iEvaluateView = null;
        }
        if (iEvaluateView != null) {
            return iEvaluateView;
        }
        if (GlobalApolloUtil.isNewEvaluate()) {
            return new NewEvaluateView(componentParams.bizCtx.getContext(), i);
        }
        return new EvaluateView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public AbsEvaluatePresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID != 1001) {
            return new ExceptHomeEvaluatePresenter(componentParams);
        }
        return new HomeEvaluatePresenter(componentParams);
    }
}
