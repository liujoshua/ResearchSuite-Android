/*
 *    Copyright 2017 Sage Bionetworks
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.sagebionetworks.research.sdk.task.modules.list.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by liujoshua on 9/20/2017.
 */

public class PerformTaskActivity extends FragmentActivity {

    private static final String INTENT_EXTRA_KEY_TASK_ID = "taskId";
    private static final String TAG_RETAINED_FRAGMENT = "performTaskRetainedFragment";

    private String taskId;
    private PerformTaskRetainedFragment retainedFragment;

    public static Intent createCallingIntent(@NonNull Context context, @NonNull String taskId) {
        Intent i = new Intent(context, PerformTaskActivity.class);
        i.putExtra(INTENT_EXTRA_KEY_TASK_ID, taskId);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            taskId = getIntent().getStringExtra(INTENT_EXTRA_KEY_TASK_ID);
        } else {
            // TODO: load from saved state, if needed
        }

        findOrCreateRetainedFragment();
    }

    private void findOrCreateRetainedFragment() {
        FragmentManager fm = getSupportFragmentManager();
        retainedFragment = (PerformTaskRetainedFragment) fm.findFragmentByTag(TAG_RETAINED_FRAGMENT);

        if (retainedFragment == null) {
            retainedFragment = new PerformTaskRetainedFragment();
            fm.beginTransaction()
                    .add(retainedFragment, TAG_RETAINED_FRAGMENT)
                    .commit();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (isFinishing()) {
            // proactively remove retained fragment
            getSupportFragmentManager().beginTransaction()
                    .remove(retainedFragment)
                    .commit();
        }
    }
}
