package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme

/** App rolls dice: click button "ROLL" then results displayed
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {rollDice()}
        //To display dice when app start
        rollDice()


//        rollButton.setOnClickListener {
////            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
////            toast.show()
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
//        }

    }
/**
 * function is used to roll dice and display results*/
    private fun rollDice() {
        //Create dice with 6 sides
        val dice = Dice(6)
        // roll it
        val diceRoll = dice.roll()
        //update the result to screen
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()


//        diceImage.setImageResource(R.drawable.dice_2)

//    val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {return (1..numSides).random()}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceRollerTheme {
        Greeting("Android")
    }
}