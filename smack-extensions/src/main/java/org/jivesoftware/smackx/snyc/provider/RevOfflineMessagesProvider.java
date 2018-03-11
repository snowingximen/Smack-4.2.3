package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.snyc.packet.OfflineMessageItems;
import org.xmlpull.v1.XmlPullParser;

public class RevOfflineMessagesProvider extends IQProvider<OfflineMessageItems> {

	@Override
	public OfflineMessageItems parse(XmlPullParser parser, int initialDepth) throws Exception {
		OfflineMessageItems items = new OfflineMessageItems();
		
        boolean done = false;
        Message offlineMsg = null;
        
        while (!done) {
            int eventType = parser.next();

            if (eventType == XmlPullParser.START_TAG && Message.ELEMENT.equals(parser.getName())) {
                // Initialize the variables from the parsed XML
                offlineMsg = PacketParserUtils.parseMessage(parser);
                items.addMessageItem(offlineMsg);
            }else if (eventType == XmlPullParser.END_TAG && "query".equals(parser.getName())) {
                done = true;
            }
        }

		return items;
	}
	
}
