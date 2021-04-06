package com.mrpowergamerbr.openrct2kotlinapi.utils

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty

/**
 * Delegates a Number field, exposing the number as Integer
 */
class AliasInt(val delegate: KMutableProperty0<Number>) {
	operator fun getValue(thisRef: Any?, property: KProperty<*>): Int =
		delegate.get().toInt()

	operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
		delegate.set(value)
	}
}