package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.ExtensionElement;

public class QuitRoomExtensionElement implements ExtensionElement {

    public static final String NAMESPACE = "sx:muc#user";
    public static final String ELEMENT = "quit";	
	
	@Override
	public String getElementName() {
		return ELEMENT;
	}

	@Override
	public CharSequence toXML() {
		 return "<" + ELEMENT + " xmlns='" + NAMESPACE + "'/>";
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

}
