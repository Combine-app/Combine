package com.combine.chain.domain

import com.combine.chain.Res
import com.combine.chain.solana_logo
import org.jetbrains.compose.resources.DrawableResource

enum class Chain(val logo: DrawableResource) {
    Solana(
        logo = Res.drawable.solana_logo,
    ),
    Eth(
        logo = Res.drawable.solana_logo,
    ),
    Bsc(
        logo = Res.drawable.solana_logo,
    );
}