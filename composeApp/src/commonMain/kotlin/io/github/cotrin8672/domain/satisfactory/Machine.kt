package io.github.cotrin8672.domain.satisfactory

sealed class Machine(val name: String, val id: String) {
    // 基本機械
    data object Constructor : Machine("製作機", "Constructor")
    data object Assembler : Machine("組立機", "Assembler")
    data object Manufacturer : Machine("製造機", "Manufacturer")

    // アイテム+液体
    data object Refinery : Machine("精製機", "Refinery")
    data object Blender : Machine("混合機", "Blender")

    // 瓶詰め
    data object Packager : Machine("充填機", "Packager")

    // 粒子加速器
    data object ParticleAccelerator : Machine("粒子加速器", "Particle_Accelerator")

    // Tier9
    data object Converter : Machine("変換機", "Converter")
    data object QuantumEncoder : Machine("量子エンコーダー", "Quantum_Encoder")

    // 炉
    data object Smelter : Machine("製錬炉", "Smelter")
    data object Foundry : Machine("鋳造炉", "Foundry")
}
