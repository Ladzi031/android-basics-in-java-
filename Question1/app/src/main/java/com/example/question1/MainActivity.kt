package com.example.question1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.question1.ui.theme.Question1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Question1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow
                ) {
                    Tut()
                }
            }
        }
    }
}
@Composable
fun Tut(modifier: Modifier = Modifier) {
   Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
       TutText(
           text = stringResource(R.string.tut_mobile),
           modifier = Modifier.background(color  = Color.Blue)
       )
       TutText(
           text = stringResource(R.string.student_number),
           modifier = Modifier
           .background(color = Color.Red)
           .padding(30.dp)
       )
       TutText(
           text = stringResource(R.string.android_compose),
           modifier = Modifier.background(color = Color.White)
       )
   }
}
@Composable
fun TutText(modifier: Modifier = Modifier, text: String) {
    Surface(modifier = modifier) {
        Text(
            text = text,
            modifier.background(color = Color.Transparent), color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TutPreview() {
    Question1Theme {
        Surface(color = Color.Yellow){
            Tut()
        }
    }
}