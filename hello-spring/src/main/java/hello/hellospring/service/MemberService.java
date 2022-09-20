package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//서비스는 비지니스에 의존적으로 설계하고
//리포지토리는 기계적인 용어 선택
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //외부에서 생성한 것을 연결
    }

    // 회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원x
        //Optional<Member> result = memberRepository.findByName(member.getName()); //null일 가능성이 있을 때 Optional로 감싸줌
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member){ //중복 회원 검증
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    //전체 회원 조회회
   public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }



}
