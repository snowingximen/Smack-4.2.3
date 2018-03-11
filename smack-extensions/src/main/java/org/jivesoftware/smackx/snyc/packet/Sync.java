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

public class Sync extends IQ {

    public static final String ELEMENT = "sync";

    public Sync(IQ iq) {
        super(ELEMENT, Push.NAMESPACE);
        setType(IQ.Type.result);
        this.setStanzaId(iq.getStanzaId());
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
        xml.setEmptyElement();
        
        return xml;
	}
    
/*    @Override
    public String getChildElementXML() {
        return "<" + ELEMENT + " xmlns=\'" + NAMESPACE + "\' />";
    }
    */
}
