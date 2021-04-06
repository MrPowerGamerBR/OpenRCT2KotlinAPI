@file:JsQualifier("global")
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package org.openrct2

import org.khronos.webgl.Uint8Array
import org.w3c.dom.Window
import kotlin.js.*

external var cheats: Cheats

external var console: Console

external var context: Context

external var date: GameDate

external var map: GameMap

external var network: Network

external var park: Park

external var scenario: Scenario

external var titleSequenceManager: TitleSequenceManager

external var ui: Ui

external fun registerPlugin(metadata: PluginMetadata)

external interface IDisposable {
    fun dispose()
}

external interface ScreenCoordsXY {
    var x: Number
    var y: Number
}

external interface ScreenSize {
    var width: Number
    var height: Number
}

external interface CoordsXY {
    var x: Number
    var y: Number
}

external interface CoordsXYZ : CoordsXY {
    var z: Number
}

external interface CoordsXYZD : CoordsXYZ {
    var direction: Number
}

external interface MapRange {
    var leftTop: CoordsXY
    var rightBottom: CoordsXY
}

external interface PluginMetadata {
    var name: String
    var version: String
    var authors: dynamic /* String | Array<String> */
        get() = definedExternally
        set(value) = definedExternally
    var type: String /* "local" | "remote" */
    var licence: String
    var minApiVersion: Number?
        get() = definedExternally
        set(value) = definedExternally
    var main: () -> Unit
}

external interface Context {
    var configuration: Configuration
    var sharedStorage: Configuration
    fun captureImage(options: CaptureOptions)
    fun getObject(type: String /* "ride" | "small_scenery" | "large_scenery" | "wall" | "banner" | "footpath" | "footpath_addition" | "scenery_group" | "park_entrance" | "water" | "terrain_surface" | "terrain_edge" | "station" | "music" | "ride" | "small_scenery" */, index: Number): dynamic /* SmallSceneryObject */
    fun getAllObjects(type: String /* "ride" | "small_scenery" | "large_scenery" | "wall" | "banner" | "footpath" | "footpath_addition" | "scenery_group" | "park_entrance" | "water" | "terrain_surface" | "terrain_edge" | "station" | "music" | "ride" */): dynamic /* Array | Array */
    fun getRandom(min: Number, max: Number): Number
    fun formatString(fmt: String, vararg args: Any): String
    fun registerAction(action: String, query: (args: Any?) -> GameActionResult, execute: (args: Any?) -> GameActionResult)
    fun queryAction(action: String /* "balloonpress" | "bannerplace" | "bannerremove" | "bannersetcolour" | "bannersetname" | "bannersetstyle" | "clearscenery" | "climateset" | "footpathplace" | "footpathplacefromtrack" | "footpathremove" | "footpathadditionplace" | "footpathadditionremove" | "guestsetflags" | "guestsetname" | "landbuyrights" | "landlower" | "landraise" | "landsetheight" | "landsetrights" | "landsmoothaction" | "largesceneryplace" | "largesceneryremove" | "largescenerysetcolour" | "loadorquit" | "mazeplacetrack" | "mazesettrack" | "networkmodifygroup" | "parkentranceremove" | "parkmarketing" | "parksetdate" | "parksetloan" | "parksetname" | "parksetparameter" | "parksetresearchfunding" | "pausetoggle" | "peeppickup" | "placeparkentrance" | "placepeepspawn" | "playerkick" | "playersetgroup" | "ridecreate" | "ridedemolish" | "rideentranceexitplace" | "rideentranceexitremove" | "ridesetappearance" | "ridesetcolourscheme" | "ridesetname" | "ridesetprice" | "ridesetsetting" | "ridesetstatus" | "ridesetvehicles" | "scenariosetsetting" | "setcheataction" | "setparkentrancefee" | "signsetname" | "smallsceneryplace" | "smallsceneryremove" | "stafffire" | "staffhire" | "staffsetcolour" | "staffsetcostume" | "staffsetname" | "staffsetorders" | "staffsetpatrolarea" | "surfacesetstyle" | "tilemodify" | "trackdesign" | "trackplace" | "trackremove" | "tracksetbrakespeed" | "wallplace" | "wallremove" | "wallsetcolour" | "waterlower" | "waterraise" | "watersetheight" */, args: Any?, callback: (result: GameActionResult) -> Unit)
    fun executeAction(action: String /* "balloonpress" | "bannerplace" | "bannerremove" | "bannersetcolour" | "bannersetname" | "bannersetstyle" | "clearscenery" | "climateset" | "footpathplace" | "footpathplacefromtrack" | "footpathremove" | "footpathadditionplace" | "footpathadditionremove" | "guestsetflags" | "guestsetname" | "landbuyrights" | "landlower" | "landraise" | "landsetheight" | "landsetrights" | "landsmoothaction" | "largesceneryplace" | "largesceneryremove" | "largescenerysetcolour" | "loadorquit" | "mazeplacetrack" | "mazesettrack" | "networkmodifygroup" | "parkentranceremove" | "parkmarketing" | "parksetdate" | "parksetloan" | "parksetname" | "parksetparameter" | "parksetresearchfunding" | "pausetoggle" | "peeppickup" | "placeparkentrance" | "placepeepspawn" | "playerkick" | "playersetgroup" | "ridecreate" | "ridedemolish" | "rideentranceexitplace" | "rideentranceexitremove" | "ridesetappearance" | "ridesetcolourscheme" | "ridesetname" | "ridesetprice" | "ridesetsetting" | "ridesetstatus" | "ridesetvehicles" | "scenariosetsetting" | "setcheataction" | "setparkentrancefee" | "signsetname" | "smallsceneryplace" | "smallsceneryremove" | "stafffire" | "staffhire" | "staffsetcolour" | "staffsetcostume" | "staffsetname" | "staffsetorders" | "staffsetpatrolarea" | "surfacesetstyle" | "tilemodify" | "trackdesign" | "trackplace" | "trackremove" | "tracksetbrakespeed" | "wallplace" | "wallremove" | "wallsetcolour" | "waterlower" | "waterraise" | "watersetheight" */, args: Any?, callback: (result: GameActionResult) -> Unit)
    fun subscribe(hook: String /* "interval.tick" | "interval.day" | "network.chat" | "network.action" | "network.join" | "network.leave" | "ride.ratings.calculate" | "action.location" */, callback: Function<*>): IDisposable
    fun subscribe(hook: String /* "action.query" | "action.execute" */, callback: (e: GameActionEventArgs) -> Unit): IDisposable
    fun subscribe(hook: String /* "interval.tick" | "interval.day" */, callback: () -> Unit): IDisposable
    fun subscribe(hook: String /* "network.chat" */, callback: (e: NetworkChatEventArgs) -> Unit): IDisposable
    fun subscribe(hook: String /* "network.authenticate" */, callback: (e: NetworkAuthenticateEventArgs) -> Unit): IDisposable
    fun subscribe(hook: String /* "network.join" | "network.leave" */, callback: (e: NetworkEventArgs) -> Unit): IDisposable
    fun subscribe(hook: String /* "ride.ratings.calculate" */, callback: (e: RideRatingsCalculateArgs) -> Unit): IDisposable
    fun subscribe(hook: String /* "action.location" */, callback: (e: ActionLocationArgs) -> Unit): IDisposable
    fun setInterval(callback: Function<*>, delay: Number): Number
    fun setTimeout(callback: Function<*>, delay: Number): Number
    fun clearInterval(handle: Number)
    fun clearTimeout(handle: Number)
}

