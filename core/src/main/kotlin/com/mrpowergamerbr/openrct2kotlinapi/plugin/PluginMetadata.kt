package com.mrpowergamerbr.openrct2kotlinapi.plugin

internal class PluginMetadata(
	val name: String,
	val version: String,
	val authors: dynamic,
	val type: String,
	val licence: String,
	val minApiVersion: Number?,
	val main: () -> Unit
)