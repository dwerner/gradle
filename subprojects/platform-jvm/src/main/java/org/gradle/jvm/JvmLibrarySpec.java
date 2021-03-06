/*
 * Copyright 2014 the original author or authors.
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

package org.gradle.jvm;

import org.gradle.api.Action;
import org.gradle.api.Incubating;
import org.gradle.internal.HasInternalProtocol;
import org.gradle.platform.base.DependencySpecContainer;
import org.gradle.platform.base.LibrarySpec;
import org.gradle.platform.base.PlatformAwareComponentSpec;

import java.util.Set;

/**
 * Definition of a JVM library component that is to be built by Gradle.
 */
@Incubating
@HasInternalProtocol
public interface JvmLibrarySpec extends LibrarySpec, JvmComponentSpec, PlatformAwareComponentSpec {

    /**
     * Specify the public API of this library.
     */
    void api(Action<? super JvmApiSpec> configureAction);

    /**
     * The public API of this library.
     */
    JvmApiSpec getApi();

    /**
     * The set of packages that comprise this library's public API.
     */
    Set<String> getExportedPackages();

    /**
     * Specify the component-level dependencies of this library.
     */
    void dependencies(Action<? super DependencySpecContainer> configureAction);

    /**
     * The component-level dependencies of this library.
     */
    DependencySpecContainer getDependencies();
}
