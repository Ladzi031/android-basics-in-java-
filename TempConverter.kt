fun main() {
    // Fill in the code.
    val value1 = 27.0
    val value2 = 350.0
    val value3 = 10.0
    
    val celsius = "Celsius"
    val kelvin = "Kelvin"
    val fahrenheit = "Fahrenheit"
    
    val celsiusToFahrenheit: (Double) -> Double = { ((9.0/5.0 * it) + 32.0) }
    val kelvinToCelsius: (Double) -> Double = { it - 273.15 }
    val fahrenheitToKelvin: (Double) -> Double = { 5.0/9.0 * (it - 32.0) + 273.15 }
    
    printFinalTemperature(value1, celsius, fahrenheit, celsiusToFahrenheit)
    printFinalTemperature(value2, kelvin, celsius, kelvinToCelsius)
    printFinalTemperature(value3, fahrenheit, kelvin, fahrenheitToKelvin)
    
}


fun printFinalTemperature(initialMeasurement: Double, initialUnit: String, finalUnit: String, conversionFormula: (Double) -> Double) {
    
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
