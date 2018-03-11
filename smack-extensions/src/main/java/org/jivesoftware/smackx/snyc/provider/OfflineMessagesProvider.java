package org.jivesoftware.smackx.snyc.provider;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.snyc.packet.OfflineMessageItems;
import org.xmlpull.v1.XmlPullParser;

public class OfflineMessagesProvider extends IQProvider<OfflineMessageItems> {

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

	/*
	@Override
	public OfflineMessageItems parse(XmlPullParser parser, int initialDepth) throws Exception {

		OfflineMessageItems items = new OfflineMessageItems();
		
        boolean done = false;
        Message item;
        Jid jid = null;
        String stanzaId = null;
        Jid to = null;
        Jid from = null;
        Message.Type type = null;
        String version = null;
        String language = null;
        String subject = null;
        String body = null;
        String thread = null;
        String error = null;
        
        while (!done) {
            int eventType = parser.next();

            if (eventType == XmlPullParser.START_TAG && "item".equals(parser.getName())) {
                // Initialize the variables from the parsed XML
                jid = ParserUtils.getJidAttribute(parser);
//                name = parser.getAttributeValue("", "name");
//                node = parser.getAttributeValue("", "node");
//                action = parser.getAttributeValue("", "action");
//                
                
                final int initialDepthMsg = parser.getDepth();
                
//                Message message = new Message();
                
                stanzaId = parser.getAttributeValue("", "id");
                to = ParserUtils.getJidAttribute(parser, "to");
                from = ParserUtils.getJidAttribute(parser, "from");
                String typeString = parser.getAttributeValue("", "type");
                if (typeString != null) {
                    type = Message.Type.fromString(typeString);
                }

                version = parser.getAttributeValue("", "version");
                String lang = ParserUtils.getXmlLang(parser);

                // determine message's default language
                String defaultLanguage = null;
                if (language != null && !"".equals(language.trim())) {
                    lang = language;
                    defaultLanguage = language;
                }
                else {
                    defaultLanguage = Stanza.getDefaultLanguage();
                }

                // Parse sub-elements. We include extra logic to make sure the values
                // are only read once. This is because it's possible for the names to appear
                // in arbitrary sub-elements.
                outerloop: while (true) {
                    int eventTypeSub = parser.next();
                    switch (eventTypeSub) {
                    case XmlPullParser.START_TAG:
                        String elementName = parser.getName();
                        String namespace = parser.getNamespace();
                        switch (elementName) {
                        case "subject":
                            String xmlLangSubject = ParserUtils.getXmlLang(parser);
                            if (xmlLangSubject == null) {
                                xmlLangSubject = defaultLanguage;
                            }

                            subject = PacketParserUtils.parseElementText(parser);

//                            if (message.getSubject(xmlLangSubject) == null) {
//                                message.addSubject(xmlLangSubject, subject);
//                            }
                            break;
                        case Message.BODY:
                            String xmlLang = ParserUtils.getLanguageAttribute(parser);
                            if (xmlLang == null) {
                                xmlLang = defaultLanguage;
                            }

                            body = PacketParserUtils.parseElementText(parser);

//                            if (message.getBody(xmlLang) == null) {
//                                message.addBody(xmlLang, body);
//                            }
                            break;
                        case "thread":
                            if (thread == null) {
                                thread = parser.nextText();
                            }
                            break;
                        case "error":
                            message.setError(PacketParserUtils.parseError(parser));
                            break;
                         default:
                            PacketParserUtils.addExtensionElement(message, parser, elementName, namespace);
                            break;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getDepth() == initialDepthMsg) {
                            break outerloop;
                        }
                        break;
                    }
                }

                message.setThread(thread);
                
            }
            else if (eventType == XmlPullParser.END_TAG && "item".equals(parser.getName())) {
                // Create a new Item and add it to DiscoverItems.
                item = new Message();
                item.setName(name);
                item.setNode(node);
                item.setAction(action);
                
                items.addMessageItem(null);
            }
            else if (eventType == XmlPullParser.END_TAG && "query".equals(parser.getName())) {
                done = true;
            }
        }
        
        return items;
	}
*/
}
