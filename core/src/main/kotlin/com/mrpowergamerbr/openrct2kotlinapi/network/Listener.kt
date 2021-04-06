package com.mrpowergamerbr.openrct2kotlinapi.network

import org.openrct2.Listener

class Listener(private val listener: Listener) {
	val listening by listener::listening

	fun listen(port: Int) = Listener(listener.listen(port))
	fun close() = Listener(listener.close())

	fun onConnection(callback: (Socket) -> (Unit)) {
		listener.on("connection") {
			callback.invoke(Socket(it))
		}
	}
}