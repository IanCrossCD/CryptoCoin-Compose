package com.crossdevelop.cryptocoincompose.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import com.crossdevelop.cryptocoincompose.common.ui.theme.CryptoCoinTheme
import com.google.accompanist.insets.ProvideWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var viewModel: CryptoCoinAppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[CryptoCoinAppViewModel::class.java]

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CryptoCoinTheme() {
                ProvideWindowInsets {
                    CryptoCoinApp()
                }
            }
        }
    }

}

