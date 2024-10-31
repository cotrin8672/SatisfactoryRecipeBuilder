package io.github.cotrin8672.registry

import io.github.cotrin8672.domain.*

object Recipes {
    private val basicRecipe = mutableMapOf<Item, BasicRecipe>()

    fun getBasic(item: Item): BasicRecipe? = if (item.isNaturalResource) null else basicRecipe[item]

    private fun basic(
        name: String,
        input: List<ItemStack>,
        output: ItemStack,
        byProduct: ItemStack = ItemStack.EMPTY,
        machine: Machine,
    ) = BasicRecipe(name, input, output, byProduct, machine)

    private fun alt(
        name: String,
        input: List<ItemStack>,
        output: ItemStack,
        byProduct: ItemStack = ItemStack.EMPTY,
        machine: Machine,
    ) = AlternativeRecipe(name, input, output, byProduct, machine)

    // 基本レシピ
    val ironIngot = basic(
        name = "鉄インゴット",
        input = listOf(
            ItemStack(Items.ironOre, 30)
        ),
        output = ItemStack(Items.ironIngot, 30),
        machine = Machine.Smelter,
    )

    val ironPlate = basic(
        name = "", // 日本語名は空文字列に設定
        input = listOf(
            ItemStack(Items.ironIngot, 30)
        ),
        output = ItemStack(Items.ironPlate, 20),
        machine = Machine.Constructor,
    )


    val ironRod = basic(
        name = "", // 日本語名は空文字列に設定
        input = listOf(
            ItemStack(Items.ironIngot, 15)
        ),
        output = ItemStack(Items.ironRod, 15),
        machine = Machine.Constructor,
    )

