package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 30);

        //when
        Member saveMember = memberRepository.save(member);

        //than
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member m1 = new Member("m1", 10);
        Member m2 = new Member("m2", 20);

        //when
        List<Member> savedMembers = new ArrayList<>();
        savedMembers.add(memberRepository.save(m1));
        savedMembers.add(memberRepository.save(m2));

        List<Member> findMembers = memberRepository.findAll();

        //than
        assertThat(findMembers.size()).isEqualTo(2);
        assertThat(findMembers).isEqualTo(savedMembers);
    }

}