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

package org.gradle.model.internal.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Denotes that the {@link org.gradle.model.RuleSource} method rule carrying this annotation creates a new top level service in the model space.
 * A top-level service is a singleton that must always be referenced via both its path and its type. This allows services to be
 * resolved before {@link NodeInitializerRegistry} is ready to supply types for other elements.
 * <p>
 * The same rules apply to service elements as other elements defined via the {@link org.gradle.model.Model} annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Service {

    /**
     * Denotes the name by which the service model element will be available.
     * <p>
     * If the value is the empty string, the exact name of the annotated method will be used.
     * <p>
     * The value must:
     * <p>
     * <ul>
     * <li>Start with a lower case letter</li>
     * <li>Contain only ASCII letters, numbers and the '_' character</li>
     * </ul>
     * <p>
     * This restriction also applies when the name is being derived from the method name.
     * </p>
     *
     * @return the name by which the model element will be available
     */
    String value() default "";
}
