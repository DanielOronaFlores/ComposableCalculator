package styles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

val TextTypography = TextStyle(
    fontWeight = FontWeight.ExtraBold,
    color = Color.White,
    textAlign = TextAlign.Center
)

val DisplayTypography = TextStyle(
    fontSize = 75.sp,
    fontWeight = FontWeight.SemiBold,
    color = Color.White,
    textAlign = TextAlign.End
)