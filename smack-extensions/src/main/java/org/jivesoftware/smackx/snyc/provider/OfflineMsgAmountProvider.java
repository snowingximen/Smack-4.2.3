package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.snyc.packet.OMAmount;
import org.xmlpull.v1.XmlPullParser;

public class OfflineMsgAmountProvider extends IQProvider<OMAmount>{

	@Override
	public OMAmount parse(XmlPullParser parser, int initialDepth) throws Exception {
		String amount = parser.getAttributeValue(null, "amount");
		
		OMAmount omAmount = new OMAmount();
		omAmount.setAmount(amount);
		
		return omAmount;
	}

}
