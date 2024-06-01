package com.example.krypto.domain.models

import com.example.krypto.data.dataSource.api.dto.LinksExtended
import com.example.krypto.data.dataSource.api.dto.Whitepaper

data class CoinDetailModel(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
    val type: String,
    val logo: String,
    val tags: List<CoinTagModel>,
    val team: List<CoinTeamModel>,
    val description: String,
    val message: String,
    val openSource: Boolean,
    val startedAt: String,
    val developmentStatus: String,
    val hardwareWallet: Boolean,
    val hashAlgorithm: String,
    val links: CoinLinksModel,
    val linksExtended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    val firstDataAt: String,
    val lastDataAt: String
)

data class CoinTagModel(
    val id: String,
    val name: String,
    val coinCounter: Int,
    val icoCounter: Int
)

data class CoinTeamModel(
    val id: String,
    val name: String,
    val position: String
)

data class CoinLinksModel(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
