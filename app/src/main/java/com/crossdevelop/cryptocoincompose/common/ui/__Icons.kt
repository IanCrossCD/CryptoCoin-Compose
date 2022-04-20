package com.crossdevelop.cryptocoincompose.common.ui

import androidx.compose.ui.graphics.vector.ImageVector
import com.crossdevelop.cryptocoincompose.common.ui.icons.Bitbucket
import com.crossdevelop.cryptocoincompose.common.ui.icons.Facebook
import com.crossdevelop.cryptocoincompose.common.ui.icons.Github
import com.crossdevelop.cryptocoincompose.common.ui.icons.Reddit
import com.crossdevelop.cryptocoincompose.common.ui.icons.Twitter
import kotlin.collections.List as ____KtList

public object CryptoIcons

private var __CryptoIcons: ____KtList<ImageVector>? = null

public val CryptoIcons.CryptoIcons: ____KtList<ImageVector>
  get() {
    if (__CryptoIcons != null) {
      return __CryptoIcons!!
    }
    __CryptoIcons= listOf(Bitbucket, Github, Facebook, Reddit, Twitter)
    return __CryptoIcons!!
  }
