package com.example.hookah;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class TablesActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TablesFragment();
    }
}
