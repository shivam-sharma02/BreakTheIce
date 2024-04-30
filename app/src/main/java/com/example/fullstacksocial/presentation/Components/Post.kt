package com.example.fullstacksocial.presentation.Components

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fullstacksocial.R
import com.example.fullstacksocial.domain.models.Post
import com.example.fullstacksocial.presentation.ui.theme.HintGray
import com.example.fullstacksocial.presentation.ui.theme.SpaceMedium
import com.example.fullstacksocial.util.Constants

@Composable
fun Post(
    post: Post,
    profilePictureSize: Dp = 75.dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(5.dp)
            .padding(SpaceMedium)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .offset(y = profilePictureSize / 2f)
        ) {
            Image(
                painterResource(id = R.drawable.post),
                contentDescription = "Post Image"
            )
            ActionRow(
                username = "Shivam Sharma",
                modifier = Modifier.fillMaxWidth(),
                onLikeClick = {isLiked ->

                },
                onCommentClick = {

                },
                onShareClick = {

                },
                onUsernameClick = {username ->

                }
            )
            Text(
                text = buildAnnotatedString {
                    append(post.description)
                    withStyle(SpanStyle(
                        color = HintGray
                    )){
                        append(
                            LocalContext.current.getString(
                                R.string.read_more
                            )
                        )
                    }

                },
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = Constants.MAX_POST_DESCRIPTION_LINE
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = stringResource(id = R.string.liked_by_x_people,
                        post.likeCount),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = stringResource(id = R.string.x_comments,
                        post.commentCount),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.profile2),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(profilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }

}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    iconSize: Dp = 30.dp,
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
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { onCommentClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(
            onClick = { onShareClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }
}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onCommentClick: () -> Unit = {},
    username: String,
    onShareClick: () -> Unit = {},
    onUsernameClick: (String) -> Unit = {}
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = modifier
                .clickable {
                    onUsernameClick(username)
                }
        )
        EngagementButtons(
            isLiked = isLiked,
            onCommentClick = onCommentClick,
            onLikeClick = onLikeClick,
            onShareClick = onShareClick
        )
    }
}