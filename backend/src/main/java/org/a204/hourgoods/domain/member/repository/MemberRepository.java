package org.a204.hourgoods.domain.member.repository;

import java.util.Optional;

import org.a204.hourgoods.domain.member.entity.Member;
import org.a204.hourgoods.domain.member.entity.Member.RegistrationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByRegistrationIdAndEmail(RegistrationId registrationId, String email);

	Member findByEmail(String email);

	boolean existsByNickname(String nickname);

}