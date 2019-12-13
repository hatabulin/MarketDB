/*
 * Copyright 2009 Cedric Priscal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marketDB.ui.base;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.marketDB.MyApp;
import com.example.marketDB.utils.fragments.FragmentChangeUtils;
import com.example.marketDB.utils.fragments.FragmentsAnimationId;

public abstract class BaseActivity extends AppCompatActivity {

    protected MyApp mApplication;

    private void DisplayError(int resourceId) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Error");
        b.setMessage(resourceId);
        b.setPositiveButton("OK", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                BaseActivity.this.finish();
            }
        });
        b.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (MyApp) getApplication();
    }

    public void setFragment(FragmentManager fragmentManager, Fragment fragment, int layoutResIs) {
        FragmentChangeUtils.setFragment(fragmentManager, fragment, layoutResIs);
    }

    public void changeFragment(FragmentManager fragmentManager, Fragment fragment, int layoutResIs) {
        FragmentChangeUtils.changeFragment(fragmentManager, fragment, layoutResIs);
    }

    public void changeFragmentWithAnimation(FragmentManager fragmentManager, Fragment fragment, int layoutResIs, FragmentsAnimationId fragmentsAnimationId) {
        FragmentChangeUtils.changeFragmentWithAnimation(fragmentManager, fragment, layoutResIs, fragmentsAnimationId);
    }
}
