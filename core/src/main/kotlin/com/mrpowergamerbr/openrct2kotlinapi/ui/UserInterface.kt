package com.mrpowergamerbr.openrct2kotlinapi.ui

import org.openrct2.TextInputDesc
import org.openrct2.Ui

class UserInterface(private val ui: Ui) {
	fun showTextInput(
		title: String,
		description: String,
		initialValue: String? = null,
		maxLength: Int? = null,
		callback: (String) -> (Unit)
	) {
		ui.showTextInput(
			TextInputDesc(
				title = title,
				description = description,
				initialValue = initialValue,
				maxLength = maxLength,
				callback
			)
		)
	}

	fun registerMenuItem(text: String, callback: () -> (Unit)) {
		ui.registerMenuItem(text, callback)
	}
}