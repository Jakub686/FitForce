package com.coach;

import com.coach.client.StatClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final StatClient client;

    public MemberService(MemberRepository memberRepository, StatClient client) {
        this.memberRepository = memberRepository;
        this.client = client;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public FullMemberResponse findMemberWithStats(Integer memberId) {
        var member = memberRepository.findById(memberId).orElse(Member.builder().firstName("NOT_FOUND").lastName("NOT_FOUND").build());
        var weights = client.findAllStatsByMember(memberId);
        return FullMemberResponse.builder().name(member.getFirstName()).weights(weights).build();
    }

    public void deleteWithStats(Integer memberId) {
        memberRepository.deleteById(memberId);
        client.deleteAllStatsByMember(memberId);
    }

    public List<Member> findAllMembersWithName(String name) {
        return memberRepository.findMembersByFirstName(name);
    }

    public List<Goal> findAllGoals() {
        return new ArrayList<>();
    }
}

