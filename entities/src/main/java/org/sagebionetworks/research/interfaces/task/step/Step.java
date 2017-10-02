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

import android.support.annotation.NonNull;


public interface Step {
    class Action {
        public static final String NEXT = "next";
        public static final String NONE = "none";
        public static final String PREVIOUS = "previous";
        public static final String END = "end";
        public static final String REFRESH = "refresh";
    }

    @NonNull
    String getIdentifier();

    @NonNull
    String getTitle();
}
