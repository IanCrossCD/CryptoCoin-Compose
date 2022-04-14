package com.crossdevelop.cryptocoincompose.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.utils.rememberWindowSizeClass
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val backPressHandler = BackPressHandler()

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CryptoCoinTheme() {
//            Providers(
//                LocalBackPressHandler provides backPressHandler
//            ) {
//                val controller = rememberAndroidSystemUiController()
                    ProvideWindowInsets {
                        CryptoCoinApp()
                    }
                }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.initCoinList()
    }

    override fun onBackPressed() {
//        if (!backPressHandler.handle()) {
//            super.onBackPressed()
//        }
    }
}

