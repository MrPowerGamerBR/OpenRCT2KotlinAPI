package com.mrpowergamerbr.openrct2kotlinapi.entities

import com.mrpowergamerbr.openrct2kotlinapi.utils.AliasInt
import com.mrpowergamerbr.openrct2kotlinapi.utils.ParkFlag
import com.mrpowergamerbr.openrct2kotlinapi.utils.ParkMessageType
import org.openrct2.Park
import org.openrct2.ParkMessageDesc

class Park(private val park: Park) {
	var cash by AliasInt(park::cash)
	var rating by AliasInt(park::rating)
	var bankLoan by AliasInt(park::bankLoan)
	var maxBankLoan by AliasInt(park::maxBankLoan)
	var entranceFee by AliasInt(park::entranceFee)
	var guests by AliasInt(park::guests)
	var value by AliasInt(park::value)
	var companyValue by AliasInt(park::companyValue)
	var totalAdmissions by AliasInt(park::totalAdmissions)
	var totalIncomeFromAdmissions by AliasInt(park::totalIncomeFromAdmissions)
	var landPrice by AliasInt(park::landPrice)
	var constructionRightsPrice by AliasInt(park::constructionRightsPrice)
	var parkSize by AliasInt(park::parkSize)

	var name by park::name

	fun getFlag(flag: ParkFlag) = park.getFlag(flag.internal)
	fun setFlag(flag: ParkFlag, value: Boolean) = park.setFlag(flag.internal, value)

	fun postMessage(type: ParkMessageType, text: String, subject: Number? = null) {
		park.postMessage(
			object: ParkMessageDesc {
				override var type: String
					get() = type.internal
					set(value) {}
				override var text: String
					get() = text
					set(value) {}
				override var subject: Number?
					get() = subject
					set(value) {}
			}
		)
	}
}