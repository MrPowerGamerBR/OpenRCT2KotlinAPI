package org.openrct2

// Stuff that was changed due to Dukat not converting stuff that OpenRCT2 accepts
// This only has stuff that are *not* external classes (because you can't add them to openrct2.kt)

class TextInputDesc(
	val title: String,
	var description: String,
	var initialValue: String?,
	var maxLength: Number?,
	var callback: (value: String) -> Unit
)