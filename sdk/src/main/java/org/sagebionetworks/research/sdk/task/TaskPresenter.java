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


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.sagebionetworks.research.interfaces.task.TaskResult;
import org.sagebionetworks.research.interfaces.task.step.Step;

/**
 * Created by liujoshua on 9/20/2017.
 */

public class TaskPresenter implements TaskPresenterInput{
    private String taskId = null;

    TaskStepCoordinator taskStepCoordinator;
    Step currentStep;
    TaskResult taskResult;
    @Override
    public void onAction(String action) {
        Step nextStep;

        switch (action) {
            case Step.Action.NEXT:
                nextStep = taskStepCoordinator.getStepAfter(currentStep, taskResult);
                break;
            case Step.Action.PREVIOUS:
                stepInteractor.onPrevious();
                break;
            case Step.Action.END:
                stepInteractor.onEnd();
                break;
            default:
                // TODO: cover remaining standard actions
        }
    }

    public void initialize(String taskId) {
        this.taskId = taskId;

        // show loading
        Observable<TaskStepCoordinator> taskObservable = null;
        taskObservable.subscribe(new Observer<TaskStepCoordinator>() {
            @Override public void onSubscribe(@NonNull Disposable d) {

            }

            @Override public void onNext(@NonNull TaskStepCoordinator taskStepCoordinator) {

            }

            @Override public void onError(@NonNull Throwable e) {

            }

            @Override public void onComplete() {

            }
        });
    }
}
