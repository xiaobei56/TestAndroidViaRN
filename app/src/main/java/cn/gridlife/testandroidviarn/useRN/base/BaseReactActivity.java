package cn.gridlife.testandroidviarn.useRN.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import cn.gridlife.testandroidviarn.App;

public class BaseReactActivity extends BaseActivity implements DefaultHardwareBackBtnHandler {
    private ReactInstanceManager reactInstanceManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        reactInstanceManager=((App)getApplication()).getReactNativeHost().getReactInstanceManager();

    }


    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(reactInstanceManager!=null)
        {
            reactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(reactInstanceManager!=null){
            reactInstanceManager.onHostResume(this,this);
        }
    }
}
