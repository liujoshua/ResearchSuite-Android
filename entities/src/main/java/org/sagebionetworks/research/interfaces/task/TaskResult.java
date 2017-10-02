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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import android.support.annotation.NonNull;
import org.sagebionetworks.research.interfaces.task.Result;
import org.sagebionetworks.research.interfaces.task.ResultBase;

/**
 * A result associated with a taskStepCoordinator. This object includes a step history, taskStepCoordinator run UUID, schema identifier, and
 * asyncronous results.
 */
public class TaskResult extends ResultBase {

    @NonNull
    private final UUID taskRunUUID;
    @NonNull
    private final List<Result> stepResults;
    @NonNull
    private final Set<Result> asyncResults;

    public TaskResult(@NonNull String identifier, @NonNull Date startDate, @NonNull Date endDate) {
        super(identifier, startDate, endDate);

        taskRunUUID = UUID.randomUUID();
        stepResults = new ArrayList<>();
        asyncResults = new HashSet<>();
    }

    public void addStepResult(@NonNull Result stepResult) {
        stepResults.add(stepResult);
    }

    @NonNull
    public UUID getTaskRunUUID() {
        return taskRunUUID;
    }

    /**
     * @return step history for this taskStepCoordinator. The listed step results should *only* include the last result for any given
     * step.
     */
    @NonNull
    public List<Result> getStepResults() {
        return stepResults;
    }

    @NonNull
    public Set<Result> getAsyncResults() {
        return asyncResults;
    }
}
