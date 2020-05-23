private fun readln() = readLine()!!
private fun readlnByte() = readln().toByte()
private fun readlnShort() = readln().toShort()
private fun readlnInt() = readln().toInt()
private fun readlnLong() = readln().toLong()
private fun readlnFloat() = readln().toFloat()
private fun readlnDouble() = readln().toDouble()
private fun readlnBigInt(radix: Int = 10) = readln().toBigInteger(radix)
private fun readlnBigDecimal() = readln().toBigDecimal()

private fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readLine() }.constrainOnce().take(limit)
private fun readlnStrings() = readln().split(' ')
private fun readlnBytes() = readlnStrings().map { it.toByte() }
private fun readlnShorts() = readlnStrings().map { it.toShort() }
private fun readlnInts() = readlnStrings().map { it.toInt() }
private fun readlnLongs() = readlnStrings().map { it.toLong() }
private fun readlnFloats() = readlnStrings().map { it.toFloat() }
private fun readlnDoubles() = readlnStrings().map { it.toDouble() }

private fun readByteArray() = readlnStrings().run { ByteArray(size) { get(it).toByte() } }
private fun readShortArray() = readlnStrings().run { ShortArray(size) { get(it).toShort() } }
private fun readIntArray() = readlnStrings().run { IntArray(size) { get(it).toInt() } }
private fun readLongArray() = readlnStrings().run { LongArray(size) { get(it).toLong() } }
private fun readFloatArray() = readlnStrings().run { FloatArray(size) { get(it).toFloat() } }
private fun readDoubleArray() = readlnStrings().run { DoubleArray(size) { get(it).toDouble() } }

private fun readlnByteArray(n: Int) = ByteArray(n) { readlnByte() }
private fun readlnShortArray(n: Int) = ShortArray(n) { readlnShort() }
private fun readlnIntArray(n: Int) = IntArray(n) { readlnInt() }
private fun readlnLongArray(n: Int) = LongArray(n) { readlnLong() }
private fun readlnFloatArray(n: Int) = FloatArray(n) { readlnFloat() }
private fun readlnDoubleArray(n: Int) = DoubleArray(n) { readlnDouble() }

private fun readByteArray2d(rows: Int, cols: Int) = Array(rows) { readByteArray().also { require(it.size == cols) } }
private fun readShortArray2d(rows: Int, cols: Int) = Array(rows) { readShortArray().also { require(it.size == cols) } }
private fun readLongArray2d(rows: Int, cols: Int) = Array(rows) { readLongArray().also { require(it.size == cols) } }
private fun readIntArray2d(rows: Int, cols: Int) = Array(rows) { readIntArray().also { require(it.size == cols) } }
private fun readFloatArray2d(rows: Int, cols: Int) = Array(rows) { readFloatArray().also { require(it.size == cols) } }
private fun readDoubleArray2d(rows: Int, cols: Int) = Array(rows) { readDoubleArray().also { require(it.size == cols) } }

private fun isWhiteSpace(c: Char) = c in " \r\n\t"

// JVM-only targeting code follows next

// readString() via sequence is still slightly faster than Scanner
private fun readString() = generateSequence { System.`in`.read().toChar() }
    .dropWhile { isWhiteSpace(it) }.takeWhile { !isWhiteSpace(it) }.joinToString("")
private fun readByte() = readString().toByte()
private fun readShort() = readString().toShort()
private fun readInt() = readString().toInt()
private fun readLong() = readString().toLong()
private fun readFloat() = readString().toFloat()
private fun readDouble() = readString().toDouble()
private fun readBigInt(radix: Int = 10) = readString().toBigInteger(radix)
private fun readBigDecimal() = readString().toBigDecimal()

private fun readBytes(n: Int) = generateSequence { readByte() }.take(n)
private fun readShorts(n: Int) = generateSequence { readShort() }.take(n)
private fun readInts(n: Int) = generateSequence { readInt() }.take(n)
private fun readLongs(n: Int) = generateSequence { readLong() }.take(n)
private fun readFloats(n: Int) = generateSequence { readFloat() }.take(n)
private fun readDoubles(n: Int) = generateSequence { readDouble() }.take(n)

fun MutableList<Int>.popFirst() = this.removeAt(0)

fun MutableList<Int>.popLast() = this.removeAt(this.lastIndex)

fun MutableList<Int>.eatLeftTill(since: Int):Int {
    var eated = 0
    while (this.isNotEmpty()){
        if(eated > since)   break
        var candy = this.first()
        eated += candy
        this.popFirst()
    }
    return eated
}

fun MutableList<Int>.eatRightTill(since: Int):Int {
    var eated = 0
    while (this.isNotEmpty()){
        if(eated > since)   break
        var candy = this.last()
        eated += candy
        this.popLast()
    }
    return eated
}


fun main() {

    val n = readInt()
    repeat(n) {
        val size = readInt()
        var lista = listOf(0)
        val arr = lista.toMutableList()
        var aux:Int
        repeat(size){
            aux = readInt()
            arr.add(aux)
        }
        arr.popFirst()
//        val lista = listOf(1, 1, 1, 1, 1, 1)
//        val lista = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
//    val lista = listOf(1, 2, 3, 4 ,5, 6, 7, 8, 9, 10 ,11, 12 ,13)
        var aliciaCandySize = 0
        var aCandy = 0
        var bCandy = 0
        var bobCandySize = 0
        var moveCunter = 0

        while (arr.isNotEmpty()) {
            if (arr.isNotEmpty()) {
                aCandy = arr.eatLeftTill(bCandy)
                aliciaCandySize += aCandy
                moveCunter++
            }
            if (arr.isNotEmpty()) {
                bCandy = arr.eatRightTill(aCandy)
                bobCandySize += bCandy
                moveCunter++
            }

        }
        println("$moveCunter $aliciaCandySize $bobCandySize")
    }

}