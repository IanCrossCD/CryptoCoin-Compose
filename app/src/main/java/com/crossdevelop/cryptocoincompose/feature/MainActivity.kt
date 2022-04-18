package com.crossdevelop.cryptocoincompose.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CryptoCoinTheme() {
                ProvideWindowInsets {
                    val appContainer = AppContainer(rememberNavController())
                    CryptoCoinApp(appContainer)
                }
            }
        }
    }

}

