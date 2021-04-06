package com.mrpowergamerbr.openrct2kotlinapi.entities

import org.openrct2.Player

class Player(private val player: Player) {
	val id by player::id
	val name by player::name
	var group by player::group
	val ping by player::ping
	val commandsRan by player::commandsRan
	val moneySpent by player::moneySpent
	val ipAddress by player::ipAddress
	val publicKeyHash by player::publicKeyHash
}