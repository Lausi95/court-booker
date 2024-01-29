package de.lausi95.courtbooker.domain.model.member

data class MemberId(val value: String)

data class MemberName(val value: String)

enum class MemberRole {
  TRAINER,
  TEAM_LEADER,
  ADMINISTRATOR,
}

data class Member(
  val id: MemberId,
  val name: MemberName,
  val roles: Set<MemberRole>,
) {

  fun hasRole(role: MemberRole) = roles.contains(role)
}

interface MemberRepository {

  fun getMember(id: MemberId): Member?

  fun getMembers(): List<Member>

  fun save(member: Member): Member
}
