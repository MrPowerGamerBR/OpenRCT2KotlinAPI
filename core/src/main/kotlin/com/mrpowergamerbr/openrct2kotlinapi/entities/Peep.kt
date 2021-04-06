package com.mrpowergamerbr.openrct2kotlinapi.entities

import com.mrpowergamerbr.openrct2kotlinapi.utils.AliasInt
import org.openrct2.Peep

open class Peep(private val peep: Peep) : Entity(peep) {
	val peepType: PeepType
		get() = PeepType.valueOf(peep.peepType.toUpperCase())
	var name by peep::name
	// TODO: Destination
	var energy by AliasInt(peep::energy)
	val energyTarget by AliasInt(peep::energyTarget)

	// TODO: Flags

	enum class PeepType {
		GUEST,
		STAFF
	}
}