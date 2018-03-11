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

public class Disturber extends IQ {
    
    public static final String ELEMENT = "query";
    public static final String VERSION = "version";
    
    public static final String NAMESPACE = "sx:disturber";
  
    public static final String ATTR_ACTION = "action";
    public static final String ATTR_ACTION_SETUP = "setup";
    public static final String ATTR_ACTION_CANCEL = "cancel";
    
    public static final String ATTR_TYPE = "type";    
    public static final String ATTR_TYPE_USER = "user";    
    public static final String ATTR_TYPE_ROOM = "room";    

    public static final String ATTR_JID = "jid";
    public static final String ATTR_USERNAME = "username";

    
    private String actoin = null;
    private String itemType = null;
    private String jid = null;
    private String username = null;
    
    public Disturber() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.set);
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		if (actoin != null) {
			 xml.attribute(ATTR_ACTION, actoin);
		}
		if(itemType != null){
			 xml.attribute(ATTR_TYPE, itemType);
		}
		if(jid != null){
			 xml.attribute(ATTR_JID, jid);
		}
		
		xml.rightAngleBracket();
		 
        return xml;
	}

	public String getActoin() {
		return actoin;
	}

	public void setActoin(String actoin) {
		this.actoin = actoin;
	}


	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
