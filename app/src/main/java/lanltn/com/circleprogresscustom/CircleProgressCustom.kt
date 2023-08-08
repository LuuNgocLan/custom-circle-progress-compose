package lanltn.com.circleprogresscustom

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
internal fun CircleProgressCustom(
    modifier: Modifier = Modifier,
    baseColor: Color = MaterialTheme.colorScheme.surface,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    allSteps: Int,
    finishedSteps: Int,
    sizeStroke: Dp,
    textColor: Color = Color.White,
    textFontSize: Dp = 20.dp
) {
    BoxWithConstraints(modifier = modifier, contentAlignment = Alignment.Center) {
        val canvasSize = min(a = constraints.maxWidth, b = constraints.maxHeight)
        val size = Size(width = canvasSize.toFloat(), height = canvasSize.toFloat())
        val canvasSizeDp = with(receiver = LocalDensity.current) { canvasSize.toDp() }
        val progressArch = finishedSteps * 360f / allSteps
        val sliceWidthPx = with(LocalDensity.current) { sizeStroke.toPx() }
        val textFontSize = with(LocalDensity.current) { textFontSize.toPx() }

        Canvas(modifier = Modifier.size(canvasSizeDp)) {
            // Draw base with full process
            drawArc(
                color = baseColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                size = size,
                style = Stroke(width = sliceWidthPx)
            )
            // Draw finished process
            drawArc(
                color = progressColor,
                startAngle = 270f,
                sweepAngle = progressArch,
                useCenter = false,
                size = size,
                style = Stroke(width = sliceWidthPx, cap = StrokeCap.Round)
            )

            // text Paint with style
            val textPaint =
                Paint().apply {
                    color = textColor.toArgb()
                    textSize = textFontSize
                    textAlign = Paint.Align.CENTER
                    typeface = Typeface.DEFAULT_BOLD
                }

            // draw text at center
            drawIntoCanvas { canvas ->
                canvas.nativeCanvas.drawText(
                    "${finishedSteps}/${allSteps}",
                    (canvasSize / 2).toFloat(),
                    (canvasSize / 2) + textFontSize / 2,
                    textPaint
                )
            }
        }
    }
}
