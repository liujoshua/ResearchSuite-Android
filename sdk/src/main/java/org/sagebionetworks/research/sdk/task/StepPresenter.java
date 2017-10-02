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

package org.sagebionetworks.research.sdk.task;

import org.sagebionetworks.research.interfaces.task.Progress;
import org.sagebionetworks.research.interfaces.task.step.Step;
import org.sagebionetworks.research.interfaces.task.step.StepLayout;
import org.sagebionetworks.research.interfaces.task.step.StepModel;
import org.sagebionetworks.research.interfaces.task.step.StepViewInput;

/**
 * Created by jyliu on 9/15/2017.
 */

public class StepPresenter implements StepPresenterInput, StepInteractorOutput {

    public final StepInteractorInput stepInteractor;
    public StepViewInput currentView;

    public StepPresenter(StepInteractorInput stepInteractor) {
        this.stepInteractor = stepInteractor;
    }

    @Override
    public <T> void addResult(String key, T value) {
        stepInteractor.addResult(key, value);
    }


    @Override
    public void onChange(StepViewInput.ChangeType changeType) {

    }

    @Override
    public void showStep(Step step) {
        StepModel stepModel;
        currentView.showStep(stepModel, null);
    }

    @Override
    public void showProgress(Progress progress) {

    }

    // factory method, builds View from Step entity
    protected StepLayout getStepLayout(Step step) {
        return null;
    }
}
