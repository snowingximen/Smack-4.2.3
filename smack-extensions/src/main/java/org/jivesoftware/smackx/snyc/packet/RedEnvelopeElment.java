package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class RedEnvelopeElment implements ExtensionElement {

	public static final String NAMESPACE = "fc:msg:ext";

    public static final String ELEMENT = "redenvelope";
	
    private String id = null;
    private String from = null;
    private String to = null;
    private String amount = null;
    
    
	@Override
	public String getElementName() {
		return ELEMENT;
	}

	@Override
	public CharSequence toXML() {
        XmlStringBuilder xml = new XmlStringBuilder(this);       
        xml.rightAngleBracket();

        xml.optElement("id", id);
        xml.optElement("from", from);      
        xml.optElement("to", to);
        xml.optElement("amount", amount);

        xml.closeElement(this);
        
        return xml;
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