external interface Configuration {
    fun getAll(namespace: String): Json
    fun <T> get(key: String): T?
    fun <T> get(key: String, defaultValue: T): T
    fun <T> set(key: String, value: T)
    fun has(key: String): Boolean
}

external interface CaptureOptions {
    var filename: String?
        get() = definedExternally
        set(value) = definedExternally
    var width: Number?
        get() = definedExternally
        set(value) = definedExternally
    var height: Number?
        get() = definedExternally
        set(value) = definedExternally
    var position: CoordsXY?
        get() = definedExternally
        set(value) = definedExternally
    var zoom: Number
    var rotation: Number
    var transparent: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GameActionEventArgs {
    var player: Number
    var type: Number
    var action: String
    var isClientOnly: Boolean
    var args: Any?
    var result: GameActionResult
}

external interface GameActionResult {
    var error: Number?
        get() = definedExternally
        set(value) = definedExternally
    var errorTitle: String?
        get() = definedExternally
        set(value) = definedExternally
    var errorMessage: String?
        get() = definedExternally
        set(value) = definedExternally
    var position: CoordsXYZ?
        get() = definedExternally
        set(value) = definedExternally
    var cost: Number?
        get() = definedExternally
        set(value) = definedExternally
    var expenditureType: String? /* "ride_construction" | "ride_runningcosts" | "land_purchase" | "landscaping" | "park_entrance_tickets" | "park_ride_tickets" | "shop_sales" | "shop_stock" | "food_drink_sales" | "food_drink_stock" | "wages" | "marketing" | "research" | "interest" */
        get() = definedExternally
        set(value) = definedExternally
}

external interface RideCreateGameActionResult : GameActionResult {
    var ride: Number
}

external interface NetworkEventArgs {
    var player: Number
}

external interface NetworkChatEventArgs : NetworkEventArgs {
    var message: String
}

external interface NetworkAuthenticateEventArgs {
    var name: Number
    var ipAddress: String
    var publicKeyHash: String
    var cancel: Boolean
}

external interface RideRatingsCalculateArgs {
    var rideId: Number
    var excitement: Number
    var intensity: Number
    var nausea: Number
}

external interface ActionLocationArgs {
    var x: Number
    var y: Number
    var player: Number
    var type: Number
    var isClientOnly: Boolean
    var result: Boolean
}

external interface GameDate {
    var ticksElapsed: Number
    var monthsElapsed: Number
    var yearsElapsed: Number
    var monthProgress: Number
    var day: Number
    var month: Number
    var year: Number
}

external interface GameMap {
    var size: CoordsXY
    var numRides: Number
    var numEntities: Number
    var rides: Array<Ride>
    fun getRide(id: Number): Ride
    fun getTile(x: Number, y: Number): Tile
    fun getEntity(id: Number): Entity?
    fun getAllEntities(type: String /* "balloon" | "car" | "crash_splash" | "crashed_vehicle_particle" | "duck" | "explosion_cloud" | "explosion_flare" | "jumping_fountain_snow" | "jumping_fountain_water" | "litter" | "money_effect" | "peep" | "steam_particle" | "peep" */): dynamic /* Array | Array */
}

external interface BaseTileElement {
    var type: String /* "surface" | "footpath" | "track" | "small_scenery" | "wall" | "entrance" | "large_scenery" | "banner" | "openrct2_corrupt_deprecated" */
    var baseHeight: Number
    var baseZ: Number
    var clearanceHeight: Number
    var clearanceZ: Number
    var occupiedQuadrants: Number
    var isGhost: Boolean
    var isHidden: Boolean
}

external interface SurfaceElement : BaseTileElement {
    var slope: Number
    var surfaceStyle: Number
    var edgeStyle: Number
    var waterHeight: Number
    var grassLength: Number
    var ownership: Number
    var parkFences: Number
    var hasOwnership: Boolean
    var hasConstructionRights: Boolean
}

external interface FootpathElement : BaseTileElement {
    var `object`: Number
    var edges: Number
    var corners: Number
    var slopeDirection: Number?
    var isBlockedByVehicle: Boolean
    var isWide: Boolean
    var isQueue: Boolean
    var queueBannerDirection: Number?
    var ride: Number?
    var station: Number?
    var addition: Number?
    var additionStatus: Number?
    var isAdditionBroken: Boolean?
    var isAdditionGhost: Boolean?
}

external interface TrackElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var trackType: Number
    var sequence: Number?
    var mazeEntry: Number?
    var colourScheme: Number?
    var seatRotation: Number?
    var ride: Number
    var station: Number?
    var brakeBoosterSpeed: Number?
    var hasChainLift: Boolean
    var isInverted: Boolean
    var hasCableLift: Boolean
}

