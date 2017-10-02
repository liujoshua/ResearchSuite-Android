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

package org.sagebionetworks.research.interfaces.task;

import org.sagebionetworks.research.interfaces.task.step.Step;

/**
 * Created by liujoshua on 10/2/2017.
 */

public class PerformTaskContract {
    interface View {
        void hideProgress();
        void showProgress(Progress progress);
        void showNextStep(Step step);
        void showPreviousStep(Step step);
    }

    interface Presenter {
        void nextStep();
        void previousStep();
        void refreshStep();
        void endStep();
    }
}
