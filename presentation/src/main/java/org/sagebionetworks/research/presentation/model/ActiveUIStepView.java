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

package org.sagebionetworks.research.presentation.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import com.ryanharter.auto.value.parcel.ParcelAdapter;

import org.sagebionetworks.research.presentation.DisplayString;
import org.sagebionetworks.research.presentation.model.parcelable.DurationToDisplayStringMapAdapter;
import org.threeten.bp.Duration;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@AutoValue
public abstract class ActiveUIStepView implements StepView {

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract ActiveUIStepView build();

        public abstract Builder setDetail(@Nullable DisplayString description);

        public abstract Builder setDuration(@Nullable Duration duration);

        public abstract Builder setIdentifier(@NonNull String identifier);

        public abstract Builder setNavDirection(@NavDirection int navDirection);

        public abstract Builder setSpokenInstructions(@NonNull Map<Duration, DisplayString> spokenInstructions);

        public abstract Builder setStepActionViews(@NonNull Set<StepActionView> stepActionViews);

        public abstract Builder setTitle(@Nullable DisplayString title);
    }

    /**
     * @return builder for an ActiveUIStepView with default NavDirection.SHIFT_LEFT
     */
    public static Builder builder() {
        return new AutoValue_ActiveUIStepView.Builder()
                .setNavDirection(NavDirection.SHIFT_LEFT)
                .setSpokenInstructions(Collections.emptyMap())
                .setStepActionViews(Collections.emptySet());
    }

    @Nullable
    public abstract Duration getDuration();

    @NonNull
    @ParcelAdapter(DurationToDisplayStringMapAdapter.class)
    public abstract ImmutableMap<Duration, DisplayString> getSpokenInstructions();

    public abstract Builder toBuilder();
}
