package cn.gridlife.testandroidviarn.useRN;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import cn.gridlife.testandroidviarn.R;

import static cn.gridlife.testandroidviarn.App.reactInstanceManager;

public class ActivityAndRN extends AppCompatActivity {
    private ReactRootView reactRootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_and_r);
        reactRootView = findViewById(R.id.rrv_react_native);

        reactRootView.startReactApplication(reactInstanceManager, "TestAndroidViaRN", null);
//        reactContext=this.getReactNativeHost()
    }

    public void btnClick(View view) {
        WritableMap params = Arguments.createMap();
        params.putString("data", "AAAA");
        if (reactContext == null)
            reactContext = getReactContext();
        if (reactContext != null)
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("testData", params);
        else {
            Toast.makeText(this, "reactContext 为 null", Toast.LENGTH_SHORT).show();
        }
    }


    private ReactContext getReactContext() {
        return reactContext != null ? reactContext : reactInstanceManager != null ? reactInstanceManager.getCurrentReactContext() : null;
    }


}
