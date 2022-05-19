package com.crossdevelop.cryptocoincompose.common.data.network.responses

import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetailCurrentPrice
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetailImage
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetailLinks
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@JsonClass(generateAdapter = true)
data class CoinDetailResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val description: DetailDescriptionResponse,
    val links: DetailLinksResponse,
    val image: DetailImageResponse,
    val hashing_algorithm: String?,
    val block_time_in_minutes: Int,
    val public_notice: String?,
    val genesis_date: String?,
    val market_cap_rank: Int?,
    val market_data: MarketDataResponse
) {

    @JsonClass(generateAdapter = true)
    data class DetailLinksResponse(
        val homepage: List<String>,
        @Json(name = "blockchain_site") val blockChainSites: List<String>,
        @Json(name = "official_forum_url") val officialForumUrls: List<String>,
        @Json(name = "twitter_screen_name") val twitterName: String?,
        @Json(name = "facebook_username") val facebookName: String?,
        @Json(name = "subreddit_url") val subRedditUrl: String?,
        @Json(name = "repos_url") val repos: RepoUrlResponse
    ) {

        @JsonClass(generateAdapter = true)
        data class RepoUrlResponse(
            val github: List<String>,
            val bitbucket: List<String>
        )


        fun toCoinDetailLinks(): CoinDetailLinks = CoinDetailLinks(
            homepage = homepage,
            blockChainSites = blockChainSites,
            officialForumUrls = officialForumUrls,
            twitterName = twitterName,
            facebookName = facebookName,
            subRedditUrl = subRedditUrl,
            githubUrl = repos.github.firstOrNull(),
            bitbucketUrl = repos.bitbucket.firstOrNull()
        )
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

    @JsonClass(generateAdapter = true)
    data class MarketDataResponse(
        val current_price: CurrentPriceResponse
    ) {

        @JsonClass(generateAdapter = true)
        data class CurrentPriceResponse(
            val usd: Double,
            val btc: Double,
            val eth: Double
        ) {
            fun toCoinDetailCurrentPrice() = CoinDetailCurrentPrice(usd = usd, eth = eth, btc = btc)
        }
    }

    fun toCoinDetail() = CoinDetail(
        id = id,
        symbol = symbol,
        name = name,
        description = description.en,
        links = links.toCoinDetailLinks(),
        image = image.toCoinDetailImage(),
        hashingAlg = hashing_algorithm,
        blockTimeInMinutes = block_time_in_minutes,
        publicNotice = public_notice,
        marketCapRank = market_cap_rank,
        genesisDate = genesis_date?.let { LocalDate.parse(genesis_date, DateTimeFormatter.ofPattern("yyyy-MM-dd")) },
        currentPrices = market_data.current_price.toCoinDetailCurrentPrice()
    )
}