external interface SmallSceneryElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var `object`: Number
    var primaryColour: Number
    var secondaryColour: Number
    var quadrant: Number
    var age: Number
}

external interface WallElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var `object`: Number
    var primaryColour: Number
    var secondaryColour: Number
    var tertiaryColour: Number
    var bannerIndex: Number?
    var slope: Number /* 0 | 1 | 2 | 3 */
}

external interface EntranceElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var `object`: Number
    var ride: Number
    var station: Number
    var sequence: Number
    var footpathObject: Number
}

external interface LargeSceneryElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var `object`: Number
    var primaryColour: Number
    var secondaryColour: Number
    var bannerIndex: Number?
    var sequence: Number
}

external interface BannerElement : BaseTileElement {
    var direction: Number /* 0 | 1 | 2 | 3 */
    var bannerIndex: Number
}

external interface CorruptElement : BaseTileElement

external interface Tile {
    var x: Number
    var y: Number
    var elements: Array<BaseTileElement>
    var numElements: Number
    var data: Uint8Array
    fun getElement(index: Number): BaseTileElement
    fun <T : BaseTileElement> getElement(index: Number): T
    fun insertElement(index: Number): BaseTileElement
    fun removeElement(index: Number)
}

external interface RideObject {
    var description: String
    var capacity: String
    var flags: Number
    var rideType: Array<Number>
    var minCarsInTrain: Number
    var maxCarsInTrain: Number
    var carsPerFlatRide: Number
    var zeroCars: Number
    var tabVehicle: Number
    var defaultVehicle: Number
    var frontVehicle: Number
    var secondVehicle: Number
    var rearVehicle: Number
    var thirdVehicle: Number
    var vehicles: Array<RideObjectVehicle>
    var excitementMultiplier: Number
    var intensityMultiplier: Number
    var nauseaMultiplier: Number
    var maxHeight: Number
    var shopItem: Number
    var shopItemSecondary: Number
}

