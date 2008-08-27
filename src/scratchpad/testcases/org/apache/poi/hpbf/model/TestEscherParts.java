/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.hpbf.model;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hpbf.HPBFDocument;

import junit.framework.TestCase;

public class TestEscherParts extends TestCase {
	private String dir;

	protected void setUp() throws Exception {
		dir = System.getProperty("HPBF.testdata.path");
	}

	public void testBasics() throws Exception {
		File f = new File(dir, "Sample.pub");
		HPBFDocument doc = new HPBFDocument(
				new FileInputStream(f)
		);

		EscherStm es = doc.getEscherStm();
		EscherDelayStm eds = doc.getEscherDelayStm();
		
		assertNotNull(es);
		assertNotNull(eds);
		
		assertEquals(13, es.getEscherRecords().length);
		assertEquals(0, eds.getEscherRecords().length);
		
		// TODO - check the contents
	}
}
