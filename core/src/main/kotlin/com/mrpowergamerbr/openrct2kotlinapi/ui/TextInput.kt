package com.mrpowergamerbr.openrct2kotlinapi.ui

private class TextInputDesc(
	val title: String,
	var description: String,
	var initialValue: String?,
	var maxLength: Number?,
	var callback: (value: String) -> Unit
)