package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.snyc.packet.RedEnvelopeElment;
import org.xmlpull.v1.XmlPullParser;

public class RedEnvelopeExtProvider extends ExtensionElementProvider<RedEnvelopeElment> {

	@Override
	public RedEnvelopeElment parse(XmlPullParser parser, int initialDepth) throws Exception {

		RedEnvelopeElment redEnvelope = new RedEnvelopeElment();
        boolean done = false;        
        
        while (!done) {
            int eventType = parser.next();

            if (eventType == XmlPullParser.START_TAG && "id".equals(parser.getName())) {
            	redEnvelope.setId(parser.nextText());
            }else if(eventType == XmlPullParser.START_TAG && "amount".equals(parser.getName())){
            	redEnvelope.setAmount(parser.nextText());
            }else if(eventType == XmlPullParser.START_TAG && "from".equals(parser.getName())){
            	redEnvelope.setFrom(parser.nextText());
            }else if(eventType == XmlPullParser.START_TAG && "to".equals(parser.getName())){
            	redEnvelope.setTo(parser.nextText());
            }else if (eventType == XmlPullParser.END_TAG && RedEnvelopeElment.ELEMENT.equals(parser.getName())) {
                done = true;
            }
        }
		
		return redEnvelope;
	}

}
