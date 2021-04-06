package com.mrpowergamerbr.openrct2kotlinapi.utils

import org.openrct2.IDisposable

class DisposableContext(val handle: IDisposable) {
	fun dispose() {
		handle.dispose()
	}
}