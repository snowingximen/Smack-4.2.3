package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class APNSToken extends IQ {

	public static final String ELEMENT = "token";
    public static final String NAMESPACE = "sx:apns";

	public static final String ATTR_ID = "id";
        
    private String id = "";

    public APNSToken() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.set);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		 xml.attribute(ATTR_ID, id);
		 xml.rightAngleBracket();
		 
		 return xml;
	}

}
