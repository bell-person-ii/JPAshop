package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // 데이터 접근시 필수 + Lazy 로드시 필요 --> 각각의 메서드들에 트랜잭션 적용
@RequiredArgsConstructor
public class MemberService {

    //필드
    private final MemberRepository memberRepository;
    //생성자: @RequiredArgsConstructor 로 대체

    //회원가입-->

    //중복 회원
    public void validateDuplicateMember(Member member){
        List<Member> findMembers =memberRepository.findByName(member.getName());
        //exception : 같은 이름의 회원이 기존 DB에 존재한다면 예외 발생
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원 입니다.");
        }
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // <-- 회원 가입


    //회원 전체 조회 -->
    @Transactional(readOnly = true) // DB에 읽기 전용으로 명시함으로써 -> 읽기 성능 최적화
    public List<Member> findMembers(){
        List<Member> result = memberRepository.findAll();
        return  result;
    }
    // <-- 회원 전체 조회


    // 회원 단건 조회 by id -->
    @Transactional(readOnly = true)
    public Member findOne(Long id){
        Member result = memberRepository.findOne(id);
        return result;
    }
    //<-- 회원 단건 조회 by id
}