external interface RideObjectVehicle {
    var rotationFrameMask: Number
    var numVerticalFrames: Number
    var numHorizontalFrames: Number
    var spacing: Number
    var carMass: Number
    var tabHeight: Number
    var numSeats: Number
    var spriteFlags: Number
    var spriteWidth: Number
    var spriteHeightNegative: Number
    var spriteHeightPositive: Number
    var animation: Number
    var flags: Number
    var baseNumFrames: Number
    var baseImageId: Number
    var restraintImageId: Number
    var gentleSlopeImageId: Number
    var steepSlopeImageId: Number
    var verticalSlopeImageId: Number
    var diagonalSlopeImageId: Number
    var bankedImageId: Number
    var inlineTwistImageId: Number
    var flatToGentleBankImageId: Number
    var diagonalToGentleSlopeBankImageId: Number
    var gentleSlopeToBankImageId: Number
    var gentleSlopeBankTurnImageId: Number
    var flatBankToGentleSlopeImageId: Number
    var curvedLiftHillImageId: Number
    var corkscrewImageId: Number
    var noVehicleImages: Number
    var noSeatingRows: Number
    var spinningInertia: Number
    var spinningFriction: Number
    var frictionSoundId: Number
    var logFlumeReverserVehicleType: Number
    var soundRange: Number
    var doubleSoundFrequency: Number
    var poweredAcceleration: Number
    var poweredMaxSpeed: Number
    var carVisual: Number
    var effectVisual: Number
    var drawOrder: Number
    var numVerticalFramesOverride: Number
}

external interface SmallSceneryObject {
    var flags: Number
    var height: Number
    var price: Number
    var removalPrice: Number
}

external interface Ride {
    var `object`: RideObject
    var id: Number
    var type: Number
    var classification: String /* "ride" | "stall" | "facility" */
    var name: String
    var status: String /* "closed" | "open" | "testing" | "simulating" */
    var lifecycleFlags: Number
    var mode: Number
    var departFlags: Number
    var minimumWaitingTime: Number
    var maximumWaitingTime: Number
    var vehicles: Array<Number>
    var vehicleColours: Array<VehicleColour>
    var colourSchemes: Array<TrackColour>
    var stationStyle: Number
    var music: Number
    var stations: Array<RideStation>
    var price: Array<Number>
    var excitement: Number
    var intensity: Number
    var nausea: Number
    var totalCustomers: Number
    var buildDate: Number
    var age: Number
    var runningCost: Number
    var totalProfit: Number
    var inspectionInterval: Number
    var value: Number
}

external interface TrackColour {
    var main: Number
    var additional: Number
    var supports: Number
}

external interface VehicleColour {
    var body: Number
    var trim: Number
    var ternary: Number
}

external interface RideStation {
    var start: CoordsXYZ
    var length: Number
    var entrance: CoordsXYZD
    var exit: CoordsXYZD
}

external interface Entity {
    var id: Number
    var type: String /* "balloon" | "car" | "crash_splash" | "crashed_vehicle_particle" | "duck" | "explosion_cloud" | "explosion_flare" | "jumping_fountain_snow" | "jumping_fountain_water" | "litter" | "money_effect" | "peep" | "steam_particle" */
    var x: Number
    var y: Number
    var z: Number
    fun remove()
}

external interface Car : Entity {
    var ride: Number
    var rideObject: Number
    var vehicleObject: Number
    var spriteType: Number
    var numSeats: Number
    var nextCarOnTrain: Number?
    var previousCarOnRide: Number
    var nextCarOnRide: Number
    var currentStation: Number
    var mass: Number
    var acceleration: Number
    var velocity: Number
    var bankRotation: Number
    var colours: VehicleColour
    var poweredAcceleration: Number
    var poweredMaxSpeed: Number
    var status: String /* "arriving" | "crashed" | "crashing" | "crooked_house_operating" | "departing" | "doing_circus_show" | "ferris_wheel_rotating" | "haunted_house_operating" | "moving_to_end_of_station" | "operating_1a" | "rotating" | "showing_film" | "simulator_operating" | "space_rings_operating" | "starting" | "stopped_by_block_brake" | "stopping_1b" | "stopping" | "swinging" | "top_spin_operating" | "travelling_boat" | "travelling_cable_lift" | "travelling_dodgems" | "travelling" | "unloading_passengers_1c" | "unloading_passengers" | "waiting_for_cable_lift" | "waiting_for_passengers_17" | "waiting_for_passengers" | "waiting_to_depart" | "waiting_to_start" */
    var trackLocation: CoordsXYZD
    var trackProgress: Number
    var remainingDistance: Number
    var peeps: Array<Number?>
    fun travelBy(distance: Number)
}

external interface Peep : Entity {
    var peepType: String /* "guest" | "staff" */
    var name: String
    var destination: CoordsXY
    var energy: Number
    var energyTarget: Number
    fun getFlag(key: String /* "leavingPark" | "slowWalk" | "tracking" | "waving" | "hasPaidForParkEntry" | "photo" | "painting" | "wow" | "litter" | "lost" | "hunger" | "toilet" | "crowded" | "happiness" | "nausea" | "purple" | "pizza" | "explode" | "rideShouldBeMarkedAsFavourite" | "parkEntranceChosen" | "contagious" | "joy" | "angry" | "iceCream" | "hereWeAre" */): Boolean
    fun setFlag(key: String /* "leavingPark" | "slowWalk" | "tracking" | "waving" | "hasPaidForParkEntry" | "photo" | "painting" | "wow" | "litter" | "lost" | "hunger" | "toilet" | "crowded" | "happiness" | "nausea" | "purple" | "pizza" | "explode" | "rideShouldBeMarkedAsFavourite" | "parkEntranceChosen" | "contagious" | "joy" | "angry" | "iceCream" | "hereWeAre" */, value: Boolean)
}

