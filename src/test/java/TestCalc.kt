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
        val resultZero = calc.calculateWaterAmount(emptyArray())
        val resultZero2 = calc.calculateWaterAmount(arrayOf(1,2,3,4,5,6,7,8,9,10))
        val resultSome = calc.calculateWaterAmount(arrayOf(1,2,3,4,5,6,6,7,8,10))
        val resultMore = calc.calculateWaterAmount(arrayOf(1,2,3,4,5,6,7,6,10))

        assert(result == 18L)
        assert(resultTwo == 9L)
        assert(resultZero == 0L)
        assert(resultZero2 == 0L)
        assert(resultSome == 0L)
        assert(resultMore == 1L)
    }

}