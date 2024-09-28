package buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCalculator(
    modifier: Modifier = Modifier,
    text: String = "?",
    onClick: () -> Unit,

    shape: RoundedCornerShape = RoundedCornerShape(percent = 0),
    color: Color = Color.Black,
    size: Dp = 75.dp,
    fontSize: TextUnit = 50.sp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(size),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = shape
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            TextButton(text = text, fontSize = fontSize)
        }
    }
}

@Composable
fun TextButton(
    text: String = "?",
    fontSize: TextUnit = 50.sp,
) {
    Text(
        text = text,
        fontSize = fontSize,
        style = styles.TextTypography
    )
}


@Preview(showBackground = false)
@Composable
fun CalculatorButtonPreview() {
    ButtonCalculator(
        text = "1",
        onClick = {}
    )
}

@Preview(showBackground = false)
@Composable
fun ButtonTextPreview() {
    TextButton(
        text = "1"
    )
}