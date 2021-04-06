package com.mrpowergamerbr.openrct2kotlinapi.entities

import com.mrpowergamerbr.openrct2kotlinapi.utils.AliasInt
import com.mrpowergamerbr.openrct2kotlinapi.utils.ParkFlag
import com.mrpowergamerbr.openrct2kotlinapi.utils.ParkMessageType
import org.openrct2.GameMap
import org.openrct2.Park
import org.openrct2.ParkMessageDesc

class GameMap(private val map: GameMap) {
	val numRides by AliasInt(map::numRides)
	val numEntities by AliasInt(map::numEntities)
	val entities: List<Entity>
		get() {
			return (0 until numEntities).mapNotNull {
				getEntity(it)
			}
		}

	// TODO: rides
	// TODO: getRide
	// TODO: getTile
	// TODO: getEntity
	// TODO: getAllEntities
	fun getEntity(id: Number): Entity? {
		return Entity.fromOpenRCT2Entity(map.getEntity(id) ?: return null)
	}
}