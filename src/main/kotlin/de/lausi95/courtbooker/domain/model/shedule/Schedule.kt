package de.lausi95.courtbooker.domain.model.shedule

import de.lausi95.courtbooker.Maybe
import de.lausi95.courtbooker.domain.value.Booking
import de.lausi95.courtbooker.domain.value.Slot
import java.time.LocalDate

data class Schedule(val date: LocalDate, val bookings: List<Booking>) {

  val slots get() = bookings.flatMap { it.slots }

  fun fitsIntoSchedule(booking: Booking): Boolean {
    return slots.any { it in booking.slots }
  }
}

fun createSchedule(date: LocalDate, bookings: List<Booking>): Maybe<Schedule> {
  val slotCount = mutableMapOf<Slot, Int>()
  for (booking in bookings) {
    for (slot in booking.slots) {
      slotCount[slot] = slotCount.getOrDefault(slot, 0) + 1
    }
  }

  val invalidSlots: List<Slot> = slotCount.filter { it.value > 1 }.keys.toList()
  if (invalidSlots.isNotEmpty()) {
    return Maybe.error("Slots are double booked: $invalidSlots")
  }

  return Maybe.success(Schedule(date, bookings))
}
