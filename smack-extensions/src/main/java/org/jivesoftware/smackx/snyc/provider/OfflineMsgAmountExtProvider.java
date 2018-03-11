/**
 * $RCSfile$
 * $Revision$
 * $Date$
 *
 */

package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.bytestreams.ibb.provider.DataPacketProvider.PacketExtensionProvider;
import org.jivesoftware.smackx.snyc.packet.OMAmountExtension;
import org.xmlpull.v1.XmlPullParser;

/**
 * OfflineMsgAmount provider.
 *
 * @author Klinsman
 */
public class OfflineMsgAmountExtProvider extends PacketExtensionProvider {

	public ExtensionElement parseExtension(XmlPullParser parser) throws Exception {
		String amount = parser.getAttributeValue(null, "amount");
		
		return new OMAmountExtension(amount);
	}
}
