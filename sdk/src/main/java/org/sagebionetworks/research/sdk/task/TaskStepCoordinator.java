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

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.sagebionetworks.research.interfaces.task.Progress;
import org.sagebionetworks.research.interfaces.task.TaskEntity;
import org.sagebionetworks.research.interfaces.task.AsyncAction;
import org.sagebionetworks.research.interfaces.task.TaskResult;
import org.sagebionetworks.research.interfaces.task.step.Step;

import java.util.List;


public interface TaskStepCoordinator {

    @Nullable
    Step getStep(@NonNull String identifier);

    @Nullable
    Step getStepBefore(@NonNull Step step, @Nullable TaskResult taskResult);

    @Nullable
    Step getStepAfter(@NonNull Step step, @Nullable TaskResult taskResult);

    @NonNull
    Progress getProgress(@NonNull Step step, @Nullable TaskResult taskResult);

    void validate();

    @NonNull
    String getIdentifier();

    @Nullable
    TaskEntity getInfo();

    @NonNull
    List<AsyncAction> getAsyncActions();
}
