/**
 * Copyright 2012 Florian Schmaus
 *
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class Fin extends IQ {
    
    public static final String ELEMENT = "fin";
    public static final String VERSION = "version";
    
    private long version = -1;
    
    public Fin() {
        super(ELEMENT, Push.NAMESPACE);
        this.setType(Type.set);
	}
    
    public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		 xml.attribute(VERSION, String.valueOf(version));
		 xml.rightAngleBracket();
		 
        return xml;
	}
	
	/*@Override
    public String getChildElementXML() {
        return "<" + ELEMENT + " xmlns=\"" + NAMESPACE +  "\" version=\"" + version +  "\" />";
    }*/
}
