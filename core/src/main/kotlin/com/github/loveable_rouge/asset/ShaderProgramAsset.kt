package com.github.loveable_rouge.asset

import com.github.loveable_rouge.asset.BaseShaderProgramAsset

enum class ShaderProgramAsset(private val asset: BaseShaderProgramAsset) {
    SHOCKWAVE_SHADER(BaseShaderProgramAsset(fileName = "vertex.vert", fragmentFileName = "fragment.frag"));

    val descriptor
        get() = asset.descriptor
}