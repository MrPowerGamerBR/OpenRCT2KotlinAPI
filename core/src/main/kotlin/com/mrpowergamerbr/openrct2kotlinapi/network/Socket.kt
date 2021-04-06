package com.mrpowergamerbr.openrct2kotlinapi.network

import org.openrct2.Socket

class Socket(private val socket: Socket) {
	fun send(data: String) = socket.write(data)

	fun onData(callback: (String) -> (Unit)) {
		socket.on("data", callback)
	}
}