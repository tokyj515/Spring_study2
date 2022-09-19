package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //테스트 케이스의 함수명은 과감하게 한글로 바꿔도 됨

    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach //각 테스트를 실행하기 전에
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //같은 멤버리포지토리를 사용하기 위해
        //dependency ejection
    }


    @AfterEach
    public void afterEach(){ //디비값을 다 날려버림
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {//join
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다123.");
        }*/


        //then
    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}