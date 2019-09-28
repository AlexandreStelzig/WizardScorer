package alexstelzig.wizardscorer.extensions

import kotlin.reflect.KMutableProperty1

inline fun <reified T, Y> List<T>.listOfField(property: KMutableProperty1<T, Y?>):MutableList<Y> {
    val yy = ArrayList<Y>()
    this.forEach { t: T ->
        yy.add(property.get(t) as Y)
    }
    return yy
}

fun <K, V> Map<K, V>.toImmutableMap(): Map<K, V> = ImmutableMap.create(this)
fun <T> List<T>.toImmutableList(): List<T> = ImmutableList.create(this)

inline fun <T> Iterable<T>.firstIndexOrNull(predicate: (T) -> Boolean): Int? {
    return this.mapIndexed { index, item -> Pair(index, item) }
        .firstOrNull() { predicate(it.second) }
        ?.first
}

class ImmutableList<T> private constructor(private val inner: List<T>) : List<T> by inner {
    companion object {
        fun <T> create(inner: List<T>) = if (inner is ImmutableList<T>) {
            inner
        } else {
            ImmutableList(inner.toList())
        }
    }
}

class ImmutableMap<K, V> private constructor(private val inner: Map<K, V>) : Map<K, V> by inner {
    companion object {
        fun <K, V> create(inner: Map<K, V>) = if (inner is ImmutableMap<K, V>) {
            inner
        } else {
            ImmutableMap(hashMapOf(*inner.toList().toTypedArray()))
        }
    }
}

fun <T> MutableList<T>.removeLast(){
    this.removeAt(this.size - 1)
}
