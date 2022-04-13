package com.crossdevelop.cryptocoincompose.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.core.ui.InsetAwareTopAppBar


@Composable
fun DashboardScreen(name: String) {

//    Column(modifier = Modifier
//        .navigationBarsPadding()
//        .padding(top = contentPaddings.calculateTopPadding())) {
//        // content can go here forexample...
//        // if you want the content go below status bar
//        //   you can remove the top padding for column
//    }
//
//    InsetAwareTopAppBar(
//        title = { Text("Toolbar") },
//        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.9f),
//        modifier = Modifier
//            .fillMaxWidth()
//            .onSizeChanged { topAppBarSize = it.height }
//    )


    Column {

        InsetAwareTopAppBar(
            title = { Text(text = stringResource(R.string.crypto_compose)) },
//        navigationIcon = navigationIcon,
//        actions = actions,
            elevation = 0.dp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)) {
                Text(modifier = Modifier.padding(16.dp), text = "Hello $name! + $it")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoCoinTheme {
        DashboardScreen("Android")
    }
}