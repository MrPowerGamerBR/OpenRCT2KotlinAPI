package com.mrpowergamerbr.openrct2kotlinapi.network

import com.mrpowergamerbr.openrct2kotlinapi.entities.Entity
import com.mrpowergamerbr.openrct2kotlinapi.entities.Player
import org.openrct2.Network

class Network(private val network: Network) {
	val mode: NetworkMode
		get() = NetworkMode.valueOf(network.mode.toUpperCase())

	fun getPlayer(index: Int): Player? {
		return Player(network.getPlayer(index) ?: return null)
	}

	fun createListener() = Listener(network.createListener())

	enum class NetworkMode {
		NONE,
		SERVER,
		CLIENT
	}
}