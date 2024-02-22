package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier
                        .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
                            UserImage()
                            UserDetails(
                                fullName = stringResource(R.string.full_name),
                                lastName = stringResource(R.string.surname),
                                jobTitle = stringResource(R.string.job_title)
                            )
                        }

                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            UserContactInfo(
                                icon = Icons.Filled.Phone,
                                contentDescription = stringResource(R.string.phone_desction),
                                info = stringResource(R.string.phone_number)
                            )
                            UserContactInfo(
                                icon = Icons.Filled.Email,
                                contentDescription = stringResource(R.string.email_description),
                                info = stringResource(R.string.email)
                            )
                            UserContactInfo(
                                icon = Icons.Filled.Home,
                                contentDescription = stringResource(R.string.home_description),
                                info = stringResource(R.string.website_info)
                            )
                        }

                    }

                }

        }
    }
}

@Composable
private fun UserImage(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.ladzi_pic)
    Image(
        painter = image,
        contentDescription = stringResource(R.string.profile_photo_description),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(150.dp)
                .clip(CircleShape)
                .background(color = Color.Transparent)
    )
}

@Composable
private fun UserDetails(fullName: String, lastName: String, jobTitle: String, modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(text = fullName, textAlign = TextAlign.Justify, fontWeight = FontWeight.Light, fontSize = 20.sp, color = Color.Gray,modifier = Modifier.padding(top = 12.dp, bottom = 12.dp))
        Text(text = lastName,textAlign = TextAlign.Justify, fontWeight = FontWeight.Bold, fontSize = 28.sp, modifier = Modifier.padding(bottom = 8.dp))
        Text(text = jobTitle,textAlign = TextAlign.Justify, fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}


@Composable
private fun UserContactInfo(icon: ImageVector,contentDescription: String, info: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(imageVector = icon, contentDescription = contentDescription, modifier = Modifier
            .weight(0.2F)
            .padding(horizontal = 8.dp))
        Text(text = info, fontSize = 18.sp,fontWeight = FontWeight.Medium,color = Color.Gray,textAlign = TextAlign.Center ,modifier = Modifier
            .weight(1F)
            .padding(horizontal = 0.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Column(modifier = Modifier
            .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
                UserImage()
                UserDetails(
                    fullName = stringResource(R.string.full_name),
                    lastName = stringResource(R.string.surname),
                    jobTitle = stringResource(R.string.job_title)
                )
            }

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    UserContactInfo(
                        icon = Icons.Filled.Phone,
                        contentDescription = stringResource(R.string.phone_desction),
                        info = stringResource(R.string.phone_number)
                    )
                    UserContactInfo(
                        icon = Icons.Filled.Email,
                        contentDescription = stringResource(R.string.email_description),
                        info = stringResource(R.string.email)
                    )
                    UserContactInfo(
                        icon = Icons.Filled.Home,
                        contentDescription = stringResource(R.string.home_description),
                        info = stringResource(R.string.website_info)
                    )
                }

        }


}