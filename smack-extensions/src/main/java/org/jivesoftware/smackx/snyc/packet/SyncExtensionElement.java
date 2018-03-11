package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.ExtensionElement;

public class SyncExtensionElement implements ExtensionElement {

    public static final String NAMESPACE = "sx:msg:sync";
//	public static final String NAMESPACE = "fc:msg:sync";

    public static final String ELEMENT = "sync";
	
	
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
