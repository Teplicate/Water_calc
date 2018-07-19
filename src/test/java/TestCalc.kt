import kotlinClasses.WaterCalc
import org.junit.jupiter.api.Test

class TestCalc {

    @Test
    fun testCorrectnes() {
        val calc = WaterCalc()
        val testArray = arrayOf(5, 2, 3, 4, 5, 4, 0, 3, 1, 10)
        val result = calc.calculateWaterAmount(testArray)
        val testArrayTwo = arrayOf(5, 2, 3, 4, 5, 4, 0, 3, 1)
        val resultTwo = calc.calculateWaterAmount(testArrayTwo)

        assert(result == 18L)
        assert(resultTwo == 9L)
    }
}