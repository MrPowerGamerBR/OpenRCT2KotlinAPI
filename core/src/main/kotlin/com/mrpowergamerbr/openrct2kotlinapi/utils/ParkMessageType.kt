package com.mrpowergamerbr.openrct2kotlinapi.utils

enum class ParkMessageType {
	ATTRACTION,
	PEEP_ON_ATTRACTION,
	PEEP,
	MONEY,
	BLANK,
	RESEARCH,
	GUESTS,
	AWARD,
	CHART;

	val internal: String
		get() = this.name.toLowerCase()
}