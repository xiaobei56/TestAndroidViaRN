package cn.gridlife.testandroidviarn.useRN;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import cn.gridlife.testandroidviarn.App;
import cn.gridlife.testandroidviarn.BuildConfig;
import cn.gridlife.testandroidviarn.R;


public class ActivityAndRN extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
    private ReactRootView reactRootView;
    private ReactContext reactContext;
    private DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_and_r);
        reactRootView = findViewById(R.id.rrv_react_native);
        reactRootView.startReactApplication(App.reactInstanceManager, "TestAndroidViaRN", null);
    }
    int count=0;
    public void btnClick(View view) {
        WritableMap params = Arguments.createMap();
        params.putString("data", "这是原生代码送给RN的字符串"+ count++);
        sendEvent(getReactContext(), "rnFunction", params);
    }
    public boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    private void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        if (reactContext == null) {
            return;
        }
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }
    private ReactContext getReactContext() {
        return reactContext != null ? reactContext : App.reactInstanceManager != null ? App.reactInstanceManager.getCurrentReactContext() : null;
    }


    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (App.reactInstanceManager != null) {
            App.reactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    public void onBackPressed() {
        if (App.reactInstanceManager != null) {
            App.reactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (getUseDeveloperSupport()) {
            if (keyCode == KeyEvent.KEYCODE_MENU) {//Ctrl + M 打开RN开发者菜单
                App.reactInstanceManager.showDevOptionsDialog();
                return true;
            }
            boolean didDoubleTapR = Assertions.assertNotNull(mDoubleTapReloadRecognizer).didDoubleTapR(keyCode, getCurrentFocus());
            if (didDoubleTapR) {//双击R 重新加载JS
                App.reactInstanceManager.getDevSupportManager().handleReloadJS();
                return true;
            }
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (App.reactInstanceManager != null) {
            App.reactInstanceManager.onHostDestroy(this);
        }
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
        }
    }

}
