package com.mrpowergamerbr.openrct2kotlinapi

import com.mrpowergamerbr.openrct2kotlinapi.events.NetworkChatEvent
import com.mrpowergamerbr.openrct2kotlinapi.utils.DisposableContext
import org.openrct2.Context
import org.openrct2.IDisposable
import org.openrct2.NetworkChatEventArgs

class Context(private val handle: Context) {
	fun onEachTick(callback: DisposableContext.() -> (Unit)) = subscribe("interval.tick", callback)
	fun onEachDay(callback: DisposableContext.() -> (Unit)) = subscribe("interval.day", callback)

	fun onChat(callback: DisposableContext.(NetworkChatEvent) -> (Unit)) {
		var disposable: IDisposable? = null
		val wrapper: (NetworkChatEventArgs) -> (Unit) = {
			callback.invoke(DisposableContext(disposable!!), NetworkChatEvent(it))
		}
		// A hacky hack
		disposable = handle.subscribe("network.chat", wrapper)
	}

	fun subscribe(type: String, callback: DisposableContext.() -> (Unit)) {
		var disposable: IDisposable? = null
		val wrapper: () -> (Unit) = {
			callback.invoke(DisposableContext(disposable!!))
		}
		// A hacky hack
		disposable = handle.subscribe(type, wrapper)
	}
}