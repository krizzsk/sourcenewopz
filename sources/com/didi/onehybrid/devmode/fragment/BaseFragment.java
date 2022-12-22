package com.didi.onehybrid.devmode.fragment;

import androidx.fragment.app.ListFragment;
import com.didi.onehybrid.devmode.interfaces.CommunicationInterface;

public class BaseFragment extends ListFragment {
    protected CommunicationInterface mInterface;

    public void setChangeToTargetFragment(CommunicationInterface communicationInterface) {
        this.mInterface = communicationInterface;
    }
}
