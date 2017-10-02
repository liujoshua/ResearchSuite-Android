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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import org.sagebionetworks.research.sdk.task.TaskPresenter;

/**
 * When our activity is shut down due to config change, this fragment will be retained, i.e. not destroyed.
 *
 * Created by liujoshua on 9/20/2017.
 */

public class PerformTaskRetainedFragment extends Fragment {

    TaskPresenter taskPresenter;
    String taskId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }


    private void loadUserDetails() {
        this.taskPresenter.initialize(taskId);
    }
}
