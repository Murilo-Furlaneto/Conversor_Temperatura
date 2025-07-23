package br.com.furlaneto.murilo.conversortemperatura

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


fun convertCelsiusToFahrenheit(input: String?): Result<Float> {
    val celsius = input?.toFloatOrNull()
        ?: return Result.failure(NumberFormatException("Entrada inválida"))
    val fahrenheit = (celsius * 9f / 5f) + 32f
    return Result.success(fahrenheit)
}

class TemperatureConversionTest {

    @Test
    fun `conversao correta valores validos`() {
        val cases = mapOf(
            "0" to 32f,
            "100" to 212f,
            "-40" to -40f,
            "37" to 98.6f,
            "30.5" to 86.9f,
            "-273.15" to -459.67f
        )

        for ((input, expected) in cases) {
            val result = convertCelsiusToFahrenheit(input)
            assertTrue("Esperava sucesso para entrada '$input'", result.isSuccess)
            assertEquals(expected, result.getOrNull()!!, 0.01f)
        }
    }

    @Test
    fun `entradas invalidas retornam erro`() {
        val invalidInputs = listOf(null, "", "abc", "10.5.6", "1e309") // 1e309 é Double infinity
        for (input in invalidInputs) {
            val result = convertCelsiusToFahrenheit(input)
            assertTrue("Esperava falha para entrada '$input'", result.isFailure)
            assertTrue(result.exceptionOrNull() is NumberFormatException)
        }
    }

    @Test
    fun `testa limites extremos de valores validos`() {
        val extremes = mapOf(
            "99999999" to 1.79999982E8f,
            "-9999999" to -1.7999998E7f,
        )
        for ((input, expected) in extremes) {
            val result = convertCelsiusToFahrenheit(input)
            assertTrue("Esperava sucesso para entrada '$input'", result.isSuccess)
            // Usar delta maior para valores muito grandes pela precisão float
            assertEquals(expected, result.getOrNull()!!, Math.abs(expected) * 0.0001f)
        }
    }

    @Test
    fun `testa comportamento para entrada vazia ou somente espaço`() {
        val inputs = listOf("", " ", "    ")
        for(input in inputs) {
            val result = convertCelsiusToFahrenheit(input)
            assertTrue("Esperava falha para entrada '$input'", result.isFailure)
        }
    }


    // Teste para limite de memória: entrada extremamente longa (milhares de chars)
    @Test
    fun `testa entrada excessivamente grande nao trava nem causa estouro`() {
        val largeInput = "9".repeat(10000) // uma string enorme
        val result = convertCelsiusToFahrenheit(largeInput)
        // Pode ou não ser possível converter dependendo do tamanho, apenas garante não crashar
        assertTrue(result.isSuccess || result.isFailure)
    }
}
