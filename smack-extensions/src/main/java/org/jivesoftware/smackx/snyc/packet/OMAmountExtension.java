package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.ExtensionElement;

public class OMAmountExtension implements ExtensionElement {

	private String amount = "0";
	
	public OMAmountExtension(String amount){
		this.amount = amount;
	}
	
	@Override
	public String getElementName() {
		return OfflineMsgAmount.ELEMENT;
	}

	@Override
	public CharSequence toXML() {
		String xml = "<" + getElementName() + " xmlns='" + getNamespace() +  "' amount='" + amount +  "'/>";
		
		return xml;
	}

	@Override
	public String getNamespace() {
		return OfflineMsgAmount.NAMESPACE;
	}

}
