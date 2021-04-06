<h1 align="center">🎢 OpenRCT2KotlinAPI 🎢</h1>
<img height="250" src="https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/320/twitter/281/roller-coaster_1f3a2.png" align="right">

**🚧 Experiemental Project 🚧**

[OpenRCT2](https://openrct2.org/) is an open-source re-implementation of RollerCoaster Tycoon 2, to allow expanding the original game with new features, OpenRCT2 has a [JavaScript scripting API](https://github.com/OpenRCT2/OpenRCT2/blob/develop/distribution/scripting.md).

And yes, JavaScript is cool and all... *but what about Kotlin?* After all, Kotlin also compiles and has interoperability with JavaScript!

And that's why OpenRCT2KotlinAPI exists! OpenRCT2KotlinAPI provides a wrapper to OpenRCT2's API to make it more "Kotlin-fied" and easier to use! The API is based on top of OpenRCT2's TypeScript bindings converted with [dukat](https://github.com/Kotlin/dukat), which you can also use if you are familiar with OpenRCT2's API.

## 🚧 Status of OpenRCT2KotlinAPI

Very experimental and lacks a bunch of features. If you prefer, you can use `openrct2-dukat` directly and avoid the nice "Kotlin-fied" API.

## How to Use


### Installation

First, add the PerfectDreams repository to your project

```kotlin
repositories {
    maven("https://repo.perfectdreams.net/")
}
```

Then add the OpenRCTKotlinAPI dependency!

```kotlin
dependencies {
    ...
    implementation("com.mrpowergamerbr.openrct2kotlinapi:core:0.0.1-SNAPSHOT")
    ...
}
```

### Creating your First Plugin

Here's a example of a simple plugin that prints stuff to OpenRCT2's console

```kotlin
fun main() {
	// Initializes your plugin
	MyFirstPlugin().init()
}

class MyFirstPlugin : OpenRCT2Plugin(
	"MyFirstPlugin", // Your Plugin Name Here
	"0.0.1", // Version
	"MrPowerGamerBR", // Author
	PluginType.REMOTE, // Remote or Local, check OpenRCT2's API reference to understand the difference!
	"MIT", // Licence
	null // Minimum API required version, you can keep this as null
) {
	override fun onEnable() {
		// This will be ran after enabling our plugin!
		//
		// This will be printed in the OpenRCT2's console, you can see the console by running "openrct2.com" with Command Prompt or PowerShell
		// (Yes, "openrct2.com", running "openrct2.exe" won't show to you the console!)
		println("Hello OpenRCT2! How are you?")
	}
}
```

(Yes, you can keep the `main` function in a different file!)

Here's a example of a simple plugin that every new day in game, the guest's names are changed to "Loritta Morenitta", "Pantufa" or "Gabriela".

```kotlin
fun main() {
	// Initializes your plugin
	MyFirstPlugin().init()
}

class MyFirstPlugin : OpenRCT2Plugin(
	"MyFirstPlugin", // Your Plugin Name Here
	"0.0.1", // Version
	"MrPowerGamerBR", // Author
	PluginType.REMOTE, // Remote or Local, check OpenRCT2's API reference to understand the difference!
	"MIT", // Licence
	null // Minimum API required version, you can keep this as null
) {
	override fun onEnable() {
		// This will be ran after enabling our plugin!
		//
		// This will be printed in the OpenRCT2's console, you can see the console by running "openrct2.com" with Command Prompt or PowerShell
		// (Yes, "openrct2.com", running "openrct2.exe" won't show to you the console!)
		println("Hello OpenRCT2! How are you?")

		context.onEachDay {
			// This will be ran every time a single day passes in game...
			// And we are going to change our guest names to a random name from the "RANDOM_NAMES" list
			map.entities.filterIsInstance<Guest>().forEach { it.name = RANDOM_NAMES.random()  }
		}
	}

	companion object {
		private val RANDOM_NAMES = listOf(
			"Loritta Morenitta",
			"Pantufa",
			"Gabriela"
		)
	}
}
```

You can check other samples in the `samples` folder!

### Running the Plugin in OpenRCT2
Running the plugin after compiling with Gradle is easy, just copy the JavaScript files from the `distributions` folder to OpenRCT2's plugins folder.

For some reason OpenRCT2 really doesn't like that there is a comment at the end of the compiled JavaScript file (OpenRCT2 always complains about "End of input"), to workaround this, open the JS file in a text editor and remove the last line of the file. This fixes the issue.


