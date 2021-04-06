package com.mrpowergamerbr.openrct2kotlinapi.entities

import org.openrct2.Entity

open class Entity(val entity: Entity) {
	companion object {
		fun fromOpenRCT2Entity(entity: Entity) = when (entity.type) {
			"peep" -> {
				val peep = entity as org.openrct2.Peep

				if (peep.peepType == "guest") {
					Guest(entity as org.openrct2.Guest)
				} else {
					Peep(entity)
				}
			}
			else -> Entity(entity)
		}
	}

	fun remove() = entity.remove()

	override fun hashCode() = entity.hashCode()
}