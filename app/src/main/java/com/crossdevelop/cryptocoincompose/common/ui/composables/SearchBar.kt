package com.crossdevelop.cryptocoincompose.common.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.crossdevelop.cryptocoincompose.R
import com.crossdevelop.cryptocoincompose.common.ui.theme.Teal200
import com.crossdevelop.cryptocoincompose.common.ui.theme.White
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_large
import com.crossdevelop.cryptocoincompose.common.ui.theme.spacing_xlarge


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    query: String,
    onQuery: (query: String) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = query,
        onValueChange = { value ->
            onQuery.invoke(value)
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(spacing_large)
                    .size(spacing_xlarge)
            )
        },
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        placeholder = {
            Text(
                color = White,
                text = stringResource(R.string.search)
            )
        },
        trailingIcon = {
            if (query != "") {
                IconButton(
                    onClick = {
                        onQuery.invoke("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(spacing_large)
                            .size(spacing_xlarge)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Teal200,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}