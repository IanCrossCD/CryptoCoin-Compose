package com.crossdevelop.cryptocoincompose.core.composables

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.crossdevelop.cryptocoincompose.R


@Composable
fun ConfirmationDialog(
    showDialog: MutableState<Boolean>,
    title: String,
    body: String,
    confirmButtonText: String = stringResource(R.string.yes),
    dismissButtonText: String = stringResource(R.string.nope),
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        }, title = {
            Text(title)
        }, text = {
            Text(body)
//        },
//        dismissButton = {
//            Button(onClick = {
//                showDialog.value = false
//            }) {
//                Text(text = dismissButtonText)
//            }
        }, confirmButton = {
            Button(onClick = {
                onConfirm.invoke()
                showDialog.value = false
            }) {
                Text(text = confirmButtonText)
            }
        })
}