package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest { //여기서 실행버튼을 누르면 이 클래스 전체를 테스트 가능
    //다른 곳에서 사용할 것이 아니니 public은 지워도 됨
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }



    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member, result); //출력한 결과가 터미널에 찍히진 않지만 제대로 실행된다면 함수이름 옆에 초록 체크 뜸
        Assertions.assertThat(member).isEqualTo(result);
    }



    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }



    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }




}
