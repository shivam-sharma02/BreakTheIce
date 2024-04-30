package com.example.fullstacksocial.presentation.Login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fullstacksocial.R
import com.example.fullstacksocial.presentation.Components.StandardTextField
import com.example.fullstacksocial.presentation.ui.theme.SpaceMedium
import com.example.fullstacksocial.presentation.utils.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = SpaceMedium,
                bottom = 50.dp,
                start = SpaceMedium,
                end = SpaceMedium
            )
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ){
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChanged = {
                    viewModel.setUsernameText(it)
                },
                hint = stringResource(id = R.string.usernameHint),
                error = viewModel.usernameError.value
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                onValueChanged = {
                    viewModel.setPasswordText(it)
                },
                text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.passwordHint),
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                }
                )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End)
                ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append(" ")
                val SignUpText = stringResource(id = R.string.sign_up)
                withStyle(
                    style = SpanStyle(
                        MaterialTheme.colorScheme.primary
                    )
                ){
                    append(SignUpText)
                }
            },
            style = MaterialTheme.typography.bodyMedium ,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )
    }
}