package display

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import styles.DisplayColor
import styles.DisplayTypography

@Composable
fun Display(viewModel: DisplayViewModel) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(DisplayColor),
        value = viewModel.text,
        singleLine = true,
        textStyle = DisplayTypography,
        readOnly = true,
        onValueChange = { viewModel.updateText(it) },
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "0",
                fontSize = 75.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    )
}