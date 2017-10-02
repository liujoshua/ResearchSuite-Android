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

import android.support.annotation.Nullable;

/**
 * Created by liujoshua on 9/25/2017.
 */
public class Progress {
    private final int progress;
    private final int total;
    private final boolean isEstimated;

    public Progress(int progress, int total, boolean isEstimated) {
        this.progress = progress;
        this.total = total;
        this.isEstimated = isEstimated;
    }

    public int getProgress() {
        return progress;
    }

    public int getTotal() {
        return total;
    }

    public boolean isEstimated() {
        return isEstimated;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Progress progress1 = (Progress) o;

        if (progress != progress1.progress) {
            return false;
        }
        if (total != progress1.total) {
            return false;
        }
        return isEstimated == progress1.isEstimated;

    }

    @Override
    public int hashCode() {
        int result = progress;
        result = 31 * result + total;
        result = 31 * result + (isEstimated ? 1 : 0);
        return result;
    }
}
