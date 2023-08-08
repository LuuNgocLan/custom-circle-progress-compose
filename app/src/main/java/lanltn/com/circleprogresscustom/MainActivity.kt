package lanltn.com.circleprogresscustom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lanltn.com.circleprogresscustom.data.DataSources
import lanltn.com.circleprogresscustom.ui.theme.CircleProgressCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleProgressCustomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SampleUI()
                }
            }
        }
    }
}

@Composable
fun SampleUI() {
    val courses = DataSources.allLearnedCourses

    LazyRow(modifier = Modifier.padding(vertical = 32.dp)) {
        items(courses.size) { index ->
            CourseItem(
                course = courses[index],
                modifier = Modifier.padding(start = if (index == 0) 24.dp else 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CircleProgressCustomTheme {
        SampleUI()
    }
}