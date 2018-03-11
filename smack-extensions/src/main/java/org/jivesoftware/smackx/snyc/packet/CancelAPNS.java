package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class CancelAPNS extends IQ {

	public static final String ELEMENT = "cancel";
    public static final String NAMESPACE = "sx:apns:cancel";

	public static final String ATTR_ID = "id";
        
    public CancelAPNS() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.set);
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		 xml.rightAngleBracket();
		 
		 return xml;
	}

}
