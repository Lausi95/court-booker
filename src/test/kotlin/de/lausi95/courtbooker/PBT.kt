package de.lausi95.courtbooker

import de.lausi95.courtbooker.domain.value.Slot
import kotlin.random.Random

fun someInt() = Random.nextInt(0, 100)

fun someSlot() = Slot(someInt() % 48)
