package com.example.labassets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labassets.ui.theme.LabAssetsTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabAssetsTheme {
                 Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     LabEq(labName = stringResource(R.string.lab_name), modifier = Modifier.padding(start = 16.dp))
                }
            }
        }
    }
}
fun calculateTotalValue(numOfComputers: Double = 0.0, numOfScreens: Double = 0.0, numOfKeyboards: Double = 0.0, labName: String) : String {
    val eachComputerCost = 5000
    val eachScreenCost = 2000
    val eachKeyboardCost = 200

    val sumAssets = (numOfComputers * eachComputerCost) + (numOfScreens * eachScreenCost) + (numOfKeyboards * eachKeyboardCost)

    val total = NumberFormat.getCurrencyInstance().format(sumAssets)

    return "Total Lab Assets Value for ${labName}: $total"
}
@Composable
fun LabEq(labName: String, modifier: Modifier = Modifier) {
    var numOfComputers by remember { mutableStateOf("") }
    var numOfScreens by remember { mutableStateOf("") }
    var numOfKeyboards by remember { mutableStateOf("") }
    var totalAmountStr by remember { mutableStateOf("") }

    val numberOfComputers = numOfComputers.toDoubleOrNull()
    val numberOfScreens = numOfScreens.toDoubleOrNull()
    val numberOfKeyboards = numOfKeyboards.toDoubleOrNull()

    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        LabTextField(
            value = numOfComputers,
            onValueChange = { numOfComputers = it },
            labelText = stringResource(R.string.number_of_computers),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        LabTextField(
            value = numOfScreens,
            onValueChange = { numOfScreens = it },
            labelText = stringResource(R.string.number_of_screens),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        LabTextField(
            value = numOfKeyboards,
            onValueChange = {numOfKeyboards = it},
            labelText = stringResource(R.string.number_of_keyboards),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        LabButton(onClick = {
           totalAmountStr = calculateTotalValue(numberOfComputers!!, numberOfScreens!!, numberOfKeyboards!!, labName)
        })

        Spacer(modifier = Modifier.height(16.dp))

        ResultText(totalAmount = totalAmountStr)
    }
}

@Composable
fun LabTextField(modifier: Modifier = Modifier, value: String, onValueChange: (String) -> Unit, labelText: String, keyboardOptions: KeyboardOptions) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText)},
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}
@Composable
fun LabButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = stringResource(R.string.calculate_total_value))
    }
}
@Composable
fun ResultText(modifier: Modifier = Modifier, totalAmount: String = "") {
        Text(text = totalAmount, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabAssetsTheme {
        LabEq(labName = stringResource(R.string.lab_name))
    }
}