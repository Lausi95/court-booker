package de.lausi95.courtbooker.domain.value

import de.lausi95.courtbooker.someInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SlotTest {

  @Test
  fun cannotCreateSlotWithNegativeValue() {
    val someNegativeValue = -(someInt() + 1)

    val maybeSlot = Slot.create(someNegativeValue)

    assertThat(maybeSlot.error)
      .isEqualTo("Invalid Slot value: $someNegativeValue. Slot value must be between 0 and 47")
  }

  @Test
  fun cannotCreateSlotWithTooHighValue() {
    val someTooHighValue: Int = someInt() + 48

    val maybeSlot = Slot.create(someTooHighValue)

    assertThat(maybeSlot.error)
      .isEqualTo("Invalid Slot value: $someTooHighValue. Slot value must be between 0 and 47")
  }

  @Test
  fun canCreateBookingWithValueWithinRange() {
    val someValueWithinRange: Int = someInt() % 48

    val maybeSlot = Slot.create(someValueWithinRange)

    assertThat(maybeSlot.result?.value).isEqualTo(someValueWithinRange)
  }
}
