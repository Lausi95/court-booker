package de.lausi95.courtbooker

import de.lausi95.courtbooker.domain.value.Description
import de.lausi95.courtbooker.domain.value.Slot
import kotlin.random.Random

fun someInt() = Random.nextInt(0, 100)

fun someString(length: Int = 10): String {
  return buildString {
    repeat(length) {
      append(('a'..'z').random())
    }
  }
}

fun someText(words: Int = 3): String {
  return buildString {
    repeat(words) {
      append(someString())
      if (it != words - 1) {
        append(" ")
      }
    }
  }
}

fun someSlot() = Slot(someInt() % 48)

fun someDescription(words: Int = 3) = Description(someText(words))
