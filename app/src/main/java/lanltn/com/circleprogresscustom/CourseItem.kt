package lanltn.com.circleprogresscustom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import lanltn.com.circleprogresscustom.data.models.Course

@Composable
fun CourseItem(course: Course, modifier: Modifier) {
    Surface(
        color = course.colorMain,
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 32.dp,
                bottom = 20.dp
            ).width(IntrinsicSize.Max)
        ) {
            CircleProgressCustom(
                allSteps = course.allClasses,
                finishedSteps = course.finishedClasses,
                sizeStroke = 10.dp,
                modifier = Modifier.size(92.dp),
                progressColor = course.progressColor,
                baseColor = course.baseColor,
                textColor = if (course.isLightColor) Color.Black else Color.White,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = course.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (course.isLightColor) Color.Black else Color.White,
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${course.allClasses} Classes •\t ${course.level.name}",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = if (course.isLightColor) Color(0xFF99948F) else Color.White,
                ),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
