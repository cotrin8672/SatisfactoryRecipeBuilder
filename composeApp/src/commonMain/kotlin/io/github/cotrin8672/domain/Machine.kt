package io.github.cotrin8672.domain

sealed class Machine(val name: String) {
    // 基本機械
    data object Constructor : Machine("製作機")
    data object Assembler : Machine("組立機")
    data object Manufacturer : Machine("製造機")

    // アイテム+液体
    data object Refinery : Machine("精製機")
    data object Blender : Machine("混合機")

    // 瓶詰め
    data object Packager : Machine("充填機")

    // 粒子加速器
    data object ParticleAccelerator : Machine("粒子加速器")

    // Tier9
    data object Converter : Machine("変換機")
    data object QuantumEncoder : Machine("量子エンコーダー")

    // 炉
    data object Smelter : Machine("製錬炉")
    data object Foundry : Machine("鋳造炉")
}
