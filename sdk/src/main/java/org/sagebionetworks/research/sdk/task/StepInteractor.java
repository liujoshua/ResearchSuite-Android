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

import org.sagebionetworks.research.interfaces.task.TaskResult;
import org.sagebionetworks.research.interfaces.task.step.Step;

/**
 * Created by jyliu on 9/15/2017.
 */

public class StepInteractor implements StepInteractorInput {

    public final TaskResult taskResult;
    public final TaskStepCoordinator taskStepCoordinator;
    public Step currentStep;
    public StepInteractorOutput stepInteractorOutput;

    public StepInteractor(TaskResult taskResult, TaskStepCoordinator taskStepCoordinator) {
        this.taskResult = taskResult;
        this.taskStepCoordinator = taskStepCoordinator;
    }

    @Override
    public <T> void addResult(String key, T value) {

    }

    @Override
    public void onNext() {
        Step nextStep = taskStepCoordinator.getStepAfter(currentStep, taskResult);
        moveStep(nextStep);
    }

    @Override
    public void onPrevious() {
        Step nextStep = taskStepCoordinator.getStepBefore(currentStep, taskResult);
        moveStep(nextStep);
    }

    protected void moveStep(Step nextStep) {
        stepInteractorOutput.showStep(nextStep);
        currentStep = nextStep;
    }

    @Override
    public void onEnd() {

    }
}