external interface Guest : Peep {
    var tshirtColour: Number
    var trousersColour: Number
    var balloonColour: Number
    var hatColour: Number
    var umbrellaColour: Number
    var happiness: Number
    var happinessTarget: Number
    var nausea: Number
    var nauseaTarget: Number
    var hunger: Number
    var thirst: Number
    var toilet: Number
    var mass: Number
    var minIntensity: Number
    var maxIntensity: Number
    var nauseaTolerance: Number
    var cash: Number
}

external interface Staff : Peep {
    var staffType: String /* "handyman" | "mechanic" | "security" | "entertainer" */
    var colour: Number
    var costume: Number
    var orders: Number
}

external interface Network {
    var mode: String /* "none" | "server" | "client" */
    var numGroups: Number
    var numPlayers: Number
    var groups: Array<PlayerGroup>
    var players: Array<Player>
    var currentPlayer: Player
    var defaultGroup: Number
    var stats: NetworkStats
    fun getServerInfo(): ServerInfo
    fun addGroup()
    fun getGroup(index: Number): PlayerGroup
    fun removeGroup(index: Number)
    fun getPlayer(index: Number): Player?
    fun kickPlayer(index: Number)
    fun sendMessage(message: String)
    fun sendMessage(message: String, players: Array<Number>)
    fun createListener(): Listener
    fun createSocket(): Socket
}

external interface Player {
    var id: Number
    var name: String
    var group: Number
    var ping: Number
    var commandsRan: Number
    var moneySpent: Number
    var ipAddress: String
    var publicKeyHash: String
}

external interface PlayerGroup {
    var id: Number
    var name: String
    var permissions: Array<String /* "chat" | "terraform" | "set_water_level" | "toggle_pause" | "create_ride" | "remove_ride" | "build_ride" | "ride_properties" | "scenery" | "path" | "clear_landscape" | "guest" | "staff" | "park_properties" | "park_funding" | "kick_player" | "modify_groups" | "set_player_group" | "cheat" | "toggle_scenery_cluster" | "passwordless_login" | "modify_tile" | "edit_scenario_options" */>
}

external interface ServerInfo {
    var name: String
    var description: String
    var greeting: String
    var providerName: String
    var providerEmail: String
    var providerWebsite: String
}

external interface NetworkStats {
    var bytesReceived: Array<Number>
    var bytesSent: Array<Number>
}

external interface ParkMessage {
    var isArchived: Boolean
    var month: Number
    var day: Number
    var tickCount: Number
    var type: String /* "attraction" | "peep_on_attraction" | "peep" | "money" | "blank" | "research" | "guests" | "award" | "chart" */
    var text: String
    var subject: Number?
        get() = definedExternally
        set(value) = definedExternally
    fun remove()
}

