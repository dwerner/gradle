/*
 * Copyright 2012 the original author or authors.
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

package org.gradle.api.internal.xml;

import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>A streaming XML writer. Encodes characters and CDATA. Provides only basic state validation, and some simple indentation.</p>
 *
 * <p>This class also is-a Writer, and any characters written to this writer will be encoded as appropriate.</p>
 *
 * by Szczepan Faber, created at: 12/3/12
 */
public class SimpleXmlWriter extends SimpleMarkupWriter {

    public SimpleXmlWriter(OutputStream output) throws IOException {
        this(output, null);
    }

    public SimpleXmlWriter(OutputStream output, String indent) throws IOException {
        super(output, indent);
        writeXmlDeclaration("UTF-8", "1.1");
    }

    private void writeXmlDeclaration(String encoding, String ver) throws IOException {
        writeRaw("<?xml version=\"");
        writeRaw(ver);
        writeRaw("\" encoding=\"");
        writeRaw(encoding);
        writeRaw("\"?>");
    }
}
