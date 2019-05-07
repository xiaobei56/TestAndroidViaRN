package cn.gridlife.testandroidviarn;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_activity_and_rn:
                break;
            case R.id.btn_fragment_and_rn:
                break;
            case R.id.btn_rn:
                break;
            default:
                break;
        }
    }

    private void goActivity(Activity activity) {
        startActivity(new Intent(this, activity.getClass()));
    }
}
