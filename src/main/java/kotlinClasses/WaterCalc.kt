package kotlinClasses

class WaterCalc {

    fun calculateWaterAmount(landscape: Array<Int>): Long {
        val peaks: MutableList<Pair<Int, Int>> = ArrayList()
        findAllPeaks(landscape, peaks, 0, landscape.size - 1)

        val result = peaks.map {
            calcTransitionSum(it, landscape)
        }.sum()

        return result
    }

    private fun calcTransitionSum(poolBorder: Pair<Int, Int>, landscape: Array<Int>): Long {
        val startIdx = poolBorder.first
        val endIdx = poolBorder.second

        val sum = if (startIdx > endIdx)
            calcSum(endIdx, startIdx, landscape)
        else calcSum(startIdx, endIdx, landscape)

        return sum
    }

    private fun calcSum(startIdx: Int, endIdx: Int, landscape: Array<Int>): Long {
        var sum = 0L
        val min = if (landscape[startIdx] >= landscape[endIdx]) landscape[endIdx] else landscape[startIdx]
        for (i in startIdx + 1 until endIdx) {
            sum += if (min - landscape[i] < 0) 0 else min - landscape[i]
        }

        return sum
    }

    private fun findAllPeaks(landscape: Array<Int>, peaksIdx: MutableList<Pair<Int, Int>>, startIdx: Int, endIdx: Int) {
        val highestIdx = findHighestIdx(landscape, startIdx, endIdx)

        if (highestIdx == -1)
            return

        val highestLeft = findHighestIdx(landscape, startIdx, highestIdx - 1)
        val highestRight = findHighestIdx(landscape, highestIdx + 1, endIdx)


        if (highestLeft != -1) {
            peaksIdx.add(Pair(highestIdx, highestLeft))
            findAllPeaks(landscape, peaksIdx, 0, highestLeft)
        }

        if (highestRight != -1) {
            peaksIdx.add(Pair(highestIdx, highestRight))
            findAllPeaks(landscape, peaksIdx, highestRight, landscape.size - 1)
        }
    }

    private fun findHighestIdx(landscape: Array<Int>, start: Int, end: Int): Int {
        var highest = -1
        var value = 0

        if (start == end)
            return highest

        for (i in start..end) {
            if (value <= landscape[i]) {
                highest = i
                value = landscape[i]
            }
        }

        return highest
    }
}