package calculator

import display.DisplayViewModel
import stacks.Stack

class InputHandler(
    private val displayViewModel: DisplayViewModel,
    private val stack: Stack<String>
) {
    private val arithmeticOperators =
        listOf("+", "x", "/") // These are going to have a similar behavior
    private val numbers = listOf(
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9"
    ) // These are going to have a similar behavior

    fun handleInput(input: String) {
        println("Input received: $input")
        when {
            arithmeticOperators.contains(input) -> {
                if (stack.peek() in arithmeticOperators || stack.peek() == "-") {
                    stack.pop()
                    deleteLastCharacter()
                }
                if (stack.peek() in numbers || stack.peek() == ".") {
                    stack.push(input)
                    stack.setDecimalPointAvailability(true)
                    updateText(input)
                }
            }
            input == "." -> {
                if (stack.isDecimalPointAvailable()) {
                    stack.push(input)
                    stack.setDecimalPointAvailability(false)
                    updateText(input)
                }
            }
            input == "<-" -> {
                if (stack.peek() == ".") {
                    stack.setDecimalPointAvailability(true)
                }
                if (stack.peek() in arithmeticOperators) {
                    stack.setDecimalPointAvailability(false)
                }
                stack.pop()
                deleteLastCharacter()
            }
            input == "AC" -> {
                stack.clear()
                stack.setDecimalPointAvailability(true)
                clearDisplay()
            }
            else -> {
                    stack.push(input)
                    updateText(input)
            }
        }
        println(stack.toString())
    }

    private fun updateText(input: String) {
        displayViewModel.updateText(displayViewModel.text + input)
    }

    private fun deleteLastCharacter() {
        displayViewModel.updateText(displayViewModel.text.dropLast(1))
    }

    private fun clearDisplay() {
        displayViewModel.updateText("")
    }
}