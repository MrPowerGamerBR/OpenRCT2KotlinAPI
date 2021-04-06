package com.mrpowergamerbr.openrct2kotlinapi.samples

import com.mrpowergamerbr.openrct2kotlinapi.entities.Guest
import com.mrpowergamerbr.openrct2kotlinapi.plugin.OpenRCT2Plugin
import com.mrpowergamerbr.openrct2kotlinapi.plugin.PluginType

fun main() {
	// Based on https://github.com/OpenRCT2/plugin-samples/blob/master/peep-tools.js
	PeepToolsPlugin().init()
}

class PeepToolsPlugin : OpenRCT2Plugin(
	name = "Peep Tools",
	version = "1.0",
	authors = arrayOf("OpenRCT2", "MrPowerGamerBR"),
	type = PluginType.REMOTE,
	licence = "MIT",
	minApiVersion = null
) {
	/**
	 * Changes the guest T-Shirt and Trouser colors to  [tshirtColour] and [trousersColour]
	 *
	 * @param tshirtColour The T-Shirt color
	 * @param trousersColour The Trousers color
	 */
	fun setGuestClothing(tshirtColour: Int, trousersColour: Int) {
		map.entities.filterIsInstance<Guest>().forEach {
			it.tshirtColour = tshirtColour
			it.trousersColour = trousersColour
		}
	}

	override fun onEnable() {
		// UI can be null if it is being ran on a headless server, so that's why UI can be null
		// So we use "?.let", the code will only be ran if "ui" is not null!
		ui?.let { userInterface ->
			// Add a menu item under the map icon on the top toolbar
			userInterface.registerMenuItem("Set guest clothes") {
				userInterface.showTextInput(
					title = "Set guest clothes",
					description = "What will be the T-Shirt colour and Trousers color? (numeric value, separated by space)"
				) {
					val split = it.split(" ")
					val tshirtColour = split[0].toInt()
					val trousersColour = split[1].toInt()

					setGuestClothing(tshirtColour, trousersColour)
				}
			}
		}
	}
}