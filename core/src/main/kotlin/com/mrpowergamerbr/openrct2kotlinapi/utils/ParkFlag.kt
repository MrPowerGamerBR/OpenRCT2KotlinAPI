package com.mrpowergamerbr.openrct2kotlinapi.utils

enum class ParkFlag {
	// difficultGuestGeneration" | "difficultParkRating" | "forbidHighConstruction" | "forbidLandscapeChanges" | "forbidMarketingCampaigns" | "forbidTreeRemoval" | "freeParkEntry" | "noMoney" | "open" | "preferLessIntenseRides" | "preferMoreIntenseRides" | "scenarioCompleteNameInput" | "unlockAllPrices
	DIFFICULT_GUEST_GENERATION,
	DIFFICULT_PARK_RATING,
	FORBID_HIGH_CONSTRUCTION,
	FORBID_LANDSCAPE_CHANGES,
	FORBID_MARKETING_CAMPAIGNS,
	FORBID_TREE_REMOVAL,
	FREE_PARK_ENTRY,
	NO_MONEY,
	OPEN,
	PREFER_LESS_INTENSE_RIDES,
	PREFER_MORE_INTENSE_RIDES,
	SCENARIO_COMPLETE_NAME_INPUT,
	UNLOCK_ALL_PRICES;

	val internal: String
		get() = this.name.toLowerCase()
}