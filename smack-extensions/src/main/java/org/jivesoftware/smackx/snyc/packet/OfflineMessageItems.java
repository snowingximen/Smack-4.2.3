package org.jivesoftware.smackx.snyc.packet;

import java.util.ArrayList;
import java.util.List;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;

public class OfflineMessageItems extends IQ {

	public static final String ELEMENT = QUERY_ELEMENT;
//    public static final String NAMESPACE = "fc:msg:offline:page:rev";
    public static final String NAMESPACE = "sx:msg:offline:page:rev";

	public static final String ATTR_COUNT = "count";
		
	private List<Message> offlineMsgList = new ArrayList<Message>();
	
	public OfflineMessageItems() {
        super(ELEMENT, NAMESPACE);
        this.setType(Type.result);
	}

	public List<Message> getOfflineMessageItems(){
		return this.offlineMsgList;
	}
	
	public void addMessageItem(Message item){
		offlineMsgList.add(item);
	}
	
	public int getCount(){
		return this.offlineMsgList.size();
	}
	
	@Override
	protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder xml) {
        xml.optAttribute(ATTR_COUNT, String.valueOf(getCount()));
        xml.rightAngleBracket();

        for (Message item : offlineMsgList) {
            xml.append(item.toXML());
        }
        
        return xml;
	}

}
