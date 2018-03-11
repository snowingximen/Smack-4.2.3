/**
 * $RCSfile$
 * $Revision$
 * $Date$
 *
 * Copyright 2003-2007 Jive Software.
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

import java.util.logging.Logger;

import org.jivesoftware.smack.packet.IQ;

/**
 * IQ packet used by Smack to bind a resource and to obtain the jid assigned by the server.
 * There are two ways to bind a resource. One is simply sending an empty Bind packet where the
 * server will assign a new resource for this connection. The other option is to set a desired
 * resource but the server may return a modified version of the sent resource.<p>
 *
 * For more information refer to the following
 * 
 * @author Klinsman Du
 */
public class Push extends IQ {

    private static final Logger LOGGER = Logger.getLogger(Push.class.getName());
	
    public static final String NAMESPACE = "sx:msg:sync";

//    public static final String NAMESPACE = "fc:msg:sync";
    
    public static final String ELEMENT = "push";

    public Push() {
        super(ELEMENT, Push.NAMESPACE);
    }
    
/*
    public String getChildElementXML() {
        StringBuilder buf = new StringBuilder();

        buf.append("<push xmlns=\"fc:msg:sync\" />");

        return buf.toString();
    }
*/
    
	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		
        xml.setEmptyElement();
        
        return xml;
	}
}
