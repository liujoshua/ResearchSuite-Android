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

import java.util.Date;

import android.support.annotation.NonNull;


public interface Result {
    /**
     * @return identifier associated with the task, step, or asyncronous action.
     */
    @NonNull
    String getIdentifier();

    /**
     * @return start date timestamp
     */
    @NonNull
    Date getStartDate();

    /**
     * @return end date timestamp
     */
    @NonNull
    Date getEndDate();
}
