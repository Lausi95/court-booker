package de.lausi95.courtbooker.domain.value

import de.lausi95.courtbooker.Maybe

data class Slot(val value: Int) {

  companion object {

    private const val MIN_SLOT_VALUE = 0
    private const val MAX_SLOT_VALUE = 47

    fun create(value: Int): Maybe<Slot> {
      if (value !in MIN_SLOT_VALUE..MAX_SLOT_VALUE) {
        return Maybe.error("Invalid Slot value: $value. Slot value must be between $MIN_SLOT_VALUE and $MAX_SLOT_VALUE")
      }

      return Maybe.success(Slot(value))
    }
  }
}
