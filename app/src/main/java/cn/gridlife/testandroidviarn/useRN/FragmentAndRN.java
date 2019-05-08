package cn.gridlife.testandroidviarn.useRN;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.gridlife.testandroidviarn.R;
import cn.gridlife.testandroidviarn.useRN.base.BaseReactFragment;

public class FragmentAndRN extends BaseReactFragment {

    private View view;
    private Button btnBack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_f_and_r,container,false);

        return view;
    }

    @Override
    protected String getMainPageName() {
        return null;
    }

}
