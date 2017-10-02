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

package org.sagebionetworks.research.interfaces.task.step;

import android.view.View;
import org.sagebionetworks.research.interfaces.task.Progress;

/**
 * Created by jyliu on 9/15/2017.
 */

public interface StepViewInput {
    enum ChangeType {
        ActivityCreate,
        ActivityPause,
        ActivityResume,
        ActivityStop,
        StepChanged
    }

    enum Transition {
        Next,
        Previous
    }

    void showStep(StepModel step, Transition transition);

    void showView(View view);

}
