package com.crossdevelop.cryptocoincompose.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.crossdevelop.cryptocoincompose.common.utils.rememberWindowSizeClass
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {

//    private val backPressHandler = BackPressHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val appContainer = (application as CryptoCoinApplication).container
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CryptoCoinTheme() {
//            Providers(
//                LocalBackPressHandler provides backPressHandler
//            ) {

//                val controller = rememberAndroidSystemUiController()
                    ProvideWindowInsets {
                        val windowSizeClass = rememberWindowSizeClass()
                        CryptoCoinApp(windowSizeClass)
                    }
                }
        }
    }

    override fun onBackPressed() {
//        if (!backPressHandler.handle()) {
//            super.onBackPressed()
//        }
    }
}

