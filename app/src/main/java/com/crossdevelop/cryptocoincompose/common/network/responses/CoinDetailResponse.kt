package com.crossdevelop.cryptocoincompose.common.network.responses

import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.models.CoinDetailImage
import com.crossdevelop.cryptocoincompose.common.models.CoinDetailLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CoinDetailResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val description: DetailDescriptionResponse,
    val links: DetailLinksResponse,
    val image: DetailImageResponse,
    @Json(name = "hashing_algorithm") val hashingAlg: String?,
    @Json(name = "block_time_in_minutes") val blockTimeInMinutes: Int,
    @Json(name = "public_notice") val publicNotice: String?
) {

    @JsonClass(generateAdapter = true)
    data class DetailLinksResponse(
        val homepage: List<String>,
        @Json(name = "blockchain_site") val blockChainSites: List<String>,
        @Json(name = "official_forum_url") val officialForumUrls: List<String>
    ) {

        fun toCoinDetailLinks(): CoinDetailLinks = CoinDetailLinks(homepage, blockChainSites, officialForumUrls)
    }

    @JsonClass(generateAdapter = true)
    data class DetailImageResponse(
        val thumb: String?,
        val small: String?,
        val large: String?
    ) {

        fun toCoinDetailImage(): CoinDetailImage = CoinDetailImage(thumb, small, large)
    }

    @JsonClass(generateAdapter = true)
    data class DetailDescriptionResponse(
        val en: String?,
    )

    fun toCoinDetail() = CoinDetail(
        id = id,
        symbol = symbol,
        name = name,
        description = description.en,
        links = links.toCoinDetailLinks(),
        image = image.toCoinDetailImage(),
        hashingAlg = hashingAlg,
        blockTimeInMinutes = blockTimeInMinutes,
        publicNotice = publicNotice
    )
}