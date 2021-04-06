package com.mrpowergamerbr.openrct2kotlinapi.events

import org.openrct2.NetworkChatEventArgs

class NetworkChatEvent(private val networkChatEvent: NetworkChatEventArgs) : NetworkEvent(networkChatEvent) {
	val message by networkChatEvent::message
}