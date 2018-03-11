package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class OMAmount extends IQ {

	public static final String ELEMENT = QUERY_ELEMENT;
    public static final String NAMESPACE = "sx:msg:offline:amount";
//    public static final String NAMESPACE = "fc:msg:offline:amount";

	public static final String ATTR_AMOUNT = "amount";
        
    private String amount = "";

    public OMAmount() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.result);
	}
    
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		 xml.attribute(ATTR_AMOUNT, amount);
		 xml.rightAngleBracket();
		 
		 return xml;
	}

}
