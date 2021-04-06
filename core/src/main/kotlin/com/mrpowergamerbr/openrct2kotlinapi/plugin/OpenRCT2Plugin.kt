package com.mrpowergamerbr.openrct2kotlinapi.plugin

import com.mrpowergamerbr.openrct2kotlinapi.Context
import com.mrpowergamerbr.openrct2kotlinapi.entities.GameMap
import com.mrpowergamerbr.openrct2kotlinapi.network.Network
import com.mrpowergamerbr.openrct2kotlinapi.entities.Park

open class OpenRCT2Plugin(
	val name: String,
	val version: String,
	val authors: dynamic, /* String | Array<String> */
	val type: PluginType,
	val licence: String,
	val minApiVersion: Number?
) {
	val context = Context(org.openrct2.context)
	val park = Park(org.openrct2.park)
	val map = GameMap(org.openrct2.map)
	val network = Network(org.openrct2.network)

	fun init() {
		println("Initializing plugin $name")
		registerPlugin(
			PluginMetadata(
				name,
				version,
				authors,
				type.name.toLowerCase(),
				licence,
				minApiVersion
			) { onEnable() } // Needs to be dynamic because the original "PluginMetadata" is a interface... and trying to implement it simply doesn't work
		)
	}

	open fun onEnable() {}
}