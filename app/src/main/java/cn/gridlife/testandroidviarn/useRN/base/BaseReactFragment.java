package cn.gridlife.testandroidviarn.useRN.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Objects;

import cn.gridlife.testandroidviarn.App;

public abstract class BaseReactFragment extends BaseFragment {
    private ReactRootView reactRootView;
    private ReactInstanceManager reactInstanceManager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        reactRootView = new ReactRootView(context);
        reactInstanceManager = ((App) getActivity().getApplication()).getReactNativeHost().getReactInstanceManager();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return reactRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        reactRootView.startReactApplication(reactInstanceManager, getMainPageName(), null);
    }

    protected abstract String getMainPageName();

    private void sendEvent(String eventName, @Nullable WritableMap params) {
        if (null != ((App) Objects.requireNonNull(getActivity()).getApplication()).getReactContext()) {
            ((App) Objects.requireNonNull(getActivity()).getApplication()).getReactContext()
                    .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit(eventName, params);
        }
    }
}
