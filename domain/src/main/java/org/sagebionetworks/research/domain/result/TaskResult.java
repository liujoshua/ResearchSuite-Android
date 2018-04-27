/*
 * BSD 3-Clause License
 *
 * Copyright 2018  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.domain.result;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import org.threeten.bp.Instant;

import java.util.UUID;

@AutoValue
public abstract class TaskResult implements Result {
    @AutoValue.Builder
    public abstract static class Builder {

        public Builder addAsyncResult(Result result) {
            asyncResultsBuilder().add(result);
            return this;
        }

        public Builder addStepResult(Result result) {
            asyncResultsBuilder().add(result);
            return this;
        }

        public abstract TaskResult build();

        public abstract Builder setEndTime(final Instant endTime);

        public abstract Builder setIdentifier(String identifier);

        abstract ImmutableSet.Builder<Result> asyncResultsBuilder();

        abstract Builder setStartTime(final Instant startTime);

        abstract Builder setTaskRunUUID(UUID taskRunUUID);

        abstract Builder setType(String type);

        abstract ImmutableList.Builder<Result> stepHistoryBuilder();
    }

    private static final String KEY_TYPE = "task";

    @NonNull
    public static Builder builder(UUID taskRunUUID, Instant startTime) {
        return new AutoValue_TaskResult.Builder()
                .setType(KEY_TYPE)
                .setTaskRunUUID(taskRunUUID)
                .setStartTime(startTime);
    }

    @NonNull
    public abstract ImmutableSet<Result> getAsyncResults();

    /**
     * Returns the first result in the step history with the given identifier.
     *
     * @param identifier
     *         The identifier to search for in the step history.
     * @return the first result in the step history with the given identifier, or null if the identifier isn't found
     * in the step history.
     */
    @Nullable
    public Result getResult(String identifier) {
        for (Result result : getStepHistory()) {
            if (result.getIdentifier().equals(identifier)) {
                return result;
            }
        }

        return null;
    }

    @NonNull
    public abstract ImmutableList<Result> getStepHistory();

    @NonNull
    public abstract UUID getTaskRunUUID();

    @NonNull
    public abstract Builder toBuilder();
}
