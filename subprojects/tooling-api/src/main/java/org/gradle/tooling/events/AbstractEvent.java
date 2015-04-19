/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.tooling.events;

import org.gradle.api.Incubating;

/**
 * Concrete event types should inherit from this base class.
 *
 * @since 2.4
 */
@Incubating
public abstract class AbstractEvent implements Event {

    private final long eventTime;

    /**
     * Creates a new instance with the given event time.
     *
     * @param eventTime The event time, in milliseconds since the epoch
     */
    protected AbstractEvent(long eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * Returns the time when the event happened.
     *
     * @return The event time, in milliseconds since the epoch
     */
    @Override
    public long getEventTime() {
        return eventTime;
    }
}