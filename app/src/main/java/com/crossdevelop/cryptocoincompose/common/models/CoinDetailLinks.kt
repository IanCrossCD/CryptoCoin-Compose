package com.crossdevelop.cryptocoincompose.common.models


data class CoinDetailLinks(
    val homepage: List<String>,
    val blockChainSites: List<String>,
    val officialForumUrls: List<String>,
    val githubUrl : String?,
    val bitbucketUrl: String?,
    val subRedditUrl : String?,
    val twitterName : String?,
    val facebookName : String?
)
