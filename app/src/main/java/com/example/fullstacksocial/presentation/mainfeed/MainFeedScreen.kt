package com.example.fullstacksocial.presentation.mainfeed

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.fullstacksocial.presentation.Components.Post

@Composable
fun MainFeedScreen(
    navController: NavController
){
    Post(
        post = com.example.fullstacksocial.domain.models.Post(
            username = "Shivam Sharma",
            imageUrl = "" ,
            profilePictureUrl = "",
            description = "If you're encountering the error Cannot access 'BoxScopeInstance':" +
                    " it is internal in 'androidx.compose.foundation.layout', it" +
                    " suggests that you might be trying to access an internal implementation detail of the Jet" +
                    "pack Compose library that is not meant to be accessed directly by users of the library.",
            likeCount = 18,
            commentCount = 10
        )
    )
}