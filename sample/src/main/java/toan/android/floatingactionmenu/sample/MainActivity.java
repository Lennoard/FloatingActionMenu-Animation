package toan.android.floatingactionmenu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    public void goToSampleBasic(View view) {
        Intent intent = new Intent(this, SampleBasicActivity.class);
        startActivity(intent);
    }

    public void goToExtendedFeatures(View view) {
        Intent intent = new Intent(this, ExtendedFeaturesActivity.class);
        startActivity(intent);
    }

}
