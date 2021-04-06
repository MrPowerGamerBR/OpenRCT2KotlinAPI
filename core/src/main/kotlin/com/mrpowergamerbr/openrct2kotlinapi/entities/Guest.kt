package com.mrpowergamerbr.openrct2kotlinapi.entities

import com.mrpowergamerbr.openrct2kotlinapi.utils.AliasInt
import org.openrct2.Guest

class Guest(private val guest: Guest) : Peep(guest) {
	var tshirtColour by AliasInt(guest::tshirtColour)
	var trousersColour by AliasInt(guest::trousersColour)
	var balloonColour by AliasInt(guest::balloonColour)
	var hatColour by AliasInt(guest::hatColour)
	var umbrellaColour by AliasInt(guest::umbrellaColour)

	var happiness by AliasInt(guest::happiness)
	var happinessTarget by AliasInt(guest::happinessTarget)

	var nausea by AliasInt(guest::nausea)
	var nauseaTarget by AliasInt(guest::nauseaTarget)

	var hunger by AliasInt(guest::hunger)
	var thirst by AliasInt(guest::thirst)
	var toilet by AliasInt(guest::toilet)
	var mass by AliasInt(guest::mass)

	var minIntensity by AliasInt(guest::minIntensity)
	var maxIntensity by AliasInt(guest::maxIntensity)

	var nauseaTolerance by AliasInt(guest::nauseaTolerance)
	var cash by AliasInt(guest::cash)
}