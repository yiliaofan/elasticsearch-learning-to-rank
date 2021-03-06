/*
 * Copyright [2017] Wikimedia Foundation
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

package com.o19s.es.ltr.feature.store;

import org.elasticsearch.common.io.stream.NamedWriteable;
import org.elasticsearch.common.xcontent.ToXContent;

public interface StorableElement extends ToXContent, NamedWriteable {
    String name();

    /**
     * Type of the element
     */
    String type();

    /**
     * Is this element updatable
     */
    default boolean updatable() {
        return true;
    }

    default String id() {
        return generateId(type(), name());
    }

    static String generateId(String type, String name) {
        return type + "-" + name;
    }

    @Override
    default String getWriteableName() {
        return type();
    }
}
