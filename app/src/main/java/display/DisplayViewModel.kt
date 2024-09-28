package display

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DisplayViewModel : ViewModel() {
    var text by mutableStateOf("")
        private set

    fun updateText(newText: String) {
        text = newText
    }
}