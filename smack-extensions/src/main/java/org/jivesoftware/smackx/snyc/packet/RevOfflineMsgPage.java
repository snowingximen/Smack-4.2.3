package org.jivesoftware.smackx.snyc.packet;

import org.jivesoftware.smack.packet.IQ;

public class RevOfflineMsgPage extends IQ {
	
	private String limit = "10";
	private String version;
	
//    public static final String NAMESPACE = "sx:msg:offline:page";  
    public static final String NAMESPACE = "fc:msg:offline:page:rev";  

    public static final String VERSION = "version";
    public static final String LIMIT = "limit";
    public static final String ELEMENT = "query";
        
    public RevOfflineMsgPage() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.get);
    }
    
	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
		 xml.attribute(LIMIT, limit);
		 xml.attribute(VERSION, version);
		 xml.rightAngleBracket();
		 
        return xml;
	}
}