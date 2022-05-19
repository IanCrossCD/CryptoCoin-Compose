package com.crossdevelop.cryptocoincompose.feature.coindetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.ui.CryptoIcons
import com.crossdevelop.cryptocoincompose.common.ui.icons.Bitbucket
import com.crossdevelop.cryptocoincompose.common.ui.icons.Facebook
import com.crossdevelop.cryptocoincompose.common.ui.icons.Github
import com.crossdevelop.cryptocoincompose.common.ui.icons.Reddit
import com.crossdevelop.cryptocoincompose.common.ui.icons.Twitter
import com.crossdevelop.cryptocoincompose.common.ui.theme.*
import com.crossdevelop.cryptocoincompose.common.utils.parseHtml
import com.crossdevelop.cryptocoincompose.feature.AppContainer
import com.google.accompanist.insets.navigationBarsPadding
import java.time.format.DateTimeFormatter


@Composable
fun CoinDetailInfoScreen(appContainer: AppContainer, coinDetail: CoinDetail) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .navigationBarsPadding(),
    ) {

        TitleRow(coinDetail = coinDetail)

        PublicNotice(coinDetail = coinDetail)

        SocialButtonsRow(coinDetail = coinDetail)

        Info(coinDetail = coinDetail)

    }
}

@Composable
private fun TitleRow(coinDetail: CoinDetail) {
    Row(
        modifier = Modifier.padding(
            start = spacing_large,
            end = spacing_large,
            bottom = spacing_default,
            top = spacing_large
        )
    ) {
        AsyncImage(
            modifier = Modifier.align(Alignment.CenterVertically),
            model = coinDetail.image.large,
            contentDescription = "coin image"
        )
        Text(
            modifier = Modifier.padding(
                start = spacing_large,
                end = spacing_zero,
                bottom = spacing_zero,
                top = spacing_zero
            ),
            text = "${coinDetail.name}\n(${coinDetail.symbol})",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun PublicNotice(coinDetail: CoinDetail) {
    if (!coinDetail.publicNotice.isNullOrBlank()) {
        Surface(
            modifier = Modifier.padding(spacing_large),
            color = Red50,
            shape = OffsetRoundedCornersShape,
            border = BorderStroke(border_stroke_medium, MaterialTheme.colors.error),
            elevation = elevation_card
        ) {
            Text(modifier = Modifier.padding(spacing_large), text = coinDetail.publicNotice.parseHtml())
        }
    }
}

@Composable
private fun Info(coinDetail: CoinDetail) {
    Surface(
        modifier = Modifier.padding(horizontal = spacing_large, vertical = spacing_default),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(border_stroke_small, MaterialTheme.colors.secondary),
        elevation = elevation_card
    ) {
        Column {

            Text(
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = spacing_large, end = spacing_large, bottom = spacing_small, top = spacing_large),
                text = stringResource(R.string.rank_s, coinDetail.marketCapRank ?: stringResource(id = R.string.unknown))
            )

            coinDetail.description?.let {
                Text(modifier = Modifier.padding(spacing_large), text = it.parseHtml())
            }

            Text(
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = spacing_large, end = spacing_large, bottom = spacing_large, top = spacing_small),
                text = stringResource(
                    R.string.created_s,
                    coinDetail.genesisDate?.format(DateTimeFormatter.ofPattern("M/d/yyyy")) ?: stringResource(R.string.unknown)
                )
            )

        }

    }
}

@Composable
private fun SocialButtonsRow(coinDetail: CoinDetail) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = spacing_large, vertical = spacing_default)
    ) {
        val homepage: String? = coinDetail.links.homepage.firstOrNull()
        if (!homepage.isNullOrBlank()) {
            SocialButton(context = context, url = homepage, icon = Icons.Filled.Home)
        }
        val twitterName = coinDetail.links.twitterName
        if (!twitterName.isNullOrBlank()) {
            SocialButton(context = context, url = "https:twitter.com/$twitterName", icon = CryptoIcons.Twitter)
        }
        val facebookName = coinDetail.links.facebookName
        if (!facebookName.isNullOrBlank()) {
            SocialButton(context = context, url = "https:facebook.com/$facebookName", icon = CryptoIcons.Facebook)
        }
        val redditUrl = coinDetail.links.subRedditUrl
        if (!redditUrl.isNullOrBlank()) {
            SocialButton(context = context, url = redditUrl, icon = CryptoIcons.Reddit)
        }
        val gitUrl = coinDetail.links.githubUrl
        if (!gitUrl.isNullOrBlank()) {
            SocialButton(context = context, url = gitUrl, icon = CryptoIcons.Github)
        }
        val bitbucketUrl = coinDetail.links.bitbucketUrl
        if (!bitbucketUrl.isNullOrBlank()) {
            SocialButton(context = context, url = bitbucketUrl, icon = CryptoIcons.Bitbucket)
        }

    }
}

@Composable
private fun SocialButton(context: Context, url: String, icon: ImageVector) {
    Button(
        modifier = Modifier
            .padding(horizontal = spacing_small)
            .size(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
        shape = CircleShape,
        contentPadding = PaddingValues(spacing_small),
        content = {
            Image(
                imageVector = icon,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = stringResource(R.string.navigate_back)
            )
        }, onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(context, intent, null)
        })
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CryptoCoinTheme {
//        CoinDetailInfoScreen(appContainer = AppContainer(rememberNavController(), rememberScaffoldState()))
//    }
//}