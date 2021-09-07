package com.github.xuxiangjun.javaext

import kotlin.random.Random

/**
 * Get Entry by index
 */
fun <K, V> LinkedHashMap<K, V>.getByIndex(index: Int): Map.Entry<K, V> {
    if (index < 0 || index >= size) {
        throw IndexOutOfBoundsException("LinkedHashMap size is $size, index is $index")
    }

    var count = 0
    for (entry in this) {
        if (count == index) {
            return entry
        }
        ++count
    }

    throw IndexOutOfBoundsException("LinkedHashMap size is $size, index is $index")
}

fun <E> Collection<E>.random(): E {
    val index = Random.nextInt(0, size)
    for ((cur, e) in this.withIndex()) {
        if (cur == index) {
            return e
        }
    }

    throw ArrayIndexOutOfBoundsException()
}

fun <K, V> Map<K, V>.random(): Map.Entry<K, V> {
    val index = Random.nextInt(0, size)
    var cur = 0
    for (e in this) {
        if (cur == index) {
            return e
        }
        ++cur
    }

    throw ArrayIndexOutOfBoundsException()
}
