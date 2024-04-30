package com.example.fullstacksocial.presentation.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.fullstacksocial.R

@Composable
fun Post() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ){

    }
}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        IconButton(
            onClick = { onLikeClick(!isLiked) }
        ) {
           Icon(
               imageVector = Icons.Filled.Favorite,
               contentDescription = if (isLiked){
                   stringResource(id = R.string.unlike)
               }else {
                   stringResource(id = R.string.like)
               }
           )
        }
        IconButton(
            onClick = { onCommentClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(id = R.string.comment)
            )
        }
        IconButton(
            onClick = { onShareClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }
}