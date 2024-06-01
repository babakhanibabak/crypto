package com.example.krypto.data.dataSource.api.dto

import com.example.krypto.domain.models.CoinDetailModel
import com.example.krypto.domain.models.CoinLinksModel
import com.example.krypto.domain.models.CoinTagModel
import com.example.krypto.domain.models.CoinTeamModel
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("is_active")
    val isActive: Boolean,
    val type: String,
    val logo: String,
    val tags: List<CoinTagDto>,
    val team: List<CoinTeamDto>,
    val description: String,
    val message: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val links: CoinLinksDto,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended>,
    val whitepaper: Whitepaper,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("last_data_at")
    val lastDataAt: String
)


data class CoinTagDto(
    val id: String,
    val name: String,
    @SerializedName("coin_counter")
    val coinCounter: Int,
    @SerializedName("ico_counter")
    val icoCounter: Int
)

data class CoinTeamDto(
    val id: String,
    val name: String,
    val position: String
)

data class CoinLinksDto(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    @SerializedName("source_code")
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)

data class LinksExtended(
    val url: String,
    val type: String,
    val stats: LinksExtendedStats? = null,
)

data class LinksExtendedStats(
    val subscribers: Int? = null,
    val contributors: Int? = null,
    val stars: Int? = null,
    val followers: Int? = null,
)

data class Whitepaper(
    val link: String,
    val thumbnail: String
)

fun mapToDomainModel(dto: CoinDetailDto): CoinDetailModel {
    return CoinDetailModel(
        id = dto.id,
        name = dto.name,
        symbol = dto.symbol,
        rank = dto.rank,
        isNew = dto.isNew,
        isActive = dto.isActive,
        type = dto.type,
        logo = dto.logo,
        tags = dto.tags.map { tag ->
            CoinTagModel(
                id = tag.id,
                name = tag.name,
                coinCounter = tag.coinCounter,
                icoCounter = tag.icoCounter
            )
        },
        team = dto.team.map { team ->
            CoinTeamModel(
                id = team.id,
                name = team.name,
                position = team.position
            )
        },
        description = dto.description,
        message = dto.message,
        openSource = dto.openSource,
        startedAt = dto.startedAt,
        developmentStatus = dto.developmentStatus,
        hardwareWallet = dto.hardwareWallet,
        hashAlgorithm = dto.hashAlgorithm,
        links = CoinLinksModel(
            explorer = dto.links.explorer,
            facebook = dto.links.facebook,
            reddit = dto.links.reddit,
            sourceCode = dto.links.sourceCode,
            website = dto.links.website,
            youtube = dto.links.youtube,
        ),
        linksExtended = dto.linksExtended,
        whitepaper = dto.whitepaper,
        firstDataAt = dto.firstDataAt,
        lastDataAt = dto.lastDataAt,
    )
}