package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return (member.getId());
    }

    // 단건 조회 find(타입,key)
    public Member find(Long id){
        return em.find(Member.class,id);
    }

    // 다중 조회 jpql 사용
    public List<Member> findAll(){
        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
        return result;
    }

    public List<Member> findByName(String name){
        List<Member> result  = em.createQuery("select m from Member m  where m.name = :name", Member.class)
                .setParameter("name",name).getResultList();
        return result;
    }

}
