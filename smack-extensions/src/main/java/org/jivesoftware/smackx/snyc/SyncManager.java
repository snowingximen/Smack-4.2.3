/**
 *
 * Copyright 2014 Georg Lukas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jivesoftware.smackx.snyc;

import java.util.Map;
import java.util.WeakHashMap;

import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException.NoResponseException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException.XMPPErrorException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler.Mode;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.snyc.packet.Push;
import org.jivesoftware.smackx.snyc.packet.Sync;
import org.jxmpp.jid.Jid;

/**
 * A Version Manager that automatically responds to version IQs with a predetermined reply.
 *
 * <p>
 * The VersionManager takes care of handling incoming version request IQs, according to
 * XEP-0092 (Software Version). You can configure the version reply for a given connection
 * by running the following code:
 * </p>
 *
 * <pre>
 * Version MY_VERSION = new Version("My Little XMPP Application", "v1.23", "OS/2 32-bit");
 * VersionManager.getInstanceFor(mConnection).setVersion(MY_VERSION);
 * </pre>
 *
 * @author Georg Lukas
 */
public final class SyncManager extends Manager {
	

    
	
    private static final Map<XMPPConnection, SyncManager> INSTANCES = new WeakHashMap<XMPPConnection, SyncManager>();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            @Override
            public void connectionCreated(XMPPConnection connection) {
            	SyncManager.getInstanceFor(connection);
            }
        });
    }

    private SyncManager(final XMPPConnection connection) {
        super(connection);

        ServiceDiscoveryManager sdm = ServiceDiscoveryManager.getInstanceFor(connection);
        sdm.addFeature(Push.NAMESPACE);

        connection.registerIQRequestHandler(new AbstractIqRequestHandler(Push.ELEMENT, Push.NAMESPACE, IQ.Type.get,
                        Mode.async) {
            @Override
            public IQ handleIQRequest(IQ iqRequest) {
            	
            	/*
            	IQ syncIQ = IQ.createResultIQ(iqRequest);            	
            	syncIQ.addExtension(new SyncExtensionElement());
            	*/
            	
            	IQ syncIQ = new Sync(iqRequest);
            	
                return syncIQ;
            }
        });
    }

    public static synchronized SyncManager getInstanceFor(XMPPConnection connection) {
    	SyncManager syncManager = INSTANCES.get(connection);

        if (syncManager == null) {
            syncManager = new SyncManager(connection);
            INSTANCES.put(connection, syncManager);
        }

        return syncManager;
    }

    public boolean isSupported(Jid jid) throws NoResponseException, XMPPErrorException,
                    NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(jid,
        		Push.NAMESPACE);
    }

}
