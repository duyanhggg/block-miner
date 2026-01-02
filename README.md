# Block Miner

A Fabric mod for Minecraft 1.21.x+ that adds a powerful multi-purpose mining tool to enhance your mining experience!

## Features

- **Custom Mining Tool**: The Block Miner is a versatile tool that combines the functionality of a pickaxe, shovel, and axe
- **Enhanced Mining Speed**: Get an 800% mining speed bonus when using the Block Miner
- **Durability**: 500 uses before breaking
- **Multi-Block Support**: Effectively mines stone, dirt, wood, and other common blocks
- **Easy Crafting**: Craftable with diamonds, iron, and sticks
- **Server Compatible**: Works on both single-player and multiplayer servers

## Installation

### For Players

1. **Download and Install Prerequisites**:
   - Install [Minecraft Java Edition](https://www.minecraft.net/) version 1.21.1 or higher
   - Install [Fabric Loader](https://fabricmc.net/use/installer/) for your Minecraft version
   - Download [Fabric API](https://modrinth.com/mod/fabric-api) and place it in your `mods` folder

2. **Install Block Miner Mod**:
   - Download the latest `.jar` file from the [releases page](https://github.com/duyanhggg/block-miner/releases)
   - Place the `.jar` file in your `.minecraft/mods` folder
   - Launch Minecraft with the Fabric profile

3. **For Servers**:
   - Install Fabric Loader on your server
   - Place both Fabric API and Block Miner `.jar` files in the server's `mods` folder
   - Restart the server

## How to Use

### Crafting the Block Miner

The Block Miner can be crafted using the following recipe:

```
D I D
  S
  S
```

Where:
- `D` = Diamond
- `I` = Iron Ingot
- `S` = Stick

### Using the Block Miner

1. Craft or obtain the Block Miner tool
2. Hold it in your main hand
3. Mine blocks as you would with any other tool
4. Enjoy the enhanced mining speed!

The tool is effective on:
- Stone and ores (like a pickaxe)
- Dirt, sand, and gravel (like a shovel)
- Wood and logs (like an axe)

## Building from Source

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Git
- **Internet connection** (required to download Minecraft, Fabric, and dependencies)

### Build Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/duyanhggg/block-miner.git
   cd block-miner
   ```

2. **Build the Mod**:
   ```bash
   ./gradlew build
   ```
   
   On Windows:
   ```cmd
   gradlew.bat build
   ```
   
   **Note**: The first build will take several minutes as Gradle downloads Minecraft, Fabric API, and other dependencies.

3. **Locate the Built Mod**:
   The compiled `.jar` file will be in `build/libs/blockminer-1.0.0.jar`

### Development Setup

1. **Import into IDE**:
   - **IntelliJ IDEA**: Open the project folder, IDEA will automatically detect the Gradle project
   - **Eclipse**: Run `./gradlew eclipse` then import as an existing project
   - **VS Code**: Open the folder and install the Java extension pack

2. **Generate Minecraft Sources** (optional, for code navigation):
   ```bash
   ./gradlew genSources
   ```

3. **Run the Mod in Development**:
   ```bash
   ./gradlew runClient
   ```
   
   For server testing:
   ```bash
   ./gradlew runServer
   ```

## Project Structure

```
block-miner/
├── src/main/
│   ├── java/com/duyanhggg/blockminer/
│   │   ├── BlockMinerMod.java         # Main mod class
│   │   └── BlockMinerItem.java        # Custom tool item
│   └── resources/
│       ├── fabric.mod.json             # Mod metadata
│       ├── assets/blockminer/
│       │   ├── icon.png                # Mod icon
│       │   ├── lang/
│       │   │   └── en_us.json         # English translations
│       │   ├── models/item/
│       │   │   └── block_miner.json   # Item model
│       │   └── textures/item/
│       │       └── block_miner.png    # Item texture
│       └── data/blockminer/
│           └── recipes/
│               └── block_miner.json   # Crafting recipe
├── build.gradle                        # Gradle build configuration
├── gradle.properties                   # Project properties
├── settings.gradle                     # Gradle settings
└── LICENSE                             # MIT License

```

## Configuration

The mod currently includes hardcoded configurations:

- **Mining Speed Multiplier**: 8.0x (800% increase)
- **Durability**: 500 uses
- **Mining Level**: Diamond-tier (level 3)

To modify these values, edit `src/main/java/com/duyanhggg/blockminer/BlockMinerItem.java` and rebuild the mod.

## Contributing

Contributions are welcome! Here's how you can help:

1. **Fork the Repository**
2. **Create a Feature Branch**: `git checkout -b feature/amazing-feature`
3. **Make Your Changes**: Ensure your code follows the existing style
4. **Test Your Changes**: Build and test the mod in-game
5. **Commit Your Changes**: `git commit -m 'Add amazing feature'`
6. **Push to the Branch**: `git push origin feature/amazing-feature`
7. **Open a Pull Request**

### Development Guidelines

- Follow Java naming conventions
- Add comments to complex code sections
- Test in both single-player and multiplayer
- Ensure compatibility with Fabric API
- Update documentation for new features

## Troubleshooting

### Common Issues

**Mod doesn't load:**
- Verify you have Fabric Loader installed
- Check that Fabric API is in your mods folder
- Ensure you're using Minecraft 1.21.1 or compatible version

**Tool doesn't work:**
- Make sure you're holding it in your main hand
- Check that the mod is enabled in the mods menu
- Verify the mod loaded successfully in the logs

**Build fails:**
- Ensure you have JDK 17 or higher
- Try running `./gradlew clean build`
- Check your internet connection (Gradle needs to download dependencies)

### Getting Help

- Open an [issue](https://github.com/duyanhggg/block-miner/issues) on GitHub
- Check existing issues for solutions
- Provide your Minecraft version, Fabric version, and logs when reporting bugs

## Version Compatibility

- **Minecraft**: 1.21.1+ (tested on 1.21.1)
- **Fabric Loader**: 0.16.0+
- **Fabric API**: 0.107.0+ for 1.21.1
- **Java**: 17+

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Credits

- **Author**: duyanhggg
- **Framework**: [Fabric](https://fabricmc.net/)
- **Tools**: [Fabric API](https://github.com/FabricMC/fabric)

## Changelog

### Version 1.0.0
- Initial release
- Added Block Miner tool with 8x mining speed
- Crafting recipe using diamonds, iron, and sticks
- Support for pickaxe, shovel, and axe functionality
- Compatible with Minecraft 1.21.x

---

**Enjoy mining with the Block Miner! ⛏️**