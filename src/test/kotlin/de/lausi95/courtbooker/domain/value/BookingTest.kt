package de.lausi95.courtbooker.domain.value

import de.lausi95.courtbooker.someDescription
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BookingTest {

  @Test
  fun cannotCreateBookingWithNotContinuousSlots() {
    val anyBookingType = Booking.Type.FREE_PLAY
    val anyDescription = someDescription()
    val slots = listOf(Slot(0), Slot(1), Slot(3))

    val maybeBooking = Booking.create(anyBookingType, slots, anyDescription)

    assertThat(maybeBooking.error).isEqualTo("Slots are not continuous")
  }
}