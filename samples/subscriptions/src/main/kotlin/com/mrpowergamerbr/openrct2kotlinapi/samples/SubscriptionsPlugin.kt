package com.mrpowergamerbr.openrct2kotlinapi.samples

import com.mrpowergamerbr.openrct2kotlinapi.plugin.OpenRCT2Plugin
import com.mrpowergamerbr.openrct2kotlinapi.plugin.PluginType
import com.mrpowergamerbr.openrct2kotlinapi.utils.ParkMessageType

fun main() {
	// Based on https://github.com/OpenRCT2/plugin-samples/blob/master/subscriptions.js
	SubscriptionsPlugin().init()
}

class SubscriptionsPlugin : OpenRCT2Plugin(
	name = "Subscriptions",
	version = "1.0",
	authors = arrayOf("Ted John", "MrPowerGamerBR"),
	type = PluginType.REMOTE,
	licence = "MIT",
	minApiVersion = null
) {
	override fun onEnable() {
		// This message will appear when the script is loaded but will error
		// in multiplayer as the game state is not mutable in the main function.
		try {
			park.postMessage(
				ParkMessageType.AWARD,
				"Kotlin Subscriptions has been initialised!"
			)
		} catch (e: Error) {
			console.log(e)
		}

		context.onEachDay {
			// Events such as this can modify the game state as they
			// will for every client on the same tick.
			// Do not use any per-client logic here!
			//
			// Give the player 10 units of currency each day
			park.cash += 100

			// If the park rating falls below 400, cancel the subscription
			if (400 > park.rating)
				this.dispose()
		}
	}
}