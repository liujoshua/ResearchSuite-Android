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

import android.support.annotation.NonNull;


public class Schema {
    @NonNull
    private final String identifier;
    private final int revision;

    public Schema(@NonNull String identifier, int revision) {
        this.identifier = identifier;

        this.revision = revision;
    }

    @NonNull
    public String getIdentifier() {
        return identifier;
    }

    public int getRevision() {
        return revision;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Schema{");
        sb.append("identifier='").append(identifier).append('\'');
        sb.append(", revision=").append(revision);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schema schema = (Schema) o;

        if (revision != schema.revision) return false;
        return identifier.equals(schema.identifier);

    }

    @Override
    public int hashCode() {
        int result = identifier.hashCode();
        result = 31 * result + revision;
        return result;
    }
}
