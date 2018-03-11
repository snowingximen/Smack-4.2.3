/**
 * $RCSfile$
 * $Revision$
 * $Date$
 *
 */

package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.snyc.packet.Push;
import org.xmlpull.v1.XmlPullParser;

/**
 * Sync provider.
 *
 * @author Klinsman
 */
public class SyncProvider extends IQProvider<Push> {

	@Override
	public Push parse(XmlPullParser parser, int initialDepth) throws Exception {		
		return new Push();
	}
	
}
