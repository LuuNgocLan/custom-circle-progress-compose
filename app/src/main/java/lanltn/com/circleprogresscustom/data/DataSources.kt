package lanltn.com.circleprogresscustom.data

import androidx.compose.ui.graphics.Color
import lanltn.com.circleprogresscustom.data.models.Course
import lanltn.com.circleprogresscustom.data.models.Level

object DataSources {

    val allLearnedCourses = listOf(
        Course(
            name = "German \nLanguage",
            allClasses = 20,
            finishedClasses = 10,
            level = Level.Easy,
            colorMain = Color(0xFF5B7BFE),
            progressColor = Color(0xFF43FEF3),
            baseColor = Color(0xFFF2F4FF)
        ),
        Course(
            name = "Spanish\nLanguage",
            allClasses = 30,
            finishedClasses = 10,
            level = Level.Easy,
            colorMain = Color(0xFFFFF6EB),
            isLightColor = true,
            progressColor = Color(0xFFF76400),
            baseColor = Color(0xFFFEEAD9)
        ),
        Course(
            name = "Vietnamese\nLanguage",
            allClasses = 20,
            finishedClasses = 4,
            level = Level.Easy,
            colorMain = Color(0xFF051774),
            progressColor = Color(0xFF2295F8),
            baseColor = Color(0xFFA4B0EE)
        ),
        Course(
            name = "Korea\nLanguage",
            allClasses = 20,
            finishedClasses = 15,
            level = Level.Easy,
            colorMain = Color(0xFFFFF6EB),
            isLightColor = true,
            progressColor = Color(0xFFF76400),
            baseColor = Color(0xFFFEEAD9),
        ),
    )
}