    val reinforcedIronPlate = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironPlate, 30),
            ItemStack(Items.screw, 60)
        ),
        output = ItemStack(Items.reinforcedIronPlate, 5),
        machine = Machine.Assembler,
    )

    val cable = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.wire, 60)
        ),
        output = ItemStack(Items.cable, 30),
        machine = Machine.Constructor,
    )

    val wire = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.copperIngot, 15)
        ),
        output = ItemStack(Items.wire, 30),
        machine = Machine.Constructor,
    )

    val copperIngot = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.copperOre, 30)
        ),
        output = ItemStack(Items.copperIngot, 30),
        machine = Machine.Smelter,
    )

    val concrete = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.limestone, 45)
        ),
        output = ItemStack(Items.concrete, 15),
        machine = Machine.Constructor,
    )

    val screw = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironRod, 10)
        ),
        output = ItemStack(Items.screw, 40),
        machine = Machine.Constructor,
    )

    val biomassWood = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.wood, 60)
        ),
        output = ItemStack(Items.biomass, 300),
        machine = Machine.Constructor,
    )

    val solidBiofuel = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.biomass, 120)
        ),
        output = ItemStack(Items.solidBiofuel, 60),
        machine = Machine.Constructor,
    )

    val hatcherProtein = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.hatcherRemains, 20)
        ),
        output = ItemStack(Items.alienProtein, 20),
        machine = Machine.Constructor,
    )

    val stingerProtein = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.stingerRemains, 20)
        ),
        output = ItemStack(Items.alienProtein, 20),
        machine = Machine.Constructor,
    )

    val hogProtein = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.hogRemains, 20)
        ),
        output = ItemStack(Items.alienProtein, 20),
        machine = Machine.Constructor,
    )

    val spitterProtein = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.spitterRemains, 20)
        ),
        output = ItemStack(Items.alienProtein, 20),
        machine = Machine.Constructor,
    )

    val silica = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.rawQuartz, 22.5)
        ),
        output = ItemStack(Items.silica, 37.5),
        machine = Machine.Constructor,
    )

    val rotor = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironRod, 20),
            ItemStack(Items.screw, 100)
        ),
        output = ItemStack(Items.rotor, 4),
        machine = Machine.Assembler,
    )

    val copperSheet = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.copperIngot, 20)
        ),
        output = ItemStack(Items.copperSheet, 10),
        machine = Machine.Constructor,
    )

    val modularFrame = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.reinforcedIronPlate, 3),
            ItemStack(Items.ironRod, 12)
        ),
        output = ItemStack(Items.modularFrame, 2),
        machine = Machine.Assembler,
    )

    val smartPlating = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.reinforcedIronPlate, 2),
            ItemStack(Items.rotor, 2)
        ),
        output = ItemStack(Items.smartPlating, 2),
        machine = Machine.Assembler,
    )

    val cateriumIngot = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.cateriumOre, 45)
        ),
        output = ItemStack(Items.cateriumIngot, 15),
        machine = Machine.Smelter,
    )

    val syntheticPowerShard = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.timeCrystal, 10),
            ItemStack(Items.darkMatterCrystal, 10),
            ItemStack(Items.quartzCrystal, 60),
            ItemStack(Items.excitedPhotonicMatter, 60)
        ),
        output = ItemStack(Items.powerShard, 5),
        byProduct = ItemStack(Items.darkMatterResidue, 60), // 副産物を設定
        machine = Machine.QuantumEncoder,
    )

    val steelIngot = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironOre, 45),
            ItemStack(Items.coal, 45)
        ),
        output = ItemStack(Items.steelIngot, 45),
        machine = Machine.Foundry,
    )

    val steelBeam = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.steelIngot, 60)
        ),
        output = ItemStack(Items.steelBeam, 15),
        machine = Machine.Constructor,
    )

    val steelPipe = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.steelIngot, 30)
        ),
        output = ItemStack(Items.steelPipe, 20),
        machine = Machine.Constructor,
    )

    val versatileFramework = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.modularFrame, 2.5),
            ItemStack(Items.steelBeam, 30)
        ),
        output = ItemStack(Items.versatileFramework, 5),
        machine = Machine.Assembler,
    )

    val encasedIndustrialBeam = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.steelBeam, 18),
            ItemStack(Items.concrete, 36)
        ),
        output = ItemStack(Items.encasedIndustrialBeam, 6),
        machine = Machine.Assembler,
    )

    val stator = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.steelPipe, 15),
            ItemStack(Items.wire, 40)
        ),
        output = ItemStack(Items.stator, 5),
        machine = Machine.Assembler,
    )

    val motor = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.rotor, 10),
            ItemStack(Items.stator, 10)
        ),
        output = ItemStack(Items.motor, 5),
        machine = Machine.Assembler,
    )

    val automatedWiring = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.stator, 2.5),
            ItemStack(Items.cable, 50)
        ),
        output = ItemStack(Items.automatedWiring, 2.5),
        machine = Machine.Assembler,
    )

    val reanimatedSAM = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.SAM, 120)
        ),
        output = ItemStack(Items.reanimatedSAM, 30),
        machine = Machine.Constructor,
    )

    val samFluctuator = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.reanimatedSAM, 60),
            ItemStack(Items.wire, 50),
            ItemStack(Items.steelPipe, 30)
        ),
        output = ItemStack(Items.SAMFluctuator, 10),
        machine = Machine.Manufacturer,
    )

    val quickwire = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.cateriumIngot, 12)
        ),
        output = ItemStack(Items.quickwire, 60),
        machine = Machine.Constructor,
    )

    val aiLimiter = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.copperSheet, 25),
            ItemStack(Items.quickwire, 100)
        ),
        output = ItemStack(Items.AILimiter, 5),
        machine = Machine.Assembler,
    )

    val petroleumCoke = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.heavyOilResidue, 40)
        ),
        output = ItemStack(Items.petroleumCoke, 120),
        machine = Machine.Refinery,
    )

    val circuitBoard = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.copperSheet, 15),
            ItemStack(Items.plastic, 30)
        ),
        output = ItemStack(Items.circuitBoard, 7.5),
        machine = Machine.Assembler,
    )

    val residualPlastic = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.polymerResin, 60),
            ItemStack(Items.water, 20)
        ),
        output = ItemStack(Items.plastic, 20),
        machine = Machine.Refinery,
    )

    val fuel = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.crudeOil, 60)
        ),
        output = ItemStack(Items.fuel, 40),
        byProduct = ItemStack(Items.polymerResin, 30),
        machine = Machine.Refinery,
    )

    val residualRubber = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.polymerResin, 40),
            ItemStack(Items.water, 40)
        ),
        output = ItemStack(Items.rubber, 20),
        machine = Machine.Refinery,
    )

    val residualFuel = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.heavyOilResidue, 60)
        ),
        output = ItemStack(Items.fuel, 40),
        machine = Machine.Refinery,
    )

    val emptyCanister = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.plastic, 30)
        ),
        output = ItemStack(Items.emptyCanister, 60),
        machine = Machine.Constructor,
    )

    val packagedWater = basic(
        name = "Packaged Water",
        input = listOf(
            ItemStack(Items.water, 60),
            ItemStack(Items.emptyCanister, 60)
        ),
        output = ItemStack(Items.packagedWater, 60),
        machine = Machine.Packager,
    )

    val packagedOil = basic(
        name = "Packaged Oil",
        input = listOf(
            ItemStack(Items.crudeOil, 30),
            ItemStack(Items.emptyCanister, 30)
        ),
        output = ItemStack(Items.packagedOil, 30),
        machine = Machine.Packager,
    )

    val packagedFuel = basic(
        name = "Packaged Fuel",
        input = listOf(
            ItemStack(Items.fuel, 40),
            ItemStack(Items.emptyCanister, 40)
        ),
        output = ItemStack(Items.packagedFuel, 40),
        machine = Machine.Packager,
    )

    val packagedHeavyOilResidue = basic(
        name = "Packaged Heavy Oil Residue",
        input = listOf(
            ItemStack(Items.heavyOilResidue, 30),
            ItemStack(Items.emptyCanister, 30)
        ),
        output = ItemStack(Items.packagedHeavyOilResidue, 30),
        machine = Machine.Packager,
    )

    val packagedLiquidBiofuel = basic(
        name = "Packaged Liquid Biofuel",
        input = listOf(
            ItemStack(Items.liquidBiofuel, 40),
            ItemStack(Items.emptyCanister, 40)
        ),
        output = ItemStack(Items.packagedLiquidBiofuel, 40),
        machine = Machine.Packager,
    )

    val liquidBiofuel = basic(
        name = "Liquid Biofuel",
        input = listOf(
            ItemStack(Items.solidBiofuel, 90),
            ItemStack(Items.water, 45)
        ),
        output = ItemStack(Items.liquidBiofuel, 60),
        machine = Machine.Refinery,
    )

    val quartzCrystal = basic(
        name = "Quartz Crystal",
        input = listOf(
            ItemStack(Items.rawQuartz, 37.5)
        ),
        output = ItemStack(Items.quartzCrystal, 22.5),
        machine = Machine.Constructor,
    )

    val computer = basic(
        name = "Computer",
        input = listOf(
            ItemStack(Items.circuitBoard, 10),
            ItemStack(Items.cable, 20),
            ItemStack(Items.plastic, 40)
        ),
        output = ItemStack(Items.computer, 2.5),
        machine = Machine.Manufacturer,
    )

    // Heavy Modular Frame
    val heavyModularFrame = basic(
        name = "Heavy Modular Frame",
        input = listOf(
            ItemStack(Items.modularFrame, 10),
            ItemStack(Items.steelPipe, 40),
            ItemStack(Items.encasedIndustrialBeam, 10),
            ItemStack(Items.screw, 240)
        ),
        output = ItemStack(Items.heavyModularFrame, 2),
        machine = Machine.Manufacturer,
    )

    val modularEngine = basic(
        name = "Modular Engine",
        input = listOf(
            ItemStack(Items.motor, 2),
            ItemStack(Items.rubber, 15),
            ItemStack(Items.smartPlating, 2)
        ),
        output = ItemStack(Items.modularEngine, 1),
        machine = Machine.Manufacturer,
    )

    val adaptiveControlUnit = basic(
        name = "Adaptive Control Unit",
        input = listOf(
            ItemStack(Items.automatedWiring, 5),
            ItemStack(Items.circuitBoard, 5),
            ItemStack(Items.heavyModularFrame, 1),
            ItemStack(Items.computer, 2)
        ),
        output = ItemStack(Items.adaptiveControlUnit, 1),
        machine = Machine.Manufacturer,
    )

    val blackPowder = basic(
        name = "Black Powder",
        input = listOf(
            ItemStack(Items.coal, 15),
            ItemStack(Items.sulfur, 15)
        ),
        output = ItemStack(Items.blackPowder, 30),
        machine = Machine.Assembler,
    )

    val nobelisk = basic(
        name = "Nobelisk",
        input = listOf(
            ItemStack(Items.blackPowder, 20),
            ItemStack(Items.steelPipe, 20)
        ),
        output = ItemStack(Items.nobelisk, 10),
        machine = Machine.Assembler,
    )

    val crystalOscillator = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.quartzCrystal, 18),
            ItemStack(Items.cable, 14),
            ItemStack(Items.reinforcedIronPlate, 2.5)
        ),
        output = ItemStack(Items.crystalOscillator, 1),
        machine = Machine.Manufacturer,
    )

    val ironRebar = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironRod, 15)
        ),
        output = ItemStack(Items.ironRebar, 15),
        machine = Machine.Constructor,
    )

    val smokelessPowder = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.blackPowder, 20),
            ItemStack(Items.heavyOilResidue, 10)
        ),
        output = ItemStack(Items.smokelessPowder, 20),
        machine = Machine.Refinery,
    )

    val stunRebar = basic(
        name = "", // TODO: 日本語名を設定
        input = listOf(
            ItemStack(Items.ironRebar, 10),
            ItemStack(Items.quickwire, 50)
        ),
        output = ItemStack(Items.stunRebar, 10),
        machine = Machine.Assembler,
    )

    val fabric = basic(
        name = "",
        input = listOf(
            ItemStack(Items.mycelia, 15),
            ItemStack(Items.biomass, 75)
        ),
        output = ItemStack(Items.fabric, 15),
        machine = Machine.Assembler,
    )

    val aluminaSolution = basic(
        name = "",
        input = listOf(
            ItemStack(Items.bauxite, 120),
            ItemStack(Items.water, 180)
        ),
        output = ItemStack(Items.aluminaSolution, 120),
        byProduct = ItemStack(Items.silica, 50),
        machine = Machine.Refinery,
    )

    val packagedAluminaSolution = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminaSolution, 120),
            ItemStack(Items.emptyCanister, 120)
        ),
        output = ItemStack(Items.packagedAluminaSolution, 120),
        machine = Machine.Packager,
    )

    val aluminumScrap = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminaSolution, 240),
            ItemStack(Items.coal, 120)
        ),
        output = ItemStack(Items.aluminumScrap, 360),
        byProduct = ItemStack(Items.water, 120),
        machine = Machine.Refinery,
    )

    val aluminumIngot = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminumScrap, 90),
            ItemStack(Items.silica, 75)
        ),
        output = ItemStack(Items.aluminumIngot, 60),
        machine = Machine.Foundry,
    )

    val alcladAluminumSheet = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminumIngot, 30),
            ItemStack(Items.copperIngot, 10)
        ),
        output = ItemStack(Items.alcladAluminumSheet, 30),
        machine = Machine.Assembler,
    )

    val aluminumCasing = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminumIngot, 90)
        ),
        output = ItemStack(Items.aluminumCasing, 60),
        machine = Machine.Constructor,
    )

    val sulfuricAcid = basic(
        name = "",
        input = listOf(
            ItemStack(Items.sulfur, 50),
            ItemStack(Items.water, 50)
        ),
        output = ItemStack(Items.sulfuricAcid, 50),
        machine = Machine.Refinery,
    )

    val packagedSulfuricAcid = basic(
        name = "",
        input = listOf(
            ItemStack(Items.sulfuricAcid, 40),
            ItemStack(Items.emptyCanister, 40)
        ),
        output = ItemStack(Items.packagedSulfuricAcid, 40),
        machine = Machine.Packager,
    )

    val battery = basic(
        name = "",
        input = listOf(
            ItemStack(Items.sulfuricAcid, 50),
            ItemStack(Items.aluminaSolution, 40),
            ItemStack(Items.aluminumCasing, 20),
        ),
        output = ItemStack(Items.battery, 20),
        byProduct = ItemStack(Items.water, 30),
        machine = Machine.Blender,
    )

    val radioControlUnit = basic(
        name = "",
        input = listOf(
            ItemStack(Items.aluminumCasing, 40),
            ItemStack(Items.crystalOscillator, 1.25),
            ItemStack(Items.computer, 2.5),
        ),
        output = ItemStack(Items.radioControlUnit, 2.5),
        machine = Machine.Manufacturer,
    )

    val supercomputer = basic(
        name = "",
        input = listOf(
            ItemStack(Items.computer, 7.5),
            ItemStack(Items.AILimiter, 3.75),
            ItemStack(Items.highSpeedConnector, 5.625),
            ItemStack(Items.plastic, 52.5),
        ),
        output = ItemStack(Items.supercomputer, 1.875),
        machine = Machine.Manufacturer,
    )

    val highSpeedConnector = basic(
        name = "",
        input = listOf(
            ItemStack(Items.quickwire, 210),
            ItemStack(Items.cable, 37.5),
            ItemStack(Items.circuitBoard, 3.75),
        ),
        output = ItemStack(Items.highSpeedConnector, 3.75),
        machine = Machine.Manufacturer,
    )

    val assemblyDirectorSystem = basic(
        name = "",
        input = listOf(
            ItemStack(Items.adaptiveControlUnit, 1.5),
            ItemStack(Items.supercomputer, 0.75),
        ),
        output = ItemStack(Items.assemblyDirectorSystem, 0.75),
        machine = Machine.Assembler,
    )

    val gasFilter = basic(
        name = "",
        input = listOf(
            ItemStack(Items.fabric, 15),
            ItemStack(Items.coal, 30),
            ItemStack(Items.ironPlate, 15),
        ),
        output = ItemStack(Items.gasFilter, 7.5),
        machine = Machine.Manufacturer,
    )

    val iodineInfusedFilter = basic(
        name = "",
        input = listOf(
            ItemStack(Items.gasFilter, 3.75),
            ItemStack(Items.quickwire, 30),
            ItemStack(Items.aluminumCasing, 3.75),
        ),
        output = ItemStack(Items.iodineInfusedFilter, 3.75),
        machine = Machine.Manufacturer,
    )

    val turbofuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.fuel, 15),
            ItemStack(Items.heavyOilResidue, 30),
            ItemStack(Items.sulfur, 22.5),
            ItemStack(Items.petroleumCoke, 22.5),
        ),
        output = ItemStack(Items.turbofuel, 45),
        machine = Machine.Manufacturer,
    )

    val packagedTurbofuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.turbofuel, 20),
            ItemStack(Items.emptyCanister, 20),
        ),
        output = ItemStack(Items.packagedTurbofuel, 20),
        machine = Machine.Packager,
    )

    val nitricAcid = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nitrogenGas, 120),
            ItemStack(Items.water, 30),
            ItemStack(Items.ironPlate, 10),
        ),
        output = ItemStack(Items.nitricAcid, 30),
        machine = Machine.Blender,
    )

    val pulseNobelisk = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nobelisk, 5),
            ItemStack(Items.crystalOscillator, 1),
        ),
        output = ItemStack(Items.pulseNobelisk, 5),
        machine = Machine.Assembler,
    )

    val emptyFluidTank = basic(
        name = "",
        input = listOf(
            ItemStack(Items.emptyFluidTank, 60),
        ),
        output = ItemStack(Items.emptyFluidTank, 60),
        machine = Machine.Constructor,
    )

    val packagedNitrogenGas = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nitrogenGas, 240),
            ItemStack(Items.emptyFluidTank, 60),
        ),
        output = ItemStack(Items.packagedNitrogenGas, 60),
        machine = Machine.Packager,
    )

    val heatSink = basic(
        name = "",
        input = listOf(
            ItemStack(Items.alcladAluminumSheet, 37.5),
            ItemStack(Items.copperSheet, 22.5),
        ),
        output = ItemStack(Items.heatSink, 7.5),
        machine = Machine.Assembler,
    )

    val coolingSystem = basic(
        name = "",
        input = listOf(
            ItemStack(Items.heatSink, 12),
            ItemStack(Items.rubber, 12),
            ItemStack(Items.water, 30),
            ItemStack(Items.nitrogenGas, 150),
        ),
        output = ItemStack(Items.coolingSystem, 6),
        machine = Machine.Blender,
    )

    val fusedModularFrame = basic(
        name = "",
        input = listOf(
            ItemStack(Items.heavyModularFrame, 1.5),
            ItemStack(Items.aluminumCasing, 75),
            ItemStack(Items.nitrogenGas, 37.5),
        ),
        output = ItemStack(Items.fusedModularFrame, 1.5),
        machine = Machine.Blender,
    )

    val rocketFuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.turbofuel, 60),
            ItemStack(Items.nitricAcid, 10),
        ),
        output = ItemStack(Items.rocketFuel, 100),
        byProduct = ItemStack(Items.compactedCoal, 10),
        machine = Machine.Blender,
    )

    val packagedRocketFuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.rocketFuel, 120),
            ItemStack(Items.emptyFluidTank, 60),
        ),
        output = ItemStack(Items.packagedRocketFuel, 60),
        machine = Machine.Packager,
    )

    val ficsoniumFuelRod = basic(
        name = "",
        input = listOf(
            ItemStack(Items.ficsonium, 5),
            ItemStack(Items.electromagneticControlRod, 5),
            ItemStack(Items.ficsiteTrigon, 100),
            ItemStack(Items.excitedPhotonicMatter, 50),
        ),
        output = ItemStack(Items.ficsoniumFuelRod, 2.5),
        byProduct = ItemStack(Items.darkMatterResidue, 50),
        machine = Machine.QuantumEncoder,
    )

    val darkMatterResidue = basic(
        name = "",
        input = listOf(
            ItemStack(Items.reanimatedSAM, 50),
        ),
        output = ItemStack(Items.darkMatterResidue, 100),
        machine = Machine.Converter,
    )

    val ficsonium = basic(
        name = "",
        input = listOf(
            ItemStack(Items.plutoniumWaste, 10),
            ItemStack(Items.singularityCell, 10),
            ItemStack(Items.darkMatterResidue, 200),
        ),
        output = ItemStack(Items.ficsonium, 10),
        machine = Machine.ParticleAccelerator,
    )

    val electromagneticControlRod = basic(
        name = "",
        input = listOf(
            ItemStack(Items.stator, 6),
            ItemStack(Items.AILimiter, 4),
        ),
        output = ItemStack(Items.electromagneticControlRod, 4),
        machine = Machine.Assembler,
    )

    val ficsiteTrigon = basic(
        name = "",
        input = listOf(
            ItemStack(Items.ficsiteIngot, 10),
        ),
        output = ItemStack(Items.ficsiteTrigon, 30),
        machine = Machine.Constructor,
    )

    val plutoniumWaste = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nuclearPasta, 1),
            ItemStack(Items.darkMatterCrystal, 20),
            ItemStack(Items.ironPlate, 100),
            ItemStack(Items.concrete, 200),
        ),
        output = ItemStack(Items.singularityCell, 10),
        machine = Machine.Manufacturer,
    )

    val timeCrystal = basic(
        name = "",
        input = listOf(
            ItemStack(Items.diamonds, 12),
        ),
        output = ItemStack(Items.timeCrystal, 6),
        machine = Machine.Converter,
    )

    val turboMotor = basic(
        name = "",
        input = listOf(
            ItemStack(Items.coolingSystem, 7.5),
            ItemStack(Items.radioControlUnit, 3.75),
            ItemStack(Items.motor, 7.5),
            ItemStack(Items.rubber, 45),
        ),
        output = ItemStack(Items.ficsiteTrigon, 1.875),
        machine = Machine.Manufacturer,
    )

    val thermalPropulsionRocket = basic(
        name = "",
        input = listOf(
            ItemStack(Items.modularEngine, 2.5),
            ItemStack(Items.turboMotor, 1),
            ItemStack(Items.coolingSystem, 3),
            ItemStack(Items.fusedModularFrame, 1),
        ),
        output = ItemStack(Items.thermalPropulsionRocket, 1),
        machine = Machine.Manufacturer,
    )

    val encasedUraniumCell = basic(
        name = "",
        input = listOf(
            ItemStack(Items.uranium, 50),
            ItemStack(Items.concrete, 15),
            ItemStack(Items.sulfuricAcid, 40),
        ),
        output = ItemStack(Items.encasedUraniumCell, 30),
        byProduct = ItemStack(Items.sulfuricAcid, 10),
        machine = Machine.Blender,
    )

    val uraniumFuelRod = basic(
        name = "",
        input = listOf(
            ItemStack(Items.encasedUraniumCell, 20),
            ItemStack(Items.encasedIndustrialBeam, 1.2),
            ItemStack(Items.electromagneticControlRod, 2),
        ),
        output = ItemStack(Items.uraniumFuelRod, 0.4),
        machine = Machine.Manufacturer,
    )

    val magneticFieldGenerator = basic(
        name = "",
        input = listOf(
            ItemStack(Items.versatileFramework, 2.5),
            ItemStack(Items.electromagneticControlRod, 1),
        ),
        output = ItemStack(Items.magneticFieldGenerator, 1),
        machine = Machine.Assembler,
    )

    val explosiveRebar = basic(
        name = "",
        input = listOf(
            ItemStack(Items.ironRebar, 10),
            ItemStack(Items.smokelessPowder, 10),
            ItemStack(Items.steelPipe, 10),
        ),
        output = ItemStack(Items.explosiveRebar, 5),
        machine = Machine.Manufacturer,
    )

    val ionizedFuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.rocketFuel, 40),
            ItemStack(Items.powerShard, 2.5),
        ),
        output = ItemStack(Items.ionizedFuel, 40),
        byProduct = ItemStack(Items.compactedCoal, 5),
        machine = Machine.Refinery,
    )

    val packagedIonizedFuel = basic(
        name = "",
        input = listOf(
            ItemStack(Items.ionizedFuel, 80),
            ItemStack(Items.emptyFluidTank, 40),
        ),
        output = ItemStack(Items.packagedIonizedFuel, 40),
        machine = Machine.Packager,
    )

    val rifleAmmo = basic(
        name = "",
        input = listOf(
            ItemStack(Items.copperSheet, 15),
            ItemStack(Items.smokelessPowder, 10),
        ),
        output = ItemStack(Items.rifleAmmo, 75),
        machine = Machine.Assembler,
    )

    val packagedNitricAcid = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nitricAcid, 30),
            ItemStack(Items.emptyFluidTank, 30),
        ),
        output = ItemStack(Items.packagedNitricAcid, 30),
        machine = Machine.Packager,
    )

    val nonFissileUranium = basic(
        name = "",
        input = listOf(
            ItemStack(Items.uraniumWaste, 37.5),
            ItemStack(Items.silica, 25),
            ItemStack(Items.nitricAcid, 15),
            ItemStack(Items.sulfuricAcid, 15),
        ),
        output = ItemStack(Items.nonFissileUranium, 50),
        byProduct = ItemStack(Items.water, 15),
        machine = Machine.Blender,
    )

    val plutoniumPellet = basic(
        name = "",
        input = listOf(
            ItemStack(Items.nonFissileUranium, 100),
            ItemStack(Items.uraniumWaste, 25),
        ),
        output = ItemStack(Items.plutoniumPellet, 30),
        machine = Machine.ParticleAccelerator,
    )

    val encasedPlutoniumCell = basic(
        name = "",
        input = listOf(
            ItemStack(Items.plutoniumPellet, 10),
            ItemStack(Items.concrete, 20),
        ),
        output = ItemStack(Items.encasedPlutoniumCell, 5),
        machine = Machine.Assembler,
    )

    val PlutoniumFuelRod = basic(
        name = "",
        input = listOf(
            ItemStack(Items.encasedPlutoniumCell, 7.5),
            ItemStack(Items.steelBeam, 4.5),
            ItemStack(Items.electromagneticControlRod, 1.5),
            ItemStack(Items.heatSink, 2.5),
        ),
        output = ItemStack(Items.encasedPlutoniumCell, 0.25),
        machine = Machine.Manufacturer,
    )

    val copperPowder = basic(
        name = "",
        input = listOf(
            ItemStack(Items.copperIngot, 300),
        ),
        output = ItemStack(Items.copperPowder, 50),
        machine = Machine.Constructor,
    )

    val pressureConversionCube = basic(
        name = "",
        input = listOf(
            ItemStack(Items.fusedModularFrame, 1),
            ItemStack(Items.radioControlUnit, 2),
        ),
        output = ItemStack(Items.pressureConversionCube, 1),
        machine = Machine.Assembler,
    )

    val nuclearPasta = basic(
        name = "",
        input = listOf(
            ItemStack(Items.copperPowder, 100),
            ItemStack(Items.pressureConversionCube, 0.5),
        ),
        output = ItemStack(Items.nuclearPasta, 0.5),
        machine = Machine.ParticleAccelerator,
    )

    val darkMatterCrystal = basic(
        name = "",
        input = listOf(
            ItemStack(Items.diamonds, 30),
            ItemStack(Items.darkMatterResidue, 150),
        ),
        output = ItemStack(Items.darkMatterCrystal, 30),
        machine = Machine.ParticleAccelerator,
    )

    val diamonds = basic(
        name = "",
        input = listOf(
            ItemStack(Items.coal, 600),
        ),
        output = ItemStack(Items.diamonds, 30),
        machine = Machine.ParticleAccelerator,
    )

    val ficsiteIngotCaterium = basic(
        name = "",
        input = listOf(
            ItemStack(Items.reanimatedSAM, 45),
            ItemStack(Items.cateriumIngot, 60),
        ),
        output = ItemStack(Items.ficsiteIngot, 15),
        machine = Machine.Converter,
    )

    val ficsiteIngotIron = basic(
        name = "",
        input = listOf(
            ItemStack(Items.reanimatedSAM, 40),
            ItemStack(Items.ironIngot, 240),
        ),
        output = ItemStack(Items.ficsiteIngot, 10),
        machine = Machine.Converter,
    )

    val ficsiteIngotAluminum = basic(
        name = "",
        input = listOf(
            ItemStack(Items.reanimatedSAM, 60),
            ItemStack(Items.aluminumIngot, 120),
        ),
        output = ItemStack(Items.ficsiteIngot, 30),
        machine = Machine.Converter,
    )

    val biochemicalSculptor = basic(
        name = "",
        input = listOf(
            ItemStack(Items.assemblyDirectorSystem, 0.5),
            ItemStack(Items.ficsiteTrigon, 40),
            ItemStack(Items.water, 10),
        ),
        output = ItemStack(Items.biochemicalSculptor, 2),
        machine = Machine.Blender,
    )

    val superpositionOscillator = basic(
        name = "",
        input = listOf(
            ItemStack(Items.darkMatterCrystal, 30),
            ItemStack(Items.crystalOscillator, 5),
            ItemStack(Items.alcladAluminumSheet, 45),
            ItemStack(Items.excitedPhotonicMatter, 125),
        ),
        output = ItemStack(Items.ficsiteIngot, 5),
        byProduct = ItemStack(Items.darkMatterResidue, 125),
        machine = Machine.QuantumEncoder,
    )

    val neuralQuantumProcessor = basic(
        name = "",
        input = listOf(
            ItemStack(Items.timeCrystal, 15),
            ItemStack(Items.supercomputer, 3),
            ItemStack(Items.ficsiteTrigon, 45),
            ItemStack(Items.excitedPhotonicMatter, 75),
        ),
        output = ItemStack(Items.ficsiteIngot, 3),
        byProduct = ItemStack(Items.darkMatterResidue, 75),
        machine = Machine.QuantumEncoder,
    )

    val aiExpansionServer = basic(
        name = "",
        input = listOf(
            ItemStack(Items.magneticFieldGenerator, 4),
            ItemStack(Items.neuralQuantumProcessor, 4),
            ItemStack(Items.superpositionOscillator, 4),
            ItemStack(Items.excitedPhotonicMatter, 100),
        ),
        output = ItemStack(Items.aiExpansionServer, 4),
        byProduct = ItemStack(Items.darkMatterResidue, 100),
        machine = Machine.QuantumEncoder,
    )
}
