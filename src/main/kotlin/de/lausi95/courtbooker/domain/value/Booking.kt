package de.lausi95.courtbooker.domain.value

import de.lausi95.courtbooker.Maybe

data class Booking(
  val type: Type,
  val slots: List<Slot>,
  val description: Description,
) {

  enum class Type {
    FREE_PLAY,
    TRAINING,
    MATCH,
  }

  companion object {

    fun create(type: Type, slots: List<Slot>, description: Description): Maybe<Booking> {
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
