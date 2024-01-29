package de.lausi95.courtbooker.domain.value

import de.lausi95.courtbooker.Maybe

enum class BookingType {
  FREE_PLAY,
  TRAINING,
  MATCH,
}

data class Booking(
  val type: BookingType,
  val slots: List<Slot>,
  val description: String,
) {

  companion object {

    fun create(type: BookingType, slots: List<Slot>, description: String): Maybe<Booking> {
      val sortedSlots = slots.sortedBy { it.value }
      for (i in 0..<(sortedSlots.size - 1)) {
        if (sortedSlots[i].value != sortedSlots[i + 1].value - 1) {
          return Maybe.error("Slots are not continuous")
        }
      }

      return Maybe.success(Booking(type, slots, description))
    }
  }
}
