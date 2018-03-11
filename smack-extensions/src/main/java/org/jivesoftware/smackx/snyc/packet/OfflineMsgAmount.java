package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class OfflineMsgAmount extends IQ{
	
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "sx:msg:offline:amount";  
//    public static final String NAMESPACE = "fc:msg:offline:amount";  

    public OfflineMsgAmount() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.get);
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
        xml.setEmptyElement();
        
        return xml;
    }
}
