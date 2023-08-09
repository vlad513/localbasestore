package com.vladv.domain.model

import java.io.Serializable

data class ModelRecord (
    val id: Int,
    val timestamp:Int,
    val numberRecord: Int,
    val value: Int,
    val idUnit: Int,
    val idProbe:Int
):Serializable