external interface ParkMessageDesc {
    var type: String /* "attraction" | "peep_on_attraction" | "peep" | "money" | "blank" | "research" | "guests" | "award" | "chart" */
    var text: String
    var subject: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Park {
    var cash: Number
    var rating: Number
    var bankLoan: Number
    var maxBankLoan: Number
    var entranceFee: Number
    var guests: Number
    var value: Number
    var companyValue: Number
    var totalAdmissions: Number
    var totalIncomeFromAdmissions: Number
    var landPrice: Number
    var constructionRightsPrice: Number
    var parkSize: Number
    var name: String
    var messages: Array<ParkMessage>
    fun getFlag(flag: String /* "difficultGuestGeneration" | "difficultParkRating" | "forbidHighConstruction" | "forbidLandscapeChanges" | "forbidMarketingCampaigns" | "forbidTreeRemoval" | "freeParkEntry" | "noMoney" | "open" | "preferLessIntenseRides" | "preferMoreIntenseRides" | "scenarioCompleteNameInput" | "unlockAllPrices" */): Boolean
    fun setFlag(flag: String /* "difficultGuestGeneration" | "difficultParkRating" | "forbidHighConstruction" | "forbidLandscapeChanges" | "forbidMarketingCampaigns" | "forbidTreeRemoval" | "freeParkEntry" | "noMoney" | "open" | "preferLessIntenseRides" | "preferMoreIntenseRides" | "scenarioCompleteNameInput" | "unlockAllPrices" */, value: Boolean)
    fun postMessage(message: String)
    fun postMessage(message: ParkMessageDesc)
}

external interface ScenarioObjective {
    var type: ScenarioObjective
    var guests: Number
    var year: Number
    var length: Number
    var excitement: Number
    var parkValue: Number
    var monthlyIncome: Number
}

external interface Scenario {
    var name: String
    var details: String
    var completedBy: String
    var filename: String
    var objective: ScenarioObjective
    var parkRatingWarningDays: Number
    var completedCompanyValue: Number?
        get() = definedExternally
        set(value) = definedExternally
    var status: String /* "inProgress" | "completed" | "failed" */
    var companyValueRecord: Number
}

external interface Cheats {
    var allowArbitraryRideTypeChanges: Boolean
    var allowTrackPlaceInvalidHeights: Boolean
    var buildInPauseMode: Boolean
    var disableAllBreakdowns: Boolean
    var disableBrakesFailure: Boolean
    var disableClearanceChecks: Boolean
    var disableLittering: Boolean
    var disablePlantAging: Boolean
    var disableRideValueAging: Boolean
    var disableSupportLimits: Boolean
    var disableTrainLengthLimit: Boolean
    var disableVandalism: Boolean
    var enableAllDrawableTrackPieces: Boolean
    var enableChainLiftOnAllTrack: Boolean
    var fastLiftHill: Boolean
    var freezeWeather: Boolean
    var ignoreResearchStatus: Boolean
    var ignoreRideIntensity: Boolean
    var neverendingMarketing: Boolean
    var sandboxMode: Boolean
    var showAllOperatingModes: Boolean
    var showVehiclesFromOtherTrackTypes: Boolean
}

external interface Ui {
    var width: Number
    var height: Number
    var windows: Number
    var mainViewport: Viewport
    var tileSelection: TileSelection
    var tool: Tool?
    fun getWindow(id: Number): Window
    fun getWindow(classification: String): Window
    fun openWindow(desc: WindowDesc): Window
    fun closeWindows(classification: String, id: Number = definedExternally)
    fun closeAllWindows()
    fun showError(title: String, message: String)
    fun showTextInput(desc: TextInputDesc)
    fun showFileBrowse(desc: FileBrowseDesc)
    fun showScenarioSelect(desc: ScenarioSelectDesc)
    fun activateTool(tool: ToolDesc)
    fun registerMenuItem(text: String, callback: () -> Unit)
    fun registerShortcut(desc: ShortcutDesc)
}

external interface FileBrowseDesc {
    var type: String /* "load" */
    var fileType: String /* "game" | "heightmap" */
    var defaultPath: String?
        get() = definedExternally
        set(value) = definedExternally
    var callback: (path: String) -> Unit
}

external interface ScenarioSelectDesc {
    var callback: (scenario: ScenarioFile) -> Unit
}

external interface `T$0` {
    var name: String
    var companyValue: Number
}

external interface ScenarioFile {
    var id: Number
    var category: String /* "beginner" | "challenging" | "expert" | "real" | "other" | "dlc" | "build_your_own" */
    var sourceGame: String /* "rct1" | "rct1_aa" | "rct1_ll" | "rct2" | "rct2_ww" | "rct2_tt" | "real" | "other" */
    var path: String
    var internalName: String
    var name: String
    var details: String
    var highscore: `T$0`
}

external interface TileSelection {
    var range: MapRange
    var tiles: Array<CoordsXY>
}

external interface Tool {
    var id: String
    var cursor: String /* "arrow" | "bench_down" | "bin_down" | "blank" | "cross_hair" | "diagonal_arrows" | "dig_down" | "entrance_down" | "fence_down" | "flower_down" | "fountain_down" | "hand_closed" | "hand_open" | "hand_point" | "house_down" | "lamppost_down" | "paint_down" | "path_down" | "picker" | "statue_down" | "tree_down" | "up_arrow" | "up_down_arrow" | "volcano_down" | "walk_down" | "water_down" | "zzz" */
    var cancel: () -> Unit
}

external interface ToolEventArgs {
    var isDown: Boolean
    var screenCoords: ScreenCoordsXY
    var mapCoords: CoordsXYZ?
        get() = definedExternally
        set(value) = definedExternally
    var tileElementIndex: Number?
        get() = definedExternally
        set(value) = definedExternally
    var entityId: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ToolDesc {
    var id: String
    var cursor: String? /* "arrow" | "bench_down" | "bin_down" | "blank" | "cross_hair" | "diagonal_arrows" | "dig_down" | "entrance_down" | "fence_down" | "flower_down" | "fountain_down" | "hand_closed" | "hand_open" | "hand_point" | "house_down" | "lamppost_down" | "paint_down" | "path_down" | "picker" | "statue_down" | "tree_down" | "up_arrow" | "up_down_arrow" | "volcano_down" | "walk_down" | "water_down" | "zzz" */
        get() = definedExternally
        set(value) = definedExternally
    var filter: Array<String? /* "terrain" | "entity" | "ride" | "water" | "scenery" | "footpath" | "footpath_item" | "park_entrance" | "wall" | "large_scenery" | "label" | "banner" */>?
        get() = definedExternally
        set(value) = definedExternally
    var onStart: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onDown: ((e: ToolEventArgs) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onMove: ((e: ToolEventArgs) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onUp: ((e: ToolEventArgs) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onFinish: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ShortcutDesc {
    var id: String
    var text: String
    var bindings: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var callback: () -> Unit
}

external interface WidgetBase {
    var window: Window?
        get() = definedExternally
        set(value) = definedExternally
    var x: Number
    var y: Number
    var width: Number
    var height: Number
    var name: String?
        get() = definedExternally
        set(value) = definedExternally
    var tooltip: String?
        get() = definedExternally
        set(value) = definedExternally
    var isDisabled: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var isVisible: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ButtonWidget : WidgetBase {
    var type: String /* "button" */
    var border: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var image: Number?
        get() = definedExternally
        set(value) = definedExternally
    var isPressed: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var onClick: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CheckboxWidget : WidgetBase {
    var type: String /* "checkbox" */
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var isChecked: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((isChecked: Boolean) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ColourPickerWidget : WidgetBase {
    var type: String /* "colourpicker" */
    var colour: Number?
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((colour: Number) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface CustomWidget : WidgetBase {
    var type: String /* "custom" */
    var onDraw: ((self: CustomWidget, g: GraphicsContext) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface DropdownWidget : WidgetBase {
    var type: String /* "dropdown" */
    var items: Array<String>?
        get() = definedExternally
        set(value) = definedExternally
    var selectedIndex: Number?
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((index: Number) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface GroupBoxWidget : WidgetBase {
    var type: String /* "groupbox" */
}

external interface LabelWidget : WidgetBase {
    var type: String /* "label" */
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var textAlign: String? /* "left" | "centred" */
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((index: Number) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ListViewColumn {
    var canSort: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var sortOrder: String? /* "none" | "ascending" | "descending" */
        get() = definedExternally
        set(value) = definedExternally
    var header: String?
        get() = definedExternally
        set(value) = definedExternally
    var headerTooltip: String?
        get() = definedExternally
        set(value) = definedExternally
    var width: Number?
        get() = definedExternally
        set(value) = definedExternally
    var ratioWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ListViewItemSeperator {
    var type: String /* "seperator" */
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RowColumn {
    var row: Number
    var column: Number
}

external interface ListView : WidgetBase {
    var type: String /* "listview" */
    var scrollbars: String? /* "none" | "horizontal" | "vertical" | "both" */
        get() = definedExternally
        set(value) = definedExternally
    var isStriped: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var showColumnHeaders: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var columns: Array<ListViewColumn>?
        get() = definedExternally
        set(value) = definedExternally
    var items: dynamic /* Array<String>? | Array<dynamic /* ListViewItemSeperator | Array<String> */>? */
        get() = definedExternally
        set(value) = definedExternally
    var selectedCell: RowColumn?
        get() = definedExternally
        set(value) = definedExternally
    var highlightedCell: RowColumn?
        get() = definedExternally
        set(value) = definedExternally
    var canSelect: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var onHighlight: ((item: Number, column: Number) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onClick: ((item: Number, column: Number) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface SpinnerWidget : WidgetBase {
    var type: String /* "spinner" */
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var onDecrement: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onIncrement: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onClick: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface TextBoxWidget : WidgetBase {
    var type: String /* "textbox" */
    var text: String?
        get() = definedExternally
        set(value) = definedExternally
    var maxLength: Number?
        get() = definedExternally
        set(value) = definedExternally
    var onChange: ((text: String) -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ViewportWidget : WidgetBase {
    var type: String /* "viewport" */
    var viewport: Viewport?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WindowDesc {
    var classification: String
    var x: Number?
        get() = definedExternally
        set(value) = definedExternally
    var y: Number?
        get() = definedExternally
        set(value) = definedExternally
    var width: Number
    var height: Number
    var title: String
    var id: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var minHeight: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxWidth: Number?
        get() = definedExternally
        set(value) = definedExternally
    var maxHeight: Number?
        get() = definedExternally
        set(value) = definedExternally
    var widgets: Array<dynamic /* ButtonWidget | CheckboxWidget | ColourPickerWidget | CustomWidget | DropdownWidget | GroupBoxWidget | LabelWidget | ListView | SpinnerWidget | TextBoxWidget | ViewportWidget */>?
        get() = definedExternally
        set(value) = definedExternally
    var colours: Array<Number>?
        get() = definedExternally
        set(value) = definedExternally
    var tabs: Array<WindowTabDesc>?
        get() = definedExternally
        set(value) = definedExternally
    var tabIndex: Number?
        get() = definedExternally
        set(value) = definedExternally
    var onClose: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onUpdate: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
    var onTabChange: (() -> Unit)?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ImageAnimation {
    var frameBase: Number
    var frameCount: Number?
        get() = definedExternally
        set(value) = definedExternally
    var frameDuration: Number?
        get() = definedExternally
        set(value) = definedExternally
    var offset: ScreenCoordsXY?
        get() = definedExternally
        set(value) = definedExternally
}

external interface WindowTabDesc {
    var image: dynamic /* Number | ImageAnimation */
        get() = definedExternally
        set(value) = definedExternally
    var widgets: Array<dynamic /* ButtonWidget | CheckboxWidget | ColourPickerWidget | CustomWidget | DropdownWidget | GroupBoxWidget | LabelWidget | ListView | SpinnerWidget | TextBoxWidget | ViewportWidget */>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Viewport {
    var left: Number
    var top: Number
    var right: Number
    var bottom: Number
    var rotation: Number
    var zoom: Number
    var visibilityFlags: Number
    fun getCentrePosition(): CoordsXY
    fun moveTo(position: CoordsXY)
    fun moveTo(position: CoordsXYZ)
    fun scrollTo(position: CoordsXY)
    fun scrollTo(position: CoordsXYZ)
}

external interface GraphicsContext {
    var colour: Number?
    var secondaryColour: Number?
    var ternaryColour: Number?
    var stroke: Number
    var fill: Number
    var paletteId: Number?
    var width: Number
    var height: Number
    fun getImage(id: Number): ImageInfo?
    fun measureText(text: String): ScreenSize
    fun clear()
    fun clip(x: Number, y: Number, width: Number, height: Number)
    fun box(x: Number, y: Number, width: Number, height: Number)
    fun image(id: Number, x: Number, y: Number)
    fun line(x1: Number, y1: Number, x2: Number, y2: Number)
    fun rect(x: Number, y: Number, width: Number, height: Number)
    fun text(text: String, x: Number, y: Number)
    fun well(x: Number, y: Number, width: Number, height: Number)
}

external interface ImageInfo {
    var id: Number
    var offset: ScreenCoordsXY
    var width: Number
    var height: Number
    var isBMP: Boolean
    var isRLE: Boolean
    var isPalette: Boolean
    var noZoom: Boolean
    var nextZoomId: Number?
}

external interface Listener {
    var listening: Boolean
    fun listen(port: Number, host: String = definedExternally): Listener
    fun close(): Listener
    fun on(event: String /* "connection" */, callback: (socket: Socket) -> Unit): Listener
    fun off(event: String /* "connection" */, callback: (socket: Socket) -> Unit): Listener
}

external interface Socket {
    fun connect(port: Number, host: String, callback: Function<*>): Socket
    fun destroy(error: Any?): Socket
    fun setNoDelay(noDelay: Boolean): Socket
    fun end(data: String = definedExternally): Socket
    fun write(data: String): Boolean
    fun on(event: String /* "close" | "error" */, callback: (hadError: Boolean) -> Unit): Socket
    fun on(event: String /* "data" */, callback: (data: String) -> Unit): Socket
    fun off(event: String /* "close" | "error" */, callback: (hadError: Boolean) -> Unit): Socket
    fun off(event: String /* "data" */, callback: (data: String) -> Unit): Socket
}

external interface TitleSequence {
    var name: String
    var path: String
    var isDirectory: Boolean
    var isReadOnly: Boolean
    var parks: Array<TitleSequencePark>
    var commands: Array<dynamic /* LoadTitleSequenceCommand | LocationTitleSequenceCommand | RotateTitleSequenceCommand | ZoomTitleSequenceCommand | FollowTitleSequenceCommand | SpeedTitleSequenceCommand | WaitTitleSequenceCommand | LoadScenarioTitleSequenceCommand | RestartTitleSequenceCommand | EndTitleSequenceCommand */>
    var isPlaying: Boolean
    var position: Number?
    fun addPark(path: String, fileName: String)
    fun clone(name: String): TitleSequence
    fun delete()
    fun play()
    fun seek(position: Number)
    fun stop()
}

external interface TitleSequencePark {
    var fileName: String
    fun delete()
    fun load()
}

external interface LoadTitleSequenceCommand {
    var type: String /* "load" */
    var index: Number
}

external interface LocationTitleSequenceCommand {
    var type: String /* "location" */
    var x: Number
    var y: Number
}

external interface RotateTitleSequenceCommand {
    var type: String /* "rotate" */
    var rotations: Number
}

external interface ZoomTitleSequenceCommand {
    var type: String /* "zoom" */
    var zoom: Number
}

external interface FollowTitleSequenceCommand {
    var type: String /* "follow" */
    var id: Number?
}

external interface SpeedTitleSequenceCommand {
    var type: String /* "speed" */
    var speed: Number
}

external interface WaitTitleSequenceCommand {
    var type: String /* "wait" */
    var duration: Number
}

external interface LoadScenarioTitleSequenceCommand {
    var type: String /* "loadsc" */
    var scenario: String
}

external interface RestartTitleSequenceCommand {
    var type: String /* "restart" */
}

external interface EndTitleSequenceCommand {
    var type: String /* "end" */
}

external interface TitleSequenceManager {
    var titleSequences: Array<TitleSequence>
    fun create(name: String): TitleSequence
}