package com.example.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesapp.datasource.DataSource
import com.example.coursesapp.model.Topic
import com.example.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseApp()
                }
            }
        }
    }
}
@Composable
fun CourseApp() {
    TopicList(topicList = DataSource.getListOfTopics())
}
@Composable
private fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.topicName),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
            )

            TopicInfo(
                topic = topic,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    )
            )

        }
    }
}
@Composable
private fun TopicInfo(topic: Topic, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = stringResource(id = topic.topicName),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Right
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.Start)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_grain),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = topic.numOfCourses.toString(),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
private fun TopicList(topicList: List<Topic>) {
   LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(count = 2), verticalItemSpacing = 8.dp, horizontalArrangement = Arrangement.spacedBy(8.dp)){
       items(topicList) {topic ->
           TopicCard(topic = topic)
       }
   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesAppTheme {
TopicCard(
    topic = Topic(
        imageResourceId = R.drawable.photography,
        numOfCourses = 321,
        topicName = R.string.photography
    )
)
    }
}