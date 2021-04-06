package com.mrpowergamerbr.openrct2kotlinapi.events

import com.mrpowergamerbr.openrct2kotlinapi.utils.AliasInt
import org.openrct2.NetworkEventArgs

open class NetworkEvent(private val networkEvent: NetworkEventArgs) {
	val player by AliasInt(networkEvent::player)
}